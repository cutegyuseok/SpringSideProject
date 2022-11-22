package org.example.smartStore.store.Entity;

import org.example.smartStore.store.DAO.CustomerDAO;
import org.example.smartStore.store.DTO.CustomerDTO;

import java.util.Objects;

public class CustomerWithGrade {
    private String userID;
    private String customerID;
    private String customerName;
    private int customerSpentMoney;
    private int customerPurchaseCount;
    private String grade;

    public CustomerWithGrade(String userID, String customerID,
                             String customerName, int customerSpentMoney,
                             int customerPurchaseCount, String grade) {
        this.userID = userID;
        this.customerID = customerID;
        this.customerName = customerName;
        this.customerSpentMoney = customerSpentMoney;
        this.customerPurchaseCount = customerPurchaseCount;
        this.grade = grade;
    }
    public CustomerWithGrade(CustomerDTO customerDTO,String grade){
        this.userID = customerDTO.getUserID();
        this.customerID = customerDTO.getCustomerID();
        this.customerName = customerDTO.getCustomerName();
        this.customerSpentMoney = customerDTO.getCustomerSpentMoney();
        this.customerPurchaseCount = customerDTO.getCustomerPurchaseCount();
        this.grade =grade;
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

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerWithGrade that = (CustomerWithGrade) o;

        if (customerSpentMoney != that.customerSpentMoney) return false;
        if (customerPurchaseCount != that.customerPurchaseCount) return false;
        if (!Objects.equals(userID, that.userID)) return false;
        if (!Objects.equals(customerID, that.customerID)) return false;
        if (!Objects.equals(customerName, that.customerName)) return false;
        return Objects.equals(grade, that.grade);
    }

    @Override
    public int hashCode() {
        int result = userID != null ? userID.hashCode() : 0;
        result = 31 * result + (customerID != null ? customerID.hashCode() : 0);
        result = 31 * result + (customerName != null ? customerName.hashCode() : 0);
        result = 31 * result + customerSpentMoney;
        result = 31 * result + customerPurchaseCount;
        result = 31 * result + (grade != null ? grade.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CustomerWithGrade{" +
                "userID='" + userID + '\'' +
                ", customerID='" + customerID + '\'' +
                ", customerName='" + customerName + '\'' +
                ", customerSpentMoney=" + customerSpentMoney +
                ", customerPurchaseCount=" + customerPurchaseCount +
                ", grade='" + grade + '\'' +
                '}';
    }
}

