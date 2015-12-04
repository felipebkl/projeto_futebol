package sistema;

import java.awt.Color;
import java.text.NumberFormat;
import static java.time.Clock.system;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Resultado {

    private JFrame jResultado;
    private int[][] mMelhor;
    private int linhas;

    @SuppressWarnings("serial")
    public Resultado() {

        // conf frame
        jResultado = new JFrame();
        jResultado.setLayout(null);
        jResultado.setTitle("Estatísticas");
        jResultado.setSize(800, 500);
        jResultado.setLocationRelativeTo(Principal.janelaPrinc);

        // cria modelos e não permite que sejam editados apenas vistos (read
        // only) classes anônimas
        DefaultTableModel modelMelhor = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };

        DefaultTableModel modelPior = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        // cria coluna models
        modelMelhor.addColumn("Jogador");
        modelMelhor.addColumn("Passes Certos");
        modelMelhor.addColumn("Passes Errados");
        modelMelhor.addColumn("Domínios Certos");
        modelMelhor.addColumn("Domínios Errados");

        modelPior.addColumn("Jogador");
        modelPior.addColumn("Passes Certos");
        modelPior.addColumn("Passes Errados");
        modelPior.addColumn("Domínios Certos");
        modelPior.addColumn("Domínios Errados");

        // popula models
        //Verifica se existe linha selecionada para não dar erro na hora de pegar os valores  
        //Pega os models das listas, para fazer as inserções e remoções  
        //Cria uma linha para ser incluida na tabela de destino, no meu caso tem duas colunas, adapte para as suas tabelas  
        int cont = Principal.table.getRowCount();

        for (int i = 0; i < cont; i++) {
            
         
          
            modelMelhor.addRow(new Object[]{Principal.table.getValueAt(i, 0),
                Principal.table.getValueAt(i, 1),
                Principal.table.getValueAt(i, 2),
                Principal.table.getValueAt(i, 3),
                Principal.table.getValueAt(i, 4)});

         
            modelPior.addRow(new Object[]{Principal.table.getValueAt(i, 0),
                Principal.table.getValueAt(i, 1),
                Principal.table.getValueAt(i, 2),
                Principal.table.getValueAt(i, 3),
                Principal.table.getValueAt(i, 4)});
        }

        // tabela
        JTable tableMelhor = new JTable(modelMelhor);

        JTable tablePior = new JTable(modelPior);

        JScrollPane stableMelhor = new JScrollPane(tableMelhor);
        stableMelhor.setHorizontalScrollBar(new JScrollBar(0));

        JScrollPane stablePior = new JScrollPane(tablePior);
        stablePior.setHorizontalScrollBar(new JScrollBar(0));

        stableMelhor.setBounds(50, 50, 700, 150);

        stablePior.setBounds(50, 250, 700, 150);

        JLabel lMelhor = new JLabel("Melhor Jogador");

        JLabel lPior = new JLabel("Pior Jogador");

        lMelhor.setBounds(50, 30, 150, 20);

        lPior.setBounds(50, 230, 150, 20);

        // adiciona ao frame
        jResultado.add(stableMelhor);
        jResultado.add(stablePior);

        jResultado.add(lMelhor);
        jResultado.add(lPior);

        // fim frame
        jResultado.setVisible(true);
        jResultado.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }

    public JFrame getjResultado() {
        return jResultado;
    }

    public void setjResultado(JFrame jResultado) {
        this.jResultado = jResultado;
    }

    public int getLinhas() {
        return linhas;
    }

    public void setLinhas(int linhas) {
        this.linhas = linhas;
    }

}
