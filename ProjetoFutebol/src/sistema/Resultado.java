package sistema;

import java.awt.Color;
import java.text.DecimalFormat;
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

        DecimalFormat deci = new DecimalFormat("0.000");

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
        modelMelhor.addColumn("Aproveitamento");
        modelMelhor.addColumn("Média de Acertos");
        modelMelhor.addColumn("Média de Erros");

        modelPior.addColumn("Jogador");
        modelPior.addColumn("Passes Certos");
        modelPior.addColumn("Passes Errados");
        modelPior.addColumn("Domínios Certos");
        modelPior.addColumn("Domínios Errados");
        modelPior.addColumn("Aproveitamento");
        modelPior.addColumn("Média de Acertos");
        modelPior.addColumn("Média de Erros");
        // popula models
        //Verifica se existe linha selecionada para não dar erro na hora de pegar os valores  
        //Pega os models das listas, para fazer as inserções e remoções  
        //Cria uma linha para ser incluida na tabela de destino, no meu caso tem duas colunas, adapte para as suas tabelas  
        int cont = Principal.table.getRowCount();
        Object[] obj = new Object[]{};
        double mediaMaior = 0;

        double mediaMenor = Double.MAX_VALUE;
        double media = 0;
        int j = 0;
        int p = 0;
        double mediaP = 0;
        double somaP = 0;
        double mediaA = 0;
        double mediaE = 0;
        //verifica o melhor jogador
        for (int i = 0; i < cont; i++) {

            //media de aproveitamento
            media = (Double.parseDouble((String) Principal.table.getValueAt(i, 2))
                    + Double.parseDouble((String) Principal.table.getValueAt(i, 4)))
                    - (Double.parseDouble((String) Principal.table.getValueAt(i, 3))
                    + Double.parseDouble((String) Principal.table.getValueAt(i, 5)));

            if (media > mediaMaior) {

                j = i;

                //calcula a porcentagem
                mediaP = (Double.parseDouble((String) Principal.table.getValueAt(j, 2))
                        + Double.parseDouble((String) Principal.table.getValueAt(j, 4))
                        + Double.parseDouble((String) Principal.table.getValueAt(j, 3))
                        + Double.parseDouble((String) Principal.table.getValueAt(j, 5))) / 100;

                somaP = (Double.parseDouble((String) Principal.table.getValueAt(j, 2))
                        + Double.parseDouble((String) Principal.table.getValueAt(j, 4))) / mediaP;
                //media de acertos
                mediaA = (Double.parseDouble((String) Principal.table.getValueAt(j, 2))
                        + Double.parseDouble((String) Principal.table.getValueAt(j, 4))) / 2;
                //media de erros
                mediaE = (Double.parseDouble((String) Principal.table.getValueAt(j, 3))
                        + Double.parseDouble((String) Principal.table.getValueAt(j, 5))) / 2;

            }
            mediaMaior = media;
        }

        obj = new Object[]{Principal.table.getValueAt(j, 1), //nome
            Principal.table.getValueAt(j, 2),//PC
            Principal.table.getValueAt(j, 3),//PE
            Principal.table.getValueAt(j, 4),//DC
            Principal.table.getValueAt(j, 5),//DE
            deci.format(somaP),
            mediaA,
            mediaE}; //media de aproveitamento

        modelMelhor.addRow(obj);
        mediaP = 0;
        somaP = 0;
        media = 0;
        for (int i = 0; i < cont; i++) {
            //media de aproveitamento
            media = (Double.parseDouble((String) Principal.table.getValueAt(i, 2))
                    + Double.parseDouble((String) Principal.table.getValueAt(i, 4)))
                    - (Double.parseDouble((String) Principal.table.getValueAt(i, 3))
                    + Double.parseDouble((String) Principal.table.getValueAt(i, 5)));

            if (media < mediaMenor) {

                p = i;
                // total / 100
                mediaP = (Double.parseDouble((String) Principal.table.getValueAt(p, 2))
                        + Double.parseDouble((String) Principal.table.getValueAt(p, 4))
                        + Double.parseDouble((String) Principal.table.getValueAt(p, 3))
                        + Double.parseDouble((String) Principal.table.getValueAt(p, 5))) / 100;
                //acertos / mediaP
                somaP = (Double.parseDouble((String) Principal.table.getValueAt(p, 2))
                        + Double.parseDouble((String) Principal.table.getValueAt(p, 4))) / mediaP;
                //media de acertos
                mediaA = (Double.parseDouble((String) Principal.table.getValueAt(p, 2))
                        + Double.parseDouble((String) Principal.table.getValueAt(p, 4))) / 2;
                //media de erros
                mediaE = (Double.parseDouble((String) Principal.table.getValueAt(p, 3))
                        + Double.parseDouble((String) Principal.table.getValueAt(p, 5))) / 2;
            }
            mediaMenor = media;
        }

        obj = new Object[]{Principal.table.getValueAt(p, 1), //nome
            Principal.table.getValueAt(p, 2),//PC
            Principal.table.getValueAt(p, 3),//PE
            Principal.table.getValueAt(p, 4),//DC
            Principal.table.getValueAt(p, 5),//DE
            deci.format(somaP),//Aproveitamento
            mediaA,
            mediaE};

        modelPior.addRow(obj);

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
