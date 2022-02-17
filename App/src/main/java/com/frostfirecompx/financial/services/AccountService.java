package com.frostfirecompx.financial.services;

import com.frostfirecompx.financial.domain.accounting.Account;
import com.frostfirecompx.financial.repository.AccountingRepo;
import org.springframework.beans.factory.annotation.Autowired;

public class AccountService {
    @Autowired
    private AccountingRepo accountingRepo;

    public String AddAccount(Account account) {
        if (account.getAccount_Id() == 0) {
            long index = accountingRepo.getAccountDao().count();
            index++;
            account.setAccount_Id((int) index);
        }
        return "Complete";
    }
}
