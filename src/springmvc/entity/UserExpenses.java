package springmvc.entity;

import javax.persistence.*;

@Entity
@Table(name = "userExpenses")
public class UserExpenses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userExpenseId")
    private int userExpenseId;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "expenseId")
    private Expenses expenses;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId")
    private UserInfo userInfo;
    @Column(name = "amountMonthly")
    private int amountMonthly;
    @Column(name = "month")
    private String month;
    @Column(name = "expenseAmount")
    private int expenseAmount;

    public UserExpenses(){
        // no-arg constructor
    }

    public UserExpenses( int amountMonthly, String month, int expenseAmount) {
        this.amountMonthly = amountMonthly;
        this.month = month;
        this.expenseAmount = expenseAmount;
    }


    public int getUserExpenseId() {return userExpenseId; }
    public Expenses getExpenses() {
        return expenses;
    }

    public void setExpenses(Expenses expenses) {
        this.expenses = expenses;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public int getAmountMonthly() {
        return amountMonthly;
    }

    public void setAmountMonthly(int amountMonthly) {
        this.amountMonthly = amountMonthly;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getExpenseAmount() {
        return expenseAmount;
    }

    public void setExpenseAmount(int expenseAmount) {
        this.expenseAmount = expenseAmount;
    }

    @Override
    public String toString() {
        return "UserExpenses{" +
                "userExpenseId=" + userExpenseId +
                ", expenses=" + expenses +
                ", userInfo=" + userInfo +
                ", amountMonthly=" + amountMonthly +
                ", month='" + month + '\'' +
                ", expenseAmt='" + expenseAmount + '\'' +
                '}';
    }
}
