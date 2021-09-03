package com.agusrichard.todo.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/account")
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping(path = "hello")
    public String hello() {
        return "Hello from Account Controller";
    }

    @PostMapping()
    public void registerAccount(@RequestBody Account account) {
        accountService.registerAccount(account);
    }

    @DeleteMapping("{accountId}")
    public void deleteAccount(@PathVariable("accountId") Long accountId) {
        accountService.deleteAccount(accountId);
    }

    @GetMapping
    public List<Account> getAllAccount() {
        return accountService.getAllAccounts();
    }

    @GetMapping("get-by-id/{accountId}")
    public Account getAccountById(@PathVariable Long accountId) {
        return accountService.getAccountById(accountId);
    }

    @GetMapping("get-by-email/{email}")
    public Account getAccountByEmail(@PathVariable String email) {
        return accountService.getAccountByEmail(email);
    }

    @PutMapping
    public void updateAccount(@RequestBody Account account) {
        accountService.updateAccount(account);
    }
}
