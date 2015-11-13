/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositorios;

import java.util.ArrayList;
import java.util.List;
import Model.Jogador;

/**
 *
 * @author 631410170
 */
public class RepositorioJogador {
    
     private List<Jogador>  jogadores;
  public RepositorioJogador() {
        jogadores = new ArrayList<Jogador>();
    }

    public boolean addJogadores(Jogador jogador) {
        return (jogadores.add(jogador));
    }

    public List<Jogador> getListaJogadores() {
        return jogadores;
    }

    public boolean jogadorExiste(String nome) {
        for (Jogador jogador : jogadores) {
            if (jogador.getNome()==(nome)) {
            } else {
                return true;
            }
        }
        return false;
    }

    public Jogador buscarJogador(String nome) {
        for (Jogador jogador : jogadores) {
            if (jogador.getNome()== (nome)) {
                return jogador;
            }
        }
        return null;
    }
    
}
