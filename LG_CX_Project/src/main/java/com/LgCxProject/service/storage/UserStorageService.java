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

    // storage 저장
    public void saveStorageAndReturnStorageId(String title, String content , String reviewerId) {

        // 리뷰 객체 생성 및 저장
        UserStorageInfo userStorageInfo = new UserStorageInfo();
//      PK인 info_num 설정하기 시퀀스?!
//        userStorageInfo.setInfo_num(title);
//        userStorageInfo.setReviewContent(content);
//        userStorageInfo.setReviewerId(reviewerId);
//
//        // 리뷰를 저장하고 생성된 ID 반환
//        Review savedReview = storageRepository.save(review);
//        return savedReview.getReviewNo();
        return;

    }


}
