package kr.junction.delavery.service.usecase;

import kr.junction.delavery.domain.User;

public interface UserUseCase {
    User createNewUser(String name);
    Void deleteUser(String userId);
    String getUserName(String userId);
}
