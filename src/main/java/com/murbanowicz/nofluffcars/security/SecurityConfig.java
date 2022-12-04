package com.murbanowicz.nofluffcars.security;

import com.auth0.jwt.algorithms.Algorithm;
import com.murbanowicz.nofluffcars.data.repo.UserRepository;
import com.murbanowicz.nofluffcars.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserRepository userRepository;
    @Value("${security.sign-secret}")
    private String secret;
    private String LOGIN_URL = "/api/users/login";

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        CustomAuthenticationFilter customAuthenticationFilter = new CustomAuthenticationFilter(
                authenticationManagerBean(),
                algorithm()
        );
        customAuthenticationFilter.setFilterProcessesUrl(LOGIN_URL);

        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.authorizeRequests()
                .antMatchers("/api/users/login").permitAll()
                .antMatchers("/api/users/register").permitAll()
                .antMatchers("**").permitAll();
                /*.antMatchers("/api/inventory").authenticated()
                .antMatchers("/api/inventory/add").hasAuthority(Role.ADMIN.toString())
                .antMatchers("/api/inventory/remove/**").hasAuthority(Role.ADMIN.toString())
                .antMatchers("/api/rentedInventory").hasAuthority(Role.ADMIN.toString())
                .antMatchers("/api/rentedInventory/user/**").authenticated()
                .antMatchers("/api/renting/rent").authenticated()
                .antMatchers("/api/renting/return").authenticated()
                .antMatchers("/api/users").hasAuthority(Role.ADMIN.toString())
                .antMatchers("/api/history/user/**").authenticated()
                .antMatchers("/api/feedback").hasAuthority(Role.ADMIN.toString());*/

        http.addFilter(customAuthenticationFilter);
        http.addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService(userRepository));
    }

    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepository) {
        return username -> userRepository
                .findByEmail(username)
                .orElseThrow(UserNotFoundException::new);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public Algorithm algorithm() {
        return Algorithm.HMAC256(secret.getBytes());
    }
}