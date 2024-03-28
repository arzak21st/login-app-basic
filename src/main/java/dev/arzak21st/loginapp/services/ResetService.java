package dev.arzak21st.loginapp.services;

import java.sql.Date;
import dev.arzak21st.loginapp.models.User;
import dev.arzak21st.loginapp.repositories.UpdateRepository;
import static dev.arzak21st.loginapp.utilities.ValidateUtility.validateParameters;

public class ResetService {

    UpdateRepository updateRepository = new UpdateRepository();

    public boolean resetUser(String firstName, String lastName, Date dateOfBirth, String gender, String country, Integer userId) {

        boolean userIsReset = false;

        Object[] parameters = {firstName, lastName, dateOfBirth, gender, country, userId};
        boolean parametersAreValid = validateParameters(parameters);

        if(parametersAreValid) {

            User user = new User(userId, firstName, lastName, dateOfBirth, gender, country);
            userIsReset = updateRepository.updateUser(user);
        }
        
        return userIsReset;
    }
}
