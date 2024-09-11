package com.LgCxProject.dto;

import java.util.Date;

public class StorageUserStorageInfoDTO {


    private String storageId;           // STORAGE_ID
    private String productId;           // PRODUCT_ID
    private String supplementId;        // SUPPLEMENT_ID
    private int stock;                  // STOCK
    private String infoNum;             // INFO_NUM
    private String userId;              // USER_ID
    private int suppleOutAmount;        // SUPPLE_OUT_AMOUNT
    private Date intakeTime;            // INTAKE_TIME
    private Date registTime;            // REGIST_TIME
    private Date medicalTreatmentDate;  // MEDICAL_TREATMENT_DATE

    // 생성자
    public StorageUserStorageInfoDTO(String storageId, String productId, String supplementId, int stock, String infoNum,
                                     String userId, int suppleOutAmount, Date intakeTime, Date registTime, Date medicalTreatmentDate) {
        this.storageId = storageId;
        this.productId = productId;
        this.supplementId = supplementId;
        this.stock = stock;
        this.infoNum = infoNum;
        this.userId = userId;
        this.suppleOutAmount = suppleOutAmount;
        this.intakeTime = intakeTime;
        this.registTime = registTime;
        this.medicalTreatmentDate = medicalTreatmentDate;
    }

    // getters, setters

    public String getStorageId() {
        return storageId;
    }

    public void setStorageId(String storageId) {
        this.storageId = storageId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getSupplementId() {
        return supplementId;
    }

    public void setSupplementId(String supplementId) {
        this.supplementId = supplementId;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getInfoNum() {
        return infoNum;
    }

    public void setInfoNum(String infoNum) {
        this.infoNum = infoNum;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getSuppleOutAmount() {
        return suppleOutAmount;
    }

    public void setSuppleOutAmount(int suppleOutAmount) {
        this.suppleOutAmount = suppleOutAmount;
    }

    public Date getIntakeTime() {
        return intakeTime;
    }

    public void setIntakeTime(Date intakeTime) {
        this.intakeTime = intakeTime;
    }

    public Date getRegistTime() {
        return registTime;
    }

    public void setRegistTime(Date registTime) {
        this.registTime = registTime;
    }

    public Date getMedicalTreatmentDate() {
        return medicalTreatmentDate;
    }

    public void setMedicalTreatmentDate(Date medicalTreatmentDate) {
        this.medicalTreatmentDate = medicalTreatmentDate;
    }

    @Override
    public String toString() {
        return "StorageUserStorageInfoDTO{" +
                "storageId='" + storageId + '\'' +
                ", productId='" + productId + '\'' +
                ", supplementId='" + supplementId + '\'' +
                ", stock=" + stock +
                ", infoNum='" + infoNum + '\'' +
                ", userId='" + userId + '\'' +
                ", suppleOutAmount=" + suppleOutAmount +
                ", intakeTime=" + intakeTime +
                ", registTime=" + registTime +
                ", medicalTreatmentDate=" + medicalTreatmentDate +
                '}';
    }
}


