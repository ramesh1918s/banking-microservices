package com.example.transaction.controller;

import com.example.transaction.model.Transaction;
import com.example.transaction.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    private final TransactionService service;

    public TransactionController(TransactionService service) {
        this.service = service;
    }

    @GetMapping
    public List<Transaction> list() { return service.listAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Transaction> get(@PathVariable Long id) {
        Transaction t = service.getById(id);
        if (t == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(t);
    }

    @GetMapping("/account/{account}")
    public List<Transaction> byAccount(@PathVariable String account) {
        return service.getByAccount(account);
    }

    @PostMapping
    public ResponseEntity<Transaction> create(@RequestBody Transaction tx) {
        Transaction created = service.create(tx);
        return ResponseEntity.created(URI.create("/api/transactions/" + created.getId())).body(created);
    }
}
