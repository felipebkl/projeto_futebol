package Model;



public class Produto {
    
    private String nome;
    private double preco;
    private int codigo = 0;
    
   
    
    public Produto(){
        this.nome = "";
        this.preco = 0.0;
        this.codigo = 0;
    }
    
    public Produto(double preco, int codigo){
        this.nome = "";
        this.preco = preco;
        this.codigo = codigo;
    }
    
     public Produto(int cod){
        this.nome = "";
        this.preco = 0.0;
        this.codigo = cod;
    }
     public Produto(String nome,Double preco){
        this.nome = "";
        this.preco = 0.0;
        this.codigo = codigo;
    }
    
     
     public Produto(String nome,int codigo, double preco){
         this.nome = nome;
         this.codigo = codigo;
         this.preco = preco;
     }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public String toString(){
        return "Este produto tem id: " + codigo;
    }
    
    public String nome(){
        return "Produto: " + nome;
    }
    
    
    
    
}
