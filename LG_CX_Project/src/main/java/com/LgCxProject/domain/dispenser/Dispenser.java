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
    @Column(name = "product_id")
    private String productId;

    @Column(name = "manufacture_date")
    private LocalDate manufactureDate;

    @Column(name = "manufacture_company")
    private LocalDate manufactureCompany;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public LocalDate getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(LocalDate manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public LocalDate getManufactureCompany() {
        return manufactureCompany;
    }

    public void setManufactureCompany(LocalDate manufactureCompany) {
        this.manufactureCompany = manufactureCompany;
    }

    @Override
    public String toString() {
        return "Dispenser{" +
                "productId='" + productId + '\'' +
                ", manufactureDate=" + manufactureDate +
                ", manufactureCompany=" + manufactureCompany +
                '}';
    }
}