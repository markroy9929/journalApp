package net.engineeringdigest.journalApp;  // es pakage ki sari @Component wali classes IOC container rakh lega
// koi aur pakage (parent folder) ko IOC scan nahi krega


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication   // merge of these 3 anotations - @Configuration @EnableAutoConfiguration  @ComponentScan
public class JournalApplication {

    public static void main(String[] args) {
        SpringApplication.run(JournalApplication.class, args);
    }

}
