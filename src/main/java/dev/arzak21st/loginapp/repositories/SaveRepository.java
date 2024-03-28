package dev.arzak21st.loginapp.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import dev.arzak21st.loginapp.databases.MySqlDatabase;
import dev.arzak21st.loginapp.models.User;
import dev.arzak21st.loginapp.models.UserCredential;

public class SaveRepository {

    /* ========== VARIABLES ========== */
    boolean userIsSaved;
    boolean userCredentialIsSaved;

    Integer saving;

    String sqlQuery;

    Connection connection = MySqlDatabase.getConnection();
    PreparedStatement preparedStatement;

    /* ========== METHODS ========== */
    public boolean saveUser(User user) {

        userIsSaved = false;

        try {

            sqlQuery
                    = "INSERT INTO user (first_name, last_name, date_of_birth, gender, country) \n"
                    + "VALUES (?, ?, ?, ?, ?)";

            preparedStatement = connection.prepareStatement(sqlQuery);

            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setDate(3, user.getDateOfBirth());
            preparedStatement.setString(4, user.getGender());
            preparedStatement.setString(5, user.getCountry());

            saving = preparedStatement.executeUpdate();

            if(saving == 1) {
                userIsSaved = true;
            }
        }
        catch(Exception exception) {
            // exception.printStackTrace();
            userIsSaved = false;
        }
        return userIsSaved;
    }

    public boolean saveUserCredential(UserCredential userCredential) {

        userCredentialIsSaved = false;

        try {

            sqlQuery
                    = "INSERT INTO user_credential (user_id, username, email, password) \n"
                    + "VALUES (?, ?, ?, ?)";

            preparedStatement = connection.prepareStatement(sqlQuery);

            preparedStatement.setInt(1, userCredential.getUserId());
            preparedStatement.setString(2, userCredential.getUsername());
            preparedStatement.setString(3, userCredential.getEmail());
            preparedStatement.setString(4, userCredential.getPassword());

            saving = preparedStatement.executeUpdate();

            if(saving == 1) {
                userCredentialIsSaved = true;
            }
        }
        catch(Exception exception) {
            // exception.printStackTrace();
            userCredentialIsSaved = false;
        }
        return userCredentialIsSaved;
    }
}
