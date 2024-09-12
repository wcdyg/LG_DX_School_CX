package com.LgCxProject.domain.medical_info;

import java.io.Serializable;
import java.util.Objects;

public class MydataId implements Serializable {

    private String medicalTreatmentId;
    private String drugName;

    public MydataId() {

    }

    public MydataId(String medicalTreatmentId, String drugName) {
        this.medicalTreatmentId = medicalTreatmentId;
        this.drugName = drugName;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MydataId mydataId = (MydataId) o;
        return Objects.equals(medicalTreatmentId, mydataId.medicalTreatmentId) &&
                Objects.equals(drugName, mydataId.drugName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(medicalTreatmentId, drugName);
    }
}
