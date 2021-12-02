package com.hexagonal.user.application.port.out;

import com.hexagonal.user.application.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

public interface SaveUserPort {

  Long saveUser(SaveUserModel user);
  @Data
  @AllArgsConstructor
  class SaveUserModel{
    private String name;
    private String email;
    private LocalDateTime registrationDate;
    public static SaveUserModel fromModel(User user) {
      return new SaveUserModel(user.getName(), user.getEmail(), LocalDateTime.now());
    }
  }
}
