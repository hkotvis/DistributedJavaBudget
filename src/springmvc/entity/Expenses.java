package springmvc.entity;

import javax.persistence.*;

@Entity
@Table(name = "expenses")
public class Expenses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "expenseId")
    private int expenseId;
    @Column(name = "expenseName")
    private String expenseName;

    public Expenses() {
        // no-arg constructor
    }

    public Expenses(String expenseName) {
        this.expenseName = expenseName;
    }

    public int getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(int expenseId) {
        this.expenseId = expenseId;
    }

    public String getExpenseName() {
        return expenseName;
    }

    public void setExpenseName(String expenseName) {
        this.expenseName = expenseName;
    }

    @Override
    public String toString() {
        return "Expenses{" +
                "expenseId=" + expenseId +
                ", expenseName='" + expenseName + '\'' +
                '}';
    }
}
