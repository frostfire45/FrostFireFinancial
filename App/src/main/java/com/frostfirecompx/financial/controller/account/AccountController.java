package com.frostfirecompx.financial.controller.account;

import com.frostfirecompx.financial.domain.accounting.Account;
import com.frostfirecompx.financial.domain.accounting.Contact;
import com.frostfirecompx.financial.domain.accounting.Pay_Info;
import com.frostfirecompx.financial.repository.AccountingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class AccountController {
    @Autowired
    private AccountingRepo accountingRepo;

    @GetMapping(value = "/Account/getAccounts")
    @ResponseStatus
    public Iterable<Account> getAllAccount(){
        return accountingRepo.getAccountDao().findAll();
    }

    @GetMapping(value = "/Account/getAccountById/{id}")
    public Account getAccountById(@PathVariable int id){
        Optional<Account> account = accountingRepo.getAccountDao().findById(id);
        if(!account.isPresent()){
            return null;
        }
        else
            return account.get();
    }

    @PostMapping(value = "Account/newAccount")
    @ResponseBody
    public String addNewObject(@RequestBody Account obj) {

        if (obj.getAccount_Id() == 0) {
            long index = accountingRepo.getAccountDao().count();
            index++;
            obj.setAccount_Id((int) index);
        }
        if (obj.getContact() == null){
            Contact con = new Contact();
            con.setContact_Id(obj.getAccount_Id());
            con.setZip(0);
            obj.setContact(con);
            accountingRepo.getContactDao().save(con);
        }
        if (obj.getPay_info() == null || obj.getPay_info().getPayInfo_Id() == 0){
            Pay_Info pi = new Pay_Info();
            pi.setPayInfo_Id(obj.getAccount_Id());
            pi.setBalance(0);
            pi.setRate(0.0F);
            pi.setMinimumDue(0.0F);
            pi.setDue_Date(0);
            pi.setPayOffDate(null);
            obj.setPay_info(pi);
            accountingRepo.getPayInfoDao().save(pi);
        }
        if (!accountingRepo.getAccountDao().existsById(obj.getAccount_Id())){
            Account acnt = new Account();
            acnt.setAccount_Id(obj.getAccount_Id());
            acnt.setAccountName(obj.getAccountName());
            acnt.setAccountNumber(obj.getAccountNumber());
            acnt.setPay_info(obj.getPay_info());
            acnt.setContact(obj.getContact());
            accountingRepo.getAccountDao().save(acnt);
            return "Complete";
        }
        else
            return "Account Already Exists";
    }

    @GetMapping("/Account/{Id}/deleteAccount")
    public String deleteObject(@PathVariable int Id) {
        Optional<Account> account = accountingRepo.getAccountDao().findById(Id);
        if(account.isPresent()){
            Account acnt = account.get();
            accountingRepo.getAccountDao().deleteById(Id);
            accountingRepo.getContactDao().deleteById(acnt.getContact().getContact_Id());
            accountingRepo.getPayInfoDao().deleteById((acnt.getPay_info().getPayInfo_Id()));
            return  "Deleted";
        }
        else {
            return "There is nothing to delete";
        }
    }

    @PostMapping("/Account/{id}/updateAccount")
    public String updateObjectById(@PathVariable int id,@RequestBody Account changes) {
        Optional<Account> accntById = accountingRepo.getAccountDao().findById(id);

        if(accntById.isPresent()){
            Account a1 = accntById.get();
            a1.setAccount_Id(id);
            if (changes.getAccountName() != null) {
                a1.setAccountName(changes.getAccountName());
            }
            if (changes.getAccountNumber() != null){
                a1.setAccountNumber(changes.getAccountNumber());
            }
            accountingRepo.getAccountDao().save(a1);
            return "Updated";
        }
        else
            return "Failed";
    }
}
