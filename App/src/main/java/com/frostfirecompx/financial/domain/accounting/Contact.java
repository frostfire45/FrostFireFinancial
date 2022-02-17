package com.frostfirecompx.financial.domain.accounting;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity(name = "ACCNT_CONTACT")
public class Contact  {
    @Id @Column(name = "CONTACT_ID")
    private int contact_Id;
    @Column(name = "STREET")
    private String street;
    @Column(name = "CITY")
    private String city;
    @Column(name = "STATE")
    private String state;
    @Column(name = "ZIP")
    private int zip = 0;
    @Column(name = "PHONE_NUM")
    private String phoneNum;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "SITE")
    private String site;

    public Contact() {
    }

}
