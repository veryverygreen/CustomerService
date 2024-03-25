package ru.popov.customerservice.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.popov.customerservice.domain.Address;

@Repository
public interface AddressRepository extends CrudRepository<Address, Long> {
}
