package dev.arzak21st.loginapp.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import dev.arzak21st.loginapp.databases.MySqlDatabase;
import dev.arzak21st.loginapp.models.User;
import dev.arzak21st.loginapp.models.UserCredential;

public class GetRepository {

    /* ========== VARIABLES ========== */
    User user;
    UserCredential userCredential;

    ResultSet userRS;
    ResultSet userCredentialRS;

    Integer lastSavedUserId;
    boolean userCredentialExists;

    String sqlQuery;

    Connection connection = MySqlDatabase.getConnection();
    PreparedStatement preparedStatement;

    /* ========== METHODS ========== */
    public Integer getLastSavedUserId() {

        lastSavedUserId = null;
        userRS = null;

        try {

            sqlQuery
                    = "SELECT MAX(user_id) \n"
                    + "FROM user";

            preparedStatement = connection.prepareStatement(sqlQuery);

            userRS = preparedStatement.executeQuery();

            if(userRS.next()) {
                if(userRS.getObject(1) != null) {
                    lastSavedUserId = userRS.getInt(1);
                }
            }
        }
        catch(Exception exception) {
            // exception.printStackTrace();
            lastSavedUserId = null;
        }
        return lastSavedUserId;
    }

    public User getUserById(Integer userId) {

        user = null;
        userRS = null;

        try {

            sqlQuery
                    = "SELECT * \n"
                    + "FROM user \n"
                    + "WHERE user.user_id = ?";

            preparedStatement = connection.prepareStatement(sqlQuery);

            preparedStatement.setInt(1, userId);

            userRS = preparedStatement.executeQuery();

            if(userRS.next()) {
                user = new User(
                        userRS.getInt(1),
                        userRS.getString(2),
                        userRS.getString(3),
                        userRS.getDate(4),
                        userRS.getString(5),
                        userRS.getString(6)
                );
            }
        }
        catch(Exception exception) {
            // exception.printStackTrace();
            user = null;
        }
        return user;
    }

    public UserCredential getUserCredentialById(Integer userId) {

        userCredential = null;
        userCredentialRS = null;

        try {

            sqlQuery
                    = "SELECT * \n"
                    + "FROM user_credential \n"
                    + "WHERE user_credential.user_id = ?";

            preparedStatement = connection.prepareStatement(sqlQuery);

            preparedStatement.setInt(1, userId);

            userCredentialRS = preparedStatement.executeQuery();

            if(userCredentialRS.next()) {

                user = getUserById(userCredentialRS.getInt(1));
                userCredential = new UserCredential(
                        userCredentialRS.getInt(1),
                        userCredentialRS.getString(2),
                        userCredentialRS.getString(3),
                        userCredentialRS.getString(4),
                        user
                );
            }
        }
        catch(Exception exception) {
            // exception.printStackTrace();
            userCredential = null;
        }
        return userCredential;
    }

    public UserCredential getUserCredentialByEmail(String email) {

        userCredential = null;
        userCredentialRS = null;

        try {

            sqlQuery
                    = "SELECT * \n"
                    + "FROM user_credential \n"
                    + "WHERE user_credential.email = ?";

            preparedStatement = connection.prepareStatement(sqlQuery);

            preparedStatement.setString(1, email);

            userCredentialRS = preparedStatement.executeQuery();

            if(userCredentialRS.next()) {

                user = getUserById(userCredentialRS.getInt(1));
                userCredential = new UserCredential(
                        userCredentialRS.getInt(1),
                        userCredentialRS.getString(2),
                        userCredentialRS.getString(3),
                        userCredentialRS.getString(4),
                        user
                );
            }
        }
        catch(Exception exception) {
            // exception.printStackTrace();
            userCredential = null;
        }
        return userCredential;
    }

    public UserCredential getUserCredentialByEmailAndPassword(String email, String password) {

        userCredential = null;
        userCredentialRS = null;

        try {

            sqlQuery
                    = "SELECT * \n"
                    + "FROM user_credential \n"
                    + "WHERE user_credential.email = ? \n"
                    + "AND user_credential.password = ?";

            preparedStatement = connection.prepareStatement(sqlQuery);

            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);

            userCredentialRS = preparedStatement.executeQuery();

            if(userCredentialRS.next()) {

                user = getUserById(userCredentialRS.getInt(1));
                userCredential = new UserCredential(
                        userCredentialRS.getInt(1),
                        userCredentialRS.getString(2),
                        userCredentialRS.getString(3),
                        userCredentialRS.getString(4),
                        user
                );
            }
        }
        catch(Exception exception) {
            // exception.printStackTrace();
            userCredential = null;
        }
        return userCredential;
    }

    public UserCredential getUserCredentialByUsernameOrEmail(String username, String email) {

        userCredential = null;
        userCredentialRS = null;

        try {

            sqlQuery
                    = "SELECT * \n"
                    + "FROM user_credential \n"
                    + "WHERE user_credential.username = ? \n"
                    + "OR user_credential.email = ?";

            preparedStatement = connection.prepareStatement(sqlQuery);

            preparedStatement.setString(1, username);
            preparedStatement.setString(2, email);

            userCredentialRS = preparedStatement.executeQuery();

            if(userCredentialRS.next()) {

                user = getUserById(userCredentialRS.getInt(1));
                userCredential = new UserCredential(
                        userCredentialRS.getInt(1),
                        userCredentialRS.getString(2),
                        userCredentialRS.getString(3),
                        userCredentialRS.getString(4),
                        user
                );
            }
        }
        catch(Exception exception) {
            // exception.printStackTrace();
            userCredential = null;
        }
        return userCredential;
    }

    public boolean getUserCredentialByIdAndPassword(Integer userId, String password) {

        userCredentialExists = false;
        userCredentialRS = null;

        try {

            sqlQuery
                    = "SELECT * \n"
                    + "FROM user_credential \n"
                    + "WHERE user_credential.user_id = ? \n"
                    + "AND user_credential.password = ?";

            preparedStatement = connection.prepareStatement(sqlQuery);

            preparedStatement.setInt(1, userId);
            preparedStatement.setString(2, password);

            userCredentialRS = preparedStatement.executeQuery();

            if(userCredentialRS.next()) {
                userCredentialExists = true;
            }
        }
        catch(Exception exception) {
            // exception.printStackTrace();
            userCredentialExists = false;
        }
        return userCredentialExists;
    }
}
