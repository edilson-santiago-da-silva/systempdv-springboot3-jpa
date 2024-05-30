package com.system.pdv.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")  // permite CORS para todos os endpoints
                        .allowedOrigins("http://127.0.0.1:5500")  // permite CORS para esta origem específica (ajuste conforme necessário)
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")  // métodos HTTP permitidos
                        .allowedHeaders("*");  // cabeçalhos permitidos
            }
        };
    }
}
