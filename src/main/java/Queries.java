import java.sql.*;

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

    public Statement makeStatement(Connection conn) {
        Statement statement;
        try {
            statement = conn.createStatement();
            return statement;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void closeStatement(Statement statement){
        try {
            statement.close();
            System.out.println("statement successfully closed");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void terminateConnection(Connection conn){
        try {
            conn.close();
            System.out.println("\"Zed\'s dead\"");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Queries query = new Queries();
        query.connect();
    }
}
