package com.LgCxProject.service.supplements;
import com.LgCxProject.domain.supplements.Supplements;
import com.LgCxProject.repository.supplements.SupplementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SupplementService {

    @Autowired
    SupplementRepository supplementRepository;

    public Optional<Supplements> FindSupplement(String supplementName){
        Optional<Supplements> supplements = supplementRepository.findBySupplementName(supplementName);
        return supplements;
    }

}
