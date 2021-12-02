package com.hexagonal.user.application.port.in;

import com.hexagonal.user.application.model.User;

public interface RegisterUseCase {
    Long registerUser(User user, boolean isSendWelcomeMail);
}
