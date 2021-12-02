package com.hexagonal.user.adapter.in.web;

import com.hexagonal.user.application.model.User;
import com.hexagonal.user.application.port.in.RegisterUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
class RegisterRestController {

    private final RegisterUseCase registerUseCase;

    @PostMapping("/forums/register")
    User register(
            @Valid @RequestBody User user,
            @RequestParam("sendWelcomeMail") boolean sendWelcomeMail) {

        registerUseCase.registerUser(new User(user.getName(), user.getEmail()), sendWelcomeMail);

        return new User(
                user.getName(),
                user.getEmail());
    }

}
