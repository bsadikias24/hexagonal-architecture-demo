package com.hexagonal.user.adapter.out.persistence;

import com.hexagonal.user.application.port.out.SaveUserPort;
import org.springframework.stereotype.Component;

@Component
public class PersistenceAdapter implements SaveUserPort {

    private final UserRepository userRepository;

    public PersistenceAdapter(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Long saveUser(SaveUserPort.SaveUserModel saveUserModel) {
        UserEntity userEntity = UserEntity.fromPersistencePort(saveUserModel);
        UserEntity savedUserEntity = userRepository.save(userEntity);
        return savedUserEntity.getId();
    }
}
