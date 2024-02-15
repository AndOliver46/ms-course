package com.andoliver46.ms.mailservice.repositories;

import com.andoliver46.ms.mailservice.models.EmailModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmailRepository extends JpaRepository<EmailModel, UUID> {
}
