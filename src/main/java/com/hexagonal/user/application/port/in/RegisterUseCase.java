package com.hexagonal.user.application.port.in;

import lombok.AllArgsConstructor;
import lombok.Data;

public interface RegisterUseCase {
    Long registerUser(RegisterCommand registerCommand);
    @Data
    @AllArgsConstructor
    class RegisterCommand {
        private String name;
        private String email;

        private boolean sendWelcomeMail;

    }
}
