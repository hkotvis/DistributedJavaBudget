package springxml.beans;

import springxml.services.LogService;

public class UserExpenses {
    private LogService logService;
    private int id;
    private int amountMonthly;
    private String month;
    private String customName;

    public void logChange(){
        logService.log("A change happened in user expenses");
    }

    public UserExpenses() {
    }

    public UserExpenses(LogService logService) {
        this.logService = logService;
    }

    public LogService getLogService() {
        return logService;
    }

    public void setLogService(LogService logService) {
        this.logService = logService;
    }

    public int getId() {
        return id;
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

    public String getCustomName() {
        return customName;
    }

    public void setCustomName(String customName) {
        this.customName = customName;
    }
}
