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
 * @author Ricardo
 */
public interface ContaDao {
    public void inserir(Conta conta);
    public List<Conta> atualizar(double valor, Conta conta);
    public void depositar(double valor, Conta conta);
    public Conta visualizar(Conta conta);
    public void remover(Conta conta);
    public Cliente buscarPorConta(int numero);
    public List<Conta> CarregarRepositorioContas();
    public List<Cliente> listar(int numero);
}