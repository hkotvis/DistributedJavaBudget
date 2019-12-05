package springmvc.dao;

import springmvc.Budget;
import springmvc.entity.UserExpenses;
import springmvc.entity.Expenses;

import java.util.List;

public interface BudgetDAO {

    void saveExpense(Expenses theBudget);

    void deleteExpense(int theId);

    List<Expenses> getExpensesByName(String theSearchTerm);
    List<UserExpenses> getExpenses();

    Budget getExpense(int theId);
}
