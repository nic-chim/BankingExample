package com.example.api.controller;

import com.example.api.dto.CustomerDto;
import com.example.api.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService cService;

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable int id){
        CustomerDto customer = cService.getCustomerById(id);
        if (customer != null) {
            return ResponseEntity.ok(customer);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/")
    public ResponseEntity<Integer> createCustomer(@RequestBody CustomerDto request){
        int id = cService.createCustomer(request);
        return ResponseEntity.ok(id);
    }

    @GetMapping("/{cId}/account/{accId}")
    public void getAccount(@PathVariable String cId, @PathVariable String accId){


    }
}
