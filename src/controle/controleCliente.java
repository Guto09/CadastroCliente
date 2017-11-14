/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.ClienteDAO;
import entidade.Cliente;
import java.util.ArrayList;
import telas.cadastroCliente;

/**
 *
 * @author pc05
 */
public class controleCliente {

    Cliente cliente;

//    public controleCliente(Cliente cliente) {
//        this.cliente = cliente;
//    }
    public String salvar(Cliente cliente) {
        this.cliente = cliente;
        String mensagem = "Erro ao salvar cliente\n";
        if (cliente.getNome().length() < 3 || cliente.getNome().length() > 150) {
            mensagem = mensagem + "Nome do cliente deve ter no mínimo 3 caracteres \n";
        }
        if (cliente.getSobrenome().length() < 3 || cliente.getSobrenome().length() > 150) {
            mensagem = mensagem + "Sobrenome do cliente deve ter no mínimo 3 caracteres \n";
        }
        if (cliente.getCfp().length() != 14) {
            mensagem = mensagem + "CPF inválido \n";
        }
        if (cliente.getRua().length() < 3 || cliente.getRua().length() > 150) {
            mensagem = mensagem + "Rua do cliente deve ter no mínimo 3 caracteres \n";
        }
        if (cliente.getNumeroRua() < 1 && cliente.getNumeroRua() > 150) {
            mensagem = mensagem + "Número da casa inválida \n";
        }
        if (mensagem.length() > 23) {
            return mensagem;
        } else {
            
            ClienteDAO clienteDAO = new ClienteDAO();
            boolean retorno = clienteDAO.salvar(cliente);
            if (retorno) {
                return "ok";
            }else{
                return "Erro ao salvar";
            }
            
        }

    }
    
    public ArrayList<Cliente> listar (Cliente cliente){
        ArrayList<Cliente> clienteArray = new ArrayList<>();
        ClienteDAO clienteDAO = new ClienteDAO();
        clienteArray = clienteDAO.consultarCliente(cliente);
        return clienteArray;
    }

}
