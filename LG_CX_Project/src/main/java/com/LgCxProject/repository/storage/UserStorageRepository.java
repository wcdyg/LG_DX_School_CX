package com.LgCxProject.repository.storage;

import com.LgCxProject.domain.storage.UserStorageInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserStorageRepository extends JpaRepository<UserStorageInfo, String> {

    // 특정 userId로 userStorage 찾기
    @Query(value = "select * from tb_user_storage_info where user_id =:userId", nativeQuery = true)
    List<UserStorageInfo> findStorageByUserId(@Param("userId") String userId);

    // TB_STORAGE 와  TB_USER_STORAGE_INFO 를 JOIN
    // = TB_STORAGE(보관함 마다)의 STOCK
    // = TB_STORAGE(보관함을 사용하는) TB_USER_STORAGE_INFO의 USER_ID
    // = TB_USER_STORAGE_INFO(보관함을 사용하는 사용자 마다)의 SUPPLE_OUT_AMOUNT
    @Query(value = "SELECT A.*,B.INFO_NUM, B.USER_ID,B.SUPPLE_OUT_AMOUNT,B.INTAKE_TIME,B.REGIST_TIME" +
            " FROM TB_STORAGE A " +
            " JOIN TB_USER_STORAGE_INFO B " +
            " ON A.STORAGE_ID = B.STORAGE_ID " +
            " WHERE B.STORAGE_ID =:storageId " , nativeQuery = true)
    List<Object[]> StorageJoinUserStorageByStorageId(@Param("storageId") String storageId);


    @Query(value = "SELECT A.*,B.INFO_NUM, B.USER_ID,B.SUPPLE_OUT_AMOUNT,B.INTAKE_TIME,B.REGIST_TIME" +
            "  FROM TB_STORAGE A , TB_USER_STORAGE_INFO B WHERE A.STORAGE_ID = B.STORAGE_ID AND B.USER_ID =:userId" , nativeQuery = true)
    List<Object[]> StorageJoinUserStorageByUserId(@Param("userId") String userId);



}
