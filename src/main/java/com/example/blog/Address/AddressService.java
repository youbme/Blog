package com.example.blog.Address;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service

public class AddressService {

    @Autowired
    AddressRepository addRepo;


    public ResponseEntity addAddress(Address address) {
        return new ResponseEntity(addRepo.save(address), HttpStatus.OK);
    }
}
