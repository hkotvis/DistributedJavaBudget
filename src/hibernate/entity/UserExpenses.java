package hibernate.entity;

import javax.persistence.*;

@Entity
@Table(name = "userExpenses")
public class UserExpenses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userExpenseId")
    private int id;
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
    @Column(name = "customExpenseName")
    private String customExpenseName;

    public UserExpenses(){
        // no-arg constructor
    }

    public UserExpenses( int amountMonthly, String month, String customExpenseName) {
        this.amountMonthly = amountMonthly;
        this.month = month;
        this.customExpenseName = customExpenseName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getCustomExpenseName() {
        return customExpenseName;
    }

    public void setCustomExpenseName(String customExpenseName) {
        this.customExpenseName = customExpenseName;
    }

    @Override
    public String toString() {
        return "UserExpenses{" +
                "id=" + id +
                ", expenses=" + expenses +
                ", userInfo=" + userInfo +
                ", amountMonthly=" + amountMonthly +
                ", month='" + month + '\'' +
                ", customExpenseName='" + customExpenseName + '\'' +
                '}';
    }
}
