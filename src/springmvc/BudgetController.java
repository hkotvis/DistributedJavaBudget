package springmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import springmvc.entity.Expenses;
import springmvc.entity.UserExpenses;
import springmvc.services.BudgetService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/budget")
public class BudgetController {
    @Autowired
    private BudgetService budgetService;

    @RequestMapping("/showBudget")
    public String showBudget(@ModelAttribute ("inputBudget") UserExpenses inputBudget){
        return "view-userExpenses";
    }

    @GetMapping("/budgetBreakdown") // list expenses
    public String budgetBreakdown(Model theModel){
        List<UserExpenses> expensesList = budgetService.getUserExpenses();
        theModel.addAttribute("expenses", expensesList);
        return "view-expense-breakdown";
    }

    @GetMapping("/delete")
    public String deleteExpense(@RequestParam("userExpenseId") int theId) {
        // Delete the expense
        budgetService.deleteExpense(theId);
        return "redirect:/budget/budgetBreakdown";
    }


    @RequestMapping("/showAddExpenseForm")
    public String showAddExpenseForm(Model theModel) {
        UserExpenses theBudget = new UserExpenses();
        theBudget.setExpenses(new Expenses());

        theModel.addAttribute("userExpenses", theBudget);
        theModel.addAttribute("expensesList", budgetService.getExpenses());

        return "expense-form";
    }

    @RequestMapping("/showUpdateExpenseForm")
    public String showUpdateExpenseForm(@RequestParam("userExpenseId") int theId,
                                      Model theModel) {
        // Get expense from the database
        UserExpenses theBudget = budgetService.getUserExpense(theId);

        // Set expense as a model attribute to pre-populate the form
        theModel.addAttribute("userExpenses", theBudget);
        theModel.addAttribute("expensesList", budgetService.getExpenses());

        // Return the view
        return "expense-form";
    }


    @PostMapping("/save")
    public String saveBudget(@Valid @ModelAttribute("userExpenses") UserExpenses theBudget,
                           BindingResult bindingResult,
                            //HttpServletRequest request,
                            Model theModel
                             ) {

        if (bindingResult.hasErrors()) {
            // Display the errors in the console
            System.out.println(bindingResult);

            // Put list of donut shops back in the new model
            theModel.addAttribute("userExpenses", theBudget);
            theModel.addAttribute("expensesList", budgetService.getExpenses());

            // Send back to form with error messages
            return "expense-form";
        }
        // Use the service to save the expense
        budgetService.saveExpense(theBudget);

        // Redirect back to the expense list
        return "redirect:/budget/budgetBreakdown";
    }

    @GetMapping("/search")
    public String search(@RequestParam("searchTerm") String theSearchTerm, Model theModel) {
        List<Expenses> matchingExpenses = budgetService.getExpenseByName(theSearchTerm);

        theModel.addAttribute("expenses", matchingExpenses);

        return "view-expense-breakdown";
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        // Trim whitespace from all string form parameters read by this controller
        // If the entire string is whitespace, trim it to null
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void handle(Exception e) {
        e.printStackTrace();
    }

}



