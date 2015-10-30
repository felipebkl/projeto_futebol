package Model;


public class Conta {
    private  int numero;
    private double saldo;
    private int id;
    
    public Conta(){
        this.numero = (int)(Math.random()*1000000);
        this.saldo = 0.0;
    }
    
     public Conta(int numero, double saldo){
        this.numero = numero;
        this.saldo = saldo;
    }
     
      public Conta(int numero){
        this.numero = numero;
        this.saldo = 0;
    }
      
     public Conta( double saldo){
        
        this.saldo = saldo;
    }
    
    
    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
    
    public void depositar(double valor){
        if(valor > 0.0){
            this.saldo += valor;
        }
    }
    
   public void diminuir(double valor){
       if(valor > 0.0){
           this.saldo -= valor;
       }
   }
    
    public String toString(){
        return "O número da sua conta é: " + numero + " Saldo: " + saldo;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
   

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    
    
    
    
    
}
