package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;

import entidade.Avaliacao;

public class Interface {

	private JFrame frame;
	private JTextField editNome;
	private JTextField editAltura;
	private JTextField editPeso;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface window = new Interface();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Interface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		DefaultListModel listModelNames = new DefaultListModel();
		JList listNomes = new JList(listModelNames);

		DefaultListModel listModelAvals = new DefaultListModel();
		JList listAvals = new JList(listModelAvals);

		Controle controleTela = new Controle();

		// listModelNames.addElement("Menina sem nome");

		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 30, 0, 0, 0, 30, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 30, 0, 0, 30, 30, 30, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 1.0, 1.0, 0.0, 1.0,
				0.0, 1.0, 0.0, 0.0, 0.0 };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 0.0, 0.0,
				0.0, 0.0 };
		frame.getContentPane().setLayout(gridBagLayout);

		JLabel lblControleDeAvaliao = new JLabel(
				"Controle de Avalia\u00E7\u00E3o de Indice de Massa Corporal");
		GridBagConstraints gbc_lblControleDeAvaliao = new GridBagConstraints();
		gbc_lblControleDeAvaliao.gridwidth = 10;
		gbc_lblControleDeAvaliao.insets = new Insets(0, 0, 5, 5);
		gbc_lblControleDeAvaliao.gridx = 0;
		gbc_lblControleDeAvaliao.gridy = 0;
		frame.getContentPane().add(lblControleDeAvaliao,
				gbc_lblControleDeAvaliao);
		JLabel lblNome = new JLabel("Nome");
		GridBagConstraints gbc_lblNome = new GridBagConstraints();
		gbc_lblNome.anchor = GridBagConstraints.WEST;
		gbc_lblNome.insets = new Insets(0, 0, 5, 5);
		gbc_lblNome.gridx = 0;
		gbc_lblNome.gridy = 1;
		frame.getContentPane().add(lblNome, gbc_lblNome);

		editNome = new JTextField();
		GridBagConstraints gbc_editNome = new GridBagConstraints();
		gbc_editNome.gridwidth = 4;
		gbc_editNome.insets = new Insets(0, 0, 5, 5);
		gbc_editNome.fill = GridBagConstraints.HORIZONTAL;
		gbc_editNome.gridx = 1;
		gbc_editNome.gridy = 1;
		frame.getContentPane().add(editNome, gbc_editNome);
		editNome.setColumns(10);

		JButton btnCadastrar = new JButton("Cadastrar");

		JButton btnIncluir = new JButton("Incluir Avalia\u00E7\u00E3o");
		btnIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				double novaAltura = Double.parseDouble(editAltura.getText());
				double novoPeso = Double.parseDouble(editPeso.getText());

				int selecionada = listNomes.getSelectedIndex();

				controleTela.incluiAvaliacaoPessoaSelecionada(selecionada,
						novaAltura, novoPeso);

				// Pessoa p =
				// controleTela.recuperaPessoaSelecionada(selecionada);
				ArrayList<Avaliacao> avaliacoes = controleTela
						.recuperaAvaliacoesPessoaSelecionada(selecionada);
				// Avaliacao ultima = avaliacoes.get((avaliacoes.size()-1));

				// TODO refactoring no modo de montagem da string (inclui
				// somente o ultimo de lista-avaliacoes)
				// String novaAvaliacao = "[" + ultima.getIndice() + "] - " +
				// ultima.getSituacao();
				// listModelAvals.addElement(novaAvaliacao);

				recarregaListagemAvaliacoes(avaliacoes, listModelAvals);

				editPeso.setText("");
				editAltura.setText("");

			}
		});
		// btnIncluir.setEnabled(false);

		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String novoNome = editNome.getText();
				// System.out.println("adicionando > " + novoNome);
				listModelNames.addElement(novoNome);
				controleTela.cadastraPessoa(novoNome);
				editNome.setText("");
			}
		});

		JLabel lblAltura = new JLabel("Altura");
		GridBagConstraints gbc_lblAltura = new GridBagConstraints();
		gbc_lblAltura.anchor = GridBagConstraints.EAST;
		gbc_lblAltura.insets = new Insets(0, 0, 5, 5);
		gbc_lblAltura.gridx = 5;
		gbc_lblAltura.gridy = 1;
		frame.getContentPane().add(lblAltura, gbc_lblAltura);

		editAltura = new JTextField();
		editAltura.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {

				// if (editPeso.getText() != "" && editAltura.getText() != "")
				// btnIncluir.setEnabled(false);
			}
		});
		GridBagConstraints gbc_editAltura = new GridBagConstraints();
		gbc_editAltura.gridwidth = 2;
		gbc_editAltura.insets = new Insets(0, 0, 5, 5);
		gbc_editAltura.fill = GridBagConstraints.HORIZONTAL;
		gbc_editAltura.gridx = 6;
		gbc_editAltura.gridy = 1;
		frame.getContentPane().add(editAltura, gbc_editAltura);
		editAltura.setColumns(10);

		JLabel lblNewLabel = new JLabel("Peso");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 8;
		gbc_lblNewLabel.gridy = 1;
		frame.getContentPane().add(lblNewLabel, gbc_lblNewLabel);

		editPeso = new JTextField();
		GridBagConstraints gbc_editPeso = new GridBagConstraints();
		gbc_editPeso.insets = new Insets(0, 0, 5, 0);
		gbc_editPeso.fill = GridBagConstraints.HORIZONTAL;
		gbc_editPeso.gridx = 9;
		gbc_editPeso.gridy = 1;
		frame.getContentPane().add(editPeso, gbc_editPeso);
		editPeso.setColumns(10);
		GridBagConstraints gbc_btnCadastrar = new GridBagConstraints();
		gbc_btnCadastrar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCadastrar.gridwidth = 5;
		gbc_btnCadastrar.insets = new Insets(0, 0, 5, 5);
		gbc_btnCadastrar.gridx = 0;
		gbc_btnCadastrar.gridy = 2;
		frame.getContentPane().add(btnCadastrar, gbc_btnCadastrar);

		GridBagConstraints gbc_btnIncluir = new GridBagConstraints();
		gbc_btnIncluir.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnIncluir.gridwidth = 5;
		gbc_btnIncluir.insets = new Insets(0, 0, 5, 0);
		gbc_btnIncluir.gridx = 5;
		gbc_btnIncluir.gridy = 2;
		frame.getContentPane().add(btnIncluir, gbc_btnIncluir);

		listNomes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO
				listNomes.getSelectedIndex();
				listNomes.getSelectedValue();
				// System.out.println(listNomes.getSelectedIndex());
				// System.out.println(listNomes.getSelectedValue());

				// if (listNomes.getSelectedIndex() >= 0)
				// btnIncluir.setEnabled(true);

				// Atualiza avaliacoes do clique
				listModelAvals.clear();
				ArrayList<Avaliacao> avaliacoes = controleTela
						.recuperaAvaliacoesPessoaSelecionada(listNomes
								.getSelectedIndex());
				recarregaListagemAvaliacoes(avaliacoes, listModelAvals);

			}
		});
		listNomes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		listNomes.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null,
				null, null, null));
		GridBagConstraints gbc_listNomes = new GridBagConstraints();
		gbc_listNomes.weighty = 20.0;
		gbc_listNomes.fill = GridBagConstraints.BOTH;
		gbc_listNomes.gridheight = 4;
		gbc_listNomes.gridwidth = 5;
		gbc_listNomes.insets = new Insets(0, 0, 5, 5);
		gbc_listNomes.gridx = 0;
		gbc_listNomes.gridy = 3;
		frame.getContentPane().add(listNomes, gbc_listNomes);

		listAvals.setEnabled(false);
		listAvals.setBorder(new LineBorder(new Color(0, 0, 0)));
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.gridheight = 4;
		gbc_list.gridwidth = 5;
		gbc_list.insets = new Insets(0, 0, 5, 0);
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 5;
		gbc_list.gridy = 3;
		frame.getContentPane().add(listAvals, gbc_list);

		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(1);
			}
		});
		GridBagConstraints gbc_btnSair = new GridBagConstraints();
		gbc_btnSair.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSair.gridx = 9;
		gbc_btnSair.gridy = 7;
		frame.getContentPane().add(btnSair, gbc_btnSair);
	}

	private void recarregaListagemAvaliacoes(ArrayList<Avaliacao> lista,  DefaultListModel list) {
		DecimalFormat mask = new DecimalFormat("0.00");
		String indiceStr;
		
		list.clear();
		double oldstatus = -1;
		String statusind = "";
		int cont = 0;
		for(Avaliacao a : lista) {
			if (cont++ == 0)
				statusind = "-";
			else {
				System.out.println(oldstatus +"<->"+ a.getIndice());
				if (oldstatus > a.getIndice()) statusind = "v";
				else if (oldstatus< a.getIndice()) statusind = "^";
				else statusind = "-";
			}
			
			indiceStr = mask.format(a.getIndice());
				
			String novaAvaliacao = "[" + a.getIndice() + "] - " + a.getSituacao() + " " + statusind;
			oldstatus = a.getIndice();
			list.addElement(novaAvaliacao);
		}
		
		
	}
}
