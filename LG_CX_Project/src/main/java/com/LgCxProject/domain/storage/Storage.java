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

    public String getStorage_id() {
        return storage_id;
    }

    public void setStorage_id(String storage_id) {
        this.storage_id = storage_id;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getSupplement_id() {
        return supplement_id;
    }

    public void setSupplement_id(String supplement_id) {
        this.supplement_id = supplement_id;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Storage{" +
                "storage_id='" + storage_id + '\'' +
                ", product_id='" + product_id + '\'' +
                ", supplement_id='" + supplement_id + '\'' +
                ", stock=" + stock +
                '}';
    }
}
