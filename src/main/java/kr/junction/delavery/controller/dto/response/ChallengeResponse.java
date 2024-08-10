package kr.junction.delavery.controller.dto.response;

import kr.junction.delavery.domain.Challenge;

public record ChallengeResponse(
        String id,
        Integer unlockTrialCount,
        Integer unlockDoneCount
) {
    public static ChallengeResponse of(
            final Challenge challenge
    ) {
        return new ChallengeResponse(
                challenge.getId(),
                challenge.getUnlockTrialCount(),
                challenge.getUnlockDoneCount()
        );
    }
}
