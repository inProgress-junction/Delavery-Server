package kr.junction.delavery.service.usecase;

import kr.junction.delavery.domain.BankAccount;

public interface BankAccountUseCase {
    BankAccount createNewBankAccount(Integer accountNumber, String bankAccountType, String bankType, String memberId);
    BankAccount getBankAccount(String type, String memberId);
    BankAccount transferToBankAccount(String memberId);
    BankAccount withdrawalToBankAccount(String memberId);
}
