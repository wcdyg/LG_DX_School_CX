package com.LgCxProject.repository.supplements;

import com.LgCxProject.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface SupplementRepository extends JpaRepository<User, String> {

    @Query(value = "select * from tb_user where user_id =:userId and user_pw =:password",nativeQuery = true)
    User findUserByIdAndPassword(@Param(value="userId") String userId,
                                 @Param(value="password") String password);

    Optional<User> findByUserId(String userId);

}
