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
public class User extends BaseTimeEntity {
    @Id
    private String id;

    private String name;

    @Builder
    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
