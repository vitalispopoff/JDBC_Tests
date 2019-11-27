import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Queries {

    private final String URL = "jdbc:postgresql://localhost/postgres";
    private final String USR = "postgres";
    private final String PSS = "****";

    public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USR, PSS);
            System.out.println("Connected to the server. Yay!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public static void main(String[] args) {
        Queries query = new Queries();
        query.connect();
    }
}
