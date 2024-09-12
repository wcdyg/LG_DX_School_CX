package com.LgCxProject.dto.service;

import com.LgCxProject.dto.domain.StorageSupplementInfoDTO;
import com.LgCxProject.dto.domain.StorageUserStorageInfoDTO;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class StorageSupplementInfoObjectToDTO {

    // convertToDTO
    public static StorageSupplementInfoDTO convertStorageSupplementInfoToDTO(Object[] result) {
        StorageSupplementInfoDTO dto = new StorageSupplementInfoDTO();
        Object[] nestedArray = (Object[]) result[0];

        // 각 필드에 값 설정
        dto.setStorageId((String) nestedArray[0]);  // STORAGE_ID
        dto.setSupplementId((String) nestedArray[1]);  // SUPPLEMENT_ID
        dto.setSupplementName((String) nestedArray[2]);  // SUPPLEMENT_NAME
        int resultSupplementCapacity = ((BigDecimal) nestedArray[3]).intValue();
        dto.setSupplementCapacity(resultSupplementCapacity);  // SUPPLEMENT_CAPACITY (BigDecimal -> int)
        dto.setMainIngredients((String) nestedArray[4]);  // MAIN_INGREDIENTS
        int resultIntakeAmount = ((BigDecimal) nestedArray[5]).intValue();
        dto.setIntakeAmount(resultIntakeAmount);  // INTAKE_AMOUNT (BigDecimal -> int)
        int resultIntakeFrequency = ((BigDecimal) nestedArray[6]).intValue();
        dto.setIntakeFrequency(resultIntakeFrequency);  // INTAKE_FREQUENCY (BigDecimal -> int)
        dto.setMedicationPrecautions((String) nestedArray[7]);  // MEDICATION_PRECAUTIONS
        dto.setIntakeMethod((String) nestedArray[8]);  // INTAKE_METHOD

        return dto;

    }

}
