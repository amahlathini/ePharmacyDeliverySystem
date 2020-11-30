package com.digital.epharmacy;
//Author: Nicole Hawthorne- Main Springboot application

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import digital.epharmacy.pharmacy.config.MyIntercepter;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.MappedInterceptor;

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

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:4200", "http://localhost:3000", "https://epharmacy-sa.herokuapp.com", "https://amahlathini.github.io/admin-dashboard", "https://vibekonnect.tech/admin-dashboard");
            }
        };
    }

    @Bean
    public MappedInterceptor myMappedInterceptor(){
        return new MappedInterceptor(new String[]{"/**"}, new MyIntercepter());
    }
}
