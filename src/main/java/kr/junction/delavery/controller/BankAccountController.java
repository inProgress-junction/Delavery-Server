package kr.junction.delavery.controller;

import kr.junction.delavery.api.BankAccountApi;
import kr.junction.delavery.controller.dto.request.BankAccountCreateRequest;
import kr.junction.delavery.controller.dto.response.BankAccountResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class BankAccountController implements BankAccountApi {

    @Override
    public BankAccountResponse createNewBankAccount(
            String memberId,
            BankAccountCreateRequest request
    ) {
        return null;
    }

    @Override
    public BankAccountResponse getBankAccount(
            String memberId,
            String type
    ) {
        return null;
    }

    @Override
    public BankAccountResponse transferToBankAccount(
            String memberId
    ) {
        return null;
    }

    @Override
    public BankAccountResponse withdrawalToBankAccount(
            String memberId
    ) {
        return null;
    }

}
