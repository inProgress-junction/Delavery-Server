package kr.junction.delavery.repository;

import kr.junction.delavery.domain.BankAccount;
import kr.junction.delavery.domain.BankAccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount, String> {
    Optional<BankAccount> findBankAccountByUserIdAndBankAccountType(String userId, BankAccountType bankAccountType);
}
