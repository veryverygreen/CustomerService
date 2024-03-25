package ru.popov.customerservice.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.popov.customerservice.dao.AddressRepository;
import ru.popov.customerservice.domain.Address;

import java.util.Optional;

@Service
@Transactional
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public Address findById(Long id) {

        Optional<Address> address = addressRepository.findById(id);
        return address.isPresent() ? address.get() : null;
    }

    public void save(Address address) {
        addressRepository.save(address);
    }

}