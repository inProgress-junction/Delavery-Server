package kr.junction.delavery.service.usecase;

import kr.junction.delavery.domain.Challenge;

public interface ChallengeUseCase {
    Double getChallengePercentile(String memberId);
    Challenge updateUnlockTrialCount(String memberId);
    Challenge updateUnlockDoneCount(String memberId);
}
