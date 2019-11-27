package _out;

import java.sql.*;

public class DatabaseAppNSFW {

    private static String JDBC_URL = "jdbc:postgresql://localhost:5432/postgres";
    private static String DATABASE_USER = "postgres";
    private static String DATABASE_PASS = "****";

    private static Connection connection;
    private static PreparedStatement statement;
    private static String requestData;

    public static void establishConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(JDBC_URL, DATABASE_PASS, DATABASE_PASS);
        Statement statement =connection.createStatement();
    }

    public static void terminateConnection() throws SQLException {
        statement.close();
        connection.close();
    }

    public static String request_1() throws SQLException, ClassNotFoundException {
        establishConnection();
        ResultSet query_01 = statement.executeQuery("SELECT tytul FROM film WHERE premiera = 2018;");
        int i = 0;
        StringBuilder result = new StringBuilder();
        while (query_01.next()) {
            i++;
            result
                    .append("tytuł: ").append(query_01.getString("tytul")).append(", \t")
//                    .append("gatunek: ").append(query_01.getString("gatunek")).append(", \t")
//                    .append("produkcja: ").append(query_01.getString("produkcja"))
                    .append(";\n");
        }
        terminateConnection();

        System.out.println(result.toString());
                return result.toString();
    }
}
