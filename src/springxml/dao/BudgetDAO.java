package springxml.dao;

import hibernate.entity.Expenses;
import springmvc.Budget;

import java.util.List;

public interface BudgetDAO {

    void saveExpense(Expenses theBudget);

    void deleteExpense(int theId);

    List<Expenses> getExpensesByName(String theSearchTerm);
    List<Expenses> getExpenses();
}
