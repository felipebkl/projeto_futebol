/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Cliente;
import Model.Produto;
import java.util.List;

/**
 *
 * @author Ricardo
 */
public interface ProdutoDao {
    public void inserir(Produto produto);
    public List<Produto> atualizar(double preco,Produto produto);
    public void visualizar(Produto produto);
    public void remover(Produto produto);
    public Produto buscarPorNome(String nome);
    public Produto buscarPorCodigo(int codigo);
    public List<Produto> listarProduto();
}

