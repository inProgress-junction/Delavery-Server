package kr.junction.delavery.controller.dto.response;

import kr.junction.delavery.domain.User;

public record UserResponse(
        String id,
        String name
) {
    public static UserResponse of(
            final User user
    ) {
        return new UserResponse(
                user.getId(),
                user.getName()
        );
    }
}
