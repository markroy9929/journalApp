package net.engineeringdigest.journalApp;

import org.springframework.stereotype.Component;


// @Bean bna dega, bean ko class pr nahi lagate, @Bean ko function pr lagate hai
@Component  // IOC container apne paas ye class rakh lega, also known as application context
public class Dog {

    public String fun(){
        return "Dog class ke andar fun - something";
    }
}
