package com.LgCxProject.repository.storage;

import com.LgCxProject.domain.storage.Storage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface StorageRepository extends JpaRepository<Storage, String> {

    @Query(value = "select * from tb_storage where storage_id =:storageId",nativeQuery = true)
    Optional<Storage> findStorageByStorageId(@Param(value="storageId") String storageId);

    // TB_STORAGE 와  TB_USER_STORAGE_INFO 를 조인!
    @Query(value = "SELECT *  FROM TB_STORAGE A , TB_USER_STORAGE_INFO B WHERE A.STORAGE_ID =:storageId AND A.STORAGE_ID = B.STORAGE_ID" , nativeQuery = true)
    List<Object[]> joinTest(@Param("storageId") String storageId);


}
