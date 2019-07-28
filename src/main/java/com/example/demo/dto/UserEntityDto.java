package com.example.demo.dto;

public class UserEntityDto {

    /**
     * 用户真实姓名
     */
    private String userRealName;

    /**
     * 用户证件号码_密文
     */
    private String identNo;

    /**
     * 用户手机号_密文
     */
    private String userMobileNo;

    /**
     * 用户绑的卡号
     */
    private String cardNo;

    /**
     * 联行号
     */
    private String bankBraNo;


    public String getUserRealName() {
        return userRealName;
    }

    public void setUserRealName(String userRealName) {
        this.userRealName = userRealName;
    }

    public String getIdentNo() {
        return identNo;
    }

    public void setIdentNo(String identNo) {
        this.identNo = identNo;
    }

    public String getUserMobileNo() {
        return userMobileNo;
    }

    public void setUserMobileNo(String userMobileNo) {
        this.userMobileNo = userMobileNo;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getBankBraNo() {
        return bankBraNo;
    }

    public void setBankBraNo(String bankBraNo) {
        this.bankBraNo = bankBraNo;
    }
}
