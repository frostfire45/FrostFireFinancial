package com.frostfirecompx.financial.repository;

import com.frostfirecompx.financial.domain.accounting.Account;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

//@RepositoryRestResource(collectionResourceRel = "accounts", path = "accounts")
public interface AccountRestRepo extends PagingAndSortingRepository<Account, Integer> {
    List<Account> findByaccountName(@Param("accountName") String accountName);
}
