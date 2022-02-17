package com.frostfirecompx.batch;

import com.frostfirecompx.financial.domain.accounting.Account;
import com.frostfirecompx.financial.domain.accounting.Contact;
import com.frostfirecompx.financial.domain.accounting.Pay_Info;
import com.frostfirecompx.financial.domain.transaction.Category;
import org.springframework.batch.item.ItemProcessor;

public class AccountItemProcessor implements ItemProcessor<Account,Account> {
    @Override
    public Account process(Account item) throws Exception {
        final int account_id = item.getAccount_Id();
        final String accountName = item.getAccountName();
        final String accountNumber = item.getAccountNumber();
        final Pay_Info pay_info = item.getPay_info();
        final Contact contact = item.getContact();
        final Category category = item.getCategory();

        final Account transFormedAccount = new Account(account_id,accountName,accountNumber,pay_info,contact,category);
        return transFormedAccount;
    }
}
