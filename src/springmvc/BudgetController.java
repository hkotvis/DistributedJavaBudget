package springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BudgetController {
    @RequestMapping("/showBudget")
    public String showBudget(@ModelAttribute ("inputBudget") Budget inputBudget){
        return "view-budget";
    }

    @GetMapping("/budgetBreakdown")
    public String budgetBreakdown(){
        return "view-expense-breakdown";
    }
}
