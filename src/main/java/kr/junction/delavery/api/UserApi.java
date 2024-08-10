package kr.junction.delavery.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.junction.delavery.common.annotation.RequestUserId;
import kr.junction.delavery.controller.dto.request.UserCreateRequest;
import kr.junction.delavery.controller.dto.response.UserResponse;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = "사용자 API")
@RequestMapping("/users")
public interface UserApi {

    @Operation(summary = "사용자 생성(가입)")
    @PostMapping
    UserResponse createNewUser(
            @RequestBody @Parameter(hidden = true) UserCreateRequest request
    );

    @Operation(summary = "사용자 삭제(탈퇴)")
    @DeleteMapping
    Void deleteUser(
            @RequestUserId @Parameter(hidden = true) String memberId
    );

}
