package com.sofka.account.application.domain.error;

import java.time.LocalDateTime;

public record RestErrorResponse(int status, String message,
                                LocalDateTime timestamp) {
}
