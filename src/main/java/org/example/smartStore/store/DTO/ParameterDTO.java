package org.example.smartStore.store.DTO;

import org.example.smartStore.store.Entity.Parameter;
import org.example.smartStore.store.VO.ParameterVO;

public class ParameterDTO {
    private String userID;
    private String grade;
    private int minimumSpentMoney;
    private int minimumPurchaseCount;

    public ParameterDTO(String userID, String grade, int minimumSpentMoney, int minimumPurchaseCount) {
        this.userID = userID;
        this.grade = grade;
        this.minimumSpentMoney = minimumSpentMoney;
        this.minimumPurchaseCount = minimumPurchaseCount;
    }
    public Parameter toEntity(){
        return new Parameter(userID,grade,minimumSpentMoney,minimumPurchaseCount);
    }
    public ParameterVO toVO(){
        return new ParameterVO(userID,grade,minimumSpentMoney,minimumPurchaseCount);
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public int getMinimumSpentMoney() {
        return minimumSpentMoney;
    }

    public void setMinimumSpentMoney(int minimumSpentMoney) {
        this.minimumSpentMoney = minimumSpentMoney;
    }

    public int getMinimumPurchaseCount() {
        return minimumPurchaseCount;
    }

    public void setMinimumPurchaseCount(int minimumPurchaseCount) {
        this.minimumPurchaseCount = minimumPurchaseCount;
    }
}
