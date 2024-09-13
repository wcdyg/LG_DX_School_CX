package com.LgCxProject.service.storage;
import com.LgCxProject.domain.storage.Storage;
import com.LgCxProject.domain.storage.UserStorageInfo;
import com.LgCxProject.domain.supplements.Supplements;
import com.LgCxProject.dto.domain.StorageSupplementInfoDTO;
import com.LgCxProject.dto.service.StorageSupplementInfoObjectToDTO;
import com.LgCxProject.repository.storage.StorageRepository;
import com.LgCxProject.repository.storage.UserStorageRepository;
import com.LgCxProject.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class StorageService {
    @Autowired
    StorageRepository storageRepository;
    @Autowired
    UserStorageRepository userStorageRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    StorageSupplementInfoObjectToDTO storageSupplementInfoObjectToDTO;

    // 전체 storage 조회
    public List<Storage> findAllStorage() {
        return storageRepository.findAll();
    }

    //보관함 별 사용자 이름 리스트
    public HashMap<String, List<String>> containerUserName() {
        HashMap<String, List<String>> containerUserName = new HashMap<>();
        List<Storage> storages = storageRepository.findAll();
        for (Storage storage : storages) {
            String storageNum = storage.getStorageId().replaceAll("[^1-9]","");
            String key = String.format("container%sUsername",storageNum);

            List<String> userIdList = userStorageRepository.findUserIdByStorageId(storage.getStorageId());
            List<String> userNameList = new ArrayList<>();
            for (String userId : userIdList) {
                userNameList.add(userRepository.findByUserId(userId).get().getName());
            }
            containerUserName.put(key, userNameList);
        }
        return containerUserName;
    }

    //보관함 별 재고 보여주기
    public HashMap<String, Integer> containerSupplementCount() {
        List<Storage> storages = storageRepository.findAll();
        HashMap<String, Integer> containerSupplementCount = new HashMap<>();

        for(Storage storage: storages){
            String storageId = storage.getStorageId();
            String storageNum = storageId.replaceAll("[^1-9]","");
            String key = String.format("container%sSupplementCount",storageNum);
            containerSupplementCount.put(key,storage.getStock());
        }
        return containerSupplementCount;
    }

    //보관함 별 영양제 용량 가져오기
    public HashMap<String, Integer> containerSupplementCapacity() {
        List<Storage> storages = storageRepository.findAll();
        HashMap<String, Integer> containerSupplementCapacity = new HashMap<>();
        for (Storage storage : storages) {
            Object[] result = storageRepository.findSupplementByStorageId(storage.getStorageId());
            StorageSupplementInfoDTO supplements = storageSupplementInfoObjectToDTO.convertStorageSupplementInfoToDTO(result);
            String storageNum = storage.getStorageId().replaceAll("[^1-9]", "");
            String key = String.format("container%sSupplementCapacity", storageNum);
            containerSupplementCapacity.put(key, supplements.getSupplementCapacity());
        }
        return containerSupplementCapacity;
    }

    //보관함 별 영양제 정보 가져오기
    public HashMap<String, String> containerSupplementName(){
        List<Storage> storages = storageRepository.findAll();
        HashMap<String, String> containerSupplementName = new HashMap<>();
        for(Storage storage: storages){
            Object[] result = storageRepository.findSupplementByStorageId(storage.getStorageId());
            StorageSupplementInfoDTO supplements = storageSupplementInfoObjectToDTO.convertStorageSupplementInfoToDTO(result);
            String storageNum = storage.getStorageId().replaceAll("[^1-9]","");
            String key = String.format("container%s",storageNum);
            containerSupplementName.put(key,supplements.getSupplementName());
        }
        return containerSupplementName;
    }

    //사용자 ID와 보관함 번호에 따라 색상을 결정하는 메서드
    public HashMap<String ,String> containerColor(String userId) {
        HashMap<String ,String> containerColor = new HashMap<>();
        // 모든 보관함에 기본 색상 적용
        for(int i=1; i < 7; i++){
            String key = String.format("container%sColor",i);
            containerColor.put(key,"#E6E6E6");
        }
        // 보관함 정보가 있는 보관함에 사용자가 쓰는 색상 적용
        List<Storage> storages = storageRepository.findAll();
        for(Storage storage: storages) {
            String storageNum = storage.getStorageId().replaceAll("[^1-9]", "");
            String key = String.format("container%sColor", storageNum);
            containerColor.put(key, "#F0ECE4");
        }
        // 현재 userId가 사용하는 보관함에 user색상 적용
        List<UserStorageInfo> userStorageInfoList = userStorageRepository.findStorageByUserId(userId);
        for(UserStorageInfo userStorageInfo: userStorageInfoList) {
            String storageNum = userStorageInfo.getStorageId().replaceAll("[^1-9]", "");
            String key = String.format("container%sColor", storageNum);
            containerColor.put(key, "#ffffff");
        }
        return containerColor;
    }

//    public void decrementSupplementCount(String containerId) {
//        storageRepository.decrementSupplementCount(containerId);
//    }

}
