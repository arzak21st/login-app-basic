package dev.arzak21st.loginapp.repositories;

import dev.arzak21st.loginapp.repositories.SaveRepository;
import java.sql.Date;
import dev.arzak21st.loginapp.models.User;
import dev.arzak21st.loginapp.models.UserCredential;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SaveRepositoryTest {

    SaveRepository saveRepository;

    @BeforeAll
    public void beforeAll() {
        saveRepository = new SaveRepository();
    }

    @Disabled
    @Nested
    public class SaveUserTest {

        @Disabled
        @Test
        @DisplayName("Valid user should be saved")
        public void testSaveUser_ValidValues() {

            String firstName = "Wassim";
            String lastName = "Arzak";
            Date dateOfBirth = Date.valueOf("2000-05-21");
            String gender = "Male";
            String country = "Morocco";
            User user = new User(firstName, lastName, dateOfBirth, gender, country);

            boolean expectedResult = true;
            boolean actualResult = saveRepository.saveUser(user);

            assertEquals(expectedResult, actualResult);
        }

        @Disabled
        @Test
        @DisplayName("Null user should NOT be saved")
        public void testSaveUser_NullValues() {

            User user = null;

            boolean expectedResult = false;
            boolean actualResult = saveRepository.saveUser(user);

            assertEquals(expectedResult, actualResult);
        }
    }

    @Disabled
    @Nested
    public class SaveUserCredentialTest {

        @Disabled
        @Test
        @DisplayName("Valid userCredential should be saved")
        public void testSaveUserCredential_ValidValues() {

            // Make sure to have an existing user with the same userId
            Integer userId = 14;
            String username = "arzak";
            String email = "arzak.wassim@gmail.com";
            String password = "123";
            UserCredential userCredential = new UserCredential(userId, username, email, password);

            boolean expectedResult = true;
            boolean actualResult = saveRepository.saveUserCredential(userCredential);

            assertEquals(expectedResult, actualResult);
        }

        @Disabled
        @Test
        @DisplayName("Null userCredential should NOT be saved")
        public void testSaveUserCredential_NullValues() {

            UserCredential userCredential = null;

            boolean expectedResult = false; // UserCredential not should be saved
            boolean actualResult = saveRepository.saveUserCredential(userCredential);

            assertEquals(expectedResult, actualResult);
        }

        @Disabled
        @Test
        @DisplayName("Duplicated userCredential should NOT be saved")
        public void testSaveUserCredential_DuplicatedValues() {

            // Make sure to have an already existing userCredential with the same userId/username/email
            Integer userId = 14;
            String username = "arzak";
            String email = "arzak.wassim@gmail.com";
            String password = "123";
            UserCredential userCredential = new UserCredential(userId, username, email, password);

            boolean expectedResult = false;
            boolean actualResult = saveRepository.saveUserCredential(userCredential);

            assertEquals(expectedResult, actualResult);
        }

        @Disabled
        @Test
        @DisplayName("Non existing user means userCredential should NOT be saved")
        public void testSaveUserCredential_NonExistingUser() {

            // Make sure to have no existing user with the same userId
            Integer userId = 0;
            String username = "arzak";
            String email = "arzak.wassim@gmail.com";
            String password = "123";
            UserCredential userCredential = new UserCredential(userId, username, email, password);

            boolean expectedResult = false;
            boolean actualResult = saveRepository.saveUserCredential(userCredential);

            assertEquals(expectedResult, actualResult);
        }
    }
}
