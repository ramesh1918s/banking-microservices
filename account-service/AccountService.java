package com.banking.account.service;

import com.banking.account.entity.Account;
import com.banking.account.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    private final AccountRepository repository;

    public AccountService(AccountRepository repository) {
        this.repository = repository;
    }

    public List<Account> getAllAccounts() {
        return repository.findAll();
    }

    public Account getAccountById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Account> getAccountsByCustomer(Long customerId) {
        return repository.findByCustomerId(customerId);
    }

    public Account saveAccount(Account account) {
        return repository.save(account);
    }

    public void deleteAccount(Long id) {
        repository.deleteById(id);
    }
}
