package com.jorgeyampara.dao;

import com.jorgeyampara.model.Coche;
import com.jorgeyampara.util.ConectorBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CocheDao {

    private static Connection connection;;
    public CocheDao(){
        connection = ConectorBD.getConnection();
    }
    public void addCoche(Coche coche){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "insert INTO cliente (nif, nombre, ciuda,direccon, telefono,)values (?,?,?,?,?)");
            preparedStatement.setString(1,coche.getMatricula());
            preparedStatement.setString(2,coche.getMarca());
            preparedStatement.setString(3,coche.getModelo());
            preparedStatement.setString(4,coche.getColor());
            preparedStatement.setDouble(5,coche.getPrecio());
            preparedStatement.executeUpdate();
            System.out.println("coche creado"+ coche);
        } catch (SQLException e){
            System.out.println("error al crear coche"+ e.getMessage());
        }

    }
    public void updateCoche(Coche coche){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE cliente SET nif=?, nombre=?,ciudad=?,direccion=?,telefono=? WHERE nif=?");
            preparedStatement.setString(1,coche.getMatricula());
            preparedStatement.setString(2,coche.getMarca());
            preparedStatement.setString(3,coche.getModelo());
            preparedStatement.setString(4,coche.getColor());
            preparedStatement.setDouble(5,coche.getPrecio());
            preparedStatement.setString(6,coche.getMatricula());
            preparedStatement.executeUpdate();
            System.out.println("coche editado"+ coche);
        } catch (SQLException e){
            System.out.println("error al crear coche"+ e.getMessage());
        }

    }
    public void deleteCoche(String Matricula){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "DELETE FROM coche WHERE nif=?");
            preparedStatement.setString(1,Matricula);
            preparedStatement.executeUpdate();

            System.out.println("coche eliminado"+ Matricula);
        } catch (SQLException e){
            System.out.println("error al crear coche"+ e.getMessage());
        }

    }
    public static List<Coche> getAllCoches(){
        List<Coche> coches= new ArrayList<>();
        try {

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM coche");
            while (resultSet.next()){
                Coche coche = new Coche();
                coche.setMatricula(resultSet.getString("matricula"));
                coche.setMarca(resultSet.getString("marca"));
                coche.setModelo(resultSet.getString("modelo"));
                coche.setColor(resultSet.getString("color"));
                coche.setPrecio(resultSet.getDouble("precio"));

                coches.add(coche);

            }

        }catch (SQLException e){
            System.out.println("error al obtener los coches"+ e.getMessage());
        }return coches;
    }
}
