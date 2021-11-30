package com.hexagonal.user.application.port.out;

import com.hexagonal.user.application.model.User;

public interface SaveUserPort {

  Long saveUser(User user);

}
