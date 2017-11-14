/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidade.Cliente;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author pc05
 */

    
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class ClienteDAO {

    Cliente cliente;

    public boolean salvar(Cliente cliente) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            //executeupdate = insert,update, delete
            //query = select

            if (cliente.getId()== 0) {

                String sql = "INSERT INTO cliente VALUES ("
                        + "DEFAULT," + "'" + cliente.getNome() + "',"
                        + "'" + cliente.getSobrenome() + "',"
                        + "'" + cliente.getCfp() + "',"
                        + "'" + cliente.getRua() + "',"
                        + "'" + cliente.getNumeroRua() + "'"
                        + ")";
                int resultado = st.executeUpdate(sql);
            } else {
                String sql = "UPDATE cidade set nome='" + cliente.getNome()
                        + "', sobrenome ='" + cliente.getSobrenome()
                        + "', cpf ='" + cliente.getCfp()
                        + "', rua ='" + cliente.getRua()
                        + "', numeroRua ='" + cliente.getNumeroRua()
                        + "' where id =" + cliente.getId();

                int resultado = st.executeUpdate(sql);

            }
            return true;
        } catch (Exception e) {

            System.out.println("Erro salvar Cliente = " + e);
        }
        return false;
    }

    public ArrayList<Cliente> consultarCliente(Cliente cliente) {
        this.cliente = cliente;
        ArrayList<Cliente> clienteArray = new ArrayList<>();

     
            try {
                Statement st = ConexaoBD.getInstance().getConnection().createStatement();
                String sql = "select * from  cliente";
                       
                ResultSet resultado = st.executeQuery(sql);
                
                while (resultado.next()) {
                    cliente = new Cliente();
                    cliente.setId(resultado.getInt("id"));
                    cliente.setNome(resultado.getString("nome"));
                    cliente.setSobrenome(resultado.getString("sobrenome"));
                    cliente.setCfp(resultado.getString("cpf"));
                    cliente.setRua(resultado.getString("rua"));
                    cliente.setNumeroRua(resultado.getInt("numeroRua"));
                    clienteArray.add(cliente);
                }
            } catch (Exception e) {
                System.out.println("Erro ao consultar clientes " + e);
            }
        

//            try {
//                Statement st = ConexaoBD.getInstance().getConnection().createStatement();
//                String sql = "select * from  cidade "
//                        + "where  descricao ilike '" + cliente.getNome()+ "%' order by id";
//                ResultSet resultado = st.executeQuery(sql);
//                while (resultado.next()) {
//                    cliente.setId(resultado.getInt("id"));
//                    cliente.setNome(resultado.getString("nome"));
//                    cliente.setSobrenome(resultado.getString("sobrenome"));
//                    cliente.setCfp(resultado.getString("cpf"));
//                    cliente.setRua(resultado.getString("rua"));
//                    cliente.setNumeroRua(resultado.getInt("numeroRua"));
//                    clienteArray.add(cliente);
//                }
//            } catch (Exception e) {
//                System.out.println("Erro ao consultar cidades " + e);
////                System.out.println("Erro ao consultar cidades " + e);
//            }

        
        return clienteArray;

    }


}

    

