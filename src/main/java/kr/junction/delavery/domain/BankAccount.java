package kr.junction.delavery.domain;

import jakarta.persistence.*;
import kr.junction.delavery.common.base.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class BankAccount extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String userId;

    private Integer money;

    private Integer accountNumber;

    @Enumerated(EnumType.STRING)
    private BankType bankType;

    @Enumerated(EnumType.STRING)
    private BankAccountType bankAccountType;

    @Builder
    public BankAccount(String userId, Integer money, Integer accountNumber, BankType bankType, BankAccountType bankAccountType) {
        this.userId = userId;
        this.money = money;
        this.accountNumber = accountNumber;
        this.bankType = bankType;
        this.bankAccountType = bankAccountType;
    }

}
