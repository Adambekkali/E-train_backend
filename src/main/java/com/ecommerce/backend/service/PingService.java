package com.ecommerce.backend.service;

import org.springframework.stereotype.Service;

@Service
public class PingService {
    public String getStatus() {
        return "ok";
    }
}
