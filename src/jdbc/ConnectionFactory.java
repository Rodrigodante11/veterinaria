package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
    //String de conexão
    private static final String URL="jdbc:mysql://localhost/veterinaria";
    private static final String USER="root";
    private static final String PASS="123456";
    
    public Connection getConnection(){
        
        try {
            Connection connection=DriverManager.getConnection(URL,USER,PASS);
            return connection;
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}