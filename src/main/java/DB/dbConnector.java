package DB;

import java.sql.*;
import java.util.Objects;
import java.util.Scanner;

public class dbConnector {

    private static final String URL = "jdbc:sqlite:C:/Users/LADIEKEN/OneDrive - BTC AG/Dokumente/Bootcamp/Datenbanken/Sqlite/Bootcamp2024.db";

    //Methode zum Verbindungsaufbau zur Datenbank
    public static Connection connect() {
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(URL);
            System.out.println("Verbindung zur SQLite-Datenbank hergestellt.");
        } catch (SQLException e) {
            System.out.println("Verbindung zur SQLite-Datenbank fehlgeschlagen.");
            e.printStackTrace();
        }
        return conn;
    }

    // Methode zum Erstellen einer Tabelle User in der Datenbank, falls nicht bereits vorhanden
    public static void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS User (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "username TEXT NOT NULL, " +
                "password TEXT NOT NULL);";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabelle 'User' wurde erfolgreich erstellt.");
        } catch (SQLException e) {
            System.out.println("Fehler beim Erstellen der Tabelle 'User'.");
            e.printStackTrace();
        }
    }

    //Methode zum Anlegen eines Users in die Datenbank
    public static void insertUser(String username, String password) {
        String sql = "INSERT INTO User(username, password) VALUES(?, ?)";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.executeUpdate();
            System.out.println("User erfolgreich eingefügt.");
        } catch (SQLException e) {
            System.out.println("Fehler beim Einfügen des Users.");
            e.printStackTrace();
        }
    }

    //Methode zur Wiedergaben aller exestierender User
    public static void selectAllUsers() {
        String sql = "SELECT * FROM User";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + "\t" +
                        "Username: " + rs.getString("username") + "\t" +
                        "Password: " + rs.getString("password"));
            }
        } catch (SQLException e) {
            System.out.println("Fehler beim Abrufen der Users.");
            e.printStackTrace();
        }
    }

    //TODO: Statement fix
    public static String userExist(String username) {
        String sql = "SELECT username From User WHERE EXIST (SELECT username From User WHERE username = \"" + username + "\")";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            return rs.getString("username");
        } catch (SQLException e) {
            System.out.println("Fehler beim Abrufen des Users.");
            e.printStackTrace();
        }
        return null;
    }

    public static String getPasswordFromDB(String username) {
        String sql = "SELECT password From User WHERE username = \"" + username + "\"";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            return rs.getString("password");
        } catch (SQLException e) {
            System.out.println("Fehler beim Abrufen des Users.");
            e.printStackTrace();
        }
        return null;
    }


    public static void main(String[] args) {
        connect();
        //createTable();
        //insertUser("User1", "geheim");
        //selectAllUsers();

        /*
        Scanner sc = new Scanner(System.in);
        System.out.println("Bitte gebe deinen Usernamen ein:");
        String username = sc.nextLine();

        System.out.println("Bitte gebe dein Passwort ein:");
        String password = sc.nextLine();

        insertUser(username, password);

         */

        Scanner sc = new Scanner(System.in);
        System.out.println("Bitte gebe deinen Usernamen ein:");
        String username = sc.nextLine();

        if(Objects.equals(username, userExist(username))) {
            System.out.println("Bitte gebe dein Passwort ein:");
            String password = sc.nextLine();

            if(Objects.equals(password, getPasswordFromDB(username))) {
                System.out.println(username + " wurde erfolgreich eingeloggt!");
            } else {
                System.out.println("Login fehlgeschlagen!");
            }
        } else {
            System.out.println("Username existiert nicht!");
        }



    }
}

