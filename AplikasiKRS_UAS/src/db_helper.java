import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class db_helper {
    private static final String URL = "jdbc:mysql://localhost:3306/db_uaspbo_krs";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Koneksi gagal: " + e.getMessage());
        }
        return conn;
    }
}
