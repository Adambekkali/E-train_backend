package com.ecommerce.backend.service;

import com.ecommerce.backend.model.Store;
import com.ecommerce.backend.model.User;
import com.ecommerce.backend.repository.StoreRepository;
import com.ecommerce.backend.repository.UserRepository;
import dto.CreateStoreRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StoreService {
    private final StoreRepository storeRepository;
    private final UserRepository userRepository;


    public StoreService(StoreRepository storeRepository, UserRepository userRepository) {
        this.storeRepository = storeRepository;
        this.userRepository = userRepository;
    }


    public Store getStoreById(UUID id) {
       return storeRepository.findById(id).orElseThrow(() -> new RuntimeException("Boutique introuvable"));
    }

    public List<Store> getStoresByUserId(UUID userId) {
        return storeRepository.findByUserId(userId);
    }

    public Store save(CreateStoreRequest request) {

        User user=userRepository.findById(request.getUserId())
                .orElseThrow(()-> new RuntimeException("User not found"));

        Store store = new Store();
        store.setUser(user);
        store.setName(request.getName());

        return storeRepository.save(store);
    }

    public Store updateStore (UUID id, CreateStoreRequest request) {

        Store store = storeRepository.findById(id).orElseThrow(() -> new RuntimeException("Store not found"));
        store.setName(request.getName());

        return storeRepository.save(store);

    }
}
