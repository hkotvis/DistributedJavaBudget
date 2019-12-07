package springmvc.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
    @NotNull(message = "required")
    @Min(value = 1, message = "must be greater than 0")
    @Column(name = "expenseAmount")
    private int expenseAmount;
    @NotNull(message = "required")
    @Size(min = 1, message = "must add details")
    @Column(name = "details")
    private String details;
    public UserExpenses(){
        // no-arg constructor
    }

    public UserExpenses( int amountMonthly, String month, int expenseAmount, String details) {
        this.amountMonthly = amountMonthly;
        this.month = month;
        this.expenseAmount = expenseAmount;
        this.details = details;
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

    public String getDetails() {
        return details;
    }
    public void setDetails(String details){
        this.details = details;

    }
}
