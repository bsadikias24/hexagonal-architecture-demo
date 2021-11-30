package com.hexagonal.user.application;

import java.time.LocalDateTime;

import com.hexagonal.user.application.model.User;
import com.hexagonal.user.application.port.out.SaveUserPort;
import com.hexagonal.user.application.port.out.SendMailPort;
import com.hexagonal.user.application.port.in.RegisterUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterService implements RegisterUseCase{

  private final SaveUserPort saveUserPort;

  private final SendMailPort sendMailPort;

  public Long registerUser(RegisterUseCase.RegisterCommand registerCommand) {
    User user= new User(registerCommand.getName(), registerCommand.getEmail());
    user.setRegistrationDate(LocalDateTime.now());
    // Some logic here
    if(registerCommand.isSendWelcomeMail()){
      sendMailPort.sendMail("Welcome!", "Thanks for registering.");
    }
    return saveUserPort.saveUser(user);
  }

}