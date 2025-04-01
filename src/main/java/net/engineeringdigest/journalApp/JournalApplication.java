package net.engineeringdigest.journalApp;  // es pakage ki sari @Component wali classes IOC container rakh lega
// koi aur pakage (parent folder) ko IOC scan nahi krega


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication   // merge of these 3 anotations - @Configuration @EnableAutoConfiguration  @ComponentScan
@EnableTransactionManagement
public class JournalApplication {

    public static void main(String[] args) {
        SpringApplication.run(JournalApplication.class, args);
    }

    @Bean
    public PlatformTransactionManager add(MongoDatabaseFactory dbFactory) {
        return new MongoTransactionManager(dbFactory);
    }

}
// PlatformTransactionManager
// MongoTransactionManager
