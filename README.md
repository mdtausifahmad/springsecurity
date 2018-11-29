# springsecurity
This repo is a playground for spring security.


Notes-

1. `FilterChainProxy` class is the entry point of all spring security filter.

2. How spring configure basic security. such as when we import security into the project then 
    automatically we get in memory authentication and logout. 
    For knowing this look into `spring.factories` file under `spring-boot-autoconfiguration`
 
3. spring provide
    
    a. Authentication
    b. Authorization
    c. Security against attack 
    
4. Authentication - who is making the request.
    
   Spring security support many types of authentication. some of them are
   a. username and password
   b. token based
   c. certificate based

    
    
    
