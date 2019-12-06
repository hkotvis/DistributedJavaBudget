package springmvc.services;

import springmvc.entity.Expenses;
import springmvc.entity.UserExpenses;

import java.util.List;

public interface BudgetService {
    List<UserExpenses> getExpenses();

    void deleteExpense(int theId);

    UserExpenses getExpense(int theId);

    List<Expenses> getExpenseByName(String theSearchTerm);

    void saveExpense(UserExpenses theBudget);
}
