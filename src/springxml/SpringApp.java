package springxml;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import springxml.beans.Expenses;


/*
Create a ClassPathXmlApplicationContext
Retrieve your bean from the container
Demonstrate that the beans fields have been populated by calling their setters
Demonstrate that the bean can use its service
Close the context
 */
public class SpringApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        springxml.beans.Expenses exp = context.getBean("myExpenses", Expenses.class);
        exp.setExpenseName("Phone Bill");
        System.out.println(exp.getExpenseName());


        // lastly always do this
        context.close();
    }
}
