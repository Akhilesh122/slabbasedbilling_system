package com.geojit.slabbasedbilling.system.service;

import com.geojit.slabbasedbilling.system.dto.BillDto;
import com.geojit.slabbasedbilling.system.exception.CustomerNotFoundException;
import com.geojit.slabbasedbilling.system.model.Bill;
import com.geojit.slabbasedbilling.system.model.Customer;
import com.geojit.slabbasedbilling.system.model.MeterReading;
import com.geojit.slabbasedbilling.system.model.PriceSlabs;
import com.geojit.slabbasedbilling.system.repository.BillRepository;
import com.geojit.slabbasedbilling.system.repository.CustomerRepository;
import com.geojit.slabbasedbilling.system.repository.MeterReadingRepository;
import com.geojit.slabbasedbilling.system.repository.PriceSlabRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillService {

    @Autowired
    private BillRepository billRepository;
    @Autowired
    private PriceSlabRepository priceSlabRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private MeterReadingRepository meterReadingRepository;
   public Bill generateBill(BillDto billDto) {

       Long customerId = billDto.getCustomerId();

       // Retrieve Customer
       Customer customer = customerRepository.findById(customerId)
               .orElseThrow(() -> new CustomerNotFoundException("Customer not found with id: " + customerId));

       PriceSlabs priceSlabs = priceSlabRepository.findById(customerId)
               .orElseThrow(() -> new CustomerNotFoundException("Price slabs not found for customer id: " + customerId));

       // Calculate units consumed
         int unitsConsumed = calculateUnitsConsumed(customerId);

       //Calculate total bill
       double totalAmount = unitsConsumed * priceSlabs.getRate();
       double baseGstRate = 0.18;
       double gstAmount = totalAmount * baseGstRate;
       totalAmount += gstAmount;

       // Create Bill object
       Bill bill = new Bill();
       bill.setCustomer(customer);
       bill.setUnitsConsumed(unitsConsumed);
       bill.setTotalAmount(totalAmount);
       bill.setGstAmount(gstAmount);

       // Save the Bill entity
       return billRepository.save(bill);
   }

   public List<Bill> getAllListOfBill(){

       return billRepository.findAll();
   }
    public int calculateUnitsConsumed(long customerId) {
        List<MeterReading> readings = meterReadingRepository.findByCustomerIdOrderByDateAscReadingDesc(customerId);

        // Check if there are at least two readings
        if (readings.size() >= 2) {
            // Assuming the list is sorted by date in ascending order
            MeterReading currentReading = readings.get(readings.size() - 1); //  Latest reading
            MeterReading previousReading = readings.get(readings.size() - 2); // Previous reading

            int unitsConsumed = currentReading.getReading() - previousReading.getReading();

            return unitsConsumed;
        } else {
            //not enough reading for these customer id
            throw new CustomerNotFoundException("Not readings available to calculate units consumed for customer ID: " + customerId);
        }
    }
}
