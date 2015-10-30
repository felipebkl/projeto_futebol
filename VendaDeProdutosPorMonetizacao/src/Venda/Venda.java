package Venda;
import Model.Produto;
import Model.Cliente;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Venda {
   
  
    private double total;
    private Date data;
    private Cliente cliente;
    private Produto produto;
    private int qtd;
    private int prod;
    private int cpf;
    private int id;
    
    
   
    
    SimpleDateFormat formatador = new SimpleDateFormat("'Data:' dd/MM/yyyy 'Hora:' HH:mm");
    SimpleDateFormat hora = new SimpleDateFormat("'Hora:'HH:mm");
    
    
    
    public Venda(int cpf,int qtd,double total,int prod){
        this.cpf = cpf;
        this.prod = prod;
        this.total = total;
        this.data = new Date();
        this.qtd = qtd;
        
    }
    
    public Venda(int id,int prod,int qtd, double total,Date data,int cpf){
        
        this.id = id;
        this.prod = prod;
        this.total = total;
        this.data = data;
        this.qtd = qtd;
        this.cpf = cpf;
    }
    
       public Venda(double total, int qtd){
        
       
        this.qtd = qtd;
        this.total = total;
        
    }
       
       public Venda(double total, int qtd, Date data){
        
       
        this.qtd = qtd;
        this.total = total;
        this.data = data;
    }
    
     public Venda(double total, int qtd, int prod){
       
       
        this.qtd = qtd;
        this.total = total;
        this.prod = prod;
    }
     
     
     /*public Venda(double total, int qtd, int prod, int cpf){
       
       
        this.qtd = qtd;
        this.total = total;
        this.prod = prod;
        this.cpf = cpf;
    }*/
     
     
     
     
     
     
       public Venda(double total, int qtd, int prod, Date data){
        
        this.qtd = qtd;
        this.total = total;
        this.prod = prod;
        this.data = data;
    }
       
       
         public Venda(double total, int qtd, int prod, Date data, Cliente cliente){
        
        this.qtd = qtd;
        this.total = total;
        this.prod = prod;
        this.data = data;
        this.cliente = cliente;
    }
         
         
      /* public Venda(double total, int qtd, int prod, int nConta){
        
        this.qtd = qtd;
        this.total = total;
        this.prod = prod;
        this.data = new Date();
        this.cliente = cliente;
    }*/
       
          public Venda(double total, int qtd, int prod, int nCpf){
        
        this.qtd = qtd;
        this.total = total;
        this.prod = prod;
        this.data = new Date();
        this.cpf = nCpf;
    }

    public Produto getProdutos(int cod){
          Produto prod = new Produto(cod);
          return prod;
        
    }

    public void saveData(){
        data = new Date();
    }
    
    public void setData(Date data){
        this.data = data;
    }

    public Date getData() {
        return data;
    }
  
    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    public String mostrarData(){
        return formatador.format(data);
    }
    
    public String mostrarHora(){
        return hora.format(data);
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    public Produto getProduto() {
        return produto;
    }
    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public int getQtd() {
        return qtd;
    }
    
    
    public String toString(){
        return "teste";
    }

    /**
     * @return the produto
     */
    public int getProd() {
        return prod;
    }

    /**
     * @param produto the produto to set
     */
    public void setProd(int prod) {
        this.prod = prod;
    }

    /**
     * @return the cpf
     */
    public int getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    
   
    
    
    
    
}
