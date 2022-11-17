package org.example.smartStore.store.VO;

public class ParameterVO {
    private String userID;
    private String grade;
    private int minimumSpentMoney;
    private int minimumPurchaseCount;

    public ParameterVO(String userID, String grade, int minimumSpentMoney, int minimumPurchaseCount) {
        this.userID = userID;
        this.grade = grade;
        this.minimumSpentMoney = minimumSpentMoney;
        this.minimumPurchaseCount = minimumPurchaseCount;
    }

    public String getUserID() {
        return userID;
    }

    public String getGrade() {
        return grade;
    }

    public int getMinimumSpentMoney() {
        return minimumSpentMoney;
    }

    public int getMinimumPurchaseCount() {
        return minimumPurchaseCount;
    }
}
