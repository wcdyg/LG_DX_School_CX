package com.LgCxProject.domain.supplements;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_supplement_info")
public class Supplements {
    @Id
    private String supplement_id;
    private String supplement_name;
    private int supplement_capacity;
    private String main_ingredients;
    private String intake_amount;
    private String intake_frequency;
    private String medication_precautions;

}
