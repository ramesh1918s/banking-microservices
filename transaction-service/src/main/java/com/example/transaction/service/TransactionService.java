package com.example.transaction.service;

import com.example.transaction.model.Transaction;
import com.example.transaction.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransactionService {
    private final TransactionRepository repo;

    public TransactionService(TransactionRepository repo) {
        this.repo = repo;
    }

    public Transaction create(Transaction t) {
        if (t.getTimestamp() == null) t.setTimestamp(LocalDateTime.now());
        t.setStatus("COMPLETED"); // simple example
        return repo.save(t);
    }

    public List<Transaction> listAll() {
        return repo.findAll();
    }

    public Transaction getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public List<Transaction> getByAccount(String account) {
        return repo.findByFromAccountOrToAccount(account, account);
    }
}
