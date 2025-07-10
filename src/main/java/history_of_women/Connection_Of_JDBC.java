package history_of_women;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Connection_Of_JDBC {

	private static final String URL = "jdbc:postgresql://localhost:5432/Legacy_Of_Women";
    private static final String USER = "postgres";
    private static final String PASS = "unnatimd22";  // Update your actual password here

	
    public static void main(String[] args) {
        createTable("Legacy_Of_Women","women_in_history");
    }
    static void createTable(String dbName, String tableName) {
        try {
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + dbName, USER, PASS);

            String createTableQuery = "CREATE TABLE IF NOT EXISTS " + tableName + " ("
                    + "    id SERIAL PRIMARY KEY,"
                    + "    name TEXT NOT NULL,"
                    + "    birth_year INT,"
                    + "    country TEXT,"
                    + "    contribution TEXT NOT NULL"
                    + ");";
            Statement stmt = con.createStatement();
            stmt.execute(createTableQuery);
            System.out.println("✅ Table '" + tableName + "' is created in database '" + dbName + "'.");

            stmt.close();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


