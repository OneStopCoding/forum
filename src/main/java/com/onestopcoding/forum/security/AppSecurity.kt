package com.onestopcoding.forum.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.crypto.factory.PasswordEncoderFactories
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

@Configuration
open class AppSecurity (private val jwtFilter: JwtFilter){

    @Bean
    open fun securityWebFilterChain(
        httpSecurity: HttpSecurity,
    ):SecurityFilterChain{
        return httpSecurity.csrf { it.disable() }
            .addFilterAt(jwtFilter, UsernamePasswordAuthenticationFilter::class.java)
            .authorizeHttpRequests { it.anyRequest().permitAll() }
            .build()
    }

    @Bean
    open fun passwordEncoder(): PasswordEncoder {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder()
    }
}