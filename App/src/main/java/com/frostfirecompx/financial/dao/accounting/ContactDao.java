package com.frostfirecompx.financial.dao.accounting;

import com.frostfirecompx.financial.domain.accounting.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactDao extends CrudRepository<Contact,Integer>{

}
