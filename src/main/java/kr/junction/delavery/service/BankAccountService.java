package kr.junction.delavery.service;

import jakarta.transaction.Transactional;
import kr.junction.delavery.common.util.IdGenerator;
import kr.junction.delavery.domain.BankAccount;
import kr.junction.delavery.domain.BankAccountType;
import kr.junction.delavery.domain.BankType;
import kr.junction.delavery.repository.BankAccountRepository;
import kr.junction.delavery.service.usecase.BankAccountUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

import static kr.junction.delavery.domain.BankAccountType.SAVING;
import static kr.junction.delavery.domain.BankAccountType.SPENDING;

@Service
@RequiredArgsConstructor
public class BankAccountService implements BankAccountUseCase {

    private final BankAccountRepository bankAccountRepository;

    @Override
    @Transactional
    public BankAccount createNewBankAccount(Integer accountNumber, String bankAccountType, String bankType, Integer money, String memberId) {
        return bankAccountRepository.save(
                BankAccount.builder()
                        .id(IdGenerator.generate())
                        .accountNumber(accountNumber)
                        .bankAccountType(BankAccountType.valueOf(bankAccountType))
                        .bankType(BankType.valueOf(bankType))
                        .money(money)
                        .userId(memberId)
                        .build()
        );
    }

    @Override
    public BankAccount getBankAccount(String type, String memberId) {
        return bankAccountRepository.findBankAccountByUserIdAndBankAccountType(
                memberId,
                BankAccountType.valueOf(type)
        ).orElseThrow();
    }

    @Override
    @Transactional
    public BankAccount transferToBankAccount(String memberId, Integer money) {
        BankAccount spendingAccount = bankAccountRepository.findBankAccountByUserIdAndBankAccountType(memberId, SPENDING).orElseThrow();
        BankAccount savingAccount = bankAccountRepository.findBankAccountByUserIdAndBankAccountType(memberId, SAVING).orElseThrow();

        spendingAccount.subtractMoney(money);
        savingAccount.addMoney(money);

        bankAccountRepository.saveAll(Arrays.asList(spendingAccount, savingAccount));

        return savingAccount;
    }

    @Override
    @Transactional
    public BankAccount withdrawalToBankAccount(String memberId, Integer money) {
        BankAccount savingAccount = bankAccountRepository.findBankAccountByUserIdAndBankAccountType(memberId, SAVING).orElseThrow();

        return bankAccountRepository.save(
                savingAccount.subtractMoney(money)
        );
    }
}
