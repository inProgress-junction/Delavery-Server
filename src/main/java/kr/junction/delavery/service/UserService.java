package kr.junction.delavery.service;

import jakarta.transaction.Transactional;
import kr.junction.delavery.common.util.IdGenerator;
import kr.junction.delavery.domain.User;
import kr.junction.delavery.repository.UserRepository;
import kr.junction.delavery.service.usecase.UserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements UserUseCase {

    private final UserRepository userRepository;

    @Override
    @Transactional
    public User createNewUser(String name) {
        return userRepository.save(
                User.builder()
                        .id(IdGenerator.generate())
                        .name(name)
                        .build()
        );
    }

    @Override
    @Transactional
    public Void deleteUser(String userId) {
        User user = userRepository.findById(userId).orElseThrow();
        userRepository.delete(user);

        return null;
    }

    @Override
    public String getUserName(String userId) {
        return userRepository.findById(userId).orElseThrow().getName();
    }
}
