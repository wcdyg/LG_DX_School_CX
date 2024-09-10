package com.LgCxProject.domain.medical_info;
import com.LgCxProject.domain.user.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_mydate")
public class Mydate {


    @Id
    private String medical_treatment_id;
    @Id
    private String drug_name;
    @Column(name = "user_id")
    private String userId;
    private int medical_treatment_date;
    private String diagnosis_name;
    private String drug_ingredient;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMedical_treatment_id() {
        return medical_treatment_id;
    }

    public void setMedical_treatment_id(String medical_treatment_id) {
        this.medical_treatment_id = medical_treatment_id;
    }

    public String getDrug_name() {
        return drug_name;
    }

    public void setDrug_name(String drug_name) {
        this.drug_name = drug_name;
    }

    public int getMedical_treatment_date() {
        return medical_treatment_date;
    }

    public void setMedical_treatment_date(int medical_treatment_date) {
        this.medical_treatment_date = medical_treatment_date;
    }

    public String getDiagnosis_name() {
        return diagnosis_name;
    }

    public void setDiagnosis_name(String diagnosis_name) {
        this.diagnosis_name = diagnosis_name;
    }

    public String getDrug_ingredient() {
        return drug_ingredient;
    }

    public void setDrug_ingredient(String drug_ingredient) {
        this.drug_ingredient = drug_ingredient;
    }

    @Override
    public String toString() {
        return "Mydate{" +
                "userId='" + userId + '\'' +
                ", medical_treatment_id='" + medical_treatment_id + '\'' +
                ", drug_name='" + drug_name + '\'' +
                ", medical_treatment_date=" + medical_treatment_date +
                ", diagnosis_name='" + diagnosis_name + '\'' +
                ", drug_ingredient='" + drug_ingredient + '\'' +
                '}';
    }
}
