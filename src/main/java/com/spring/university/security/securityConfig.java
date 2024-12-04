package com.spring.university.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class securityConfig {

    private final JwtAuthFilter jwtAuthFilter;

        @Bean
        SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
            http.csrf(AbstractHttpConfigurer::disable)
//                    .csrf(Customizer.withDefaults())
                    .authorizeHttpRequests(
                            authorizeHttp->{
                                authorizeHttp.requestMatchers("/error","/auth/login").permitAll();
                                authorizeHttp.anyRequest().authenticated();
                            }
                    )
                    .sessionManagement(manager->manager.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                    .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
    //                .formLogin(login->login.defaultSuccessUrl("/home"))
    //                .logout(out->out.logoutSuccessUrl("/"))
//                    .build();
            return http.build();
        }

//    @Bean
//    UserDetailsService userDetailsService() {
//        return new InMemoryUserDetailsManager(
//                User.withUsername("Lorn")
//                        .password(passwordEncoder().encode("0000"))
//                        .build()
//        );
//    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}
