package dev.arzak21st.loginapp.repositories;

import dev.arzak21st.loginapp.repositories.RemoveRepository;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RemoveRepositoryTest {

    RemoveRepository removeRepository;

    @BeforeAll
    public void beforeAll() {
        removeRepository = new RemoveRepository();
    }

    @Disabled
    @Nested
    public class RemoveUserByIdTest {

        @Disabled
        @Test
        @DisplayName("Existing user should be removed")
        public void testRemoveUserById_ExistingUser() {

            // Make sure to have an existing user with the same userId
            Integer userId = 13;

            boolean expectedResult = true;
            boolean actualResult = removeRepository.removeUserById(userId);

            assertEquals(expectedResult, actualResult);
        }

        @Disabled
        @Test
        @DisplayName("Non existing user should be removed")
        public void testRemoveUserById_NonExistingUser() {

            // Make sure to have no existing user with the same userId
            Integer userId = 0;

            boolean expectedResult = false;
            boolean actualResult = removeRepository.removeUserById(userId);

            assertEquals(expectedResult, actualResult);
        }
    }
}
/*
How to test a method
====================
1. Create an instance of the class under test
2. Set up inputs to be passed to the method
3. Execute the code that we want to test
4. Verify the result (expected result VS actual result) using assertion methods
 */
