package com.LgCxProject.service.storage;

import com.LgCxProject.domain.storage.Storage;
import com.LgCxProject.repository.storage.StorageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StorageService {
    @Autowired
    StorageRepository storageRepository;

    //전체 storage 조회
    public List<Storage> findAllStorage() {
        return storageRepository.findAll();
    }

    //Storage 화면 설정

}
