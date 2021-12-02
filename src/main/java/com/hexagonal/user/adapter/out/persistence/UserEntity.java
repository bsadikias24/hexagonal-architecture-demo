package com.hexagonal.user.adapter.out.persistence;

import com.hexagonal.user.application.port.out.SaveUserPort;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class UserEntity {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String email;
    private LocalDateTime registrationDate;

    public UserEntity(String name, String email, LocalDateTime registrationDate) {
        this.name = name;
        this.email = email;
        this.registrationDate = registrationDate;
    }

    public static UserEntity fromPersistencePort(SaveUserPort.SaveUserModel saveUserModel) {
        return new UserEntity(saveUserModel.getName(), saveUserModel.getEmail(), saveUserModel.getRegistrationDate());
    }
}
