package Model;


public class Cliente extends Conta{
    private String nome;
    private int cpf;
    private String email;
    private Conta conta;
    private int id;
    
    public Cliente(){
        this.id = -1;
        this.nome = "";
        this.cpf = 0;
        this.email = "";
        this.conta = new Conta();
    }
    
    public Cliente( int cpf, String nome){
        this.nome = nome;
        this.cpf = cpf;
        conta = new Conta();
    }
    
    public Cliente( int cpf, String nome, String email){
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        conta = new Conta();
    }
     public Cliente(String nome,int numero, double saldo){
        this.nome = nome;
        conta = new Conta(numero,saldo);
     }
     public Cliente(String nome){
        this.nome = nome;
        conta = new Conta();
     }
     public Cliente( int cpf,String nome, String email, int numero, double saldo){
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        conta = new Conta(numero,saldo);
    }

     
      public Cliente( int cpf,String nome, String email, Conta conta){
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.conta = conta;
    } 
      
       public Cliente(int id, int cpf,String nome, String email){
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.conta = new Conta();
        this.id = id;
    } 

    
    
    public String getNome() {
        return nome;
    }

    public int getCpf() {
        return cpf;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public Conta getConta() {
        return conta;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }
    
    
    @Override
    public String toString(){
        return "Nome do cliente: " + nome;
    }
    
    
}
