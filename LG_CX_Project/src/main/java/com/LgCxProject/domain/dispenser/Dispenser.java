package com.LgCxProject.domain.dispenser;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "tb_product")
public class Dispenser {
    Dispenser dispenser;

    @Id
    private String product_id;
    private LocalDate manufacture_date;
    private String manufacture_company;

}