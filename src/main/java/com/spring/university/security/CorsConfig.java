//package com.spring.university.security;
///*When to Use It:
//Use it: If your frontend and backend are hosted on different origins (e.g., during development or in production when hosted separately).
//Skip it: If frontend and backend are served from the same origin (e.g., backend serves the frontend), CORS is not needed.
//However, having this configuration ensures your API is prepared for scalability and cross-origin scenarios, even if not immediately required.*/
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class CorsConfig {
//
//
//    @Bean
//    public WebMvcConfigurer webMvcConfigurer() {
//        return new WebMvcConfigurer() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/**")
//                        .allowedMethods("GET", "POST", "PUT", "DELETE")
//                        .allowedOrigins("*");
//            }
//        };
//    }
//}
