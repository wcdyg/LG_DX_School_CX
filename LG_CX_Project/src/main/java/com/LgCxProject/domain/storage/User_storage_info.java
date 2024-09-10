package com.LgCxProject.domain.storage;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "tb_user_storage_info")
public class User_storage_info {

    @Id
    @Column(name = "user_id")
    private String userId;
    private String info_num;
    private String storage_id;
    private LocalDate medical_treatment_date;
    private String product_id;
    private String supplement_id;
    private LocalDate supple_out_amount;
    private int intake_time;
    private LocalDate regist_time;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getInfo_num() {
        return info_num;
    }

    public void setInfo_num(String info_num) {
        this.info_num = info_num;
    }

    public String getStorage_id() {
        return storage_id;
    }

    public void setStorage_id(String storage_id) {
        this.storage_id = storage_id;
    }

    public LocalDate getMedical_treatment_date() {
        return medical_treatment_date;
    }

    public void setMedical_treatment_date(LocalDate medical_treatment_date) {
        this.medical_treatment_date = medical_treatment_date;
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

    public LocalDate getSupple_out_amount() {
        return supple_out_amount;
    }

    public void setSupple_out_amount(LocalDate supple_out_amount) {
        this.supple_out_amount = supple_out_amount;
    }

    public int getIntake_time() {
        return intake_time;
    }

    public void setIntake_time(int intake_time) {
        this.intake_time = intake_time;
    }

    public LocalDate getRegist_time() {
        return regist_time;
    }

    public void setRegist_time(LocalDate regist_time) {
        this.regist_time = regist_time;
    }

    @Override
    public String toString() {
        return "user_storage_info{" +
                "userId='" + userId + '\'' +
                ", info_num='" + info_num + '\'' +
                ", storage_id='" + storage_id + '\'' +
                ", medical_treatment_date=" + medical_treatment_date +
                ", product_id='" + product_id + '\'' +
                ", supplement_id='" + supplement_id + '\'' +
                ", supple_out_amount=" + supple_out_amount +
                ", intake_time=" + intake_time +
                ", regist_time=" + regist_time +
                '}';
    }
}
