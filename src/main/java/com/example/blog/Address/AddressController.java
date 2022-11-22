package com.example.blog.Address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class AddressController {

    @Autowired
    AddressService addService;

    @PostMapping("addAddress")
    private ResponseEntity<?> addAddress(@RequestBody Address address){
        return new ResponseEntity<>(addService.addAddress(address), HttpStatus.OK);
    }
}
