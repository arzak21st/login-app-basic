package dev.arzak21st.loginapp.utilities;

import java.sql.Date;

public class ValidateUtility {

    /* ========== METHODS ========== */
    public static boolean validateParameters(Object[] parameters) {

        boolean parametersAreValid = false;

        if(parameters == null) {
            return parametersAreValid; // false
        }

        Integer parametersCount = parameters.length;
        Integer validParametersCount = 0;

        for(Object parameter : parameters) {

            if(parameter != null) {

                if(parameter.getClass() == Integer.class) {
                    if(((Integer) parameter) > 0) {
                        validParametersCount++;
                    }
                }
                else if(parameter.getClass() == String.class) {
                    if(!((String) parameter).equals("")) {
                        validParametersCount++;
                    }
                }
                else if(parameter.getClass() == Date.class) {
                    if(!((Date) parameter).equals("")) {
                        validParametersCount++;
                    }
                }
            }
        }
//        System.out.println("Parameters: " + parametersCount);
//        System.out.println("Valid Parameters: " + validParametersCount);
        if(validParametersCount == parametersCount) {
            parametersAreValid = true;
        }

        return parametersAreValid;
    }
}
