package kr.junction.delavery.repository;

import kr.junction.delavery.domain.Challenge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChallengeRepository extends JpaRepository<Challenge, String> {
    Optional<Challenge> findByUserId(String userId);
}
