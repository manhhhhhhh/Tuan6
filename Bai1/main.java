package Bai1;

import com.mysql.cj.Query;
import com.mysql.cj.x.protobuf.MysqlxCrud;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class main {
    public static void main(String[] args) throws SQLException {
        product productManager = new product();
        Connection conn = productManager.connection();


//        addDataToDatabase(conn);
//        updateDataToDatabase(conn);
//        deleteDataToDatabase(conn);
//        queryDataToDatabase(conn);
//        queryIdDataToDatabase(conn);

    }

    private static void queryIdDataToDatabase(Connection conn) throws SQLException {
        String query = "select * from san_pham where id = 3";

        Statement statement = null;

        statement = conn.createStatement();

        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String tenSP = resultSet.getString("tenSP");
            String giaSP = resultSet.getString("giaSP");
            String ChiTietSP = resultSet.getString("ChiTietSP");
            String HangSX = resultSet.getString("HangSX");
            int SLTK = resultSet.getInt("SLTK");
            boolean soluongSP = resultSet.getBoolean("soluongSP");

            System.out.println(" id : " + id  + " tenSP : " + tenSP + " giaSP : " + giaSP + " ChiTietSP : " + ChiTietSP + " HangSX : " + HangSX + " SLTK : " + SLTK + (soluongSP ? " con hang " : "het hang"));

        }
    }

    private static void queryDataToDatabase(Connection conn) throws SQLException {
        String query = "select * from san_pham";

        Statement statement = null;
        statement = conn.createStatement();

        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String tenSP = resultSet.getString("tenSP");
            String giaSP = resultSet.getString("giaSP");
            String ChiTietSP = resultSet.getString("ChiTietSP");
            String HangSX = resultSet.getString("HangSX");
            int SLTK = resultSet.getInt("SLTK");
            boolean soluongSP = resultSet.getBoolean("soluongSP");

            System.out.println(" id : " + id  + " tenSP : " + tenSP + " giaSP : " + giaSP + " ChiTietSP : " + ChiTietSP + " HangSX : " + HangSX + " SLTK : " + SLTK + (soluongSP ? " con hang " : "het hang"));

        }
    }

    private static void deleteDataToDatabase(Connection conn) throws SQLException {
        String query = "delete from san_pham where id = 3";

        Statement statement = null;
        statement = conn.createStatement();

        int row = statement.executeUpdate(query);
        if (row != 0){
            System.out.println("xoa thanh cong " + row);
        }
        conn.close();
    }

    private static void updateDataToDatabase(Connection conn) throws SQLException {
        String query = "update san_pham set giaSP =  '600$', SLTK = 6000 where id = 3";

        Statement statement = null;
        statement = conn.createStatement();

        int row = statement.executeUpdate(query);
        if (row != 0){
            System.out.println("cap nhat thanh cong" + row);
        }
        conn.close();
    }

    private static void addDataToDatabase(Connection connection) throws SQLException {
        String query = "insert into san_pham (id, tenSP, giaSP, ChiTietSP, HangSX , SLTK , soluongSP) " +
                "value (3, 'apple','400$','dep','apple',4000,1)";

        Statement statement = null;
        statement = connection.createStatement();

        int row = statement.executeUpdate(query);
        if (row != 0) {
            System.out.println("Thêm thành công " + row);
        }
        connection.close();
    }
}

