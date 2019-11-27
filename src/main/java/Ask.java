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

    public static void rebuildTables(Queries query) {
        try {
            int generateTables = query.getStatement().executeUpdate(new StringBuilder()
                    .append("CREATE TABLE klient (\n")
                    .append(" idk   SERIAL  PRIMARY KEY  NOT NULL,\n")
                    .append(" login  TEXT NOT NULL,\n")
                    .append(" haslo  TEXT NOT NULL,\n")
                    .append(" imie  TEXT,\n")
                    .append(" nazwisko TEXT,\n")
                    .append(" email  TEXT,\n")
                    .append(" telefon  TEXT\n")
                    .append(" );\n")

                    .append("CREATE TABLE film (\n")
                    .append(" idf   SERIAL  PRIMARY KEY  NOT NULL,\n")
                    .append(" tytul  TEXT NOT NULL,\n")
                    .append(" gatunek  TEXT,\n")
                    .append(" produkcja TEXT,\n")
                    .append(" premiera INT  NOT NUll,\n")
                    .append(" rezyseria TEXT,\n")
                    .append(" czas  INT,\n")
                    .append(" wiek  INT\n")
                    .append(" );\n")

                    .append("CREATE TABLE sala (\n")
                    .append(" idsali  SERIAL  PRIMARY KEY  NOT NULL,\n")
                    .append(" nazwa TEXT,\n")
                    .append(" klimatyzacja boolean\n")
                    .append(" );\n")

                    .append("CREATE TABLE seans (\n")
                    .append(" idse SERIAL  PRIMARY KEY  NOT NULL,\n")
                    .append(" idsali INT REFERENCES sala (idsali),\n")
                    .append(" idf  INT REFERENCES film (idf),\n")
                    .append(" jezyk TEXT,\n")
                    .append(" wersja TEXT,\n")
                    .append(" termin TEXT,\n")
                    .append(" godzina TEXT\n")
                    .append(" );\n")

                    .append("CREATE TABLE miejsce (\n")
                    .append(" idm  SERIAL PRIMARY KEY  NOT NULL,\n")
                    .append(" idsali INT  REFERENCES sala(idsali) NOT NULL,\n")
                    .append(" miejsce INT  NOT NULL,\n")
                    .append(" rzad INT  NOT NULL\n")
                    .append(" );\n")

                    .append("CREATE TABLE zamowienie (\n")
                    .append(" idz  SERIAL PRIMARY KEY  NOT NULL,\n")
                    .append(" idk  INT REFERENCES klient(idk) NOT NULL,\n")
                    .append(" idse INT REFERENCES seans(idse) NOT NULL,\n")
                    .append(" status TEXT\n")
                    .append(");\n")

                    .append("CREATE TABLE bilet (\n")
                    .append(" idb  SERIAL PRIMARY KEY  NOT NULL,\n")
                    .append(" idz  INT  REFERENCES zamowienie(idz) NOT NULL,\n")
                    .append(" idm  INT  REFERENCES miejsce(idm) NOT NULL,\n")
                    .append(" ulgowy boolean\n")
                    .append(");\n")

                    .toString());
            System.out.println("Tables are in place again");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void repopulateTables(Queries query){
        try {
            boolean resultFlag = query.getStatement().execute(new StringBuilder()

                    .append("INSERT INTO klient VALUES\n")
                    .append(" (1, 'janusz69', 'legia',    'janusz',  'zygi', 'janusz69@onet.pl',  '986'),\n")
                    .append(" (2, 'kocica14', 'lowciambożydarka', 'marzena',  'noga', 'kocica14@pudelek.pl', ''),\n")
                    .append(" (3, 'łysy',  'hcwdp',   'bożydar', 'zygi', 'legia1916@legia.pl',  '1312')\n")
                    .append(" ;\n")
                    .append(" \n")

                    .append("INSERT INTO film VALUES\n")
                    .append(" (1, 'Deadpool2', 'action', 'usa', 2018, '', 113, 18),\n")
                    .append(" (2, 'Venom',  'thriller', 'usa', 2018, '', 127, 18),\n")
                    .append(" (3, 'Watchmen',  'drama', 'usa', 2007, '', 154, 18);\n")
                    .append("\n")
                    .append("\n")

                    .append("INSERT INTO sala VALUES\n")
                    .append(" (1, 'mała', true),\n")
                    .append(" (2, 'tycia', true);\n")
                    .append(" \n")

                    .append("INSERT INTO seans VALUES\n")
                    .append(" (1, 1, 1, 'angielski','2d','11.10','12:00'),\n")
                    .append(" (2, 2, 3, 'angielski','2d','11.10','12:00'),\n")
                    .append(" (3, 1, 2, 'angielski','2d','11.10','15:00'),\n")
                    .append(" (4, 2, 3, 'angielski','2d','11.10','15:00'),\n")
                    .append(" (5, 1, 2, 'angielski','2d','11.10','18:00'),\n")
                    .append(" (6, 2, 1, 'angielski','2d','11.10','18:00');\n")
                    .append("\n")

                    .append("INSERT INTO miejsce VALUES\n")
                    .append(" (1, 1, 1, 1),\n")
                    .append(" (2, 1, 2, 1),\n")
                    .append(" (3, 1, 3, 1),\n")
                    .append(" (4, 1, 1, 2),\n")
                    .append(" (5, 1, 2, 2),\n")
                    .append(" (6, 1, 3, 2),\n")
                    .append(" (7, 2, 1, 1),\n")
                    .append(" (8, 2, 2, 1),\n")
                    .append(" (9, 2, 3, 1);\n")
                    .append(" \n")

                    .append("INSERT INTO zamowienie VALUES\n")
                    .append(" (1, 1, 2, 'niezrealizowane'),\n")
                    .append(" (2, 2, 1, 'zrealizowane'),\n")
                    .append(" (3, 2, 2, 'zrealizowane'),\n")
                    .append(" (4, 2, 6, 'niezrealizowane'),\n")
                    .append(" (5, 3, 1, 'zrealizowane')\n")
                    .append(" ;\n")
                    .append(" \n")

                    .append("INSERT INTO bilet VALUES\n")
                    .append(" (1, 1, 2),\n")
                    .append(" (2, 2, 4),\n")
                    .append(" (3, 3, 5),\n")
                    .append(" (4, 4, 2);")
                    .toString());

            System.out.println("The tables've been repopulated");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
