package Venda;

import Venda.Venda;
import java.util.ArrayList;
import java.util.List;


public class Relatorio {
    private ArrayList<Venda> arrayClientes = new ArrayList();   
    
    public Relatorio(){
       
    }
    
    public void addVenda(Venda venda){
       arrayClientes.add(venda);
    }

   public Venda getCliente(int index){
       return arrayClientes.get(index);
   }

    public ArrayList<Venda> getArrayClientes() {
        return arrayClientes;
    }
   
   
    
    
    
    
    
    
}
