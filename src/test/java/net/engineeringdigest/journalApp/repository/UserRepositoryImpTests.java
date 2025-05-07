package net.engineeringdigest.journalApp.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

//@ActiveProfiles("dev")
@SpringBootTest
public class UserRepositoryImpTests {

    @Autowired
    private UserRepositoryImpl userRepository;

//    @Disabled
    @Test
    public void kuchbhi() {
        Assertions.assertNotNull(userRepository.getUserForSA());
    }
}
