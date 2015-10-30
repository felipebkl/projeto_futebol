/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Banco.ConnectionFactory;
import Model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * 
 * @author Ricardo
 */
public class ProdutoDaoBd implements ProdutoDao{

    private Connection conexao;
    private PreparedStatement comando;
    
    @Override
    public void inserir(Produto produto) {
        try{
            String sql = "INSERT INTO produtos (nome, preco, codigo) VALUES(?,?,?)";
            conectar(sql);
            comando = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            
            comando.setString(1,produto.getNome());
            comando.setDouble(2,produto.getPreco());
            comando.setInt(3,produto.getCodigo());
            
            comando.executeUpdate();
            
             ResultSet resultado = comando.getGeneratedKeys();
            if(resultado.next())
                produto.setCodigo(resultado.getInt(1));
                
            fecharConexao();
            
        }
        catch(ClassNotFoundException e){
            System.out.println("Erro de classe: " + e.getMessage());
        }
        catch(SQLException e){
            System.out.println("Erro SQL: " + e.getMessage());
        }
    }
    public Produto buscarPorNome(String nome) {
        Produto produto = null;
        try {
            String sql = "SELECT * FROM produtos WHERE nome=?";
            conectar(sql);
            comando.setString(1, nome);
            ResultSet resultado = comando.executeQuery();
            if (resultado.next()) {
                produto = new Produto(resultado.getString("nome"),
                        resultado.getInt("codigo"),
                        resultado.getDouble("preco"));
            }
            fecharConexao();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDaoBd.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDaoBd.class.getName()).log(Level.SEVERE, null, ex);
        }
        return produto;
    }
    @Override
    public Produto buscarPorCodigo(int codigo) {
        Produto produto = null;
        try {
            String sql = "SELECT * FROM produtos WHERE codigo=?";
            conectar(sql);
            comando.setInt(1, codigo);
            ResultSet resultado = comando.executeQuery();
            if (resultado.next()) {
                produto = new Produto(resultado.getString("nome"),
                        resultado.getInt("codigo"),
                        resultado.getDouble("preco"));
            }
            fecharConexao();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDaoBd.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDaoBd.class.getName()).log(Level.SEVERE, null, ex);
        }
        return produto;
    }
    
    
    @Override
    public List<Produto> atualizar(double preco,Produto produto) {
         
        List<Produto> produtos = new ArrayList<Produto>();
         
        try {
            String sql = "SELECT nome,codigo,preco FROM produtos WHERE nome = ? ";
            conectar(sql);
            comando.setString(1, produto.getNome());
            ResultSet resultado = comando.executeQuery();
            
            while (resultado.next()) {
                produto = new Produto(resultado.getString("nome"),
                        resultado.getInt("codigo"),
                        resultado.getDouble("preco"));

                produtos.add(produto);
            
            }
            fecharConexao();

        } catch (ClassNotFoundException e) {
            System.out.println("Erro: Classe não encontrada!");
        } catch (SQLException e) {
            System.out.println("Erro: SQL invalido!");
        }
        try {

            String sql = "UPDATE produtos SET preco = ? WHERE codigo = ?";
            conectar(sql);
            comando = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            comando.setDouble(1, preco);
           comando.setInt(2, produto.getCodigo());

            comando.executeUpdate();

            ResultSet resultado = comando.getGeneratedKeys();
            if (resultado.next()) {
                produto.setNome(resultado.getString(1));
            }

            fecharConexao();

        } catch (ClassNotFoundException e) {
            System.out.println("Erro de classe: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Erro SQL: " + e.getMessage());
        }
        return produtos;
    }

    @Override
    public void visualizar(Produto produto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remover(Produto produto) {
         try{
           
           String sql00 = "DELETE FROM vendas WHERE vendas.produto = (SELECT codigo FROM produtos WHERE codigo = ?)";
           conectar(sql00);
           comando.setInt(1, produto.getCodigo());
           comando.executeUpdate();
           fecharConexao();
             
             
           String sql = "DELETE  FROM produtos WHERE codigo = ?";
           conectar(sql);
           comando.setInt(1,produto.getCodigo());
           comando.executeUpdate();
           fecharConexao();
           
       }
       catch(SQLException ex){
           
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
       } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProdutoDaoBd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
       private void conectar(String sql) throws ClassNotFoundException, SQLException {
        conexao = ConnectionFactory.getConnection();
        comando = conexao.prepareStatement(sql);
    }

    private void fecharConexao() throws SQLException {
        comando.close();
        conexao.close();
    }

    @Override
    public List<Produto> listarProduto() {
           
        
        List<Produto> produtos = new ArrayList<Produto>();
        
        try{
            String sql = "SELECT * FROM produtos";
            conectar(sql);
            comando = conexao.prepareStatement(sql);
            
            
          
           
            Produto produto = null;
            
             ResultSet resultado = comando.executeQuery();
           while (resultado.next()) {
                                int id = resultado.getInt("id");
				String nome = resultado.getString("nome");
				double preco = resultado.getDouble("preco");
                                int codigo = resultado.getInt("codigo");
                                
                                
                                produto = new Produto(nome,codigo,preco);
                                
                              
                                
                                produtos.add(produto);
                               
                                
 
            }
           
           
              
            fecharConexao();
            
    }
            catch(ClassNotFoundException e){
                System.out.println("Erro: Classe não encontrada!");
            }
            catch(SQLException e){
                System.out.println("Erro: " + e.getMessage());
            }
        return produtos;  
    }
    
}
