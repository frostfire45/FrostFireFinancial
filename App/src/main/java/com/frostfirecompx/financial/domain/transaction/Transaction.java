package com.frostfirecompx.financial.domain.transaction;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "TRANSACTION")
public class Transaction {
    @Id @Column(name = "TRANS_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int trans_Id;
    @Column(name = "PAYEE")
    private String payee;
    @Column(name = "AMOUNT")
    private float amount;
    @Column(name = "CHECK_NUM")
    private int checkNum = 0;
    @Column(name = "DATE")
    private Date date;
    @Column(name = "MEMO")
    private String memo = "";
    @Column(name = "IS_BILLABLE")
    private boolean isBillable = false;
    @Column(name = "IS_ACCOUNT")
    private boolean isAccount = false;

    public Transaction() {
    }

    public Transaction(int trans_Id, String payee, float amount, int checkNum, Date date, String memo) {
        this.trans_Id = trans_Id;
        this.payee = payee;
        this.amount = amount;
        this.checkNum = checkNum;
        this.date = date;
        this.memo = memo;
    }

    public int getTrans_Id() {
        return trans_Id;
    }

    public void setTrans_Id(int trans_Id) {
        this.trans_Id = trans_Id;
    }

    public String getPayee() {
        return payee;
    }

    public void setPayee(String payee) {
        this.payee = payee;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public int getCheckNum() {
        return checkNum;
    }

    public void setCheckNum(int checkNum) {
        this.checkNum = checkNum;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public boolean isBillable() {
        return isBillable;
    }

    public void setBillable(boolean billable) {
        isBillable = billable;
    }

    public boolean isAccount() {
        return isAccount;
    }

    public void setAccount(boolean account) {
        isAccount = account;
    }
}
