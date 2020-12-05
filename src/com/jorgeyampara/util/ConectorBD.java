package com.jorgeyampara.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConectorBD {

    private static Connection connection= null;
    public static  Connection getConnection(){
        if (connection!=null){
            return connection;
        }
        else {

            try {
                Properties properties = new Properties();
                properties.load(new FileInputStream("bd.properties"));
                String driver = properties.getProperty("driver");
                String url = properties.getProperty("url");
                String usuario = properties.getProperty("usuario");
                String contraseña = properties.getProperty("contraseña");

                Class.forName(driver);

                connection = DriverManager.getConnection(url,usuario,contraseña);
            } catch (IOException e) {
                System.out.println("Error en el archivo de propiedades"+ e.getMessage());
            } catch (ClassNotFoundException e) {
                System.out.println("error al cargar driver"+e.getMessage());
            } catch (SQLException throwables) {
                System.out.println("error en la coneccion en la base de datos"+ throwables.getMessage());

            }
        }
        return connection;

    }
}
