package dev.arzak21st.loginapp.utilities;

import java.sql.Date;
import static dev.arzak21st.loginapp.utilities.ValidateUtility.validateParameters;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ValidateUtilityTest {

    @Disabled
    @Nested
    public class ValidateParametersTest {

        @Disabled
        @Test
        @DisplayName("Valid parameters should be validated")
        public void testValidateParameters_ValidValues() {

            Integer parameter1 = 1;
            String parameter2 = "Reda";
            Date parameter3 = Date.valueOf("2000-05-21");

            Object[] parameters = {parameter1, parameter2, parameter3};

            boolean expectedResult = true;
            boolean actualResult = validateParameters(parameters);

            assertEquals(expectedResult, actualResult);
        }

        @Disabled
        @Test
        @DisplayName("Empty parameters should NOT be validated")
        public void testValidateParameters_EmptyValues() {

            Integer parameter1 = 1;
            String parameter2 = "";
            Date parameter3 = Date.valueOf("2000-05-21");

            Object[] parameters = {parameter1, parameter2, parameter3};

            boolean expectedResult = false;
            boolean actualResult = validateParameters(parameters);

            assertEquals(expectedResult, actualResult);
        }

        @Disabled
        @Test
        @DisplayName("Null parameters should NOT be validated")
        public void testValidateParameters_NullValues() {

            Integer parameter1 = null;
            String parameter2 = null;
            Date parameter3 = null;

            Object[] parameters = {parameter1, parameter2, parameter3};

            boolean expectedResult = false;
            boolean actualResult = validateParameters(parameters);

            assertEquals(expectedResult, actualResult);

            parameters = null;

            expectedResult = false;
            actualResult = validateParameters(parameters);

            assertEquals(expectedResult, actualResult);
        }
    }
}
