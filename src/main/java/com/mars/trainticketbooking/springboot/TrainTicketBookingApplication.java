package com.mars.trainticketbooking.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author madhu
 *
 */
@SpringBootApplication
public class TrainTicketBookingApplication {

    /**
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(TrainTicketBookingApplication.class, args);
    }
    
    /**
     * @return WebMvcConfigurer
     */
    @Bean
    public WebMvcConfigurer corsConfig() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("http://localhost:5173")
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS");
            }
        };
    }
}
