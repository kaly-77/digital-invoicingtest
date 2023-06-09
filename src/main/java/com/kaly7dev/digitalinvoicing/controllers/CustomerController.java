package com.kaly7dev.digitalinvoicing.controllers;

import com.kaly7dev.digitalinvoicing.core_api.dtos.CustomerDto;
import com.kaly7dev.digitalinvoicing.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping("/api/customer")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;
    @PostMapping("/create")
    public ResponseEntity<String> createCustomer(@RequestBody CustomerDto customerDto){
        customerService.createCustomer(customerDto);
        return new ResponseEntity<>(CREATED);
    }
    @GetMapping("/lists")
    public ResponseEntity<List<CustomerDto>> getAllCustomers(){
        return status(HttpStatus.OK).body(customerService.getAllCustomers());
    }
    @PutMapping("/update/{custId}")
    public ResponseEntity<CustomerDto> updateCustomer(@PathVariable Long custId, @RequestBody CustomerDto customerDto){
        return status(HttpStatus.OK).body(customerService.updateCustomer(custId, customerDto));
    }
    @DeleteMapping("/delete/{custId}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long custId){
        customerService.deleteCustomer(custId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    ///////////////////////////// pagination and filtering endpoints ///////////////////////////////////////////////////
    @GetMapping("/paginatedlist")
    public ResponseEntity<Map<String, Object>> paginateCustomers(@RequestParam(required = false) String name,
                                                                 @RequestParam(defaultValue ="0") Integer page,
                                                                 @RequestParam(defaultValue ="3") Integer size){
        try {
            return new ResponseEntity<>(customerService.paginateCustomers(name, page, size), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
