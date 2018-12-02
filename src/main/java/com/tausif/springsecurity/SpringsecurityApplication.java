package com.tausif.springsecurity;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

@SpringBootApplication
public class SpringsecurityApplication {

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



    public static void main(String[] args) {

        SpringApplication.run(SpringsecurityApplication.class, args);
    }
}
