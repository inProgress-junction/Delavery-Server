package kr.junction.delavery.service;

import kr.junction.delavery.domain.Challenge;
import kr.junction.delavery.repository.ChallengeRepository;
import kr.junction.delavery.service.usecase.ChallengeUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChallengeService implements ChallengeUseCase {

    private final ChallengeRepository challengeRepository;

    @Override
    public Double getChallengePercentile(String memberId) {
        return null;
    }

    @Override
    public Challenge updateUnlockTrialCount(String memberId) {
        return null;
    }

    @Override
    public Challenge updateUnlockDoneCount(String memberId) {
        return null;
    }
}
