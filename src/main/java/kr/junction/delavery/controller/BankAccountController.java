package kr.junction.delavery.controller;

import kr.junction.delavery.api.BankAccountApi;
import kr.junction.delavery.controller.dto.request.BankAccountCreateRequest;
import kr.junction.delavery.controller.dto.response.BankAccountResponse;
import kr.junction.delavery.domain.BankAccount;
import kr.junction.delavery.service.BankAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class BankAccountController implements BankAccountApi {

    private final BankAccountService bankAccountService;

    @Override
    public BankAccountResponse createNewBankAccount(
            String memberId,
            BankAccountCreateRequest request
    ) {
        BankAccount bankAccount = bankAccountService.createNewBankAccount(
                request.accountNumber(),
                request.bankAccountType(),
                request.bankType(),
                memberId
        );

        return BankAccountResponse.of(bankAccount);
    }

    @Override
    public BankAccountResponse getBankAccount(
            String memberId,
            String type
    ) {
        BankAccount bankAccount = bankAccountService.getBankAccount(
                type,
                memberId
        );

        return BankAccountResponse.of(bankAccount);
    }

    @Override
    public BankAccountResponse transferToBankAccount(
            String memberId
    ) {
        BankAccount bankAccount = bankAccountService.transferToBankAccount(
                memberId
        );

        return BankAccountResponse.of(bankAccount);
    }

    @Override
    public BankAccountResponse withdrawalToBankAccount(
            String memberId
    ) {
        BankAccount bankAccount = bankAccountService.withdrawalToBankAccount(
                memberId
        );

        return BankAccountResponse.of(bankAccount);
    }

}
