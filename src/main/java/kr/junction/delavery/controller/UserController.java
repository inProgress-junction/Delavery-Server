package kr.junction.delavery.controller;

import kr.junction.delavery.api.UserApi;
import kr.junction.delavery.controller.dto.request.UserCreateRequest;
import kr.junction.delavery.controller.dto.response.UserResponse;
import kr.junction.delavery.domain.User;
import kr.junction.delavery.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController implements UserApi {

    private final UserService userService;

    @Override
    public UserResponse createNewUser(
            UserCreateRequest request
    ) {
        User newUser = userService.createNewUser(request.name());

        return UserResponse.of(newUser);
    }

    @Override
    public Void deleteUser(
            String memberId
    ) {
        userService.deleteUser(memberId);

        return null;
    }

}
