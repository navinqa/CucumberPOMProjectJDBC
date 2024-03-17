import lombok.SneakyThrows;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCDemo {
    @SneakyThrows
    public static void main(String[] args)  {

        Connection connection = null;
        // Register the MySQL JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        String hostname = "Mysql@localhost:3306";
        String databaseName = "schooldb";
        String username = "root";
        String password = "navin@123";
        // JDBC URL
        String url = "jdbc:mysql://" + hostname + ":3306/" + databaseName;
        Connection con = DriverManager.getConnection(url, username, password);

        // Check if the connection is open
        if (con != null && !con.isClosed())
        {
            System.out.println("Database connection is open!");
            Statement st = con.createStatement();
            ResultSet resultSet = st.executeQuery("select * from employee");
            while (resultSet.next())
            {
                System.out.println("ID :" + resultSet.getInt(1));
                System.out.println("Name :" + resultSet.getString(2));
                System.out.println("Address :" + resultSet.getString(3));
            }
        } else {
            System.out.println("Database connection is closed!");
        }
    }

}
