package com.frostfirecompx.financial.domain.accounting;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
@Data
@Entity(name="ACCNT_PAY_INFO")
public class Pay_Info  {

    @Id @NotNull
    @Column(name="PAY_INFO_ID")
    private int payInfo_Id;

    @Column(name="MINIMUM_DUE")
    private float minimumDue = 0.0F;

    @Column(name = "BALANCE")
    private float balance  = 0.0F;

    @Column(name = "DUE_DATE")
    private int due_Date ;

    @Column(name = "RATE")
    private float rate  = 0.0F;

    @Column(name = "PAY_OFF_DATE")
    private Date payOffDate  ;

    public Pay_Info() {
    }

    public Pay_Info(int payInfo_Id, float minimumDue, float balance, int due_Date, float rate, Date payOffDate) {
        this.payInfo_Id = payInfo_Id;
        this.minimumDue = minimumDue;
        this.balance = balance;
        this.due_Date = due_Date;
        this.rate = rate;
        this.payOffDate = payOffDate;
    }

}
