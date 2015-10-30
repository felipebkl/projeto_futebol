
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Banco.ConnectionFactory;
import Model.Cliente;
import Model.Conta;
import Model.Produto;

import Venda.Venda;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;




/**
 *
 * @author Ricardo
 */
public class VendaDaoBd implements VendaDao{
    
    private Connection conexao;
    private PreparedStatement comando;

    @Override
    public void inserir(Produto produto, Venda venda) {
        try{
            String sql = "INSERT INTO vendas (produto,total,cliente,qtd,dat) VALUES(?,?,?,?,?)";
            conectar(sql);
            comando = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            
            comando.setInt(1,produto.getCodigo());
            comando.setDouble(2,venda.getTotal());
            comando.setInt(3,venda.getCpf());
            comando.setInt(4,venda.getQtd());
            
           // java.util.Date data = venda.getData().getTime();
            
               
            Timestamp dataSql = new java.sql.Timestamp(venda.getData().getTime());
            
            comando.setTimestamp(5, dataSql);
            
            comando.executeUpdate();
            
             ResultSet resultado = comando.getGeneratedKeys();
            if(resultado.next())
                venda.setTotal(resultado.getDouble(3));
                
            fecharConexao();
            
        }
        catch(ClassNotFoundException e){
            System.out.println("Erro de classe: " + e.getMessage());
        }
        catch(SQLException e){
            System.out.println("Erro SQL: " + e.getMessage());
        }
    }
    
    
    @Override
    public void inserirID(int id) {
        try{
            String sql = "INSERT INTO idProdutos (idProd) VALUES(?)";
            conectar(sql);
            comando = conexao.prepareStatement(sql);
            
            comando.setInt(1,id);
            
            
            
            
            comando.executeUpdate();
            
            
                
            fecharConexao();
            
        }
        catch(ClassNotFoundException e){
            System.out.println("Erro de classe: " + e.getMessage());
        }
        catch(SQLException e){
            System.out.println("Erro SQL: " + e.getMessage());
        }
    }

    @Override
    public List<Venda> listaVendas() {
         
        List<Venda> vendas = new ArrayList<Venda>();
        try{
            String sql = "SELECT (vendas.id),(produtos.nome),produto,qtd,preco,total,(cliente.nome),cliente,dat FROM vendas,cliente,produtos WHERE cpf = cliente and codigo = produto;";
            conectar(sql);
            comando = conexao.prepareStatement(sql);
            
            
          
           
            Venda venda = null;
            
             ResultSet resultado = comando.executeQuery();
           while (resultado.next()) {
                                int id = resultado.getInt("id");
				int prod = resultado.getInt("produto");
                                int qtd = resultado.getInt("qtd");
				double total = resultado.getDouble("total");
                                int clienteCpf = resultado.getInt("cliente");
                                java.util.Date data = new Date(resultado.getTimestamp("dat").getTime());
                                
                                venda = new Venda(id,prod,qtd,total, data,clienteCpf);
                                
                               
                               vendas.add(venda);
                                
 
            }
           
           
              
            fecharConexao();
    }
       catch(ClassNotFoundException e){
         System.out.println("Erro: Classe não encontrada!");
       }
       catch(SQLException e){
         System.out.println("Erro: " + e.getMessage());
       }
        return vendas;
        
    }
    
    
    
    
    
    private void conectar(String sql) throws ClassNotFoundException, SQLException {
        conexao = ConnectionFactory.getConnection();
        comando = conexao.prepareStatement(sql);
    }

    private void fecharConexao() throws SQLException {
        comando.close();
        conexao.close();
    }
    
}
