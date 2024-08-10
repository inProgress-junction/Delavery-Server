package kr.junction.delavery.controller.dto.response;

import kr.junction.delavery.domain.BankAccount;

public record BankAccountResponse(
        String id,
        String userName,
        Integer money,
        Integer accountNumber,
        String bankType,
        String bankAccountType
) {
    public static BankAccountResponse of(
            final BankAccount bankAccount,
            final String userName
    ) {
        return new BankAccountResponse(
                bankAccount.getId(),
                userName,
                bankAccount.getMoney(),
                bankAccount.getAccountNumber(),
                bankAccount.getBankType().toString(),
                bankAccount.getBankAccountType().toString()
        );
    }
}
