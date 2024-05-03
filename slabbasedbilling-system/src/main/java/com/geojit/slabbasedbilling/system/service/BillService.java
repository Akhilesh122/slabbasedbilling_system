package com.geojit.slabbasedbilling.system.service;

import com.geojit.slabbasedbilling.system.dto.BillDto;
import com.geojit.slabbasedbilling.system.exception.CustomException;
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
       Long meterReadingId = billDto.getMeterReadingId();
       Long priceSlabsId = billDto.getPriceSlabsId();

       // Check if a bill already exists for the given combination of meterReadingId and priceSlabsId
       boolean billExists = billRepository.existsByMeterReading_IdAndPriceSlabs_Id(meterReadingId, priceSlabsId);

       if (billExists) {
           throw new CustomException("A bill already exists for this combination of meter reading, and price slabs.");
       }

       // Retrieve Customer
       Customer customer = customerRepository.findById(customerId)
               .orElseThrow(() -> new CustomerNotFoundException("Customer not found with id: " + customerId));

       // Retrieve MeterReading
       MeterReading meterReading = meterReadingRepository.findById(meterReadingId)
               .orElseThrow(() -> new CustomerNotFoundException("MeterReading not found with id: " + meterReadingId));

       // Retrieve PriceSlabs
       PriceSlabs priceSlabs = priceSlabRepository.findById(priceSlabsId)
               .orElseThrow(() -> new CustomerNotFoundException("PriceSlabs not found with id: " + priceSlabsId));

       // Calculate units consumed
       int unitsConsumed = meterReading.getCurrentReading() - meterReading.getPreviousReading();

       // Calculate total bill
       double totalAmount = unitsConsumed * priceSlabs.getRate();
       double baseGstRate = 0.18;
       double gstAmount = totalAmount * baseGstRate;
       totalAmount += gstAmount;

       // Create Bill object
       Bill bill = new Bill();
       bill.setCustomer(customer);
       bill.setMeterReading(meterReading);
       bill.setPriceSlabs(priceSlabs);
       bill.setUnitsConsumed(unitsConsumed);
       bill.setTotalAmount(totalAmount);
       bill.setGstAmount(gstAmount);

       // Save the Bill entity
       return billRepository.save(bill);
   }

   public List<Bill> getAllListOfBill(){

       return billRepository.findAll();
   }
}
