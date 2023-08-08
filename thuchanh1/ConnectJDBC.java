package thuchanh1;

import java.sql.*;

public class ConnectJDBC {
    private String hostName = "localhost:3306";
    private String dbName = "demo_jdbc";
    private String username = "root";
    private String password = "1";

    private String connectionURL = "jdbc:mysql://" + hostName + "/" + dbName;

    public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(connectionURL, username, password);
            System.out.println("Kết nối thành công");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}

class Main {
    public static void main(String[] args) {
        ConnectJDBC connectJDBC = new ConnectJDBC();
        connectJDBC.connect();
        Connection conn = connectJDBC.connect();

//        String query = "SELECT * FROM thong_tin";
//
//
//        Statement stm = null;
//        try {
//            stm = conn.createStatement();
//            ResultSet rs = stm.executeQuery(query);
//            while (rs.next()) {
//                int id = rs.getInt("id");
//                String username = rs.getString("username");
//                String password = rs.getString("pasword");
//                String email = rs.getString("email");
//                System.out.println(id + "-" + username + "-" + password + "-" + email);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

//        String question = "INSERT INTO thong_tin(id , username, pasword , email) " + "values(?,?,?,?)";
//
//        PreparedStatement pstm = null;
//        try {
//            pstm = conn.prepareStatement(question);
//           pstm.setInt(1,5);
//            pstm.setString(2,"Manh");
//            pstm.setString(3,"2003");
//            pstm.setString(4,"Manh@codegtm.vn");
//
//            int row = pstm.executeUpdate();
//            if (row != 0){
//                System.out.println("Thêm thành công " + row);
//            }
//            conn.close();
//        } catch (SQLException e) {
//           e.printStackTrace();
//         }
        String query = "DELETE FROM thong_tin WHERE id = ?";

        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(query);

            pst.setInt(1, 5);

            int row = pst.executeUpdate();
            if(row != 0){
                System.out.println("Xóa thành công " + row);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}