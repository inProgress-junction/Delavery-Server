package kr.junction.delavery.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import kr.junction.delavery.common.base.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Challenge extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String userId;

    private Integer unlockTrialCount;

    private Integer unlockDoneCount;

    @Builder
    public Challenge(String userId, Integer unlockTrialCount, Integer unlockDoneCount) {
        this.userId = userId;
        this.unlockTrialCount = unlockTrialCount;
        this.unlockDoneCount = unlockDoneCount;
    }
}
