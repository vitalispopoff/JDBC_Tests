import java.sql.*;

public class Queries {

    private final String URL = "jdbc:postgresql://localhost/postgres";
    private final String USR = "postgres";
    private final String PSS = "****";

    private Connection conn;
    private Statement statement;

    public void establishConnection() {
        this.conn = null;
        try {
            conn = DriverManager.getConnection(URL, USR, PSS);
            System.out.println("Connected to the server. Yay!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void makeStatement() {
        try {
            this.statement = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConn() {
        return conn;
    }

    public Statement getStatement() {
        return statement;
    }

    public void closeStatement(){
        try {
            statement.close();
            System.out.println("statement successfully closed");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void terminateConnection(){
        try {
            conn.close();
            System.out.println("\"Zed\'s dead\"");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

/*    public static void main(String[] args) {
        Queries query = new Queries();
        query.establishConnection();
    }*/
}
