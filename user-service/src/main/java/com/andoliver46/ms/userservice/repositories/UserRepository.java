package com.andoliver46.ms.userservice.repositories;

import com.andoliver46.ms.userservice.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserModel, UUID> {
}
