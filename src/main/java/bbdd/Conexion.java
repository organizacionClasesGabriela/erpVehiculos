package bbdd;

import java.sql.*;

public class Conexion {
    //Conexion Local
    public static Connection conectar(){
        try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/erpvehiculos", "root", "");
            return cn;
        }catch(SQLException e){
            System.err.println("Error en la conexión local " + e);
        }

        return (null);
    }
}
