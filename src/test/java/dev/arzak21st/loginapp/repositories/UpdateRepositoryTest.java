package dev.arzak21st.loginapp.repositories;

import dev.arzak21st.loginapp.repositories.UpdateRepository;
import java.sql.Date;
import dev.arzak21st.loginapp.models.User;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UpdateRepositoryTest {

    UpdateRepository updateRepository;

    @BeforeAll
    public void beforeAll() {
        updateRepository = new UpdateRepository();
    }

    @Disabled
    @Nested
    public class UpdateUserTest {

        @Disabled
        @Test
        @DisplayName("Valid user should be updated")
        public void testUpdateUser_ValidValues() {

            // Make sure to have an existing user with the same userId
            Integer userId = 14;
            String firstName = "Wassim";
            String lastName = "Arzak";
            Date dateOfBirth = Date.valueOf("2000-05-21");
            String gender = "Male";
            String country = "Morocco";
            User user = new User(userId, firstName, lastName, dateOfBirth, gender, country);

            boolean expectedResult = true;
            boolean actualResult = updateRepository.updateUser(user);

            assertEquals(expectedResult, actualResult);
        }

        @Disabled
        @Test
        @DisplayName("Null user should NOT be updated")
        public void testUpdateUser_NullValues() {

            User user = null;

            boolean expectedResult = false;
            boolean actualResult = updateRepository.updateUser(user);

            assertEquals(expectedResult, actualResult);
        }
    }

    @Disabled
    @Nested
    public class UpdatePasswordTest {

        @Disabled
        @Test
        @DisplayName("Valid password should be updated")
        public void testUpdatePassword_ValidValues() {

            // Make sure to have an existing userCredentisl with the same userId
            String newPassword = "123";
            Integer userId = 14;

            boolean expectedResult = true;
            boolean actualResult = updateRepository.updatePassword(newPassword, userId);

            assertEquals(expectedResult, actualResult);
        }

        @Disabled
        @Test
        @DisplayName("Null password should NOT be updated")
        public void testUpdatePassword_NullValues() {

            String newPassword = null;
            Integer userId = 14;

            boolean expectedResult = false;
            boolean actualResult = updateRepository.updatePassword(newPassword, userId);

            assertEquals(expectedResult, actualResult);
        }
    }
}
