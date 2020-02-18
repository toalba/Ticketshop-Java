import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Tablecreate {

    public Tablecreate() {
    }

    public void createNewTableKunden() {
        // SQLite connection string
        String url = "jdbc:sqlite:shop.db";
        
        // SQL statement for creating a new table
        String drop = "DROP TABLE IF EXISTS Kunden;";

        String sql = "CREATE TABLE IF NOT EXISTS Kunden (\n"
                + "    id integer PRIMARY KEY,\n"
                + "    name text NOT NULL,\n"
                + "    postleizahl integer NOT NULL,\n"
                + "    land text NOT NULL\n"
                + ");";
        
        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(drop);
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Failed insert");
        }
        System.out.println("Succsesfully created Tabelle Kunden");

    }

    public void createNewTableTicketsart() {
        // SQLite connection string
        String url = "jdbc:sqlite:shop.db";
        
        // SQL statement for creating a new table
        String drop = "DROP TABLE IF EXISTS Ticketart;";

        String sql = "CREATE TABLE IF NOT EXISTS Ticketart (\n"
                + "    id integer PRIMARY KEY,\n"
                + "    ticketname text NOT NULL,\n"
                + "    anzahl integer NOT NULL,\n"
                + "    kategorie text NOT NULL\n"
                + ");";
        
        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(drop);
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Failed insert");
        }
        System.out.println("Succsesfully created Tabelle Ticketart");

    }
    public void createNewTableTickets() {
        // SQLite connection string
        String url = "jdbc:sqlite:shop.db";
        
        // SQL statement for creating a new table
        String drop = "DROP TABLE IF EXISTS Ticket;";

        String sql = "CREATE TABLE IF NOT EXISTS Ticket (\n"
                + "    ticketid integer PRIMARY KEY,\n"
                + "    userid integer  NOT NULL,\n"
                + "    ticketartid integer NOT NULL\n"
                + ");";
        
        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            // create a new table
           // stmt.execute(drop);
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Failed insert");
        }
        System.out.println("Succsesfully created Tabelle Ticket");

    }



    public void createNewDatabase(String fileName) {
 
        String url = "jdbc:sqlite:" + fileName;
    
        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }
    
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        createNewTableKunden();
        createNewTableTickets();
        createNewTableTicketsart();
    }





    
}