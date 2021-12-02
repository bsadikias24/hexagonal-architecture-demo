package com.hexagonal.user.application.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
@Entity
@NoArgsConstructor
@Table(name = "user")
@Data
@AllArgsConstructor
public class User {
  @Id
  @GeneratedValue
  private Long id;
  @NotNull
  private String name;
  @NotNull
  private String email;
  private LocalDateTime registrationDate;

  public User(@JsonProperty("name")String name,@JsonProperty("email") String email) {
    this.name = name;
    this.email = email;
  }
}
