package com.LgCxProject.repository.storage;

import com.LgCxProject.domain.storage.Storage;
import com.LgCxProject.domain.supplements.Supplements;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface StorageRepository extends JpaRepository<Storage, String> {

    @Query(value = "select * from tb_storage where storage_id  =:storageId",nativeQuery = true)
    Optional<Storage> findStorageByStorageId(@Param(value="storageId") String storageId);

    // TB_STORAGE 와  TB_SUPPLEMENT_INFO 를 조인!
    @Query(value = "SELECT A.STORAGE_ID, B.*  FROM TB_STORAGE A , TB_SUPPLEMENT_INFO B WHERE A.SUPPLEMENT_ID = B.SUPPLEMENT_ID AND A.STORAGE_ID =:storageId" , nativeQuery = true)
    Object[] findSupplementByStorageId(@Param("storageId") String storageId);


}
