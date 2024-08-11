package kr.junction.delavery.service;

import kr.junction.delavery.common.util.IdGenerator;
import kr.junction.delavery.domain.Challenge;
import kr.junction.delavery.repository.ChallengeRepository;
import kr.junction.delavery.service.usecase.ChallengeUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ChallengeService implements ChallengeUseCase {

    private final ChallengeRepository challengeRepository;

    @Override
    @Transactional
    public Challenge createNewChallenge(String memberId) {
        return challengeRepository.save(
                Challenge.builder()
                        .id(IdGenerator.generate())
                        .userId(memberId)
                        .build()
        );
    }

    @Override
    @Transactional(readOnly = true)
    public Double getChallengePercentile(String memberId) {
        Challenge userChallenge = challengeRepository.findByUserId(memberId).orElseThrow();

        double userPercentile = calculatePercentile(userChallenge);

        List<Challenge> allChallenges = challengeRepository.findAll();

        List<Double> percentages = allChallenges.parallelStream()
                .map(this::calculatePercentile)
                .sorted()
                .collect(Collectors.toList());

        int position = (int) (percentages.stream().filter(p -> p <= userPercentile).count());

        double percentileRank = (position / (double) percentages.size()) * 100;

        return percentileRank;
    }

    private double calculatePercentile(Challenge challenge) {
        int trial = challenge.getUnlockTrialCount();
        int done = challenge.getUnlockDoneCount();
        return (double) done / (trial + done);
    }

    @Override
    @Transactional
    public Challenge updateUnlockTrialCount(String memberId) {
        Challenge challenge = challengeRepository.findById(memberId)
                .orElseThrow(() -> new RuntimeException("해당하는 challenge가 없습니다."));

        challengeRepository.save(
                challenge.addUnlockTrialCount()
        );

        return challenge;
    }

    @Override
    @Transactional
    public Challenge updateUnlockDoneCount(String memberId) {
        Challenge challenge = challengeRepository.findById(memberId)
                .orElseThrow(() -> new RuntimeException("해당하는 challenge가 없습니다."));

        challengeRepository.save(
                challenge.addUnlockDoneCount()
        );

        return challenge;
    }

    @Scheduled(fixedRate = 604800000) // 7일
    @Transactional
    public void autoResetChallenge() {
        List<Challenge> allChallenges = challengeRepository.findAll();
        for (Challenge challenge : allChallenges) {
            challenge.resetUnlockCounts();
        }
        challengeRepository.saveAll(allChallenges);
    }

}
