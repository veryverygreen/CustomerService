package ru.popov.customerservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.popov.customerservice.dao.CustomerRepository;
import ru.popov.customerservice.domain.Customer;

import java.util.Optional;

@Service
@Transactional
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer findById(Long id) {

        Optional<Customer> customer = customerRepository.findById(id);
        return customer.isPresent() ? customer.get() : null;
    }

    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    public Page<Customer> search(Pageable page, String query) {
        String[] parts = query.split(" ", 2);
        if (parts.length == 2) {
            return customerRepository.findAllByFirstNameContainingIgnoreCaseAndLastNameContainingIgnoreCase(page, parts[0], parts[1]);
        } else {
            return customerRepository.findAllByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(page, parts[0], parts[0]);
        }
    }

    public void save(Customer customer) {
        customerRepository.save(customer);
    }
}