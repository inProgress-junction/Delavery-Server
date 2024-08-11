package kr.junction.delavery.service;

import kr.junction.delavery.common.util.IdGenerator;
import kr.junction.delavery.domain.BankAccount;
import kr.junction.delavery.domain.BankAccountType;
import kr.junction.delavery.domain.BankType;
import kr.junction.delavery.repository.BankAccountRepository;
import kr.junction.delavery.service.usecase.BankAccountUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

import static kr.junction.delavery.domain.BankAccountType.SAVING;
import static kr.junction.delavery.domain.BankAccountType.SPENDING;

@Service
@RequiredArgsConstructor
public class BankAccountService implements BankAccountUseCase {

    private final BankAccountRepository bankAccountRepository;

    @Override
    @Transactional
    public BankAccount createNewBankAccount(Integer accountNumber, String bankAccountType, String bankType, Integer money, String memberId) {

        boolean accountExists = bankAccountRepository.findBankAccountByUserIdAndBankAccountType(
                memberId,
                BankAccountType.valueOf(bankAccountType)
        ).isPresent();

        if (accountExists) {
            throw new IllegalArgumentException("이미 해당하는 계좌를 생성한 사용자입니다!");
        }

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
    @Transactional(readOnly = true)
    public BankAccount getBankAccount(String bankAccountType, String memberId) {
        return bankAccountRepository.findBankAccountByUserIdAndBankAccountType(
                memberId,
                BankAccountType.valueOf(bankAccountType)
        ).orElseThrow();
    }

    @Override
    @Transactional
    public BankAccount transferToBankAccount(String memberId, Integer money) {
        BankAccount spendingAccount = bankAccountRepository.findBankAccountByUserIdAndBankAccountType(memberId, SPENDING).orElseThrow();
        BankAccount savingAccount = bankAccountRepository.findBankAccountByUserIdAndBankAccountType(memberId, SAVING).orElseThrow();

        if (spendingAccount.getMoney() < money) {
            throw new IllegalArgumentException("계좌의 돈이 부족하여 해당 금액은 저축이 불가능합니다!");
        }

        spendingAccount.subtractMoney(money);
        savingAccount.addMoney(money);

        bankAccountRepository.saveAll(Arrays.asList(spendingAccount, savingAccount));

        return savingAccount;
    }

    @Override
    @Transactional
    public BankAccount withdrawalToBankAccount(String memberId, Integer money) {
        BankAccount savingAccount = bankAccountRepository.findBankAccountByUserIdAndBankAccountType(memberId, SAVING).orElseThrow();

        if (savingAccount.getMoney() < money) {
            throw new IllegalArgumentException("계좌의 돈이 부족하여 해당 금액은 출금이 불가능합니다!");
        }

        return bankAccountRepository.save(
                savingAccount.subtractMoney(money)
        );
    }
}
