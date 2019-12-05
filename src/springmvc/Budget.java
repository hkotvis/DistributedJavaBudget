package springmvc;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "userexpenses")
public class Budget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userExpenseId")
    private int userExpenseId;
    private String dollarAmt;

    @NotNull(message = "required")
    @Min(value = 1, message = "must be greater than 0")
    @Column(name = "expenseAmt")
    private int expenseAmt;

    @NotNull(message = "required")
    @Size(min = 1, message = "must be greater than 0")
    @Column(name = "expenseName")
    private String expenseName;
    public Budget(){
    }

    public Budget(int id, String dollarAmt, int expenseAmt, String expenseName){
        this.userExpenseId = id;
        this.dollarAmt = dollarAmt;
        this. expenseAmt = expenseAmt;
        this.expenseName = expenseName;
    }
    public int getUserExpenseId() { return userExpenseId; }
    public void setUserExpenseId(int userExpenseId) { this.userExpenseId = userExpenseId; }
    public String getDollarAmt() { return dollarAmt; }
    public void setDollarAmt(String dollarAmt) { this.dollarAmt = dollarAmt; }
    public int getExpenseAmt() { return expenseAmt; }
    public void setExpenseAmt(int expenseAmt) {this.expenseAmt = expenseAmt; }
    public String getExpenseName() { return expenseName;}
    public void setExpenseName(String expenseName) { this.expenseName = expenseName; }



    @Override
    public String toString() {
        return "Expense{" +
                "id=" + userExpenseId +
                ", name='" + expenseName + '\'' +
                ", expense amount=" + expenseAmt +
                ", monthly amount='" + dollarAmt + '\'' +
                '}';
    }

}


