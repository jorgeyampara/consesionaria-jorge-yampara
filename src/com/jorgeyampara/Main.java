package com.jorgeyampara;

import com.jorgeyampara.dao.ClienteDao;
import com.jorgeyampara.dao.CocheDao;
import com.jorgeyampara.model.Cliente;
import com.jorgeyampara.model.Coche;
import com.jorgeyampara.model.Revision;
import com.jorgeyampara.util.ConectorBD;

import java.sql.Connection;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Connection connection = ConectorBD.getConnection();
        //crear cliente
        Cliente cliente = new Cliente("444","jose ortega","cochabamba", "san martin",454846);
        ClienteDao clienteDao = new ClienteDao();
        clienteDao.addCliente(cliente);
        //read
        List<Cliente> clientes = clienteDao.getAllClientes();
        for (int i = 0; i < clientes.size();i++){
            Cliente cliente1 = clientes.get(i);

            System.out.println(cliente);
        }
        //update
        Cliente sara = new Cliente("443","sara ortega","cochabamba", "san martin",454846);
        clienteDao.updateCliente(cliente);
        //delete
        clienteDao.deleteCliente("443");

        // crear coche
        Coche coche = new Coche("cfz 344", "nissan","xterra", "rojo",2344.54,cliente);
        CocheDao cocheDao = new CocheDao();
        cocheDao.addCoche(coche);
        //read coche
        List<Coche> coches= CocheDao.getAllCoches();
        for (int i = 0; i < coches.size(); i++) {
            Coche coche1 = coches.get(i);
            System.out.println(coche);
        }
        //update coche
        Coche peta = new Coche("cfz 356", "toyota","peta", "blanco",225,cliente);
        cocheDao.updateCoche(coche);
        //delete coche
        cocheDao.deleteCoche("cfz 344");
    }
}
