package com.ecommerce.backend.controller;

import com.ecommerce.backend.model.Store;
import com.ecommerce.backend.service.StoreService;
import dto.CreateStoreRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/stores")
class StoreController {
    private StoreService storeService;

    @GetMapping("/storeById")
    public Store getStoreById(@RequestParam UUID id) {
        return storeService.getStoreById(id);
    }

    @GetMapping("/storesByUserId")
    public List<Store> getStoresByUserId(@RequestParam UUID userId) {
        return storeService.getStoresByUserId(userId);
    }

    @PostMapping("/createStore")
    public Store createStore(@RequestBody CreateStoreRequest request) {
        return storeService.save(request);
    }

    @PostMapping("/updateStore")
    public Store updateStore(@RequestBody UUID id, CreateStoreRequest request) {

        return storeService.updateStore(id,request);

    }
}