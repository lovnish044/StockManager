package stocksmanager.DA;

import java.sql.*;

public abstract class AbstractDao {

    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "System", "123456789");

        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }
}
