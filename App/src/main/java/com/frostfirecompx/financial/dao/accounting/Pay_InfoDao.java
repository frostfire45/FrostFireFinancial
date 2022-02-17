package com.frostfirecompx.financial.dao.accounting;

import com.frostfirecompx.financial.domain.accounting.Pay_Info;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Pay_InfoDao extends CrudRepository<Pay_Info,Integer> {
}
