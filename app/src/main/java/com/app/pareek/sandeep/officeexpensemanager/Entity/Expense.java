package com.app.pareek.sandeep.officeexpensemanager.Entity;

/**
 * Created by sandeep on 8/8/2015.
 */
public class Expense {

    int transactionId;
    String personName= null;
    String productName = null;
    Long dateOfPurchase;
    int quantity;
    int employeeId;
    long expense;


    public long getExpense() {
        return expense;
    }

    public void setExpense(long expense) {
        this.expense = expense;
    }
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(Long dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

}
