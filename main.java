package hw2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.*;
import java.util.Scanner;

public class main {
    private static Connection connection;
    private static Statement stmt;
    private static PreparedStatement pstmt;


    public static void main(String[] args) throws SQLException {

        try {
            connect();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            create("stupidStudents");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            insert("students", "Bob1", "30");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            delete("students", 6);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            update("students", 5, "75");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            select("students", "Bob1");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            fileReadAndUpdate();
        } catch (FileNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        try {
            select("students", "Bob1");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        disconnect();

    }

    public static void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:mainDB.db");
        stmt = connection.createStatement();
    }

    public static void disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void create(String name) throws SQLException {
            stmt.executeUpdate("CREATE TABLE " + name +
                    "(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "name TEXT," +
                    "score TEXT)");
    }

    public static void insert(String database, String nameStudent, String score) throws SQLException {
        stmt.executeUpdate("INSERT INTO "+ database +
                                " (name, score) VALUES ('" +
                                nameStudent + "', " + score + ")");
    }

    public static void delete(String database, int id) throws SQLException {
        stmt.executeUpdate("DELETE FROM "+ database +
                                " WHERE ID=" + id);
    }

    public static void select(String database, String name) throws SQLException {
        String sql = String.format("SELECT id, name, score FROM " + database +
                                    " where name = '%s'", name);

        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
              System.out.println(rs.getInt(1) + " " + rs.getString("name") + " " + rs.getString("score"));
        }
    }

    public static void update(String database, int id, String score) throws SQLException {
        stmt.executeUpdate("UPDATE " + database +
                            " SET score = " + score +
                            " WHERE id = " + id);
    }

    public static void fileReadAndUpdate() throws FileNotFoundException, SQLException {
        FileReader reader = new FileReader(new File("/Users/Oleg/data.txt"));
        Scanner scan = new Scanner(reader);
        while (scan.hasNextLine()) {
            String studentData = scan.nextLine();
            String[] data = studentData.split("  ");
            int id = Integer.parseInt(data[0]);
                    // чтобы parseInt работал, надо сохранять файл в кодировке UTF-8 без спецификации
            update("students", id, data[2]);
        }
    }
}