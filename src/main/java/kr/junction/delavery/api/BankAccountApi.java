package kr.junction.delavery.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.junction.delavery.common.annotation.RequestUserId;
import kr.junction.delavery.controller.dto.request.BankAccountCreateRequest;
import kr.junction.delavery.controller.dto.response.BankAccountResponse;
import org.springframework.web.bind.annotation.*;

@Tag(name = "은행 계좌 API")
@RequestMapping("/bank-accounts")
public interface BankAccountApi {

    @Operation(summary = "은행 계좌 생성")
    @PostMapping
    BankAccountResponse createNewBankAccount(
            @RequestUserId String memberId,
            @RequestBody BankAccountCreateRequest request
    );

    @Operation(summary = "은행 계좌 조회")
    @GetMapping
    BankAccountResponse getBankAccount(
            @RequestUserId String memberId,
            @RequestParam String type
    );

    @Operation(summary = "저금하기")
    @PatchMapping("/{bankAccountId}/transfer")
    BankAccountResponse transferToBankAccount(
            @RequestUserId String memberId
    );

    @Operation(summary = "출금하기")
    @PatchMapping("/{bankAccountId}/withdrawal")
    BankAccountResponse withdrawalToBankAccount(
            @RequestUserId String memberId
    );

}
