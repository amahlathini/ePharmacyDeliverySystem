//package com.digital.epharmacy.controller.Driver;
///*
// * Author: Chad Boswell 215254589
// * Date: 25/09/2020
// * Desc: Controller of Driver Car
// */
//import com.digital.epharmacy.entity.Driver.DriverCar;
//import com.digital.epharmacy.factory.Driver.DriverCarFactory;
//import com.digital.epharmacy.service.Driver.impl.DriverCarServiceImpl;
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
//@RequestMapping("/cars")
//public class DriverCarController {
//
//    @Autowired
//    private DriverCarServiceImpl carService;
//
//    @Autowired
//    private ValidationService validationService;
//
//    @PostMapping("/create")
//    public DriverCar create(@Valid @RequestBody DriverCar driverCar) {
//
////        ResponseEntity<DriverCar> errorMap = (ResponseEntity<DriverCar>) validationService.MapValidationService(result);
////
////        if (errorMap != null)
////            return errorMap;
//
//        DriverCar newDriverCar = DriverCarFactory
//                .createDriverCar(
//                        driverCar.getCar_registration(),
//                        driverCar.getCar_colour(),
//                        driverCar.getCar_name(),
//                        driverCar.getCar_model(),
//                        driverCar.getDriver()
//                );
//
//       return carService.create(newDriverCar);
//
//    }
//
//    @GetMapping("/read/{driver_id}")
//    public DriverCar read(@PathVariable String driver_id){
//        return carService.read(driver_id);
//    }
//
//    @PostMapping("/update")
//    public DriverCar update(@RequestBody DriverCar driver_id){
//        return carService.update(driver_id);
//    }
//
//    @GetMapping("/")
//    public Set<DriverCar>getAll(){
//        return carService.getAll();
//    }
//
//    @DeleteMapping("/delete/{driver_id}")
//    public boolean delete(@PathVariable String driver_id){
//        return carService.delete(driver_id);
//    }
//}
