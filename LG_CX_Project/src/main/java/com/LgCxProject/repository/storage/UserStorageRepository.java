package com.LgCxProject.repository.storage;

import com.LgCxProject.domain.storage.UserStorageInfo;
import com.LgCxProject.dto.StorageUserStorageInfoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserStorageRepository extends JpaRepository<UserStorageInfo, String> {

    // 특정 userId로 userStorage 찾기
    @Query(value = "select * from tb_user_storage_info where user_id =:userId", nativeQuery = true)
    List<UserStorageInfo> findStorageByUserId(@Param("userId") String userId);

    @Query(value = "SELECT *  FROM TB_STORAGE A , TB_USER_STORAGE_INFO B WHERE A.STORAGE_ID = :storageId AND A.STORAGE_ID = B.STORAGE_ID" , nativeQuery = true)
    List<Object[]> joinTest(@Param("storageId") String storageId);


}
