package kr.junction.delavery.service;

import kr.junction.delavery.controller.dto.response.ChallengeResponse;
import kr.junction.delavery.domain.Challenge;
import kr.junction.delavery.repository.ChallengeRepository;
import kr.junction.delavery.service.usecase.ChallengeUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ChallengeService implements ChallengeUseCase {
    @Autowired
    private final ChallengeRepository challengeRepository;

    // 챌린지 현황 조회
    @Override
    @Transactional
    public Double getChallengePercentile(String memberId) {

        List<Challenge> challenges = challengeRepository.findAll();

        // 각 Challenge의 done_count / trial_count 비율을 계산하고 정렬
        List<Double> ratios = challenges.stream()
                .map(challenge -> (double) challenge.getUnlockDoneCount() / challenge.getUnlockTrialCount())
                .sorted()
                .collect(Collectors.toList());

        // 해당 userId에 해당하는 Challenge의 비율 계산
        Challenge userChallenge = challengeRepository.findById(memberId)
                .orElseThrow(() -> new RuntimeException("해당하는 challenge가 없습니다."));

        double userRatio = (double) userChallenge.getUnlockDoneCount() / userChallenge.getUnlockTrialCount();

        // 해당 비율의 순위를 계산
        int rank = 0;
        for (int i = 0; i < ratios.size(); i++) {
            if (ratios.get(i) == userRatio) {
                rank = i + 1;
                break;
            }
        }

        // 백분위 계산 (전체 데이터 수에서 현재 순위의 비율을 계산)
        double percentail = (double) rank / ratios.size() * 100;

        return percentail;
    }

    @Override
    public Challenge updateUnlockTrialCount(String memberId) {

        Challenge challenge = challengeRepository.findById(memberId)
                .orElseThrow(() -> new RuntimeException("해당하는 challenge가 없습니다."));
        challenge.addUnlockTrialCount();
        challengeRepository.save(challenge);

        return challenge;
    }

    @Override
    public Challenge updateUnlockDoneCount(String memberId) {
        Challenge challenge = challengeRepository.findById(memberId)
                .orElseThrow(() -> new RuntimeException("해당하는 challenge가 없습니다."));
        challenge.addUnlockDoneCount();
        challengeRepository.save(challenge);

        return challenge;
    }
}
