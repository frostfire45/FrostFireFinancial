package com.frostfirecompx.financial.dao.accounting;

import com.frostfirecompx.financial.domain.accounting.Pay_History;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Pay_HistoryDao extends CrudRepository<Pay_History,Integer> {
}
