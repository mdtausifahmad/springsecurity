package com.tausif.springsecurity.authentication.inmemory;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

@Configuration
public class BeanDeclaration {

    //configuration for in memory authentication
    @Bean
    UserDetailsManager memory(){
        return new InMemoryUserDetailsManager();
    }

    @Bean
    InitializingBean initializer(UserDetailsManager manager){
        return () -> {
            UserDetails tausif = User.withDefaultPasswordEncoder()
                    .username("tausif")
                    .password("password")
                    .roles("USER")
                    .build();

            manager.createUser(tausif);

            UserDetails ahmad = User.withUserDetails(tausif)
                    .username("ahmad")
                    .build();
            manager.createUser(ahmad);
        };
    }
}
