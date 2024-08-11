package kr.junction.delavery.domain;

import jakarta.persistence.Entity;
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
    private String id;

    private String userId;

    private Integer unlockTrialCount;

    private Integer unlockDoneCount;

    @Builder
    public Challenge(String id, String userId) {
        this.id = id;
        this.userId = userId;
        this.unlockTrialCount = 0;
        this.unlockDoneCount = 0;
    }

    // add method
    public Integer addUnlockTrialCount() {
        this.unlockTrialCount++;
        return unlockTrialCount;
    }

    // add method
    public Integer addUnlockDoneCount() {
        this.unlockDoneCount++;
        return unlockDoneCount;
    }
}
