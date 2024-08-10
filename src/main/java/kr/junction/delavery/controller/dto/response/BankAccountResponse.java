package kr.junction.delavery.controller.dto.response;

import kr.junction.delavery.domain.BankAccount;

public record BankAccountResponse(
        String id,
        String userId,
        Integer money,
        Integer accountNumber,
        String bankType,
        String bankAccountType
) {
    public static BankAccountResponse of(
            final BankAccount bankAccount
    ) {
        return new BankAccountResponse(
                bankAccount.getId(),
                bankAccount.getUserId(),
                bankAccount.getMoney(),
                bankAccount.getAccountNumber(),
                bankAccount.getBankType().toString(),
                bankAccount.getBankAccountType().toString()
        );
    }
}
