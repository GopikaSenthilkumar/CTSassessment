package com.example;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
@DataJpaTest
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;
    @Test
    public void testFindByName() {
        userRepository.save(new User("Gopika"));
        userRepository.save(new User("Senthilkumar"));
        userRepository.save(new User("Gopika"));
        List<User> result = userRepository.findByName("Gopika");
        assertThat(result).hasSize(2);
        assertThat(result).extracting(User::getName).containsOnly("Gopika");
    }
}
