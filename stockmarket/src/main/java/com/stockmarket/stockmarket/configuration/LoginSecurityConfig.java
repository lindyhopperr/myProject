package com.stockmarket.stockmarket.configuration;

import com.stockmarket.stockmarket.handler.RestAccessDeniedHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class LoginSecurityConfig extends WebSecurityConfigurerAdapter {
    private static final String ROLE_ADMIN = "ADMIN";
    private static final String ROLE_USER = "USER";

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        try {
            auth.inMemoryAuthentication()
                    .withUser("user").password(passwordEncoder().encode("12345")).roles(ROLE_USER).and()
                    .withUser("admin").password(passwordEncoder().encode("12345")).roles(ROLE_ADMIN);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().and().authorizeRequests()
                .antMatchers("/stocks/**").hasRole(ROLE_ADMIN)
                .antMatchers("/users/crud/**").hasRole(ROLE_ADMIN)
                .antMatchers("/users/buyStock").hasRole(ROLE_USER)
                .antMatchers("/users/sellStock").hasRole(ROLE_USER)
                .anyRequest().permitAll()
                .and().headers().frameOptions().disable()
                .and().csrf().disable()
                .formLogin().disable()
                .exceptionHandling().accessDeniedHandler(accessDeniedHandler());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    RestAccessDeniedHandler accessDeniedHandler() {
        return new RestAccessDeniedHandler();
    }
}
