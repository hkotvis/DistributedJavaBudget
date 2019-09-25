package springxml.beans;

import springxml.services.LogService;

public class UserInfo {
    private LogService logService;
    private int id;
    private int monthlyIncome;
    public void logChange(){
        logService.log("A change happened in user info");
    }

    public UserInfo() {
    }

    public UserInfo(LogService logService) {
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

    public int getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(int monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }
}
