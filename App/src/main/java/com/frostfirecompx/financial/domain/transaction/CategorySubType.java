package com.frostfirecompx.financial.domain.transaction;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity(name = "cat_subtype")
public class CategorySubType {
    @Id @Column(name = "id")
    private int categorySubId;
    @Column(name = "name")
    private String typeName;

}
