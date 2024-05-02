package com.geojit.slabbasedbilling.system.service;

import com.geojit.slabbasedbilling.system.exception.CustomException;
import com.geojit.slabbasedbilling.system.model.Customer;
import com.geojit.slabbasedbilling.system.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CustomerService {
@Autowired
   private CustomerRepository customerRepository;

    public Customer saveCustomerDetails(Customer customer){
        if (Objects.nonNull(customerRepository.findByCunsumerId(customer.getCunsumerId()))) {
            throw new CustomException("CunsumerId already present");
        }
        customer.generateConsumerId();
        return customerRepository.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerDetailsById(Long id) {
      return customerRepository.getById(id);
    }
    public Customer updateCustomerDetails(Customer customer,Long id){
        customer.setId(id);
        return customerRepository.save(customer);
    }
    public void deleteCustomerById(Long id) {
        customerRepository.deleteById(id);
    }
}
