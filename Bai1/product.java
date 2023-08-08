package Bai1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class product {
    private String hostName = "localhost:3306";
    private String dbName = "product_manager";
    private String username = "root";
    private String password = "1";
    private String connectionURL = "jdbc:mysql://" + hostName + "/" + dbName;


    public Connection connection() {

        Connection conn = null;

       try {
           conn = DriverManager.getConnection(connectionURL,username,password);
           System.out.println("Kết nối thành công!");
       } catch (SQLException e) {
           e.printStackTrace();
       }

       return conn;
    }

}
