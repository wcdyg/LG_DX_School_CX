package com.LgCxProject.domain.dispenser;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "tb_product")
public class Dispenser {

    @Id
    private String product_id;
    private LocalDate manufacture_date;
    private String manufacture_company;

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public LocalDate getManufacture_date() {
        return manufacture_date;
    }

    public void setManufacture_date(LocalDate manufacture_date) {
        this.manufacture_date = manufacture_date;
    }

    public String getManufacture_company() {
        return manufacture_company;
    }

    public void setManufacture_company(String manufacture_company) {
        this.manufacture_company = manufacture_company;
    }

    @Override
    public String toString() {
        return "Dispenser{" +
                "product_id='" + product_id + '\'' +
                ", manufacture_date=" + manufacture_date +
                ", manufacture_company='" + manufacture_company + '\'' +
                '}';
    }
}