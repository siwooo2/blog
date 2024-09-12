// package com.siu.blog.config;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
// import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
// import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
// import org.springframework.security.web.SecurityFilterChain;

// @Configuration
// @EnableWebSecurity
// public class WebSecurityConfig {
//     @Bean
//     public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//         http
//             .csrf(AbstractHttpConfigurer::disable)
//             .authorizeHttpRequests(auth -> auth
//                 .requestMatchers("/", "/home", "/swagger-ui.html", "/v3/api-docs/**").permitAll()
//                 .anyRequest().authenticated())
//             .formLogin(AbstractAuthenticationFilterConfigurer::permitAll)
//             .logout(LogoutConfigurer::permitAll);
//         return http.build();
//     }
// }
