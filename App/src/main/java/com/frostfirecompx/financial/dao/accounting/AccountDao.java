package com.frostfirecompx.financial.dao.accounting;

import com.frostfirecompx.financial.domain.accounting.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountDao extends CrudRepository<Account,Integer > {
}
