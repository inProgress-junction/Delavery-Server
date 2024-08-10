package kr.junction.delavery.controller;

import kr.junction.delavery.api.BankAccountApi;
import kr.junction.delavery.controller.dto.request.BankAccountCreateRequest;
import kr.junction.delavery.controller.dto.request.BankAccountMoneyRequest;
import kr.junction.delavery.controller.dto.response.BankAccountResponse;
import kr.junction.delavery.domain.BankAccount;
import kr.junction.delavery.service.BankAccountService;
import kr.junction.delavery.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class BankAccountController implements BankAccountApi {

    private final BankAccountService bankAccountService;
    private final UserService userService;

    @Override
    public BankAccountResponse createNewBankAccount(
            String memberId,
            BankAccountCreateRequest request
    ) {
        BankAccount bankAccount = bankAccountService.createNewBankAccount(
                request.accountNumber(),
                request.bankAccountType(),
                request.bankType(),
                request.money(),
                memberId
        );

        String userName = userService.getUserName(memberId);

        return BankAccountResponse.of(bankAccount, userName);
    }

    @Override
    public BankAccountResponse getBankAccount(
            String memberId,
            String type
    ) {
        BankAccount bankAccount = bankAccountService.getBankAccount(
                type.toUpperCase(),
                memberId
        );

        String userName = userService.getUserName(memberId);

        return BankAccountResponse.of(bankAccount, userName);
    }

    @Override
    public BankAccountResponse transferToBankAccount(
            String memberId,
            BankAccountMoneyRequest request
    ) {
        BankAccount bankAccount = bankAccountService.transferToBankAccount(
                memberId,
                request.money()
        );

        String userName = userService.getUserName(memberId);

        return BankAccountResponse.of(bankAccount, userName);
    }

    @Override
    public BankAccountResponse withdrawalToBankAccount(
            String memberId,
            BankAccountMoneyRequest request
    ) {
        BankAccount bankAccount = bankAccountService.withdrawalToBankAccount(
                memberId,
                request.money()
        );

        String userName = userService.getUserName(memberId);

        return BankAccountResponse.of(bankAccount, userName);
    }

}
