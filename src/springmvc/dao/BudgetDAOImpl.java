package springmvc.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import springmvc.entity.Expenses;
import springmvc.entity.UserExpenses;

import java.util.List;

@Repository
public class BudgetDAOImpl implements BudgetDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<UserExpenses> getUserExpenses() {
        Session session = sessionFactory.getCurrentSession();
        List<UserExpenses> expensesList = session.createQuery("from UserExpenses", UserExpenses.class).getResultList();
        return expensesList;
    }

    @Override
    public UserExpenses getExpense(int theId) {
        Session session = sessionFactory.getCurrentSession();

        return session.get(UserExpenses.class, theId);
    }

    @Override
    public Expenses getExpenses(int theId) {
        Session session = sessionFactory.getCurrentSession();

        return session.get(Expenses.class, theId);
    }

    public List<Expenses> getExpenses() {
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery("from Expenses").getResultList();
    }

    @Override
    public List<Expenses> getExpensesByName(String theSearchTerm) {
        Session session = sessionFactory.getCurrentSession();

        // Add wildcards and make search term lowercase (for case insensitivity)
        theSearchTerm = "%" + theSearchTerm.toLowerCase() + "%";

        Query<Expenses> query = session.createQuery("from Expenses where lower(expenseName) like :nameToSearch");
        query.setParameter("nameToSearch", theSearchTerm);

        return query.getResultList();
    }

    @Override
    public void saveExpense(UserExpenses theBudget) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(theBudget.getExpenses());
        session.saveOrUpdate(theBudget);
    }


    @Override
    public void deleteExpense(int theId) {
        Session session = sessionFactory.getCurrentSession();
        // Delete object using primary key
        Query query = session.createQuery("delete from UserExpenses where userExpenseId = :doomedExpensesId");
        // Set parameter value
        query.setParameter("doomedExpensesId", theId);

        // Perform the delete
        query.executeUpdate();
    }

}
