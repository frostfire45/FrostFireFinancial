package com.frostfirecompx.financial.domain.transaction;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "cat_type")
public class CategoryType {
    @Id @Column(name = "id")
    private int typeId;

    @Column(name = "name")
    private String categoryName;

    @OneToOne
    @JoinColumn(name = "subType_id")
    private CategorySubType categorySubType;
}
