package com.LgCxProject.controller.supplements;

import com.LgCxProject.domain.storage.Storage;
import com.LgCxProject.domain.storage.UserStorageInfo;
import com.LgCxProject.domain.supplements.Supplements;
import com.LgCxProject.repository.storage.StorageRepository;
import com.LgCxProject.repository.storage.UserStorageRepository;
import com.LgCxProject.repository.supplements.SupplementRepository;
import com.LgCxProject.service.supplements.SupplementService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Calendar;
import java.util.Date;

@RestController
public class SupplementDataController {

    @Autowired
    UserStorageRepository userStorageRepository;
    @Autowired
    StorageRepository storageRepository;
    @Autowired
    SupplementRepository supplementRepository;

    @Autowired
    SupplementService supplementService;

    @PostMapping("/saveIntakeTime")
    public ResponseEntity<String> saveIntakeTime(@RequestParam(name = "hour") Integer hour,
                                                 @RequestParam(name = "minute") Integer minute,
                                                 HttpSession session) {
        try {
            LocalTime intakeTime = LocalTime.of(hour, minute); // 예: 14:30
            // LocalTime을 java.util.Date로 변환
            Date convertedDate = convertLocalTimeToDate(intakeTime);

            // 세션에 시간 정보 저장
            session.setAttribute("intakeTime", convertedDate);

            System.out.println("convertedDate == " + convertedDate);
            return ResponseEntity.ok("Time saved successfully");
        } catch (DateTimeParseException e) {
            System.err.println("Invalid time format: " + e.getMessage());
            return ResponseEntity.badRequest().body("Invalid time format");
        } catch (Exception e) {
            System.err.println("Error saving time: " + e.getMessage());
            return ResponseEntity.internalServerError().body("Error saving time");
        }
    }

    public static Date convertLocalTimeToDate(LocalTime localTime) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, localTime.getHour());
        calendar.set(Calendar.MINUTE, localTime.getMinute());
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    @PostMapping("/saveUserStorage")
    public String storageSaveProcess(HttpSession session) {
        String supplementId = (String) session.getAttribute("supplementId");
        int suppleOutAmount = (int) session.getAttribute("suppleOutAmount");
        String userId = (String) session.getAttribute("userId");
        Date intakeTime = (Date) session.getAttribute("intakeTime");
        UserStorageInfo userStorageInfo = supplementService.makeSupplementUserStorage(supplementId,suppleOutAmount,userId,intakeTime,session);

        Storage storage = new Storage();
        storage.setStorageId(userStorageInfo.getStorageId());
        storage.setSupplementId(supplementId);
        storage.setProductId(userStorageInfo.getProductId());
        storage.setStock(supplementRepository.findBySupplementId(supplementId).get().getSupplementCapacity());

        userStorageRepository.save(userStorageInfo);
        storageRepository.save(storage);

        return "/storage/newstorage";
    }
}



