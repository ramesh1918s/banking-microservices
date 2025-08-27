package com.banking.customer.controller;

import com.banking.customer.entity.Customer;
import com.banking.customer.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerService svc;

    public CustomerController(CustomerService svc) {
        this.svc = svc;
    }

    @GetMapping
    public List<Customer> all() {
        return svc.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> byId(@PathVariable Long id) {
        Customer c = svc.findById(id);
        return c == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(c);
    }

    @PostMapping
    public ResponseEntity<Customer> create(@RequestBody Customer c) {
        Customer saved = svc.save(c);
        return ResponseEntity.ok(saved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        svc.delete(id);
        return ResponseEntity.noContent().build();
    }
}
