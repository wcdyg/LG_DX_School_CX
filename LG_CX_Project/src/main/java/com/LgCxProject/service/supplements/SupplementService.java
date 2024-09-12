package com.LgCxProject.service.supplements;
import com.LgCxProject.domain.storage.UserStorageInfo;
import com.LgCxProject.domain.supplements.Supplements;
import com.LgCxProject.domain.user.User;
import com.LgCxProject.repository.storage.UserStorageRepository;
import com.LgCxProject.repository.supplements.SupplementRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.Optional;

@Service
public class SupplementService {

    @Autowired
    SupplementRepository supplementRepository;
    @Autowired
    UserStorageRepository userStroageRepository;

    // 영양제 찾기
    public Optional<Supplements> FindSupplement(String supplementName){
        Optional<Supplements> supplements = supplementRepository.findBySupplementName(supplementName);
        return supplements;
    }

    // 다음 ID를 생성하는 메서드
    public static String generateNextInfoNum(String currentInfoNum) {
        // 숫자 부분만 추출 (예: "009" 추출)
        // 만약 "STRGINFO"가 고정된 접두사라면, 이를 기준으로 8번째 이후 문자를 추출
        String numberPart = currentInfoNum.substring(8);

        // 숫자 부분을 정수로 변환
        int number = Integer.parseInt(numberPart);

        // 숫자를 1 증가
        number++;

        // 증가된 숫자를 다시 문자열로 변환하되, 3자리로 포맷팅 (예: "010")
        String newNumberPart = String.format("%03d", number);

        // 새로운 ID 생성 (예: "STRGINFO010")
        return currentInfoNum.substring(0, 8) + newNumberPart;
    }

    // 사용자 저장소 정보 만들기
    public UserStorageInfo makeSupplementUserStorage(String supplementId, int suppleOutAmount,
                                                     String userId, Date intakeTime, HttpSession session) {
        UserStorageInfo userStorageInfo = new UserStorageInfo();
//        System.out.println("여기는 타나1");
        String currentInfoNum = userStroageRepository.findRecentInfoNum().getInfoNum();
//        System.out.println("여기는 타나2");
        String productId = userStroageRepository.findRecentInfoNum().getProductId();
        String storageId = "STRG00" + session.getAttribute("container").toString();
        // setter 메서드를 통해 값 설정
        userStorageInfo.setInfoNum(generateNextInfoNum(currentInfoNum));
        userStorageInfo.setUserId(userId);
        userStorageInfo.setStorageId(storageId);
        userStorageInfo.setProductId(productId);
        userStorageInfo.setSupplementId(supplementId);
        userStorageInfo.setSuppleOutAmount(suppleOutAmount);
        userStorageInfo.setIntakeTime(intakeTime);
        userStorageInfo.setRegistTime(LocalDateTime.now());

        // toString()으로 설정된 값 확인
//        System.out.println("TESTTESTTEST" + userStorageInfo);
        return userStorageInfo;
    }


}
