package springmvc.services;

import springmvc.entity.Expenses;
import springmvc.entity.UserExpenses;

import java.util.List;

public interface BudgetService {
    List<Expenses> getExpenses();

    Expenses getExpenses(int theId);

    List<UserExpenses> getUserExpenses();

    void deleteExpense(int theId);

    UserExpenses getUserExpense(int theId);

    List<Expenses> getExpenseByName(String theSearchTerm);

    void saveExpense(UserExpenses theBudget);
}
