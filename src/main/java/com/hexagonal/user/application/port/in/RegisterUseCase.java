package com.hexagonal.user.application.port.in;

import com.hexagonal.user.application.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;

public interface RegisterUseCase {
    Long registerUser(User user, boolean sendEmail);
    @Data
    @AllArgsConstructor
    class RegisterCommand {
        private String name;
        private String email;

        private boolean sendWelcomeMail;

    }
}
