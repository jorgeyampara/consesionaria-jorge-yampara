package com.jorgeyampara.dao;

import com.jorgeyampara.model.Cliente;
import com.jorgeyampara.model.Revision;
import com.jorgeyampara.util.ConectorBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RevisionDao {
    private Connection connection;
    public RevisionDao(){
        connection = ConectorBD.getConnection();
    }
    public void addCliente(Revision revision){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "insert INTO cliente (nif, nombre, ciuda,direccon, telefono,)values (?,?,?,?,?)");
            preparedStatement.setString(1,revision.getCodigo());
            preparedStatement.setString(2,revision.getFiltro());
            preparedStatement.setString(3,revision.getAceite());
            preparedStatement.setString(4,revision.getFrenos());
            preparedStatement.executeUpdate();
            System.out.println("Revision creado"+ revision);
        } catch (SQLException e){
            System.out.println("error al crear cliente"+ e.getMessage());
        }

    }
    public void updateCliente(Revision revision){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE cliente SET nif=?, nombre=?,ciudad=?,direccion=?,telefono=? WHERE nif=?");
            preparedStatement.setString(1,revision.getCodigo());
            preparedStatement.setString(2,revision.getFiltro());
            preparedStatement.setString(3,revision.getAceite());
            preparedStatement.setString(4,revision.getFrenos());
            preparedStatement.executeUpdate();
            System.out.println("revision editado"+ revision);
        } catch (SQLException e){
            System.out.println("error al crear revision"+ e.getMessage());
        }

    }
    public void deleteCliente(String codigo){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "DELETE FROM revision WHERE nif=?");
            preparedStatement.setString(1,codigo);
            preparedStatement.executeUpdate();

            System.out.println("codigo eliminado"+ codigo);
        } catch (SQLException e){
            System.out.println("error al crear codigo"+ e.getMessage());
        }

    }
    public List<Revision> getAllClientes(){
        List<Revision> revisions= new ArrayList<>();
        try {

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM cliente");
            while (resultSet.next()){
                Revision revision = new Revision();
                revision.setCodigo(resultSet.getString("nif"));
                revision.setFiltro(resultSet.getString("nombre"));
                revision.setAceite(resultSet.getString("nciudad"));
                revision.setFrenos(resultSet.getString("ndirecicion"));

                revisions.add(revision);

            }

        }catch (SQLException e){
            System.out.println("error al obtener los clientes"+ e.getMessage());
        }return revisions;
    }
}
