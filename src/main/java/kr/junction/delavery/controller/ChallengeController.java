package kr.junction.delavery.controller;

import kr.junction.delavery.api.ChallengeApi;
import kr.junction.delavery.controller.dto.response.ChallengeResponse;
import kr.junction.delavery.controller.dto.response.PercentileResponse;
import kr.junction.delavery.domain.Challenge;
import kr.junction.delavery.service.ChallengeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ChallengeController implements ChallengeApi {

    private final ChallengeService challengeService;

    @Override
    public PercentileResponse getChallengePercentile(
            String memberId
    ) {
        Double percentile = challengeService.getChallengePercentile(memberId);

        return PercentileResponse.of(percentile);
    }

    @Override
    public ChallengeResponse updateUnlockTrialCount(
            String memberId
    ) {
        Challenge challenge = challengeService.updateUnlockTrialCount(memberId);

        return ChallengeResponse.of(challenge);
    }

    @Override
    public ChallengeResponse updateUnlockDoneCount(
            String memberId
    ) {
        Challenge challenge = challengeService.updateUnlockDoneCount(memberId);

        return ChallengeResponse.of(challenge);
    }
}
