package springmvc.dao;

import springmvc.entity.Expenses;
import springmvc.entity.UserExpenses;

import java.util.List;

public interface BudgetDAO {

    void saveExpense(UserExpenses theBudget);

    void deleteExpense(int theId);

    List<Expenses> getExpensesByName(String theSearchTerm);
    List<UserExpenses> getExpenses();

    UserExpenses getExpense(int theId);
}
