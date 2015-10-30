/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Produto;
import Venda.Venda;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ricardo
 */
public interface VendaDao {
    public void inserir(Produto produto, Venda venda);
    public List<Venda> listaVendas();
    public void inserirID(int id);
   
}

