package history_of_women;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {
    private static final String URL = "jdbc:postgresql://localhost:5432/Legacy_Of_Women";
    private static final String USER = "postgres";
    private static final String PASS = "unnatimd22";
    private static final String TABLE = "women_in_history";

    public static void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE + " ("
                   + "id SERIAL PRIMARY KEY, "
                   + "name TEXT NOT NULL, "
                   + "birth_year INT, "
                   + "country TEXT, "
                   + "contribution TEXT NOT NULL)";
        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             Statement st = con.createStatement()) {
            Class.forName("org.postgresql.Driver");
            st.execute(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void insert(Woman w) {
        String sql = "INSERT INTO " + TABLE + " (name, birth_year, country, contribution) VALUES (?, ?, ?, ?)";
        execute(sql, ps -> {
            ps.setString(1, w.getName());
            ps.setInt(2, w.getBirthYear());
            ps.setString(3, w.getCountry());
            ps.setString(4, w.getContribution());
        });
    }

    public static void update(Woman w) {
        String sql = "UPDATE " + TABLE + " SET name=?, birth_year=?, country=?, contribution=? WHERE id=?";
        execute(sql, ps -> {
            ps.setString(1, w.getName());
            ps.setInt(2, w.getBirthYear());
            ps.setString(3, w.getCountry());
            ps.setString(4, w.getContribution());
            ps.setInt(5, w.getId());
        });
    }

    public static void delete(int id) {
        String sql = "DELETE FROM " + TABLE + " WHERE id=?";
        execute(sql, ps -> ps.setInt(1, id));
    }

    public static List<Woman> fetchAll() {
        List<Woman> list = new ArrayList<>();
        String sql = "SELECT * FROM " + TABLE;
        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Woman w = new Woman(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("birth_year"),
                        rs.getString("country"),
                        rs.getString("contribution")
                );
                list.add(w);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    private static void execute(String sql, SQLConsumer<PreparedStatement> consumer) {
        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement ps = con.prepareStatement(sql)) {
            consumer.accept(ps);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
