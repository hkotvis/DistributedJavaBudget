package springxml.beans;

import springmvc.services.LogService;

/*
reate a private field of your service interface type
Add a public setter for this field
Add another constructor that accepts an object of this and assigns it to the field
Create a public method of your choice that  demonstrates using the service
For example,  a method named logChange() that writes  uses a logging service
to produce console output
 */
public class Expenses {
    private LogService logService;
    private int id;
    private String expenseName;

    public void logChange(){
        logService.log("A change happened in expenses");
    }
    public Expenses() {
    }

    public Expenses(LogService logService) {
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

    public String getExpenseName() {
        return expenseName;
    }

    public void setExpenseName(String expenseName) {
        this.expenseName = expenseName;
    }
}
