import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Ticket {
    private int TicketID;
    private int ID;

    public Ticket() {
    }

    public void generateTicketart(String Name, int anzahl, String Kategorie)
    {
        int TicketID = this.TicketID;
        this.TicketID++;

        // SQLite connection string
      String url = "jdbc:sqlite:shop.db";
      
      // SQL statement for creating a new table
      String sql = "INSERT INTO Ticketart(id,ticketname,anzahl,kategorie) VALUES (" + TicketID + ", '" + Name + "', " + anzahl +", '"+Kategorie+"');";

      
      try (Connection conn = DriverManager.getConnection(url);
              Statement stmt = conn.createStatement()) {
          // create a new table
         
          stmt.execute(sql);
          System.out.println("Neues Ticket erstellt");
          System.out.println();

      } catch (SQLException e) {
          System.out.println(e.getMessage());
      }

    }
    public void Ticketartshow(){
        String url = "jdbc:sqlite:shop.db";
        Connection conn = null;
        Statement stmt = null;
        
        try {
          conn = DriverManager.getConnection(url);
    
          stmt = conn.createStatement();
          ResultSet rs = stmt.executeQuery( "SELECT * FROM Ticketart;" );
          
          System.out.println("------Alle Tickets werden aufgelistet------");

          while ( rs.next() ) {
             int id = rs.getInt("id");
             String  name = rs.getString("ticketname");
             int anzahl= rs.getInt("anzahl");
             String kategorie = rs.getString("kategorie");
            
             System.out.print( "|ID = " + id );
             System.out.print( "|Name = " + name );
             System.out.print( "|Tickets verfügbar: = " + anzahl );
             System.out.print( "|Kategorie des Tickets: = " + kategorie );
             System.out.println("|");
          }
          System.out.println("------------------------------------------");
          rs.close();
          stmt.close();
          conn.close();
          System.out.println();
        }
    
    
        catch (SQLException e) {
          System.out.println(e.getMessage());
        }
        
    }

    public void Ticketbuy(){
        // SQLite connection string
        String url = "jdbc:sqlite:shop.db";
        System.out.println("Was für ein Ticket willst du kaufen?");
        Ticketartshow();
        Scanner s = new Scanner(System.in);
        System.out.println("ID des Ticktes angeben");
        int i= s.nextInt();
        System.out.println("Kundennummer eingeben");
        int j = s.nextInt();

      
      // SQL statement for creating a new table
      String sql = "INSERT INTO Ticket(ticketid,userid,ticketartid) VALUES (" + ID + ", " + j + ", " + i +" );";
      ID = this.ID+1;


      
      try (Connection conn = DriverManager.getConnection(url);
          Statement stmt = conn.createStatement()) {
          // create a new table
          stmt.execute(sql);
          System.out.println("Neues Ticket gekauft");
          System.out.println();

      } catch (SQLException e) {
          System.out.println(e.getMessage());
      }

    }

    public void Ticketshow() {

        String url = "jdbc:sqlite:shop.db";
        Connection conn = null;
        Statement stmt = null;
        
        try {
          conn = DriverManager.getConnection(url);
    
          stmt = conn.createStatement();
          ResultSet rs = stmt.executeQuery( "SELECT k.name,a.ticketname,a.kategorie FROM Kunden AS k INNER JOIN Ticket AS t ON t.userid=k.id INNER JOIN Ticketart a ON a.id=t.ticketartid;" );
          
          System.out.println("------Alle Tickets des Kundens werden aufgelistet------");

          while ( rs.next() ) {
  
             String  name = rs.getString("name");
             String  aname = rs.getString("ticketname");
             String land = rs.getString("kategorie");


            
             
             System.out.print( "|Kunde = " + name );
             System.out.print( "|Ticket = " + aname );
             System.out.print( "|Kategorie = " + land );


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