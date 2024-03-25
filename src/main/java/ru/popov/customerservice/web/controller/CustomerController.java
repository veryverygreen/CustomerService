package ru.popov.customerservice.web.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.popov.customerservice.domain.Customer;
import ru.popov.customerservice.service.CustomerService;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/{id}")
    public Customer get(@PathVariable Long id) throws NotFoundException {

        Customer customer = customerService.findById(id);

        if (customer == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No user found with id: " + id);
        }

        return customer;
    }

    @GetMapping
    public Page<Customer> getAll(@NotNull final Pageable pageable) {
        return customerService.findAll(pageable);
    }

    @PostMapping
    public void create(@Valid @RequestBody Customer customer) {
        customerService.save(customer);
    }

    @GetMapping("/search")
    public Page<Customer> search(@NotNull final Pageable pageable,
                                 @RequestParam String query) {

        return customerService.search(pageable, query);
    }
}