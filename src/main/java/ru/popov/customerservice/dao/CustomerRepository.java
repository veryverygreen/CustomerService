package ru.popov.customerservice.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.popov.customerservice.domain.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
    public Page<Customer> findAll(Pageable page);
    public Page<Customer> findAllByFirstNameContainingIgnoreCaseAndLastNameContainingIgnoreCase(Pageable page, String firstNamePtrn, String lastNamePtrn);
    public Page<Customer> findAllByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(Pageable page, String firstNamePtrn, String lastNamePtrn);
}
