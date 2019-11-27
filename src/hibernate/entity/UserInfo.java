package hibernate.entity;

import javax.persistence.*;

@Entity
@Table(name = "userInfo")
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private int userId;
    @Column(name = "monthlyIncome")
    private int monthlyIncome;

    public UserInfo() {
    }

    public UserInfo(int monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(int monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "userId=" + userId +
                ", monthlyIncome=" + monthlyIncome +
                '}';
    }
}
