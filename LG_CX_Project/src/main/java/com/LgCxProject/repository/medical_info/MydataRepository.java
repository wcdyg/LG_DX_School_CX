package com.LgCxProject.repository.medical_info;
import com.LgCxProject.domain.medical_info.Mydata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MydataRepository extends JpaRepository<Mydata, String> {

    // USER_ID를 통해 drug_ingredient 값을 가져오는 메서드
    @Query(value = "select * from tb_mydata where user_id = :userId", nativeQuery = true)
    List<Mydata> findDrugIngredientByUserId(@Param("userId") String userId);
}
