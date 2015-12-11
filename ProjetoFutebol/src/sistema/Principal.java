package sistema;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Principal {

	protected static int estatistica; // estatistica
	protected static JFrame janelaPrinc; // janela principal
	protected static JTable table; // tabela em que os processos são inseridos
	protected static int p = 0; // contador de processos
	protected static int openJa = 0; // variavel para controle da janela
										// adicionar
	private static JMenu menuPrincipal;
        private static JMenu menu1Principal;
        
	private static JMenuBar barraMenu;
	private static JMenuItem itemAdicionar, itemRemover;
        
        private static JMenuItem itemCreditos;
        
        private static JButton btnCalcular;
	private String alerta = "Erro!";
	private static DefaultTableModel model; // modelo de table - modelo de dados
	private static JTextField tEstatistica; // campo de texto para o estatistica

	public Principal() {
		// inicializa janela principal
		janelaPrinc = new JFrame();
                
                
                
		janelaPrinc.setLayout(null);
		janelaPrinc.setTitle("Estatísticas de Futebol");
		janelaPrinc.setSize(800, 600);
		inicializarMenu();
		configuraMenu();
		adicionarMenu();
		inicializarTabela();
		eventosMenu();
		janelaPrinc.setVisible(true);
		janelaPrinc.setLocationRelativeTo(null);
		janelaPrinc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@SuppressWarnings("serial")
	private void inicializarTabela() {
		model = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		model.addColumn("Time");
                model.addColumn("Jogador");
		model.addColumn("Passes Certos");
		model.addColumn("Passes Errados");
		model.addColumn("Domínios Certos");
                model.addColumn("Domínios Errados");

		// cria tabela
		table = new JTable(model);

		// cria Scroll
		JScrollPane scrollTable = new JScrollPane(table);
		scrollTable.setHorizontalScrollBar(new JScrollBar(0));
		scrollTable.setBounds(50, 50, 700, 150);
		janelaPrinc.add(scrollTable);
	}

	private void eventosMenu() {
		// eventos
		// evento botao adicionar
		itemAdicionar.addActionListener(new ActionListener() {

			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent e) {
				// abre frame
				if (openJa == 0) {
					JAdicionarJogador ja = new JAdicionarJogador();
					// define janela como aberta
					openJa = 1;
				}
			}
		});
		// evento botao remover
		itemRemover.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// remove linha
				int colunas = table.getSelectedColumn();
				int linhas = table.getSelectedRow();
				if (linhas == -1 || colunas == -1) {
					JOptionPane.showMessageDialog(null,"Selecione a linha");
				} else {
					model.removeRow(linhas);
					// decrementa a varialvel de controle para processos
					p--;
				}
			}
		});
		// evento botao calcular
		btnCalcular.addActionListener(new ActionListener() {

			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent e) {
				// abre frame resultado e pega estatistica
				
                            
                                        Resultado res = new Resultado();
				
                                        

			}

		});
                
		itemCreditos.addActionListener(new ActionListener() {

			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent e) {
                            JOptionPane.showMessageDialog(janelaPrinc,"Engenharia de Software II "
                                    + "\nAlunos: Felipe, Jair e Thiago"
                                    + "\nProfessor: Marcos Mangam","Créditos",JOptionPane.INFORMATION_MESSAGE);
			}

		});

	}

	public static void adicionaLinha(Object nl[]) {
		model.addRow(nl);
	}

	private void inicializarMenu() {
		// barra
		barraMenu = new JMenuBar();

		// Menu Principal
		menuPrincipal = new JMenu("Opções");
                menu1Principal = new JMenu("Ajuda");

		// itens do menu
		itemAdicionar = new JMenuItem("Adicionar Jogador");
		itemRemover = new JMenuItem("Remover Jogador");
                btnCalcular = new JButton("Gerar Estatísticas");
                
               
                
                itemCreditos = new JMenuItem("Créditos");

		
		JLabel lEstatistica = new JLabel("Jogadores");
		
		tEstatistica = new JTextField();
                
		lEstatistica.setBounds(50, 0, 80, 50);
                
		tEstatistica.setBounds(125, 15, 60, 20);
                
                btnCalcular.setBounds(50,220,150,20);
              
		janelaPrinc.add(lEstatistica);
		
                janelaPrinc.add(btnCalcular);
	}

	private void adicionarMenu() {
               
		janelaPrinc.setJMenuBar(barraMenu);
		barraMenu.add(menuPrincipal);
                barraMenu.add(menu1Principal);
		menuPrincipal.add(itemAdicionar);
		menuPrincipal.add(itemRemover);
                menu1Principal.add(itemCreditos);
                
	}

	private void configuraMenu() {
		menuPrincipal.setMnemonic('S');
		itemAdicionar.setMnemonic('A');
		btnCalcular.setMnemonic('C');
		itemRemover.setMnemonic('R');
	}

	public static void main(String[] args) {
		new Principal();
	}

   
        
        
}
