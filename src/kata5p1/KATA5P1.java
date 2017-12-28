package kata5p1;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class KATA5P1 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException{
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
        query = "CREATE TABLE IF NOT EXISTS MAIL "
        + "('Id' INTEGER PRIMARY KEY AUTOINCREMENT , 'Mail' TEXT NOT NULL);";
        statement.execute(query);
        
        FileReader fl=null;
        BufferedReader bf=null;
        String fileName ="C:\\Users\\DaniCerv\\Desktop"
         + "\\Ficheros para la práctica en laboratorio 5 -20171227\\emails.txt";
        
        try{
            fl=new FileReader(fileName);
            bf= new BufferedReader(fl);
            String mail;
            while((mail=bf.readLine())!=null){
                if(!mail.contains("@")){
                    continue;
                }
                query =	"INSERT	INTO	MAIL	(Mail)	VALUES	('"+ mail +"');”";
                statement.execute(query);
            }
        }catch(IOException e){
                    e.printStackTrace();
        }
        
        query = "SELECT COUNT(*) FROM MAIL";
        rs=statement.executeQuery(query);
        System.out.println("Número de registros de la tabla MAIL: " + rs.getInt(1));
        
    }    
}
