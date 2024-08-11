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

    public Challenge addUnlockTrialCount() {
        this.unlockTrialCount++;
        return this;
    }

    public Challenge addUnlockDoneCount() {
        this.unlockDoneCount++;
        return this;
    }

    public Challenge resetUnlockCounts() {
        this.unlockTrialCount = 0;
        this.unlockDoneCount = 0;

        return this;
    }
}
