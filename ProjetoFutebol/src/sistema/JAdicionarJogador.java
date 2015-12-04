package sistema;

import java.awt.Color;
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  
import javax.swing.*; 

public class JAdicionarJogador {
    private static JFrame jAdicionar;  
    private static Object[] nl;  
    private JTextField Jogador;  
    private JTextField PC;  
    private JTextField PE; 
    private JTextField DC; 
    private JTextField DE; 
  
  
    //cria janela  
    public JAdicionarJogador() {  
        Principal.p++;  
        
        //Enquanto for o primeiro processo, inicia com processo de chegada em zero.
        if(Principal.p == 1){
           PC = new JTextField();
           PC.setText("0");
           PC.setEditable(true);
           
        }
        else{
            PC = new JTextField();
            PC.setBackground(Color.WHITE);
        }
  
        //inicializa janela  
        jAdicionar = new JFrame();  
  
        //define propriedades  
        jAdicionar.setTitle("Adicionar Jogador");  
        jAdicionar.setLayout(null);  
        jAdicionar.setSize(500, 400);  
        jAdicionar.setLocationRelativeTo(Principal.janelaPrinc);  
  
        //cria componentes  
        JLabel ljogador = new JLabel("Jogador");  
        JLabel lpc = new JLabel("Passes Certos");  
        JLabel lpe = new JLabel("Passes Errados");  
        JLabel ldc = new JLabel("Domínios Certos"); 
        JLabel lde = new JLabel("Domínios Errados"); 
         
  
         Jogador = new JTextField();    
         PE = new JTextField();  
         PC = new JTextField(); 
         DE = new JTextField(); 
         DC = new JTextField(); 
         
       
       
         
         
  
        JButton bok = new JButton("OK");  
        JButton bcancel = new JButton("CANCELAR");  
  
         
        ljogador.setBounds(30, 30, 100, 20);  
        lpc.setBounds(30, 70, 150, 20);  
        lpe.setBounds(30, 110, 150, 20); 
        ldc.setBounds(30, 150, 150, 20); 
        lde.setBounds(30, 190, 150, 20); 
         
  
        Jogador.setBounds(170, 30, 220, 20); 
        
        PC.setBounds(170, 70, 80, 20);  
        
        
        
        PE.setBounds(170, 110, 80, 20);
        PE.setBackground(Color.WHITE);
        
        DC.setBounds(170, 150, 80, 20);
        DC.setBackground(Color.WHITE);
        
        DE.setBounds(170, 190, 80, 20);
        DE.setBackground(Color.WHITE);
        
        //tprioridade.setBounds(170, 230, 80, 20);
       // tprioridade.setBackground(Color.WHITE);
  
        bok.setBounds(160, 270, 100, 30);  
        
       
        
        bcancel.setBounds(280, 270, 100, 30);
        
       
  
          
        Jogador.setEditable(true);  
         
  
        //adiciona a janela  
        jAdicionar.add(ljogador);  
        jAdicionar.add(lpc);  
        jAdicionar.add(lpe);
        jAdicionar.add(ldc);
        jAdicionar.add(lde);
         
        jAdicionar.add(Jogador);  
        jAdicionar.add(PC);  
        jAdicionar.add(PE); 
        jAdicionar.add(DC); 
        jAdicionar.add(DE); 
        //jAdicionar.add(tprioridade);  
        jAdicionar.add(bok);  
        jAdicionar.add(bcancel);  
        
        PC.requestFocus();
  
        //eventos  
        bok.addActionListener(new ActionListener() {  
  
            public void actionPerformed(ActionEvent e) {
                
                
                 //adiciona lina  
                nl = new Object[]{Jogador.getText(),PC.getText() ,PE.getText() ,DC.getText(),DE.getText()};  
                Principal.adicionaLinha(nl);  
                Principal.openJa=0;  
                jAdicionar.dispose();  
            }  
        });  
        bcancel.addActionListener(new ActionListener() {  
  
            public void actionPerformed(ActionEvent e) {  
                Principal.p--;  
                Principal.openJa=0;  
                jAdicionar.dispose();  
  
            }  
        });  
        //opcoes finais da janela  
        jAdicionar.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
        jAdicionar.setVisible(true);  
    }  
  
    @SuppressWarnings("unused")
	public static void main(String args[]) {  
        JAdicionarJogador ja = new JAdicionarJogador();  
    }  

    public static JFrame getjAdicionar() {
        return jAdicionar;
    }

    public static void setjAdicionar(JFrame jAdicionar) {
        JAdicionarJogador.jAdicionar = jAdicionar;
    }

    public static Object[] getNl() {
        return nl;
    }

    public static void setNl(Object[] nl) {
        JAdicionarJogador.nl = nl;
    }

    public JTextField getJogador() {
        return Jogador;
    }

    public void setJogador(JTextField Jogador) {
        this.Jogador = Jogador;
    }

    public JTextField getPC() {
        return PC;
    }

    public void setPC(JTextField PC) {
        this.PC = PC;
    }

    public JTextField getTte() {
        return PE;
    }

    public void setTte(JTextField tte) {
        this.PE = tte;
    }

    

    
        
        
}
