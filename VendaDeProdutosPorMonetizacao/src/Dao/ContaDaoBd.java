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
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ricardo
 */
public class ContaDaoBd implements ContaDao {

    private Connection conexao;
    private PreparedStatement comando;

    @Override
    public void inserir(Conta conta) {

        try {
            String sql = "INSERT INTO conta (numero, saldo) VALUES(?,?)";
            conectar(sql);
            comando = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            comando.setInt(1, conta.getNumero());
            comando.setDouble(2, conta.getSaldo());

            comando.executeUpdate();

            ResultSet resultado = comando.getGeneratedKeys();
            if (resultado.next()) {
                conta.setNumero(resultado.getInt(1));
            }

            fecharConexao();

        } catch (ClassNotFoundException e) {
            System.out.println("Erro de classe: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Erro SQL: " + e.getMessage());
        }

    }

    @Override
    public List<Cliente> listar(int numero) {
        List<Cliente> clientes = new ArrayList<Cliente>();

        try {
            String sql = "SELECT nome,numero,saldo FROM cliente,conta WHERE numero = ? AND conta = ? ";
            conectar(sql);
            comando.setInt(1, numero);
            comando.setInt(2, numero);
            ResultSet resultado = comando.executeQuery();
            while (resultado.next()) {
                Cliente cliente = new Cliente(resultado.getString("nome"),
                        resultado.getInt("numero"),
                        resultado.getDouble("saldo"));

                clientes.add(cliente);
            }

            fecharConexao();

        } catch (ClassNotFoundException e) {
            System.out.println("Erro: Classe não encontrada!");
        } catch (SQLException e) {
            System.out.println("Erro: SQL invalido!");
        }
        return clientes;

    }

    @Override
    public List<Conta> atualizar(double valor, Conta conta) {
        List<Conta> contas = new ArrayList<Conta>();
        
        try {
            String sql = "SELECT nome,numero,saldo FROM cliente,conta WHERE numero = ? AND conta = ? ";
            conectar(sql);
            comando.setInt(1, conta.getNumero());
            comando.setInt(2, conta.getNumero());
            ResultSet resultado = comando.executeQuery();
            while (resultado.next()) {
                Cliente cliente = new Cliente(resultado.getString("nome"),
                        resultado.getInt("numero"),
                        resultado.getDouble("saldo"));

                contas.add(cliente);
            }

            fecharConexao();

        } catch (ClassNotFoundException e) {
            System.out.println("Erro: Classe não encontrada!");
        } catch (SQLException e) {
            System.out.println("Erro: SQL invalido!");
        }
        try {

            String sql = "UPDATE conta SET saldo = ? WHERE numero = ?";
            conectar(sql);
            comando = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            comando.setDouble(1, valor);
            comando.setInt(2, conta.getNumero());

            comando.executeUpdate();

            ResultSet resultado = comando.getGeneratedKeys();
            if (resultado.next()) {
                conta.setNumero(resultado.getInt(1));
            }

            fecharConexao();

        } catch (ClassNotFoundException e) {
            System.out.println("Erro de classe: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Erro SQL: " + e.getMessage());
        }
        return contas;
    }
    
    @Override
    public Conta visualizar(Conta conta) {

        try {
            String sql = "SELECT * FROM conta WHERE numero = ?";
            conectar(sql);
            comando = conexao.prepareStatement(sql);

            comando.setInt(1, conta.getNumero());
            

            ResultSet resultado = comando.executeQuery();
            while (resultado.next()) {

                int numero = resultado.getInt("numero");
                double saldo = resultado.getDouble("saldo");
                int id = resultado.getInt("id");
                conta = new Conta(numero, saldo);
                conta.setId(id);
            }
            
            fecharConexao();

        } catch (ClassNotFoundException e) {
            System.out.println("Erro de classe: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Erro SQL: " + e.getMessage());
        }
        return conta;
    }

    @Override
    public void remover(Conta conta) {

        try {
            String sql = "DELETE  FROM conta WHERE numero = ?";
            conectar(sql);
            comando.setInt(1, conta.getNumero());
            comando.executeUpdate();
            fecharConexao();

        } catch (SQLException ex) {

            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDaoBd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Cliente buscarPorConta(int numero) {
        Conta conta = null;
        Cliente cliente = null;
        try {
            String sql = "SELECT * FROM cliente,conta WHERE numero = ?";
            conectar(sql);
            comando.setInt(1, numero);
            ResultSet resultado = comando.executeQuery();
            if (resultado.next()) {
                cliente = new Cliente(resultado.getString("nome"),
                        resultado.getInt("numero"),
                        resultado.getDouble("saldo"));
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
    public List<Conta> CarregarRepositorioContas() {

        List<Conta> contas = new ArrayList<Conta>();

        try {
            String sql = "SELECT * FROM conta";
            conectar(sql);
            comando = conexao.prepareStatement(sql);

            Conta c = null;

            ResultSet resultado = comando.executeQuery();
            while (resultado.next()) {
                int id = resultado.getInt("id");
                int numero = resultado.getInt("numero");
                double saldo = resultado.getDouble("saldo");

                                //System.out.println("ID Registro Banco : " + id);
                //System.out.println("Conta : " + numero);
                //System.out.println("Saldo : " + saldo);
                c = new Conta(numero, saldo);

                contas.add(c);

            }

            fecharConexao();

        } catch (ClassNotFoundException e) {
            System.out.println("Erro: Classe não encontrada!");
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return contas;

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
    public void depositar(double valor, Conta conta) {
         try {
            String sql = "UPDATE conta SET saldo = saldo + ? WHERE numero = ?";
            conectar(sql);
            comando.setDouble(1, valor);
            comando.setInt(2, conta.getNumero());
            comando.executeUpdate();

            fecharConexao();

        } catch (ClassNotFoundException e) {
            System.out.println("Erro: Classe não encontrada!");
        } catch (SQLException e) {
            System.out.println("Erro: SQL invalido!");
        }
    }

}
