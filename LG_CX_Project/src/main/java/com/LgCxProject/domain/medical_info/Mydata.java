package com.LgCxProject.domain.medical_info;
import com.LgCxProject.domain.user.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import oracle.sql.DATE;

import java.time.LocalDate;

@Entity
@Table(name = "tb_mydata")
public class Mydata {
    @Id
    @Column(name = "medical_treatment_id")
    private String medicalTreatmentId;

    @Id
    @Column(name = "drug_name")
    private String drugName;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "medical_treatment_date")
    private LocalDate medicalTreatmentDate;

    @Column(name = "diagnosis_name")
    private String diagnosisName;

    @Column(name = "drug_ingredient")
    private String drugIngredient;

    public String getMedicalTreatmentId() {
        return medicalTreatmentId;
    }

    public void setMedicalTreatmentId(String medicalTreatmentId) {
        this.medicalTreatmentId = medicalTreatmentId;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public LocalDate getMedicalTreatmentDate() {
        return medicalTreatmentDate;
    }

    public void setMedicalTreatmentDate(LocalDate medicalTreatmentDate) {
        this.medicalTreatmentDate = medicalTreatmentDate;
    }

    public String getDiagnosisName() {
        return diagnosisName;
    }

    public void setDiagnosisName(String diagnosisName) {
        this.diagnosisName = diagnosisName;
    }

    public String getDrugIngredient() {
        return drugIngredient;
    }

    public void setDrugIngredient(String drugIngredient) {
        this.drugIngredient = drugIngredient;
    }

    @Override
    public String toString() {
        return "Mydata{" +
                "medicalTreatmentId='" + medicalTreatmentId + '\'' +
                ", drugName='" + drugName + '\'' +
                ", userId='" + userId + '\'' +
                ", medicalTreatmentDate=" + medicalTreatmentDate +
                ", diagnosisName='" + diagnosisName + '\'' +
                ", drugIngredient='" + drugIngredient + '\'' +
                '}';
    }
}
