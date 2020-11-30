package com.digital.epharmacy;
//Author: Nicole Hawthorne- Main Springboot application

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ePharmacyDeliverySystemApplication {


    public static void main(String[] args){
        SpringApplication.run(ePharmacyDeliverySystemApplication.class, args);
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("http://localhost:3000");
        config.addAllowedOrigin("https://vibekonnect.tech/admin-dashboard");
        config.addAllowedOrigin("https://amahlathini.github.io/admin-dashboard");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
