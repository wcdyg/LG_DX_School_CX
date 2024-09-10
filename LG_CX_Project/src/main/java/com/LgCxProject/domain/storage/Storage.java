package com.LgCxProject.domain.storage;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_storage")
public class Storage {
    @Id
    private String storage_id;
    @Id
    private String product_id;

    private String supplement_id;
    private int stock;

}
