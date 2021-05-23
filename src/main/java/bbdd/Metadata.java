package bbdd;

import java.sql.*;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

public class Metadata {
    private DatabaseMetaData databaseMetaData;

    public Metadata(){

    }

    public void infoBBDD(){
        Connection conexion = null;

        try{
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/erpvehiculos", "root", "");
            databaseMetaData = conexion.getMetaData(); //Traer info de base de datos

            //Mostrando informacion de la base de datos
            System.out.println("Gestor de base de datos: " + databaseMetaData.getDatabaseProductName());
            System.out.println("Nombre del driver: " + databaseMetaData.getDriverName());
            System.out.println("Version del driver: " + databaseMetaData.getDriverVersion());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void infoTablas(){
        Connection conexion = null;
        ResultSet rs = null;

        try{
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/erpvehiculos", "root", "");
            databaseMetaData = conexion.getMetaData();

            //Lista de tablas
            System.out.println("Lista de tablas");
            rs = databaseMetaData.getTables(null, null, null, null);

            while(rs.next()){
                System.out.println("--------" + rs.getString("TABLE_NAME") + "---------");

            }

            System.out.println("Campos de clientes:\n");
            rs = databaseMetaData.getColumns(null, null, "cliente", null);
            while(rs.next()){
                System.out.println(rs.getString("COLUMN_NAME"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
