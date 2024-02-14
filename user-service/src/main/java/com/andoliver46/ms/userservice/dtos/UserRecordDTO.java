package com.andoliver46.ms.userservice.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public record UserRecordDTO(@NotBlank String name,
                            @NotBlank @Email String email) {
}
