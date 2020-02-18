import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Kunde {

    private int IDzaehler=0;

    

    public Kunde() {
        
    }

    public void kundecreate(String name, int postleizahl, String land)
    {

        int ID = this.IDzaehler;
        this.IDzaehler++;

        // SQLite connection string
      String url = "jdbc:sqlite:shop.db";
      
      // SQL statement for creating a new table
      String sql = "INSERT INTO Kunden(id,name,postleizahl,land) VALUES (" + ID + ", '" + name + "', " + postleizahl +", '"+land+"');";

      
      try (Connection conn = DriverManager.getConnection(url);
              Statement stmt = conn.createStatement()) {
          
         
          stmt.execute(sql);
          System.out.println("Neuer Kunde erstellt");
          System.out.println();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
      }

    }

    public void kundelist()
    {
        String url = "jdbc:sqlite:shop.db";
        Connection conn = null;
        Statement stmt = null;
        
        try {
          conn = DriverManager.getConnection(url);
    
          stmt = conn.createStatement();
          ResultSet rs = stmt.executeQuery( "SELECT * FROM Kunden;" );
          
          System.out.println("------Alle Kunden werden aufgelistet------");

          while ( rs.next() ) {
             int id = rs.getInt("ID");
             String  name = rs.getString("name");
             int postleizahl= rs.getInt("postleizahl");
             String land = rs.getString("land");
            
             System.out.print( "|ID = " + id );
             System.out.print( "|Name = " + name );
             System.out.print( "|Postleizahl = " + postleizahl );
             System.out.print( "|Land = " + land );
             System.out.println("|");
          }
          System.out.println("------------------------------------------");
          rs.close();
          stmt.close();
          conn.close();
        }
    
    
        catch (SQLException e) {
          System.out.println(e.getMessage());
        }
        

    }
  


    



}