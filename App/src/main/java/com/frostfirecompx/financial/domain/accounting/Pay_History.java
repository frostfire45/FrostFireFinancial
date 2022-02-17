package com.frostfirecompx.financial.domain.accounting;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
@Data
@Entity(name = "ACCNT_PAY_HISTORY")
public class Pay_History {
    @Id @Column(name = "PAY_HISTORY_ID")
    private int payHistory_Id;

    @Column(name = "TRANS_ID")
    private int trans_Id;

    @ManyToOne(cascade=CascadeType.ALL)
    private Account account;

    @Column(name = "POST_DATE")
    private Date postDate;
    @Column(name = "ACCNT_ID")
    private int accnt_Id;
    @Column(name = "ACCNT_PAY_AMOUNT")
    private float payAmount;

    public Pay_History() {
    }

    public Pay_History(int payHistory_Id, int trans_Id, Account account,
                       Date postDate, int accnt_Id, float payAmount) {
        this.payHistory_Id = payHistory_Id;
        this.trans_Id = trans_Id;
        this.account = account;
        this.postDate = postDate;
        this.accnt_Id = accnt_Id;
        this.payAmount = payAmount;
    }

}
