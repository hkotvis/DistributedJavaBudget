package springmvc.services;

import springmvc.entity.Expenses;
import springmvc.entity.UserExpenses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springmvc.dao.BudgetDAO;


import java.util.List;

@Service
public class BudgetExpenseService implements BudgetService{
    @Autowired
    private BudgetDAO budgetDAO;

    @Override
    @Transactional
    public List<Expenses> getExpenses() {
        return budgetDAO.getExpenses();
    }

    @Override
    @Transactional
    public Expenses getExpenses(int theId) {
        return budgetDAO.getExpenses(theId);
    }

    @Override
    @Transactional
    public List<UserExpenses> getUserExpenses() {
        return budgetDAO.getUserExpenses();
    }

    @Override
    @Transactional
    public UserExpenses getUserExpense(int theId) {
        return budgetDAO.getExpense(theId);
    }

    @Override
    @Transactional
    public void deleteExpense(int theId) {
        budgetDAO.deleteExpense(theId);
    }


    @Override
    @Transactional
    public List<Expenses> getExpenseByName(String theSearchTerm) {
        return budgetDAO.getExpensesByName(theSearchTerm);
    }

    @Override
    @Transactional
    public void saveExpense(UserExpenses theExpense) {
        budgetDAO.saveExpense(theExpense);
    }
}


