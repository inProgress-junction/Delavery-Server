package kr.junction.delavery.controller.dto.request;

public record BankAccountCreateRequest (
    Integer accountNumber,
    String bankType,
    String bankAccountType
) {
}
