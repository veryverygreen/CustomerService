package ru.popov.customerservice.web.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import ru.popov.customerservice.domain.Address;
import ru.popov.customerservice.service.AddressService;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PutMapping
    public void update(@RequestBody Address address) {

        if (address.getId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No id specified to update address");
        }

        Address addressFromDb = addressService.findById(address.getId());

        if (addressFromDb == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No address found with id: " + address.getId());
        }

        BeanUtils.copyProperties(address, addressFromDb);

        addressService.save(address);
    }
}