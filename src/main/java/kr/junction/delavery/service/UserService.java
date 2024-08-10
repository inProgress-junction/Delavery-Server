package kr.junction.delavery.service;

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
    public User createNewUser(String name) {
        return userRepository.save(
                User.builder()
                        .name(name)
                        .build()
        );
    }

    @Override
    public Void deleteUser(String userId) {
        User user = userRepository.findById(userId).orElseThrow();
        userRepository.delete(user);

        return null;
    }
}
