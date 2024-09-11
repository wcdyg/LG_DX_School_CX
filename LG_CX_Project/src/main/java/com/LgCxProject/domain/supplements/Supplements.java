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
    private String intake_method;

    public String getSupplement_id() {
        return supplement_id;
    }

    public void setSupplement_id(String supplement_id) {
        this.supplement_id = supplement_id;
    }

    public String getSupplement_name() {
        return supplement_name;
    }

    public void setSupplement_name(String supplement_name) {
        this.supplement_name = supplement_name;
    }

    public int getSupplement_capacity() {
        return supplement_capacity;
    }

    public void setSupplement_capacity(int supplement_capacity) {
        this.supplement_capacity = supplement_capacity;
    }

    public String getMain_ingredients() {
        return main_ingredients;
    }

    public void setMain_ingredients(String main_ingredients) {
        this.main_ingredients = main_ingredients;
    }

    public String getIntake_amount() {
        return intake_amount;
    }

    public void setIntake_amount(String intake_amount) {
        this.intake_amount = intake_amount;
    }

    public String getIntake_frequency() {
        return intake_frequency;
    }

    public void setIntake_frequency(String intake_frequency) {
        this.intake_frequency = intake_frequency;
    }

    public String getMedication_precautions() {
        return medication_precautions;
    }

    public void setMedication_precautions(String medication_precautions) {
        this.medication_precautions = medication_precautions;
    }

    public String getIntake_method() {
        return intake_method;
    }

    public void setIntake_method(String intake_method) {
        this.intake_method = intake_method;
    }

    @Override
    public String toString() {
        return "Supplements{" +
                "supplement_id='" + supplement_id + '\'' +
                ", supplement_name='" + supplement_name + '\'' +
                ", supplement_capacity=" + supplement_capacity +
                ", main_ingredients='" + main_ingredients + '\'' +
                ", intake_amount='" + intake_amount + '\'' +
                ", intake_frequency='" + intake_frequency + '\'' +
                ", medication_precautions='" + medication_precautions + '\'' +
                ", intake_method='" + intake_method + '\'' +

                '}';
    }
}
