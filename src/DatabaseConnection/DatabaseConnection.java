/*
 * Class for database connection.
 */
package DatabaseConnection;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseConnection {

    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/fittstestingdb";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    public static Connection dbConnection = null;

    static {
        try {
            Class.forName(DB_DRIVER);
            dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER,
                    DB_PASSWORD);

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName(DB_DRIVER);
            conn = DriverManager.getConnection(DB_CONNECTION, DB_USER,
                    DB_PASSWORD);

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("----"+e.getMessage());
        }
        System.out.println("COnn "+conn);
        return conn;
    }
}
