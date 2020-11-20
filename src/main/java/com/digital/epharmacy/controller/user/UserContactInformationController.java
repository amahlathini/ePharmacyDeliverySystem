//package com.digital.epharmacy.controller.user;
//
////Matthew Pearce - UserContactInformation Controller
//
//import com.digital.epharmacy.entity.User.ContactInformation;
//import com.digital.epharmacy.factory.User.ContactInformationFactory;
//import com.digital.epharmacy.service.User.impl.ContactInformationServiceImpl;
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
//@RequestMapping("/contacts")
//public class UserContactInformationController {
//
//    @Autowired
//    private ContactInformationServiceImpl contactInformationService;
//
//    @Autowired
//    private ValidationService validationService;
//
//    @PostMapping("/create")
//    public ContactInformation create (@Valid @RequestBody ContactInformation contactInformation){
//
////        ResponseEntity<ContactInformation> errorMap = (ResponseEntity<ContactInformation>) validationService.MapValidationService(result);
////
////   if(errorMap != null){
////
////       return errorMap;
////   }
//
//        ContactInformation newContactInformation = ContactInformationFactory.createContactInformation(
//                contactInformation.getPrimary_number(),
//                contactInformation.getSecondary_number()
//        );
//
//       return contactInformationService.create(newContactInformation);
//    }
//
//    @GetMapping("/read/{user_id}")
//    public ContactInformation read (@PathVariable String user_id){
//
//        return contactInformationService.read(user_id);
//    }
//
//    @PostMapping("/update")
//    public ContactInformation update (@RequestBody ContactInformation contactInformation){
//        return contactInformationService.update(contactInformation);
//    }
//
//    @GetMapping("/")
//    public Set<ContactInformation> getAll(){
//        return contactInformationService.getAll();
//    }
//
//    @DeleteMapping("/delete/{user_id}")
//    public boolean delete(@PathVariable String user_id){
//        return contactInformationService.delete(user_id);
//    }
//}
