package com.jorgeyampara.dao;

import com.jorgeyampara.model.Cliente;
import com.jorgeyampara.util.ConectorBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDao {
    private Connection connection;
    public ClienteDao(){
        connection = ConectorBD.getConnection();
    }
    public void addCliente(Cliente cliente){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "insert INTO cliente (nif, nombre, ciuda,direccon, telefono,)values (?,?,?,?,?)");
            preparedStatement.setString(1,cliente.getNif());
            preparedStatement.setString(2,cliente.getNombre());
            preparedStatement.setString(3,cliente.getCiudad());
            preparedStatement.setString(4,cliente.getDireccion());
            preparedStatement.setInt(5,cliente.getTelefono());
            preparedStatement.executeUpdate();
            System.out.println("cliente creado"+ cliente);
        } catch (SQLException e){
            System.out.println("error al crear cliente"+ e.getMessage());
        }

    }
    public void updateCliente(Cliente cliente){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE cliente SET nif=?, nombre=?,ciudad=?,direccion=?,telefono=? WHERE nif=?");
            preparedStatement.setString(1,cliente.getNif());
            preparedStatement.setString(2,cliente.getNombre());
            preparedStatement.setString(3,cliente.getCiudad());
            preparedStatement.setString(4,cliente.getDireccion());
            preparedStatement.setInt(5,cliente.getTelefono());
            preparedStatement.setString(6,cliente.getNif());
            preparedStatement.executeUpdate();
            System.out.println("cliente editado"+ cliente);
        } catch (SQLException e){
            System.out.println("error al crear cliente"+ e.getMessage());
        }

    }
    public void deleteCliente(String nif){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "DELETE FROM cliente WHERE nif=?");
            preparedStatement.setString(1,nif);
            preparedStatement.executeUpdate();

            System.out.println("nif eliminado"+ nif);
        } catch (SQLException e){
            System.out.println("error al crear cliente"+ e.getMessage());
        }

    }
    public List<Cliente>getAllClientes(){
        List<Cliente> clientes= new ArrayList<>();
        try {

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM cliente");
            while (resultSet.next()){
                Cliente cliente = new Cliente();
                cliente.setNif(resultSet.getString("nif"));
                cliente.setNombre(resultSet.getString("nombre"));
                cliente.setCiudad(resultSet.getString("nciudad"));
                cliente.setDireccion(resultSet.getString("ndirecicion"));
                cliente.setTelefono(resultSet.getInt("telefono"));

                clientes.add(cliente);

            }

        }catch (SQLException e){
            System.out.println("error al obtener los clientes"+ e.getMessage());
        }return clientes;
    }

}
