package springxml.dao;

import hibernate.entity.Expenses;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import springmvc.Budget;

import java.util.List;

@Repository
public class BudgetDAOImpl implements BudgetDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Expenses> getExpenses() {
        Session session = sessionFactory.getCurrentSession();
        List<Expenses> expensesList = session.createQuery("from Expenses", Expenses.class).getResultList();
        return expensesList;
    }

    @Override
    public List<Expenses> getExpensesByName(String theSearchTerm) {
        return null;
    }

    @Override
    public void saveExpense(Expenses theBudget) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(theBudget);
    }



    @Override
    public void deleteExpense(int theId) {
        Session session = sessionFactory.getCurrentSession();
        // Delete object using primary key
        Query query = session.createQuery("delete from Expenses where expenseId = :doomedExpensesId");
        // Set parameter value
        query.setParameter("doomedExpensesId", theId);

        // Perform the delete
        query.executeUpdate();
    }

}
