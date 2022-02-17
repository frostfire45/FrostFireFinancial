package com.frostfirecompx.financial.controller.account;

import com.frostfirecompx.financial.domain.accounting.Account;
import com.frostfirecompx.financial.domain.accounting.Contact;
import com.frostfirecompx.financial.domain.accounting.Pay_Info;
import com.frostfirecompx.financial.repository.AccountingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(path = "api/account")
public class AccountRestController {
    @Autowired
    private AccountingRepo accountingRepo;

    @GetMapping(path = "/", produces = "application/json")
    public Iterable<Account> getAllAccounts(){
        return accountingRepo.getAccountDao().findAll();
    }
    @PostMapping( path = "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addEmployee(@RequestBody Account account){
        if (account.getAccount_Id() == 0) {
            long index = accountingRepo.getAccountDao().count();
            index++;
            account.setAccount_Id((int) index);
        }
        if (account.getContact() == null){
            Contact con = new Contact();
            con.setContact_Id(account.getAccount_Id());
            con.setZip(0);
            account.setContact(con);
            accountingRepo.getContactDao().save(con);
        }
        if (account.getPay_info() == null || account.getPay_info().getPayInfo_Id() == 0){
            Pay_Info pi = new Pay_Info();
            pi.setPayInfo_Id(account.getAccount_Id());
            pi.setBalance(0);
            pi.setRate(0.0F);
            pi.setMinimumDue(0.0F);
            pi.setDue_Date(0);
            pi.setPayOffDate(null);
            account.setPay_info(pi);
            accountingRepo.getPayInfoDao().save(pi);
        }
        if (!accountingRepo.getAccountDao().existsById(account.getAccount_Id())){
            Account acnt = new Account();
            acnt.setAccount_Id(account.getAccount_Id());
            acnt.setAccountName(account.getAccountName());
            acnt.setAccountNumber(account.getAccountNumber());
            acnt.setPay_info(account.getPay_info());
            acnt.setContact(account.getContact());
            accountingRepo.getAccountDao().save(acnt);
        }
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(
                        account.getAccount_Id()
                )
                .toUri();
        return ResponseEntity.created(location).build();
    }
}
