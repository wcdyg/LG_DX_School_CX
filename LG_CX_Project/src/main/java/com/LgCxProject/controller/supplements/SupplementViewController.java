package com.LgCxProject.controller.supplements;
import com.LgCxProject.domain.storage.UserStorageInfo;
import com.LgCxProject.domain.supplements.Supplements;
import com.LgCxProject.repository.storage.UserStorageRepository;
import com.LgCxProject.service.supplements.SupplementService;
import org.springframework.ui.Model;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class SupplementViewController {
    @Autowired
    UserStorageRepository userStorageRepository;

    @Autowired
    private SupplementService supplementService;

    @GetMapping("/supplements/add")
    public String showSupplementForm(Model model) {
        // 기본 페이지를 위한 모델 설정
        return "/supplements/add";
    }


    // 영양제명을 입력받아 DB에서 조회 후 add 페이지로 이동
    @PostMapping("/supplements/add")
<<<<<<< HEAD
    public String getSupplementInfo(@RequestParam("supplementName") String supplementName, Model model,
                                    HttpSession session) {
=======
    public String getSupplementInfoAndCheckMedication(
            @RequestParam("supplementName") String supplementName,
            HttpSession session,
            Model model) {

        String userId = (String) session.getAttribute("userId");

>>>>>>> 61ba63e2ad20ffa6ada018ff7db18a1e298d27ef
        // 입력받은 영양제명으로 DB에서 영양제 데이터를 조회
        Optional<Supplements> supplements = supplementService.FindSupplement(supplementName);
        session.setAttribute("supplementId",supplements.get().getSupplementId());
        session.setAttribute("suppleOutAmount",supplements.get().getIntakeAmount());

        if (supplements.isPresent()) {
            // 조회된 데이터를 모델에 추가
            Supplements supp = supplements.get();
            model.addAttribute("supplement_Name", supp.getSupplementName());
            model.addAttribute("main_ingredients", supp.getMainIngredients());
            model.addAttribute("intake_amount", supp.getIntakeAmount());
            model.addAttribute("intake_frequency", supp.getIntakeFrequency());
            model.addAttribute("intake_method", supp.getIntakeMethod());
            model.addAttribute("medication_precautions", supp.getMedicationPrecautions());

            String resultMessage = supplementService.checkMedicationPrecautions(userId, supplementName);
            model.addAttribute("resultMessage", resultMessage);
        } else {
            // 영양제 정보가 없는 경우
            model.addAttribute("error", "해당 영양제 정보를 찾을 수 없습니다.");
        }

        // add.html 페이지로 이동
        return "/supplements/add";
    }

<<<<<<< HEAD
    // newStorage 화면으로 넘어감
    @PostMapping("/storage/newstorage")
    public String newstoragepage(@ModelAttribute UserStorageInfo userStorageInfo) {
        userStorageRepository.save(userStorageInfo);
        return "/storage/storage";
    }
=======
>>>>>>> 61ba63e2ad20ffa6ada018ff7db18a1e298d27ef
}
