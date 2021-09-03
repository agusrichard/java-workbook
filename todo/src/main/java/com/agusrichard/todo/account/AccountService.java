package com.agusrichard.todo.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void registerAccount(Account account) {
        Optional<Account> accountFound = accountRepository.findAccountByEmail(account.getEmail());
        if (accountFound.isPresent()) {
            throw new IllegalStateException("Email has been registered!");
        }

        accountRepository.save(account);
    }

    public void deleteAccount(Long id) {
        boolean exists = accountRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("No account with id " + id + " is exist");
        }

        accountRepository.deleteById(id);
    }

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public Account getAccountById(Long id) {
        Optional<Account> account = accountRepository.findById(id);
        if (!account.isPresent()) {
            throw new IllegalStateException("No account with id " + id + " is exist");
        }

        return account.get();
    }

    public Account getAccountByEmail(String email) {
        Optional<Account> account = accountRepository.findAccountByEmail(email);
        if (!account.isPresent()) {
            throw new IllegalStateException("No account with email " + email + " is exist");
        }

        return account.get();
    }

    @Transactional
    public void updateAccount(Account account) {
        Account willBeUpdatedAccount = accountRepository.findById(account.getId()).orElseThrow(
                () -> new IllegalStateException("No account with id " + account.getId() + " is exist")
        );

        willBeUpdatedAccount.setEmail(account.getEmail());
        willBeUpdatedAccount.setFullname(account.getFullname());
        willBeUpdatedAccount.setDob(account.getDob());
    }
}
