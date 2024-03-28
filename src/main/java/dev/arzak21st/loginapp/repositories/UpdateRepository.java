package dev.arzak21st.loginapp.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import dev.arzak21st.loginapp.databases.MySqlDatabase;
import dev.arzak21st.loginapp.models.User;

public class UpdateRepository {

    /* ========== VARIABLES ========== */
    boolean userIsUpdated;
    boolean passwordIsUpdated;

    Integer updating;

    String sqlQuery;

    Connection connection = MySqlDatabase.getConnection();
    PreparedStatement preparedStatement;

    /* ========== METHODS ========== */
    public boolean updateUser(User user) {

        userIsUpdated = false;

        try {

            sqlQuery
                    = "UPDATE user \n"
                    + "SET user.first_name = ?, \n"
                    + "user.last_name = ?, \n"
                    + "user.date_of_birth = ?, \n"
                    + "user.gender = ?, \n"
                    + "user.country = ? \n"
                    + "WHERE user.user_id = ? ";

            preparedStatement = connection.prepareStatement(sqlQuery);

            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setDate(3, user.getDateOfBirth());
            preparedStatement.setString(4, user.getGender());
            preparedStatement.setString(5, user.getCountry());
            preparedStatement.setInt(6, user.getUserId());

            updating = preparedStatement.executeUpdate();

            if(updating == 1) {
                userIsUpdated = true;
            }
        }
        catch(Exception exception) {
            // exception.printStackTrace();
            userIsUpdated = false;
        }
        return userIsUpdated;
    }

    public boolean updatePassword(String newPassword, Integer userId) {

        passwordIsUpdated = false;

        try {

            sqlQuery
                    = "UPDATE user_credential \n"
                    + "SET user_credential.password = ? \n"
                    + "WHERE user_credential.user_id = ? ";

            preparedStatement = connection.prepareStatement(sqlQuery);

            preparedStatement.setString(1, newPassword);
            preparedStatement.setInt(2, userId);

            updating = preparedStatement.executeUpdate();

            if(updating == 1) {
                passwordIsUpdated = true;
            }
        }
        catch(Exception exception) {
            // exception.printStackTrace();
            passwordIsUpdated = false;
        }
        return passwordIsUpdated;
    }
}
