package com.frostfirecompx.financial.domain.transaction;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Data
@Entity(name = "CAT")
public class Category {
    @Id
    private int category_Id;
    private String categoryName;

    @OneToOne
    @JoinColumn(name = "cat_type_id")
    private CategoryType type;

    @OneToOne
    @JoinColumn(name = "cat_subtype_id")
    private CategorySubType subType;
    public Category() { }
}
