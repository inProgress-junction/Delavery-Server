package kr.junction.delavery.service.usecase;

import kr.junction.delavery.domain.BankAccount;

public interface BankAccountUseCase {
    BankAccount createNewBankAccount(Integer accountNumber, String bankAccountType, String bankType, Integer money, String memberId);
    BankAccount getBankAccount(String type, String memberId);
    BankAccount transferToBankAccount(String memberId, Integer money);
    BankAccount withdrawalToBankAccount(String memberId, Integer money);
}
