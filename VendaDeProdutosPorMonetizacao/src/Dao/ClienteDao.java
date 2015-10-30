/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Cliente;
import Model.Conta;
import java.util.List;

/**
 *
 * @author Ricard
 */
public interface ClienteDao {
     public void inserir(Cliente cliente);
     public Cliente visualizarConta(Conta conta);
     public void deletar(int cliente);
     public void atualizar(Cliente cliente);
     public void atualizarEmail(String email, String nEmail);
     public List<Cliente> atualizar(Cliente cliente, String email);
     public Cliente visualizar(Cliente cliente);
     public void remover(Cliente cliente);
     public Cliente buscarPorCpf(int cpf);
     public List<Cliente> listar();
}
