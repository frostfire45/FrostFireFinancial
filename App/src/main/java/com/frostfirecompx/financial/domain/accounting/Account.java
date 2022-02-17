package com.frostfirecompx.financial.domain.accounting;

import com.frostfirecompx.financial.domain.transaction.Category;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "ACCOUNT")
public class Account {
    @Id @Column(name = "ACCNT_ID")
    private int account_Id;
    @Column(name = "Accnt_Name")
    private String accountName;
    @Column(name = "Accnt_Number")
    private String accountNumber;

    @OneToOne @JoinColumn(name = "pay_info_id")
    public Pay_Info pay_info;

    @OneToOne @JoinColumn(name = "contact_contact_id")
    private Contact contact;

    @OneToOne @JoinColumn(name = "category_category_id")
    private Category category;

    public Account (){}
    public Account(int account_Id, String accountName, String accountNumber, Pay_Info pay_info, Contact contact,Category category) {
        this.account_Id = account_Id;
        this.accountName = accountName;
        this.accountNumber = accountNumber;
        this.pay_info = pay_info;
        this.contact = contact;
        this.category = category;
    }

    public String toJson(){

        StringBuilder sb = new StringBuilder();
        sb.append("{ \"Account\" : { \"account_Id\" : \"");
        if (account_Id != 0) {
            sb.append(account_Id);
        }
        else{
            account_Id = 0;
        }
        sb.append("\", ");
        sb.append("\"accountName\" : \"");
        if(accountName != null) {
            sb.append(accountName);
        }
        else {
            sb.append("Not Implem");
        }
        sb.append("\", ");
        sb.append("\"accountNumber\" : \"");
        if(accountNumber != null){
            sb.append(accountNumber);
        }
        else {
            sb.append("Not Implem");
        }
        sb.append("\" } }");
        return sb.toString();
    }
}
