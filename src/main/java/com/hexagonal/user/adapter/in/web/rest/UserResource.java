package com.hexagonal.user.adapter.in.web.rest;

import javax.validation.constraints.NotNull;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hexagonal.user.application.model.User;
import com.hexagonal.user.application.port.in.RegisterUseCase;
import lombok.Value;

@Value
public class UserResource {

  @NotNull
  private final String name;

  @NotNull
  private final String email;

  private LocalDateTime registrationDate;

  public UserResource(
          @JsonProperty("name") String name,
          @JsonProperty("email") String email) {
    this.name = name;
    this.email = email;
    this.registrationDate = null;
  }
}
