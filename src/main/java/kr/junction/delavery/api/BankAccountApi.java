package kr.junction.delavery.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.junction.delavery.common.annotation.RequestUserId;
import kr.junction.delavery.controller.dto.request.BankAccountCreateRequest;
import kr.junction.delavery.controller.dto.request.BankAccountMoneyRequest;
import kr.junction.delavery.controller.dto.response.BankAccountResponse;
import org.springframework.web.bind.annotation.*;

@Tag(name = "은행 계좌 API")
@RequestMapping("/bank-accounts")
public interface BankAccountApi {

    @Operation(summary = "은행 계좌 생성")
    @PostMapping
    BankAccountResponse createNewBankAccount(
            @RequestUserId @Parameter(hidden = true) String memberId,
            @RequestBody BankAccountCreateRequest request
    );

    @Operation(summary = "은행 계좌 조회")
    @GetMapping
    BankAccountResponse getBankAccount(
            @RequestUserId @Parameter(hidden = true) String memberId,
            @RequestParam String type
    );

    @Operation(summary = "저축하기")
    @PostMapping("/transfer")
    BankAccountResponse transferToBankAccount(
            @RequestUserId @Parameter(hidden = true) String memberId,
            @RequestBody BankAccountMoneyRequest request
    );

    @Operation(summary = "출금하기")
    @PostMapping("/withdrawal")
    BankAccountResponse withdrawalToBankAccount(
            @RequestUserId @Parameter(hidden = true) String memberId,
            @RequestBody BankAccountMoneyRequest request
    );

}
