package com.LgCxProject;

import com.LgCxProject.domain.storage.Storage;
import com.LgCxProject.domain.storage.UserStorageInfo;
import com.LgCxProject.domain.user.User;
import com.LgCxProject.dto.domain.StorageUserStorageInfoDTO;
import com.LgCxProject.dto.service.StorageUserStorageInfoObjetToDTO;
import com.LgCxProject.repository.storage.StorageRepository;
import com.LgCxProject.repository.storage.UserStorageRepository;
import com.LgCxProject.repository.user.UserRepository;
import com.LgCxProject.service.storage.UserStorageService;
import org.hibernate.type.descriptor.java.spi.JsonJavaType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class JoinTest {

    @Autowired
    StorageUserStorageInfoObjetToDTO objetToDTO;

    @Autowired
    UserStorageService userStorageService;

    @Autowired
    UserStorageRepository userStorageRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    StorageRepository storageRepository;

    @Test
    @DisplayName("조인 테스트")
    public void 조인_테스트() {

//        BigDecimal test = new BigDecimal(26);
//        int test1 = test.intValue();
//        System.out.println(test.intValue());
//        System.out.println(test1);
        List<UserStorageInfo> result3 =  userStorageService.findStorageByUserId("test");
        System.out.println(result3.size());


        List<StorageUserStorageInfoDTO> results = objetToDTO.getStorageUserStorageInfoByStorageId("STRG001");
        System.out.println(results.size());

        for (StorageUserStorageInfoDTO result : results) {
            System.out.println(result.getStorageId() + "사용자 아이디는" + result.getUserId());
            System.out.println(result);
            Optional<User> user = userRepository.findByUserId(result.getUserId());
            System.out.println(user.get().getName());
        }
    }

    @Test
    @DisplayName("스토리지 -1 테스트")
    public void 테스트() {


        Storage storage = storageRepository.findStorageByStorageId("STRG001").get();

        System.out.println(storage.getStock());


        storage.setStock(storage.getStock()-1);
        Storage after = storageRepository.save(storage);

        System.out.println(after.getStock());

    }

}