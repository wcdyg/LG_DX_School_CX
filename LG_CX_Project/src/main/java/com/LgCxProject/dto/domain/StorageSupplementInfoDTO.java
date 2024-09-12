package com.LgCxProject.dto.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

public class StorageSupplementInfoDTO {

    private String storageId;          // STORAGE_ID
    private String supplementId;       // SUPPLEMENT_ID
    private String supplementName;     // SUPPLEMENT_NAME
    private int supplementCapacity;    // SUPPLEMENT_CAPACITY
    private String mainIngredients;    // MAIN_INGREDIENTS
    private int intakeAmount;          // INTAKE_AMOUNT
    private int intakeFrequency;       // INTAKE_FREQUENCY
    private String medicationPrecautions;  // MEDICATION_PRECAUTIONS
    private String intakeMethod;       // INTAKE_METHOD

    // 기본 생성자
    public StorageSupplementInfoDTO() {
    }

    // 모든 필드를 포함하는 생성자
    public StorageSupplementInfoDTO(String storageId, String supplementId, String supplementName, int supplementCapacity,
                          String mainIngredients, int intakeAmount, int intakeFrequency,
                          String medicationPrecautions, String intakeMethod) {
        this.storageId = storageId;
        this.supplementId = supplementId;
        this.supplementName = supplementName;
        this.supplementCapacity = supplementCapacity;
        this.mainIngredients = mainIngredients;
        this.intakeAmount = intakeAmount;
        this.intakeFrequency = intakeFrequency;
        this.medicationPrecautions = medicationPrecautions;
        this.intakeMethod = intakeMethod;
    }

    // Getter and Setter methods

    public String getStorageId() {
        return storageId;
    }

    public void setStorageId(String storageId) {
        this.storageId = storageId;
    }

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
        return "StorageSupplementInfoDTO{" +
                "storageId='" + storageId + '\'' +
                ", supplementId='" + supplementId + '\'' +
                ", supplementName='" + supplementName + '\'' +
                ", supplementCapacity=" + supplementCapacity +
                ", mainIngredients='" + mainIngredients + '\'' +
                ", intakeAmount=" + intakeAmount +
                ", intakeFrequency=" + intakeFrequency +
                ", medicationPrecautions='" + medicationPrecautions + '\'' +
                ", intakeMethod='" + intakeMethod + '\'' +
                '}';
    }
}
