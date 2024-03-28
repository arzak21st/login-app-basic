package dev.arzak21st.loginapp.services;

import dev.arzak21st.loginapp.repositories.RemoveRepository;
import static dev.arzak21st.loginapp.utilities.ValidateUtility.validateParameters;

public class RemoveService {

    RemoveRepository removeRepository = new RemoveRepository();

    public boolean removeUserById(Integer userId) {

        boolean userIsRemoved = false;

        Object[] parameters = {userId};
        boolean parametersAreValid = validateParameters(parameters);

        if(parametersAreValid) {
            userIsRemoved = removeRepository.removeUserById(userId);
        }
        
        return userIsRemoved;
    }
}
