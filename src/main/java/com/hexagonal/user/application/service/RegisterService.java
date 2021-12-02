package com.hexagonal.user.application.service;

import com.hexagonal.user.application.model.User;
import com.hexagonal.user.application.port.in.RegisterUseCase;
import com.hexagonal.user.application.port.out.SaveUserPort;
import com.hexagonal.user.application.port.out.SendMailPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class RegisterService implements RegisterUseCase {

    private final SaveUserPort saveUserPort;

    private final SendMailPort sendMailPort;

    public Long registerUser(RegisterUseCase.RegisterCommand registerCommand) {
        User user = registerCommand.toModel();
        user.setRegistrationDate(LocalDateTime.now());
        // Some logic here
        if (registerCommand.isSendWelcomeMail()) {
            sendMailPort.sendMail("Welcome!", "Thanks for registering.");
        }
        return saveUserPort.saveUser(SaveUserPort.SaveUserModel.fromModel(user));
    }

}
