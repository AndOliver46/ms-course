package com.andoliver46.ms.mailservice.dtos;

import java.util.UUID;

public record EmailRecordDTO(UUID userId,
                             String emailTo,
                             String subject,
                             String text) {
}
