package com.example.project_scg.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {

        return http
                .csrf(ServerHttpSecurity.CsrfSpec::disable)
                .authorizeExchange(ex -> ex
                        //.pathMatchers("/actuator/**", "/v1/actuator/**").permitAll()
                        //.pathMatchers("/v1/health").permitAll()  
                        // Swagger, API 문서도 여기서 공개하려면 추가 가능
                        // .pathMatchers("/swagger-ui/**", "/v3/api-docs/**").permitAll()
                        //.anyExchange().authenticated()
                        .anyExchange().permitAll()  
                )
                .httpBasic(ServerHttpSecurity.HttpBasicSpec::disable)
                .formLogin(ServerHttpSecurity.FormLoginSpec::disable)
                .build();
    }
}