package com.LgCxProject.domain.supplements;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_supplement_info")
public class Supplements {

    @Id  // 기본 키로 매핑
    @Column(name = "supplement_id")
    private String supplementId;

    @Column(name = "supplement_name")
    private String supplementName;

    @Column(name = "supplement_capacity")
    private int supplementCapacity;

    @Column(name = "main_ingredients")
    private String mainIngredients;

    @Column(name = "intake_amount")
    private int intakeAmount;

    @Column(name = "intake_frequency")
    private int intakeFrequency;

    @Column(name = "medication_precautions")
    private String medicationPrecautions;

    @Column(name = "intake_method")
    private String intakeMethod;

    public String getSupplementId() {
        return supplementId;
    }

    public void setSupplementId(String supplementId) {
        this.supplementId = supplementId;
    }

    public String getSupplementName() {
        return supplementName;
    }

    public void setSupplementName(String supplementName) {
        this.supplementName = supplementName;
    }

    public int getSupplementCapacity() {
        return supplementCapacity;
    }

    public void setSupplementCapacity(int supplementCapacity) {
        this.supplementCapacity = supplementCapacity;
    }

    public String getMainIngredients() {
        return mainIngredients;
    }

    public void setMainIngredients(String mainIngredients) {
        this.mainIngredients = mainIngredients;
    }

    public int getIntakeAmount() {
        return intakeAmount;
    }

    public void setIntakeAmount(int intakeAmount) {
        this.intakeAmount = intakeAmount;
    }

    public int getIntakeFrequency() {
        return intakeFrequency;
    }

    public void setIntakeFrequency(int intakeFrequency) {
        this.intakeFrequency = intakeFrequency;
    }

    public String getMedicationPrecautions() {
        return medicationPrecautions;
    }

    public void setMedicationPrecautions(String medicationPrecautions) {
        this.medicationPrecautions = medicationPrecautions;
    }

    public String getIntakeMethod() {
        return intakeMethod;
    }

    public void setIntakeMethod(String intakeMethod) {
        this.intakeMethod = intakeMethod;
    }

    @Override
    public String toString() {
        return "Supplements{" +
                "supplementId='" + supplementId + '\'' +
                ", supplementName='" + supplementName + '\'' +
                ", supplementCapacity=" + supplementCapacity +
                ", mainIngredients='" + mainIngredients + '\'' +
                ", intakeAmount='" + intakeAmount + '\'' +
                ", intakeFrequency='" + intakeFrequency + '\'' +
                ", medicationPrecautions='" + medicationPrecautions + '\'' +
                ", intakeMethod='" + intakeMethod + '\'' +
                '}';
    }
}
