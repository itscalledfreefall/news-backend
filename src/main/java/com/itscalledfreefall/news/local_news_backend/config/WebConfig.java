package com.itscalledfreefall.news.local_news_backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class WebConfig {

    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity http, CorsConfigurationSource corsConfigurationSource) throws Exception{
        http.csrf(csrf -> csrf.disable())
                .cors(cors -> cors.configurationSource(corsConfigurationSource))
                .authorizeHttpRequests(auth-> auth
                        .requestMatchers("/api/articles").permitAll()
                        .requestMatchers("/api/articles/{id}").permitAll()
                        .requestMatchers("/api/categories").permitAll()
                )
                .httpBasic(httpBasic -> httpBasic.disable());
                return http.build();

    }
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
                 CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList(
                            "http://localhost:5500",
                            "http://127.0.0.1:5500",
                "null"
        ));
                configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"
        ));

                 configuration.setAllowedHeaders(Arrays.asList("*"));
                 configuration.setAllowCredentials(true);

                UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
                source.registerCorsConfiguration("/**", configuration);
                 return source;
            }
    }




