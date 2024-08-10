package kr.junction.delavery.controller;

import kr.junction.delavery.api.ChallengeApi;
import kr.junction.delavery.controller.dto.response.ChallengeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ChallengeController implements ChallengeApi {

    @Override
    public ChallengeResponse getChallenge(
            String memberId
    ) {
        return null;
    }

    @Override
    public ChallengeResponse updateUnlockTrialCount(
            String memberId
    ) {
        return null;
    }

    @Override
    public ChallengeResponse updateUnlockDoneCount(
            String memberId
    ) {
        return null;
    }
}
