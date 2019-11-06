package hibernate;

import hibernate.entity.Expenses;
import hibernate.entity.UserExpenses;
import hibernate.entity.UserInfo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CRUD {
    private SessionFactory factory;
    public CRUD(){
        factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Expenses.class)
                .addAnnotatedClass(UserExpenses.class)
                .addAnnotatedClass(UserInfo.class)
                .buildSessionFactory();
    }
    public static void main(String[] args) {
        CRUD crud = new CRUD();
        try{
            // call CRUD methods
            crud.createUserExpense();
        }finally {
            crud.close();
        }
    }
    private int createExpense(){
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        Expenses expenses = new Expenses("Laundry");
        session.save(expenses);

        session.getTransaction().commit();
        return expenses.getExpenseId();
    }
    private void readExpense(int expenseId){
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        Expenses theExpense = session.get(Expenses.class, expenseId);
        if (theExpense == null){
            System.out.println("No expense found for ID " + expenseId);
        } else {
            System.out.println(theExpense);
        }

        session.getTransaction().commit();
    }
    private void updateExpense(int expenseId) {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        Expenses theExpense = session.get(Expenses.class, expenseId);
        if (theExpense != null)
            theExpense.setExpenseName(theExpense.getExpenseName() + " UPDATED");

        session.getTransaction().commit();
    }

    private void deleteExpense(int expenseId) {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        Expenses doomedExpense = session.get(Expenses.class, expenseId);
        if(doomedExpense != null)
            session.delete(doomedExpense);

        session.getTransaction().commit();
    }
//////////////////////////////////////////////////////
    private int createUserInfo(){
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        UserInfo userInfo = new UserInfo(3000);
        session.save(userInfo);

        session.getTransaction().commit();
        return userInfo.getUserId();
    }
    private void readUserInfo(int userInfoId){
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        UserInfo theUserInfo = session.get(UserInfo.class, userInfoId);
        if (theUserInfo == null){
            System.out.println("No user found for ID " + userInfoId);
        } else {
            System.out.println(theUserInfo);
        }

        session.getTransaction().commit();
    }
    private void updateUserInfo(int userInfoId) {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        UserInfo theUserInfo = session.get(UserInfo.class, userInfoId);
        if (theUserInfo != null)
            theUserInfo.setMonthlyIncome(theUserInfo.getMonthlyIncome());

        session.getTransaction().commit();
    }

    private void deleteUserInfo(int userInfoId) {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        UserInfo doomedUser = session.get(UserInfo.class, userInfoId);
        if(doomedUser != null)
            session.delete(doomedUser);

        session.getTransaction().commit();
    }

    /////////////////////////////////////////////////////////////////////////////
    private int createUserExpense(){
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        UserInfo userInfo = session.get(UserInfo.class, 1);
        Expenses expenses = session.get(Expenses.class, 3);
        UserExpenses userExpenses = new UserExpenses(850, "January", "-");
        userExpenses.setUserInfo(userInfo);
        userExpenses.setExpenses(expenses);
        session.save(userExpenses);

        session.getTransaction().commit();
        return userExpenses.getId();
    }
    private void readUserExpense(int userExpenseId){
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        UserExpenses theUserExpense = session.get(UserExpenses.class, userExpenseId);
        if (theUserExpense == null){
            System.out.println("No user expense found for ID " + userExpenseId);
        } else {
            System.out.println(theUserExpense);
        }

        session.getTransaction().commit();
    }
    private void updateUserExpense(int userExpenseId) {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        UserExpenses theUserExpense = session.get(UserExpenses.class, userExpenseId);
        if (theUserExpense != null) {
            theUserExpense.setAmountMonthly(theUserExpense.getAmountMonthly());
            theUserExpense.setMonth(theUserExpense.getMonth());
            theUserExpense.setCustomExpenseName(theUserExpense.getCustomExpenseName());

        }
        session.getTransaction().commit();
    }

    private void deleteUserExpense(int userExpenseId) {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        UserExpenses doomedUserExpense = session.get(UserExpenses.class, userExpenseId);
        if(doomedUserExpense != null)
            session.delete(doomedUserExpense);

        session.getTransaction().commit();
    }





    private void close(){
        factory.close();
    }
}
