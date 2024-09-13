package com.LgCxProject.controller.storage;

import com.LgCxProject.domain.storage.Storage;
import com.LgCxProject.repository.storage.StorageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class StorageDataController {
    @Autowired
    StorageRepository storageRepository;

    @PostMapping("/supplements/discharge")
    @ResponseBody
    public ResponseEntity<Storage> dischargeSupplement(@RequestParam String container) {
        Optional<Storage> storage = storageRepository.findStorageByStorageId("STRG00" + container);
        storage.get().setStock(storage.get().getStock() - 1);
        storageRepository.save(storage.get());
        return ResponseEntity.ok(storage.get());
    }
}
