package dev.arzak21st.loginapp.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import dev.arzak21st.loginapp.databases.MySqlDatabase;

public class RemoveRepository {

    /* ========== VARIABLES ========== */
    boolean userIsRemoved;

    Integer removing;

    String sqlQuery;

    Connection connection = MySqlDatabase.getConnection();
    PreparedStatement preparedStatement;

    /* ========== METHODS ========== */
    public boolean removeUserById(Integer userId) {

        userIsRemoved = false;

        try {

            sqlQuery
                    = "DELETE FROM user \n"
                    + "WHERE user.user_id = ? ";

            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, userId);

            removing = preparedStatement.executeUpdate();
            if(removing == 1) {
                userIsRemoved = true;
            }
        }
        catch(Exception exception) {
            // exception.printStackTrace();
            userIsRemoved = false;
        }
        return userIsRemoved;
    }
}
