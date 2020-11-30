//package com.digital.epharmacy;
//
//import com.zaxxer.hikari.HikariConfig;
//import com.zaxxer.hikari.HikariDataSource;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.sql.DataSource;
//
//@Configuration
//public class DatabaseConfig {
//
//    @Value("${mysql://b01b3dbfc97121:b25de727@us-cdbr-east-02.cleardb.com/heroku_71cd35f17f8eef3?reconnect=true}")
//    private String dbUrl;
//
//    @Bean
//    public DataSource dataSource() {
//        HikariConfig config = new HikariConfig();
//        config.setJdbcUrl(dbUrl);
//        return new HikariDataSource(config);
//    }
//}
