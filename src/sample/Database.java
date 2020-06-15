package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database {


    public Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:C://sqlite/db/gra.db";
        Connection conn = null;
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS user (\n"
                + "	id integer PRIMARY KEY,\n"
                + "	name text NOT NULL,\n"
                + "	score integer NOT NULL\n"
                + ");";

        try {
            conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            System.out.println("Connected to Database");
            // create a new table
            stmt.execute(sql);
            //stmt.execute("insert into user (name) values ('kot')");
            //stmt.execute("insert into user (name) values ('ryba')");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            //  return null;
        }
        return conn;
    }

    public void insertName(String name, int score) {
        String sql = "insert into user (name,score) values ('" + name + "','" + score + "')";

        try (Connection conn = this.connect();
             Statement pstmt = conn.createStatement()) {
            // pstmt.setString(1, name);
            pstmt.execute(sql);
            System.out.println("Inserted");
            ResultSet rs = pstmt.executeQuery("select * from user");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " " + rs.getString("name") + " " + rs.getString("score"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public ObservableList select() {

        try (Connection conn = this.connect();
             Statement pstmt = conn.createStatement()) {
            List user = new ArrayList();
            String name;
            int score;
            int id;
            ResultSet rs = pstmt.executeQuery("select * from user order by score DESC");      //wyswietlenie indeksu i imienia
            while (rs.next()) {
                id = rs.getInt("id");
                name = rs.getString("name");
                score = rs.getInt("score");
                user.add(new Controller(name,score));
            }

            ObservableList data = FXCollections.observableList(user);
            //System.out.println(data);
            return data;


        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
        return null;
    }
}
