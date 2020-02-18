import java.sql.*;

public class sqlbuilder{

    public sqlbuilder(){

    }   

    public void inputbuilder(String Tablename)
    {

        String url = "jdbc:sqlite:shop.db";

        String sql = "INSERT INTO"+ Tablename +"("+ ")";

        try (Connection conn = DriverManager.getConnection(url);
              Statement stmt = conn.createStatement()) {
         
          stmt.execute(sql);
      } catch (SQLException e) {
          System.out.println(e.getMessage());
      }

    }
}