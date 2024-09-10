package com.LgCxProject.repository.storage;

import com.LgCxProject.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StorageRepository extends JpaRepository<User, String> {


}
