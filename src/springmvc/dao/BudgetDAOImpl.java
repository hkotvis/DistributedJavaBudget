package springmvc.dao;

import springmvc.entity.Expenses;
import springmvc.entity.UserExpenses;
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
    public List<UserExpenses> getExpenses() {
        Session session = sessionFactory.getCurrentSession();
        List<UserExpenses> expensesList = session.createQuery("from UserExpenses", UserExpenses.class).getResultList();
        return expensesList;
    }

    @Override
    public Budget getExpense(int theId) {
        Session session = sessionFactory.getCurrentSession();

        return session.get(Budget.class, theId);
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
