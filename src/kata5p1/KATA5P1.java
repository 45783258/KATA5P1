package kata5p1;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class KATA5P1 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException{
        Class.forName("");
        Connection connection = DriverManager.getConnection(
                "http://127.0.0.1:5560/isqlplus/workspace.uix","system","orcl");
        Statement statement = (Statement) connection.createStatement();
        String query="SELECT * FROM HISTORICO_CAMBIOS;";
        ResultSet rs = statement.executeQuery(query);
        while(rs.next()){
             System.out.println("ID= " + rs.getInt("ID"));
             System.out.println("NAME= " + rs.getString("NAME"));
        }
        
        /**
         * Consultas a realizar:
         * Contar el número de registros de la tabla.
         * SELECT COUNT (*) FROM HISTORICO_CAMBIOS;
         * Contar el número de registros de una determinada DIVISA_DESDE y
         * DIVISA_A
         * SELECT COUNT(DIVISA_DESDE, DIVISA_A) FROM HISTORICO_CAMBIOS;
         * 
         * Listar todos	los cambios que	tenemos	desde una DIVISA_DESDE a 
         * una DIVISA_A.
         * Para ello se podría crear una auditoría para guardar los cambios
         * en la tabla a través de un trigger genérico.
         * 
         * Si fuese necesario se podría realiza alguna query que pudiese ser
         * necesaria para MoneyCalculator.
         * 
         */
        
    }    
}
