package com.LgCxProject.service.supplements;
import com.LgCxProject.domain.medical_info.Mydata;
import com.LgCxProject.domain.supplements.Supplements;
import com.LgCxProject.repository.medical_info.MydataRepository;
import com.LgCxProject.repository.supplements.SupplementRepository;
import com.LgCxProject.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplementService {

    @Autowired
    SupplementRepository supplementRepository;

    @Autowired
    MydataRepository mydataRepository;

    //영양제 이름으로 영양제 정보를 찾아서 던지는 메소드
    public Optional<Supplements> FindSupplement(String supplementName){
        Optional<Supplements> supplements = supplementRepository.findBySupplementName(supplementName);
        return supplements;
    }

    public String checkMedicationPrecautions(String  userId, String supplementName) {
        // Find the supplement information
        Optional<Supplements> supplements = supplementRepository.findBySupplementName(supplementName);
        // 영양제 정보가 없을 경우 처리
        if (!supplements.isPresent()) {
            return "해당 영양제 정보를 찾을 수 없습니다.";
        }
        // Get medication precautions
        String medicationPrecautions = supplements.get().getMedicationPrecautions();

        // Find the user's drug ingredients
        List<Mydata> myDataList = mydataRepository.findDrugIngredientByUserId(userId);

        // 약 정보가 없을 경우 처리
        for (Mydata myData : myDataList) {
            String drugIngredients = myData.getDrugIngredient();
            if (medicationPrecautions.contains(drugIngredients)) {
                return "복용 중인 약에 " + drugIngredients + " 성분이 있어요!";
            }
        }

        return "문제되는 성분이 없습니다 :)";
    }



}


