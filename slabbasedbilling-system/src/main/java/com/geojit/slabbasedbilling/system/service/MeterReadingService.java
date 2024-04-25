package com.geojit.slabbasedbilling.system.service;

import com.geojit.slabbasedbilling.system.exception.CustomerNotFoundException;
import com.geojit.slabbasedbilling.system.model.Customer;
import com.geojit.slabbasedbilling.system.model.MeterReading;
import com.geojit.slabbasedbilling.system.repository.CustomerRepository;
import com.geojit.slabbasedbilling.system.repository.MeterReadingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeterReadingService {
    @Autowired
    private MeterReadingRepository meterReadingRepository;
    @Autowired
    private CustomerRepository customerRepository;

    public MeterReading saveMeterReadingDetails(Long customerId,MeterReading meterReading){
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found with id: " + customerId));
        meterReading.setCustomer(customer);
        return meterReadingRepository.save(meterReading);
    }

    public List<MeterReading> getAllMeterReading(){
        return meterReadingRepository.findAll();
    }

    public MeterReading getMeterReadingById(Long id){
        return meterReadingRepository.getById(id);
    }

    public MeterReading updateMeterReadingDetails(MeterReading meterReading,Long id){
        meterReading.setId(id);
        return meterReadingRepository.save(meterReading);
    }

    public void deleteByMeterReading(Long id){
        meterReadingRepository.deleteById(id);
    }
}
