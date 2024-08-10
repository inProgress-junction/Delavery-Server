package kr.junction.delavery.service;

import kr.junction.delavery.domain.BankAccount;
import kr.junction.delavery.repository.BankAccountRepository;
import kr.junction.delavery.service.usecase.BankAccountUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BankAccountService implements BankAccountUseCase {

    private final BankAccountRepository bankAccountRepository;

    @Override
    public BankAccount createNewBankAccount(Integer accountNumber, String bankAccountType, String bankType, String memberId) {
        return null;
    }

    @Override
    public BankAccount getBankAccount(String type, String memberId) {
        return null;
    }

    @Override
    public BankAccount transferToBankAccount(String memberId) {
        return null;
    }

    @Override
    public BankAccount withdrawalToBankAccount(String memberId) {
        return null;
    }
}
