import java.sql.*;
import java.util.Scanner;

public class TransactionDemoWithRollback {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
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

        System.out.println("data before transaction... ");
        String selectQuery = "select * from accounts";
        Statement st = con.createStatement();
        ResultSet resultSet = st.executeQuery(selectQuery);
        while (resultSet.next()) {
            System.out.println(resultSet.getString(1) + " " + resultSet.getString(2));
        }
        System.out.println("Transactions begins....");
        con.setAutoCommit(false);
        st.executeUpdate("update accounts set balance=balance-500 where user='navin'");
        st.executeUpdate("update accounts set balance=balance+500 where user='hiten'");
        System.out.println("Can you please conform this transaction yes/no");
        Scanner sc = new Scanner(System.in);
        String options = sc.next();
        if (options.equals("yes")) {
            con.commit();
            System.out.println("Transaction commit..");
        } else {
            con.rollback();
            System.out.println("Transaction rollback...");
        }
        System.out.println("data after transaction..");

        String selectQuery1 = "select * from accounts";
        Statement st1 = con.createStatement();
        ResultSet resultSet1 = st1.executeQuery(selectQuery1);
        while (resultSet.next()) {
            System.out.println(resultSet.getString(1) + " " + resultSet.getString(2));
        }


        String insertQuery = "insert into employee(id,name,address)values(3,'Darshan','UK')";

    }
}
