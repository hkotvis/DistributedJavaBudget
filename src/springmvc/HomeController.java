package springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String showHomePage(Model model) {
        Budget theBudge = new Budget();
        model.addAttribute("inputBudget", theBudge);
        return "index";
    }

}
