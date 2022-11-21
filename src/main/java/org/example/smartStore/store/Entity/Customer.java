package org.example.smartStore.store.Entity;

import org.example.smartStore.store.DTO.CustomerDTO;

public class Customer {
    private String userID;
    private String customerID;
    private String customerName;
    private int customerSpentMoney;
    private int customerPurchaseCount;

    public Customer(String userID, String customerID, String customerName, int customerSpentMoney, int customerPurchaseCount) {
        this.userID = userID;
        this.customerID = customerID;
        this.customerName = customerName;
        this.customerSpentMoney = customerSpentMoney;
        this.customerPurchaseCount = customerPurchaseCount;
    }

    public Customer(String userID, String customerID) {
        this.userID = userID;
        this.customerID = customerID;
    }

    public CustomerDTO toDTO(){ return new CustomerDTO(userID,customerID,customerName,customerSpentMoney,customerPurchaseCount);}

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getCustomerSpentMoney() {
        return customerSpentMoney;
    }

    public void setCustomerSpentMoney(int customerSpentMoney) {
        this.customerSpentMoney = customerSpentMoney;
    }

    public int getCustomerPurchaseCount() {
        return customerPurchaseCount;
    }

    public void setCustomerPurchaseCount(int customerPurchaseCount) {
        this.customerPurchaseCount = customerPurchaseCount;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "userID='" + userID + '\'' +
                ", customerID='" + customerID + '\'' +
                ", customerName='" + customerName + '\'' +
                ", customerSpentMoney=" + customerSpentMoney +
                ", customerPurchaseCount=" + customerPurchaseCount +
                '}';
    }
}
