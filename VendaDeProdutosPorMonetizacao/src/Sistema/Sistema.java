
package Sistema;








import Views.*;



public class Sistema {
    

	    public static void main(String[] args) {
	       
             
                EntradaSistema entrada = new EntradaSistema();
                entrada.setVisible(true);
                
                //new MainUI().executar();
	    }
   
   
  /*  
        
       
        
        
    
    
    
    
    
    
    
   
         else if(temp.equals("5")){
             ComprarProduto();
         }
         else if(temp.equals("6")){
             showProds();
 
         System.out.println("2 - Relatório último Cliente");
         System.out.println("3 - Relatório Produtos");
        
         else if(temp.equals("2")){
             RelatorioClientes();
         }
         else if(temp.equals("3")){
             RelatorioCompras();
         }
         else if(temp.equals("4")){
             showProds();
       
        
         
    
    
    
   
    
    
    
    
    
        
    }
    
    
    
    
        
        
        
        
    
    
    public static void ComprarProduto(){
        
        VendaDao vendaBD = new VendaDaoBd();
        ContaDao contaBD = new ContaDaoBd();
        
        System.out.println("Escreva o código do produto a comprar: ");
        int prod = sc.nextInt();
        int temp;
        System.out.println("Escreva a quantidade de itens a comprar: ");
        int qtd; 
        double preco;
        double saldo;
        for(int i = 0; i < repProdutos.getTam(); i++){
            if(repProdutos.getProdutos()[i].getCodigo() == prod){
                qtd = sc.nextInt();
                preco = repProdutos.getProdutos()[i].getPreco()*qtd;
                
                System.out.println("Escreva o número da sua conta: ");
                temp = sc.nextInt();
                for(int j = 0; j < repClientes.getTam(); j++){
                    
                   
                    
                    if(repClientes.getClientes()[j].getConta().getNumero() == temp){
                        if(repClientes.getClientes()[j].getConta().getSaldo() >= preco){
                            System.out.println("Você comprou o produto com sucesso.");
                            
                            idProd = prod;
                            repVendas.getVendas()[i].saveData();
                            if(idGlobal[j] == 0){
                                idGlobal[j] = prod;
                            }
                            repVendas.getVendas()[i].setTotal(preco);
                            repVendas.getVendas()[i].setCliente(repClientes.getClientes()[j]);
                            repVendas.getVendas()[i].setQtd(qtd);
                            repClientes.getClientes()[j].getConta().diminuir(preco);
                            saldo = repClientes.getClientes()[j].getConta().getSaldo();
                            contaBD.atualizar(saldo, repClientes.getClientes()[j].getConta());
                            Produto produto = new Produto(prod);
                            relatorio.addVenda(repVendas.getVendas()[i]);
                            
                         
                           
                             vendaBD.inserir(produto, repVendas.getVendas()[i]);
                            vendaBD.inserirID(idProd);
                            for(int k = qtd; k > 0; k--){
                                //repVendas.getCompras().add(repVendas.getVendas()[i]);
                               repCompras.getCompras().add(idProd);
                            }
                            
                            
                        }
                        else{
                            System.out.print("[ERRO] Você não tem o saldo necessário!\n");
                        }
                    }
                }
            }
        }
    }
    
    public static void RelatorioClientes(){
        
  
        System.out.println("Escreva o nome do cliente:");
        String nome = sc.next();
        
        String format = "%1$-35s%2$-35s%3$-35s%4$-35s\n";
        System.out.format(format, "Nome", "Data","Total","ID Produto");
        String nomeCliente;
        String data;
        String hora;
        double total;
        int idProduto;
        
        
        
       
        
        for(int i = 0; i < repVendas.getTam(); i++){
            if(repVendas.getVendas()[i].getCliente().getNome().equals(nome)){
                
                
                nomeCliente = repVendas.getVendas()[i].getCliente().getNome();
                data = repVendas.getVendas()[i].mostrarData();
                //hora = repVendas.getVendas()[i].mostrarHora();
                total = repVendas.getVendas()[i].getTotal();
                idProduto = 0000;
                for(int j = 0; j < repCompras.getCompras().size(); i++){
                    if(repCompras.getCompras().get(j) != null){
                    System.out.println(j);
                    idProduto = repCompras.getCompras().get(j);
                    break;
                    }
                }
                
                */
               // System.out.format(format,nomeCliente,data/*,hora*/,total,idProduto);
                
              /*  break;
            }
        }
    }
        
    public static void showProds(){
        String nome = "";
        double preco = 0.0;
        int cod = 0;
        String format = "%1$-10s%2$-10s%3$-20s\n";
        
        System.out.format(format, "Código", "Produto", "Preço");
        
        
        
        for(int i = 0; i < repProdutos.getTam(); i++){
           
            if(!repProdutos.getProdutos()[i].getNome().equals("")){
                nome = repProdutos.getProdutos()[i].getNome();
                preco = repProdutos.getProdutos()[i].getPreco();
                cod = repProdutos.getProdutos()[i].getCodigo();
                System.out.format(format,  cod, nome, preco);
              
            }
            
        }
        
    
    }
        
    
    
        public static void RelatorioCompras(){
            String format = "%1$-35s%2$-35s\n";
             
            System.out.format(format, "Data", "Código de Produto");
            String data;
            String hora;
            int cod;
            
            
            
                for(int i = 0; i < repCompras.getCompras().size(); i++){
               
                data =  repVendas.getVendas()[i].mostrarData();
                
                cod = repCompras.getCompras().get(i);
                
                
               
                System.out.format(format,data,cod);
                
                
                
                
                
                
                
            
        }
    }*/
    
    
    
    
    
   
    
    
}
