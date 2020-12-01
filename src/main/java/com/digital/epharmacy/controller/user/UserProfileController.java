package com.digital.epharmacy.controller.user;
//Nicole Hawthorne - UserProfile Controller to expose the service of the userprofile
//Added validation service on the 27 october and added read by id and name methods for admin

import com.digital.epharmacy.entity.User.UserProfile;
import com.digital.epharmacy.factory.User.UserProfileFactory;
//import com.digital.epharmacy.service.MedicalAid.impl.MedicalAidServiceImpl;
//import com.digital.epharmacy.service.User.impl.AddressServiceImpl;
//import com.digital.epharmacy.service.User.impl.ContactInformationServiceImpl;
import com.digital.epharmacy.service.User.impl.UserProfileServiceImpl;
import com.digital.epharmacy.service.Validation.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

;

@RestController
@RequestMapping ("/users")
public class UserProfileController {
    @Autowired
    private UserProfileServiceImpl userProfileService;

//    @Autowired
//    private ContactInformationServiceImpl contactService;
//
//    @Autowired
//    private AddressServiceImpl addressService;
//
//    @Autowired
//    private MedicalAidServiceImpl medicalAidService;

    @Autowired
    private ValidationService validationService;

    @PostMapping("/create")
    public UserProfile create(@Valid @RequestBody UserProfile userProfile) {
//        ResponseEntity<UserProfile> errorMap = (ResponseEntity<UserProfile>) validationService.MapValidationService(bindingResult);
//        if (errorMap != null) {
//            return errorMap;
//        }

        UserProfile user = userProfileService.create(UserProfileFactory.createUserProfile(userProfile.getUser_name(),userProfile.getUser_surname(), userProfile.getGender(), userProfile.getEmail(), userProfile.getPassword(), userProfile.getContact(), userProfile.getAddress(), userProfile.getMedical_aid()));

        return user;

    }
    @GetMapping("/id/{user_id}")
    public UserProfile readByUserProfileId(@PathVariable String user_id) {
        return userProfileService.read(user_id);
    }

    @GetMapping("/name/{user_name}")
    public UserProfile readByUserProfileName(@PathVariable String user_name){
        return userProfileService.findUserProfileByUserName(user_name);
    }
    @PostMapping ("/update")
    public UserProfile update (@Valid @RequestBody UserProfile userProfile){
        return userProfileService.update(userProfile);
    }
    @GetMapping("")
    public Set<UserProfile>getall(){
        return userProfileService.getAll();
    }

    @DeleteMapping ("/delete/{user_id}")
    public boolean delete(@PathVariable String user_id){
        return userProfileService.delete(user_id);
    }
}

