package com.geojit.slabbasedbilling.system.controller;

import com.geojit.slabbasedbilling.system.model.Customer;
import com.geojit.slabbasedbilling.system.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;
   @PostMapping("/saveCustomers")
    public ResponseEntity<Customer> saveCustomer(@Valid @RequestBody Customer customer){
         Customer customers = customerService.saveCustomerDetails(customer);
        return  ResponseEntity.ok(customers);
    }
    @GetMapping("/listOfCustomers")
    public List<Customer> getAllCustomers(){
         List<Customer> allCustomers = customerService.getAllCustomers();
           return allCustomers;
    }
    @GetMapping("/listOfCustomers/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id){
         Customer customerDetailsById = customerService.getCustomerDetailsById(id);
         return ResponseEntity.ok(customerDetailsById);
    }
    @PutMapping("/updateCustomers/{id}")
    public ResponseEntity<Customer> UpdateCustomerDetails(@RequestBody Customer customer, @PathVariable Long id) {
        Customer customerUpdates = customerService.updateCustomerDetails(customer, id);
        return ResponseEntity.ok(customerUpdates);
    }
    @DeleteMapping("/deleteCustomers/{id}")
    public void deleteById(@PathVariable Long id){

       customerService.deleteCustomerById(id);
    }
}
