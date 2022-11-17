package org.example.smartStore.store.VO;

public class CustomerVO {
    private String userID;
    private String customerID;
    private String customerName;
    private int customerSpentMoney;
    private int customerPurchaseCount;

    public CustomerVO(String userID, String customerID, String customerName, int customerSpentMoney, int customerPurchaseCount) {
        this.userID = userID;
        this.customerID = customerID;
        this.customerName = customerName;
        this.customerSpentMoney = customerSpentMoney;
        this.customerPurchaseCount = customerPurchaseCount;
    }

    public String getUserID() {
        return userID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getCustomerSpentMoney() {
        return customerSpentMoney;
    }

    public int getCustomerPurchaseCount() {
        return customerPurchaseCount;
    }
}
