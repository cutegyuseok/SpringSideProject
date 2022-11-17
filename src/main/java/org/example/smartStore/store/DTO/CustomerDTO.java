package org.example.smartStore.store.DTO;

import org.example.smartStore.store.Entity.Customer;
import org.example.smartStore.store.VO.CustomerVO;

public class CustomerDTO {
    private String userID;
    private String customerID;
    private String customerName;
    private int customerSpentMoney;
    private int customerPurchaseCount;

    public CustomerDTO(String userID, String customerID, String customerName, int customerSpentMoney, int customerPurchaseCount) {
        this.userID = userID;
        this.customerID = customerID;
        this.customerName = customerName;
        this.customerSpentMoney = customerSpentMoney;
        this.customerPurchaseCount = customerPurchaseCount;
    }
    public Customer toEntity(){
        return new Customer(userID,customerID,customerName,customerSpentMoney,customerPurchaseCount);
    }
    public CustomerVO toVO(){
        return new CustomerVO(userID,customerID,customerName,customerSpentMoney,customerPurchaseCount);
    }

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
}
