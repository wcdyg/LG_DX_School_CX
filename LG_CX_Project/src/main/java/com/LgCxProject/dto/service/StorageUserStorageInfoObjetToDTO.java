package com.LgCxProject.dto.service;

import com.LgCxProject.dto.domain.StorageUserStorageInfoDTO;
import com.LgCxProject.repository.storage.UserStorageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class StorageUserStorageInfoObjetToDTO {

    @Autowired
    UserStorageRepository userStorageRepository;
    // convertToDTO
    public static List<StorageUserStorageInfoDTO> convertStorageUserStorageInfoToDTO(List<Object[]> results) {
        List<StorageUserStorageInfoDTO> dtoList = new ArrayList<>();

        for (Object[] result : results) {
            StorageUserStorageInfoDTO dto = new StorageUserStorageInfoDTO();
            // 필드에 적절히 값을 매핑
            dto.setStorageId((String) result[0]);           // STORAGE_ID
            dto.setProductId((String) result[1]);           // PRODUCT_ID
            dto.setSupplementId((String) result[2]);        // SUPPLEMENT_ID
            int resultStock = ((BigDecimal) result[3]).intValue();
            dto.setStock(resultStock);                                // STOCK
            dto.setInfoNum((String) result[4]);             // INFO_NUM
            dto.setUserId((String) result[5]);              // USER_ID
            int resultSuppleOutAmount = ((BigDecimal) result[6]).intValue();
            dto.setSuppleOutAmount(resultSuppleOutAmount);                      // SUPPLE_OUT_AMOUNT
            dto.setIntakeTime((((Timestamp) result[7]).toLocalDateTime()).toLocalTime());  // INTAKE_TIME
            dto.setRegistTime(((Timestamp) result[8]).toLocalDateTime());  // REGIST_TIME

            dtoList.add(dto);  // DTO 객체를 리스트에 추가
        }
        return dtoList;
    }

    // storageId로 조인한 테이블에서
    public List<StorageUserStorageInfoDTO> getStorageUserStorageInfoByStorageId(String storageId) {
        List<Object[]> results = userStorageRepository.StorageJoinUserStorageByStorageId(storageId);
        List<StorageUserStorageInfoDTO> dtoList = convertStorageUserStorageInfoToDTO(results);
        return dtoList;
    }

    public List<StorageUserStorageInfoDTO> getStorageUserStorageInfoByUserId(String userId) {
        List<Object[]> results = userStorageRepository.StorageJoinUserStorageByUserId(userId);
        List<StorageUserStorageInfoDTO> dtoList = convertStorageUserStorageInfoToDTO(results);
        return dtoList;
    }

}
