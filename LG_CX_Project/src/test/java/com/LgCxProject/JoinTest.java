package com.LgCxProject;

import com.LgCxProject.dto.StorageUserStorageInfoDTO;
import com.LgCxProject.repository.storage.UserStorageRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Objects;

@SpringBootTest
public class JoinTest {


    @Autowired
    UserStorageRepository userStorageRepository;

    @Test
    @DisplayName("조인 테스트")
    public void 조인_테스트() {
        List<Object[]> results = userStorageRepository.joinTest("STRG001");

        for (Object[] result : results) {
            System.out.println(result[0]);
            System.out.println(result[1]);
            System.out.println(result[2]);
        }
    }
}
