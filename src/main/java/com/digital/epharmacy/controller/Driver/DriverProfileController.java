package com.digital.epharmacy.controller.Driver;
/*
 * Author: Chad Boswell 215254589
 * Date: 25/09/2020
 * Desc: Controller of Driver profile
 */
import com.digital.epharmacy.entity.Driver.DriverProfile;
import com.digital.epharmacy.factory.Driver.DriverProfileFactory;
import com.digital.epharmacy.service.Driver.impl.DriverProfileServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
;

@RestController
@RequestMapping ("/drivers")
public class DriverProfileController {
    @Autowired
    private DriverProfileServiceImpl driverProfileService;

    @PostMapping ("/create")
    public DriverProfile create (@RequestBody DriverProfile driverProfile){
        DriverProfile newDriverProfile = DriverProfileFactory.createDriverProfile(driverProfile.getDriver_name(),driverProfile.getDriver_surname(),driverProfile.getDriver_location());
        return driverProfileService.create(newDriverProfile);
    }
    @GetMapping ("/read/{driver_id}")
    public DriverProfile read (@PathVariable String driver_id){
        return driverProfileService.read(driver_id);
    }
    @PostMapping ("/update")
    public DriverProfile update (@RequestBody DriverProfile driverProfile){
        return driverProfileService.update(driverProfile);
    }

    @GetMapping("/")
    public Set<DriverProfile>getAll(){
        return driverProfileService.getAll();
    }
    @DeleteMapping ("/delete/{driver_id}")
    public boolean delete(@PathVariable String driver_id){
        return driverProfileService.delete(driver_id);
    }
}
