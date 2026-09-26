package com.ecommerce.backend.repository;

import com.ecommerce.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID; // Ne pas oublier cet import

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
}