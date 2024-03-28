package dev.arzak21st.loginapp.services;

import java.sql.Date;
import dev.arzak21st.loginapp.models.User;
import dev.arzak21st.loginapp.models.UserCredential;
import dev.arzak21st.loginapp.repositories.GetRepository;
import dev.arzak21st.loginapp.repositories.SaveRepository;
import static dev.arzak21st.loginapp.utilities.ValidateUtility.validateParameters;

public class RegisterService {

    SaveRepository saveRepository = new SaveRepository();
    GetRepository getRepository = new GetRepository();

    public UserCredential checkUserCredential(String username, String email) {

        UserCredential userCredential = null;

        Object[] parameters = {username, email};
        boolean parametersAreValid = validateParameters(parameters);

        if(parametersAreValid) {
            userCredential = getRepository.getUserCredentialByUsernameOrEmail(username, email);
        }

        return userCredential;
    }

    public boolean registerUser(String firstName, String lastName, Date dateOfBirth, String gender, String country) {

        boolean userIsRegistered = false;

        Object[] parameters = {firstName, lastName, dateOfBirth, gender, country};
        boolean parametersAreValid = validateParameters(parameters);

        if(parametersAreValid) {

            User user = new User(firstName, lastName, dateOfBirth, gender, country);
            userIsRegistered = saveRepository.saveUser(user);
        }

        return userIsRegistered;
    }

    public Integer getRegisteredUserId() {

        Integer lastRegisteredUserId = getRepository.getLastSavedUserId();
        return lastRegisteredUserId;
    }

    public boolean registerUserCredential(Integer userId, String username, String email, String password) {

        boolean userCredentialIsRegistered = false;

        Object[] parameters = {userId, username, email, password};
        boolean parametersAreValid = validateParameters(parameters);

        if(parametersAreValid) {

            UserCredential userCredential = new UserCredential(userId, username, email, password);
            userCredentialIsRegistered = saveRepository.saveUserCredential(userCredential);
        }

        return userCredentialIsRegistered;
    }
}
