package springmvc.services.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import springmvc.entity.Expenses;
import springmvc.services.BudgetService;


public class StringToExpensesConverter implements Converter<String, Expenses> {
    @Autowired
    private BudgetService budgetService;

    /*
     * Source is guaranteed to not be null, see:
     * https://docs.spring.io/spring/docs/4.1.3.RELEASE/spring-framework-reference/htmlsingle/#core-convert
     */
    @Override
    public Expenses convert(String source) {
        int expensesId = Integer.parseInt(source);
        Expenses expenses = budgetService.getExpenses(expensesId);
        return expenses;
    }
}
