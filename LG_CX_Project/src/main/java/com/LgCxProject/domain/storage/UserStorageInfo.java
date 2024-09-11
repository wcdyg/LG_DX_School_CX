package com.LgCxProject.domain.storage;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "tb_user_storage_info")
public class UserStorageInfo {
    @Id
    @Column(name = "info_num") // 'info_num' 열과 매핑
    private String infoNum;

    @Column(name = "user_id") // 'user_id' 열과 매핑
    private String userId;

    @Column(name = "storage_id") // 'storage_id' 열과 매핑
    private String storageId;

    @Column(name = "product_id") // 'product_id' 열과 매핑
    private String productId;

    @Column(name = "supplement_id") // 'supplement_id' 열과 매핑
    private String supplementId;

    @Column(name = "supple_out_amount") // 'supple_out_amount' 열과 매핑
    private int suppleOutAmount;

    @Column(name = "intake_time") // 'intake_time' 열과 매핑
    private LocalDate intakeTime;

    @Column(name = "regist_time") // 'regist_time' 열과 매핑
    private LocalDate registTime;


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

    public int getSuppleOutAmount() {
        return suppleOutAmount;
    }

    public void setSuppleOutAmount(int suppleOutAmount) {
        this.suppleOutAmount = suppleOutAmount;
    }

    public LocalDate getIntakeTime() {
        return intakeTime;
    }

    public void setIntakeTime(LocalDate intakeTime) {
        this.intakeTime = intakeTime;
    }

    public LocalDate getRegistTime() {
        return registTime;
    }

    public void setRegistTime(LocalDate registTime) {
        this.registTime = registTime;
    }

    @Override
    public String toString() {
        return "UserStorageInfo{" +
                "infoNum='" + infoNum + '\'' +
                ", userId='" + userId + '\'' +
                ", storageId='" + storageId + '\'' +
                ", productId='" + productId + '\'' +
                ", supplementId='" + supplementId + '\'' +
                ", suppleOutAmount=" + suppleOutAmount +
                ", intakeTime=" + intakeTime +
                ", registTime=" + registTime +
                '}';
    }
}
