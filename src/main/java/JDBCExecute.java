
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;


public class JDBCExecute {
    public static void main(String[] args) throws Exception {

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

        if (con != null && !con.isClosed()) {
            System.out.println("Database connection is open!");
            Statement st = con.createStatement();
            String selectQuery = "select * from employee";
            String insertQuery = "insert into employee(id,name,address)values(3,'Darshan','UK')";
            if (st.execute(selectQuery)) {
                ResultSet resultSet = st.getResultSet();
                while (resultSet.next()) {
                    System.out.println("ID :" + resultSet.getInt(1));
                    System.out.println("Name :" + resultSet.getString(2));
                    System.out.println("Address :" + resultSet.getString(3));
                }
            }
            int count = st.executeUpdate(insertQuery);
            System.out.println("No of rows affected : " + count);


        } else {
            System.out.println("Database connection is closed!");
        }
    }
}
