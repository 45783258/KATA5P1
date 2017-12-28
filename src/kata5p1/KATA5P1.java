package kata5p1;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class KATA5P1 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException{
        Class.forName("org.sqlite.JDBC");
        Connection connection = DriverManager.getConnection("jdbc:sqlite:"
        + "C:\\Users\\DaniCerv\\Downloads\\SQLiteDatabaseBrowserPortable\\Data\\KATA5.db");
        Statement statement = (Statement) connection.createStatement();
        String query="SELECT * FROM PEOPLE;";
        ResultSet rs = statement.executeQuery(query);
        while(rs.next()){
             System.out.println("ID= " + rs.getInt("ID"));
             System.out.println("NAME= " + rs.getString("NAME"));
        }
    }
        
}
