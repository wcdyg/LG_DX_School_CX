package com.LgCxProject.service.storage;

import com.LgCxProject.domain.storage.UserStorageInfo;
import com.LgCxProject.repository.storage.UserStorageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserStorageService {

    @Autowired
    UserStorageRepository userStorageRepository;

    // userId 기반으로 storage 조회
    public List<UserStorageInfo> findStorageByUserId(String userId) {
        return userStorageRepository.findStorageByUserId(userId);
    }

}
