import java.sql.ResultSet;
import java.sql.SQLException;

public interface Ask {


    public static String question_01(Queries query) {
        StringBuilder result = new StringBuilder();
        try {
            ResultSet answer = query.getStatement().executeQuery("SELECT tytul FROM film WHERE premiera = 2018;");
            {
                int i = 0;
                while (answer.next()) {
                    i++;
                    result
                            .append("tytuł: ").append(answer.getString("tytul")).append(", \t")
//                    .append("gatunek: ").append(query_01.getString("gatunek")).append(", \t")
//                    .append("produkcja: ").append(query_01.getString("produkcja"))
                            .append(";\n");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    public static void dropTables(Queries query) {
        try {
            int deleteTables = query.getStatement().executeUpdate(new StringBuilder()
                    .append("DROP TABLE bilet;")
                    .append("DROP TABLE zamowienie;")
                    .append("DROP TABLE miejsce;")
                    .append("DROP TABLE seans;")
                    .append("DROP TABLE sala;")
                    .append("DROP TABLE film;")
                    .append("DROP TABLE klient;")
                    .toString());
            System.out.println("Tables have been dropped");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
