/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author 631410170
 */
public class Time {
    private String nome;
    private int anoFundacao;
    private String estadio;
    private String localizacao;
    
    public Time(){
        this.nome = ""; 
    }
    
    public Time(String nome,int anoFundacao, String estadio, String localizacao){
        this.nome = nome;
        this.anoFundacao = anoFundacao;
        this.estadio = estadio;
        this.localizacao = localizacao;
        
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the anoFundacao
     */
    public int getAnoFundacao() {
        return anoFundacao;
    }

    /**
     * @param anoFundacao the anoFundacao to set
     */
    public void setAnoFundacao(int anoFundacao) {
        this.anoFundacao = anoFundacao;
    }

    /**
     * @return the estadio
     */
    public String getEstadio() {
        return estadio;
    }

    /**
     * @param estadio the estadio to set
     */
    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }

    /**
     * @return the localizacao
     */
    public String getLocalizacao() {
        return localizacao;
    }

    /**
     * @param localizacao the localizacao to set
     */
    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }
    
}
