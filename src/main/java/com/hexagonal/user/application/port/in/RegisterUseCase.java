package com.hexagonal.user.application.port.in;

import com.hexagonal.user.application.model.User;
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
        public User toModel(){
            return new User(name,email);
        }
    }
}
