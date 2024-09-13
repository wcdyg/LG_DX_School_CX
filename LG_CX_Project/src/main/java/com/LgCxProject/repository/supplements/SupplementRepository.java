package com.LgCxProject.repository.supplements;
import com.LgCxProject.domain.storage.Storage;
import com.LgCxProject.domain.supplements.Supplements;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Optional;



@Repository
public interface SupplementRepository extends JpaRepository<Supplements, String> {
    // 영양제명을 기준으로 데이터를 조회
    Optional<Supplements> findBySupplementName(String supplementName);

    @Query(value = "select * from tb_supplement_info where supplement_id =:supplementId",nativeQuery = true)
    Optional<Supplements> findBySupplementId(@Param(value="supplementId") String supplementId);
}


