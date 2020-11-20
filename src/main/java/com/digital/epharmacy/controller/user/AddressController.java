//package com.digital.epharmacy.controller.user;
//// Keagan Tabisher, Address Controller to expose the AddressService.
//
//
//import com.digital.epharmacy.entity.Pharmacy.Pharmacy;
//import com.digital.epharmacy.entity.User.Address;
//import com.digital.epharmacy.factory.User.AddressFactory;
//import com.digital.epharmacy.service.User.impl.AddressServiceImpl;
//import com.digital.epharmacy.service.Validation.ValidationService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//import java.util.Set;
//;
//
//@RestController
//@RequestMapping("/addresses")
//public class AddressController {
//
//    @Autowired
//    private AddressServiceImpl addressService;
//
//    @Autowired
//    private ValidationService validationService;
//
//    @PostMapping("/create")
//    public Address create (@Valid @RequestBody Address address)
//    {
////        ResponseEntity<Address> errorMap = (ResponseEntity<Address>) validationService.MapValidationService(result);
////
////        if (errorMap != null)
////            return errorMap;
//
//        Address newAddress = AddressFactory.createAddress(
//                address.getStreet_number(),
//                address.getArea_code(),
//                address.getStreet_name(),
//                address.getArea_name()
//        );
//
//        return addressService.create(newAddress);
//    }
//
//    @GetMapping("/read/{address_id}")
//    public Address readbyAddress(@PathVariable String address_id){
//        return addressService.read(address_id);
//
//    }
//
//    @GetMapping("/name/{street_name}")
//    public Address readByPharmacyName(@PathVariable String street_name){
//        return addressService.findAddressByStreetName(street_name);
//
//    }
//
//    @PostMapping("/update")
//    public Address update (@RequestBody Address address){
//        return addressService.update(address);
//    }
//
//    @GetMapping("/")
//    public Set<Address> getAll(){
//        return addressService.getAll();
//    }
//
//    @DeleteMapping("/delete/{addressI_id}")
//    public boolean delete(@PathVariable String address_id){
//        return addressService.delete(address_id);
//    }
//}
//
//
