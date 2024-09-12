package com.LgCxProject;

import com.LgCxProject.domain.storage.Storage;
import com.LgCxProject.domain.supplements.Supplements;
import com.LgCxProject.dto.domain.StorageSupplementInfoDTO;
import com.LgCxProject.dto.service.StorageSupplementInfoObjectToDTO;
import com.LgCxProject.repository.storage.StorageRepository;
import com.LgCxProject.repository.storage.UserStorageRepository;
import com.LgCxProject.repository.user.UserRepository;
import com.LgCxProject.service.storage.StorageService;
import jdk.swing.interop.SwingInterOpUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
class ExampleApplicationTests {

	@Autowired
	StorageRepository storageRepository;
	@Autowired
	UserStorageRepository userStorageRepository;
	@Autowired
	UserRepository userRepository;

	@Autowired
	StorageSupplementInfoObjectToDTO storageSupplementInfoObjectToDTO;
	@Autowired
	StorageService storageService;


	public HashMap<String, List<String>> containerUserName() {
		List<String> userNameList = new ArrayList<>();
		HashMap<String, List<String>> containerUserName = new HashMap<>();
		List<Storage> storages = storageRepository.findAll();
		for (Storage storage : storages) {
			String storageNum = storage.getStorageId().replaceAll("[^1-9]","");
			String key = String.format("container%sUsername",storageNum);

			List<String> userIdList = userStorageRepository.findUserIdByStorageId(storage.getStorageId());
			for (String userId : userIdList) {
				userNameList.add(userRepository.findByUserId(userId).get().getName());
			}
			containerUserName.put(key, userNameList);
		}
		return containerUserName;
	}

	// 보관함 별 사용자 이름 리스트


	@Test
	void contextLoads() {

		HashMap<String, List<String>> containerUserName= storageService.containerUserName();

		List<String> userIdList = userStorageRepository.findUserIdByStorageId("STRG001");
		System.out.println(userIdList.size());
		System.out.println(String.join("<br>",userIdList));
//		for(String key: containerUserName.keySet()){
//			System.out.println(key);
//			System.out.println(String.join("<br>",containerUserName.get(key)));
//		}



	}

}
