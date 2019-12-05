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
import springmvc.services.BudgetService;
import springmvc.entity.UserExpenses;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/budget")
public class BudgetController {

    @Autowired
    private BudgetService budgetService;

    @RequestMapping("/showBudget")
    public String showBudget(@ModelAttribute ("inputBudget") Budget inputBudget){
        return "view-budget";
    }

    @GetMapping("/budgetBreakdown") // list expenses
    public String budgetBreakdown(Model theModel){
        List<UserExpenses> expensesList = budgetService.getExpenses();
        theModel.addAttribute("expenses", expensesList);
        return "view-expense-breakdown";
    }

    @GetMapping("/delete")
    public String deleteExpense(@RequestParam("userExpenseId") int theId) {
        // Delete the donut
        budgetService.deleteExpense(theId);

        return "redirect:/budget/budgetBreakdown";
    }


    @RequestMapping("/showAddExpenseForm")
    public String showAddDonutForm(Model theModel) {
        Budget theBudget = new Budget();

        theModel.addAttribute("budget", theBudget);

        return "expense-form";
    }

    @RequestMapping("/showUpdateExpenseForm")
    public String showUpdateDonutForm(@RequestParam("donutId") int theId,
                                      Model theModel) {
        // Get donut from the database
        Budget theBudget = budgetService.getExpense(theId);

        // Set donut as a model attribute to pre-populate the form
        theModel.addAttribute("donut", theBudget);

        // Return the view
        return "expense-form";
    }


    @PostMapping("/budget/save")
    public String saveDonut(@Valid @ModelAttribute("expense") Expenses theBudget,
                            BindingResult bindingResult,
                            HttpServletRequest request,
                            Model theModel) {
        // Any validation errors?
        if (bindingResult.hasErrors()) {
            // Display the errors in the console
            System.out.println(bindingResult);

            // Send back to form with error messages
            return "expense-form";
        }

        // Find the complete path of the application
        String applicationPath = request.getServletContext().getRealPath("/");

        // Use the service to save the donut
        budgetService.saveExpense(theBudget);

        // Redirect back to the donut list
        return "redirect:/donut/list";
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



