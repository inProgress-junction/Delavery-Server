package kr.junction.delavery.controller;

import kr.junction.delavery.api.UserApi;
import kr.junction.delavery.controller.dto.request.UserCreateRequest;
import kr.junction.delavery.controller.dto.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController implements UserApi {

    @Override
    public UserResponse createNewUser(
            UserCreateRequest request
    ) {
        return null;
    }

    @Override
    public Void deleteUser(
            String memberId
    ) {
        return null;
    }

}
