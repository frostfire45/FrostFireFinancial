package com.frostfirecompx.financial.repository;

import com.frostfirecompx.financial.dao.accounting.AccountDao;
import com.frostfirecompx.financial.dao.accounting.ContactDao;
import com.frostfirecompx.financial.dao.accounting.Pay_HistoryDao;
import com.frostfirecompx.financial.dao.accounting.Pay_InfoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountingRepo {
    @Autowired
    private AccountDao accountDao;
    @Autowired
    private ContactDao contactDao;
    @Autowired
    private Pay_InfoDao payInfoDao;
    @Autowired
    private Pay_HistoryDao payHistoryDao;

    public AccountDao getAccountDao() {
        return accountDao;
    }

    public ContactDao getContactDao() {
        return contactDao;
    }

    public Pay_InfoDao getPayInfoDao() {
        return payInfoDao;
    }

    public Pay_HistoryDao getPayHistoryDao() {
        return payHistoryDao;
    }

}
