/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Banco.ConnectionFactory;
import Model.Cliente;
import Model.Conta;
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
 * @author Ricardo
 */
public class ClienteDaoBd implements ClienteDao{
    
    private Connection conexao;
    private PreparedStatement comando;
    
    private ContaDao ContaBD = new ContaDaoBd();

    @Override
    public void inserir(Cliente cliente) {
       try{
            String sql = "INSERT INTO cliente (nome,cpf,email,conta) VALUES(?,?,?,?)";
            conectar(sql);
            comando = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            
            comando.setString(1,cliente.getNome());
            comando.setInt(2,cliente.getCpf());
            comando.setString(3,cliente.getEmail());
            comando.setInt(4,cliente.getConta().getNumero());
            
            comando.executeUpdate();
            
             ResultSet resultado = comando.getGeneratedKeys();
            if(resultado.next())
                cliente.setNome(resultado.getString(1));
                
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
    public void deletar(int id) {
        try {
            String sql = "DELETE FROM cliente WHERE id=?";
            conectar(sql);
            comando.setInt(1, id);
            comando.executeUpdate();
            fecharConexao();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDaoBd.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDaoBd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
      @Override
    public void atualizar(Cliente pessoa) {
        try {
            String sql = "UPDATE cliente SET cpf=?, nome=?, email=?, conta=? WHERE id=?";
            conectar(sql);
            comando.setInt(1, pessoa.getCpf());
            comando.setString(2, pessoa.getNome());
            comando.setString(3, pessoa.getEmail());
            comando.setInt(4, pessoa.getConta().getNumero());
            comando.setInt(5, pessoa.getId());
            comando.executeUpdate();
            fecharConexao();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDaoBd.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDaoBd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Cliente> atualizar(Cliente cliente, String email) {
        List<Cliente> clientes = new ArrayList<Cliente>();
         
        try {
            String sql = "SELECT cpf,nome,email FROM cliente WHERE email = ? ";
            conectar(sql);
            comando.setString(1, cliente.getEmail());
            ResultSet resultado = comando.executeQuery();
            
            while (resultado.next()) {
                cliente = new Cliente(resultado.getInt("cpf"),
                        resultado.getString("nome"),
                        resultado.getString("email"));

                clientes.add(cliente);
            
            }
            fecharConexao();

        } catch (ClassNotFoundException e) {
            System.out.println("Erro: Classe não encontrada!");
        } catch (SQLException e) {
            System.out.println("Erro: SQL invalido!");
        } 
        
        try{
            String sql = "UPDATE cliente SET email = ? WHERE nome = ?";
            conectar(sql);
            comando = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            
            comando.setString(1,email);
            comando.setString(2,cliente.getNome());
            
            comando.executeUpdate();
            
             ResultSet resultado = comando.getGeneratedKeys();
            if(resultado.next())
                cliente.setEmail(resultado.getString(1));
                
            fecharConexao();
            
        }
        catch(ClassNotFoundException e){
            System.out.println("Erro de classe: " + e.getMessage());
        }
        catch(SQLException e){
            System.out.println("Erro SQL: " + e.getMessage());
        }
        return clientes;
    }

    @Override
    public Cliente visualizar(Cliente cliente) {
         try {
            String sql = "SELECT * FROM cliente WHERE cpf = ?";
            conectar(sql);
            comando = conexao.prepareStatement(sql);

            comando.setInt(1, cliente.getCpf());
            

            ResultSet resultado = comando.executeQuery();
            while (resultado.next()) {

                int id = resultado.getInt("id");
                int cpf = resultado.getInt("cpf");
                String email  = resultado.getString("email");
                String nome = resultado.getString("nome");
                
                cliente = new Cliente(cpf,nome,email);
                cliente.setId(id);
            }
            
            fecharConexao();

        } catch (ClassNotFoundException e) {
            System.out.println("Erro de classe: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Erro SQL: " + e.getMessage());
        }
         return cliente;
    }
    
    
    public Cliente visualizarConta(Conta conta) {
         Cliente cliente = new Cliente(); 
        try {
            String sql = "SELECT cliente.cpf,cliente.id,email,nome FROM cliente,conta WHERE  conta.numero = ?";
            conectar(sql);
            comando = conexao.prepareStatement(sql);
           
            comando.setInt(1, conta.getNumero());
            

            ResultSet resultado = comando.executeQuery();
            while (resultado.next()) {

                int id = resultado.getInt("id");
                int cpf = resultado.getInt("cpf");
                String email  = resultado.getString("email");
                String nome = resultado.getString("nome");
                
                cliente.setCpf(cpf);
                cliente.setEmail(email);
                cliente.setNome(nome);
                cliente.setId(id);
            }
            
            fecharConexao();

        } catch (ClassNotFoundException e) {
            System.out.println("Erro de classe: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Erro SQL: " + e.getMessage());
        }
         return cliente;
    }

    @Override
    public void remover(Cliente cliente) {
          
       
       try{
           String sql = "DELETE FROM vendas WHERE vendas.cliente = (SELECT cpf FROM cliente WHERE email = ?)";
           
           conectar(sql);
           comando.setString(1,cliente.getEmail());
           comando.executeUpdate();
           fecharConexao();
           
           String sql1 = "DELETE FROM cliente WHERE email = ?";
           conectar(sql1);
           comando.setString(1, cliente.getEmail());
           comando.executeUpdate();
           fecharConexao();
           
       }
       catch(SQLException ex){
           
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
       } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDaoBd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public Cliente buscarPorCpf(int cpf) {
        Cliente cliente = null;
        try {
            String sql = "SELECT * FROM cliente WHERE cpf=?";
            conectar(sql);
            comando.setInt(1, cpf);
            ResultSet resultado = comando.executeQuery();
            if (resultado.next()) {
                cliente = new Cliente(resultado.getInt("cpf"),
                        resultado.getString("nome"),
                        resultado.getString("email"));
            }
            fecharConexao();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDaoBd.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDaoBd.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cliente;
    }
    
 @Override
    public  List<Cliente> listar(){
         List<Cliente> clientes = new ArrayList<Cliente>();
           
        try{
            String sql = "SELECT * FROM cliente";
            conectar(sql);
            ResultSet resultado = comando.executeQuery();
            while (resultado.next()) {
                Cliente cliente = new Cliente(resultado.getInt("cpf"),
                        resultado.getString("nome"),
                        resultado.getString("email"));
                clientes.add(cliente);
            }
            
              
            fecharConexao();
            
    }
            catch(ClassNotFoundException e){
                System.out.println("Erro: Classe não encontrada!");
            }
            catch(SQLException e){
                System.out.println("Erro: SQL invalido!");
            }
        return clientes;  
            
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
    public void atualizarEmail(String email, String nEmail) {
         try{
            String sql = "UPDATE cliente SET email = ? WHERE email = ?";
            conectar(sql);
            comando = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            
            comando.setString(1,nEmail);
            comando.setString(2,email);
            
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
    
    
}
