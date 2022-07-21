package br.com.lojacalcados.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.text.MaskFormatter;

import br.com.lojacalcados.dao.DAOCliente;
import br.com.lojacalcados.dao.DAOContato;
import br.com.lojacalcados.dao.DAODadosPessoais;
import br.com.lojacalcados.dao.DAOEndereco;
import br.com.lojacalcados.pojo.Cliente;
import br.com.lojacalcados.pojo.Contato;
import br.com.lojacalcados.pojo.DadosPessoais;
import br.com.lojacalcados.pojo.Endereco;
import javax.swing.ScrollPaneConstants;

public class TelaCliente extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomeCliente;
	private JFormattedTextField txtCPF;
	private JFormattedTextField txtDataNascimento;
	private JTextField txtEmail;
	private JFormattedTextField txtResidencial;
	private JFormattedTextField txtCelular;
	private JFormattedTextField txtComercial;
	private JTextField txtLogradouro;
	private JTextField txtNumero;
	private JTextField txtComplemento;
	private JTextField txtBairro;
	private JTextField txtCidade;
	private JTextField txtEstado;
	private JFormattedTextField txtCEP;
	private JTable table;
	
	private JScrollPane scrollPane;
	
	
	//instâncias do pojo
	private Cliente cliente = new Cliente();
	private DadosPessoais dp = new DadosPessoais();
	private Contato ct = new Contato();
	private Endereco end = new Endereco();
	//instância do dao
	private DAOCliente daocli = new DAOCliente();
	private DAODadosPessoais daodp = new DAODadosPessoais();
	private DAOContato daocontato = new DAOContato();
	private DAOEndereco daoend = new DAOEndereco();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCliente frame = new TelaCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaCliente() {
		setResizable(false);
		setTitle("Tela Clientes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1049, 823);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(248, 248, 255));
		contentPane.setBorder(new LineBorder(new Color(192, 192, 192)));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel pnlTitulo = new JPanel();
		pnlTitulo.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(100, 149, 237)));
		pnlTitulo.setBackground(new Color(248, 248, 255));
		pnlTitulo.setBounds(0, 0, 1023, 132);
		contentPane.add(pnlTitulo);
		pnlTitulo.setLayout(null);

		JLabel lblicone = new JLabel("");
		lblicone.setIcon(new ImageIcon("C:\\Users\\edilson.jsilva7\\Documents\\LojaCalcados\\imagens\\1256650.png"));
		lblicone.setBounds(10, 11, 174, 110);
		pnlTitulo.add(lblicone);

		JLabel lblTituloTela = new JLabel("Gerenciar Clientes");
		lblTituloTela.setFont(new Font("Swis721 BT", Font.PLAIN, 29));
		lblTituloTela.setBounds(194, 11, 329, 99);
		pnlTitulo.add(lblTituloTela);

		JButton btnSalvar = new JButton("Salvar");
		
		btnSalvar.setIcon(new ImageIcon("C:\\Users\\edilson.jsilva7\\Documents\\LojaCalcados\\imagens\\salve.png"));
		btnSalvar.setFont(new Font("Swis721 LtEx BT", Font.PLAIN, 18));
		btnSalvar.setBounds(686, 30, 160, 80);
		pnlTitulo.add(btnSalvar);

		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setIcon(new ImageIcon("C:\\Users\\edilson.jsilva7\\Documents\\LojaCalcados\\imagens\\lupa.png"));
		btnConsultar.setFont(new Font("Swis721 LtEx BT", Font.PLAIN, 18));
		btnConsultar.setBounds(853, 30, 160, 80);
		pnlTitulo.add(btnConsultar);

		JPanel pnlDP = new JPanel();
		pnlDP.setBounds(10, 143, 551, 168);
		contentPane.add(pnlDP);
		pnlDP.setLayout(null);

		JLabel lblNomeCliente = new JLabel("Nome do Cliente:");
		lblNomeCliente.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNomeCliente.setFont(new Font("Swis721 LtEx BT", Font.PLAIN, 14));
		lblNomeCliente.setBounds(10, 22, 176, 14);
		pnlDP.add(lblNomeCliente);

		JLabel lblCPF = new JLabel("CPF do Cliente:");
		lblCPF.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCPF.setFont(new Font("Swis721 LtEx BT", Font.PLAIN, 14));
		lblCPF.setBounds(10, 58, 176, 14);
		pnlDP.add(lblCPF);

		JLabel lblDataNascimento = new JLabel("Data de Nascimento:");
		lblDataNascimento.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDataNascimento.setFont(new Font("Swis721 LtEx BT", Font.PLAIN, 14));
		lblDataNascimento.setBounds(10, 94, 176, 14);
		pnlDP.add(lblDataNascimento);

		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSexo.setFont(new Font("Swis721 LtEx BT", Font.PLAIN, 14));
		lblSexo.setBounds(10, 130, 176, 14);
		pnlDP.add(lblSexo);

		txtNomeCliente = new JTextField();
		txtNomeCliente.setFont(new Font("Swis721 LtEx BT", Font.PLAIN, 14));
		txtNomeCliente.setBounds(196, 15, 345, 30);
		pnlDP.add(txtNomeCliente);
		txtNomeCliente.setColumns(10);

		try {
			txtCPF = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
			txtCPF.setFont(new Font("Swis721 LtEx BT", Font.PLAIN, 14));
			txtCPF.setBounds(196, 51, 144, 30);
			pnlDP.add(txtCPF);

			txtDataNascimento = new JFormattedTextField(new MaskFormatter("####-##-##"));
			txtDataNascimento.setFont(new Font("Swis721 LtEx BT", Font.PLAIN, 14));
			txtDataNascimento.setBounds(196, 87, 144, 30);
			pnlDP.add(txtDataNascimento);
		} catch (Exception e) {
			e.printStackTrace();
		}

		JComboBox cboSexo = new JComboBox();
		cboSexo.setFont(new Font("Swis721 LtEx BT", Font.PLAIN, 14));
		cboSexo.setModel(new DefaultComboBoxModel(new String[] { "Masculino", "Feminino", "Outros" }));
		cboSexo.setBounds(196, 123, 144, 30);
		pnlDP.add(cboSexo);

		JPanel pnlContato = new JPanel();
		pnlContato.setBounds(571, 143, 452, 168);
		contentPane.add(pnlContato);
		pnlContato.setLayout(null);

		JLabel lblTelefoneResidencial = new JLabel("Telefone Residencial:");
		lblTelefoneResidencial.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefoneResidencial.setFont(new Font("Swis721 LtEx BT", Font.PLAIN, 14));
		lblTelefoneResidencial.setBounds(10, 19, 157, 14);
		pnlContato.add(lblTelefoneResidencial);

		JLabel lblTelefoneCelular = new JLabel("Telefone Celular:");
		lblTelefoneCelular.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefoneCelular.setFont(new Font("Swis721 LtEx BT", Font.PLAIN, 14));
		lblTelefoneCelular.setBounds(10, 55, 157, 14);
		pnlContato.add(lblTelefoneCelular);

		JLabel lblTelefoneComercial = new JLabel("Telefone Comercial:");
		lblTelefoneComercial.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefoneComercial.setFont(new Font("Swis721 LtEx BT", Font.PLAIN, 14));
		lblTelefoneComercial.setBounds(10, 91, 157, 14);
		pnlContato.add(lblTelefoneComercial);

		JLabel lblEmail = new JLabel("E-Mail:");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setFont(new Font("Swis721 LtEx BT", Font.PLAIN, 14));
		lblEmail.setBounds(10, 127, 157, 14);
		pnlContato.add(lblEmail);

		try {
			txtResidencial = new JFormattedTextField(new MaskFormatter("(##) ####-####"));
			txtResidencial.setFont(new Font("Swis721 LtEx BT", Font.PLAIN, 14));
			txtResidencial.setBounds(177, 11, 253, 30);
			pnlContato.add(txtResidencial);

			txtCelular = new JFormattedTextField(new MaskFormatter("(##) 9####-####"));
			txtCelular.setFont(new Font("Swis721 LtEx BT", Font.PLAIN, 14));
			txtCelular.setBounds(177, 47, 253, 30);
			pnlContato.add(txtCelular);

			txtComercial = new JFormattedTextField(new MaskFormatter("(##) ####-####"));
			txtComercial.setFont(new Font("Swis721 LtEx BT", Font.PLAIN, 14));
			txtComercial.setBounds(177, 83, 253, 30);
			pnlContato.add(txtComercial);
		} catch (Exception e) {
			e.printStackTrace();
		}

		txtEmail = new JTextField();
		txtEmail.setBounds(177, 120, 253, 30);
		pnlContato.add(txtEmail);
		txtEmail.setColumns(10);
		
		JPanel pnlEndereco = new JPanel();
		pnlEndereco.setBounds(10, 322, 1013, 173);
		contentPane.add(pnlEndereco);
		pnlEndereco.setLayout(null);
		
		JLabel lblTipo = new JLabel("Tipo de Logradouro:");
		lblTipo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTipo.setFont(new Font("Swis721 LtEx BT", Font.PLAIN, 14));
		lblTipo.setBounds(10, 23, 148, 16);
		pnlEndereco.add(lblTipo);
		
		JLabel lblLogradouro = new JLabel("Logradouro:");
		lblLogradouro.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLogradouro.setFont(new Font("Swis721 LtEx BT", Font.PLAIN, 14));
		lblLogradouro.setBounds(10, 60, 148, 16);
		pnlEndereco.add(lblLogradouro);
		
		JLabel lblNumero = new JLabel("N\u00FAmero:");
		lblNumero.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumero.setFont(new Font("Swis721 LtEx BT", Font.PLAIN, 14));
		lblNumero.setBounds(10, 97, 148, 14);
		pnlEndereco.add(lblNumero);
		
		JLabel lblComplemento = new JLabel("Complemento:");
		lblComplemento.setHorizontalAlignment(SwingConstants.RIGHT);
		lblComplemento.setFont(new Font("Swis721 LtEx BT", Font.PLAIN, 14));
		lblComplemento.setBounds(10, 134, 148, 16);
		pnlEndereco.add(lblComplemento);
		
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCep.setFont(new Font("Swis721 LtEx BT", Font.PLAIN, 14));
		lblCep.setBounds(446, 23, 148, 14);
		pnlEndereco.add(lblCep);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBairro.setFont(new Font("Swis721 LtEx BT", Font.PLAIN, 14));
		lblBairro.setBounds(446, 60, 148, 14);
		pnlEndereco.add(lblBairro);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCidade.setFont(new Font("Swis721 LtEx BT", Font.PLAIN, 14));
		lblCidade.setBounds(446, 97, 148, 14);
		pnlEndereco.add(lblCidade);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEstado.setFont(new Font("Swis721 LtEx BT", Font.PLAIN, 14));
		lblEstado.setBounds(446, 134, 148, 14);
		pnlEndereco.add(lblEstado);
		
		JComboBox cboTipo = new JComboBox();
		cboTipo.setModel(new DefaultComboBoxModel(new String[] {"Rua", "Avenida", "Pra\u00E7a", "Alameda", "Viela", "Estrada", "Travessa"}));
		cboTipo.setBounds(168, 17, 148, 30);
		pnlEndereco.add(cboTipo);
		
		try {
		txtCEP = new JFormattedTextField(new MaskFormatter("#####-###"));
		txtCEP.setBounds(604, 17, 162, 30);
		pnlEndereco.add(txtCEP);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		txtLogradouro = new JTextField();
		txtLogradouro.setBounds(168, 54, 345, 30);
		pnlEndereco.add(txtLogradouro);
		txtLogradouro.setColumns(10);
		
		txtNumero = new JTextField();
		txtNumero.setColumns(10);
		txtNumero.setBounds(168, 90, 148, 30);
		pnlEndereco.add(txtNumero);
		
		txtComplemento = new JTextField();
		txtComplemento.setColumns(10);
		txtComplemento.setBounds(168, 128, 339, 30);
		pnlEndereco.add(txtComplemento);
		
		txtBairro = new JTextField();
		txtBairro.setColumns(10);
		txtBairro.setBounds(604, 54, 387, 30);
		pnlEndereco.add(txtBairro);
		
		txtCidade = new JTextField();
		txtCidade.setColumns(10);
		txtCidade.setBounds(604, 90, 387, 30);
		pnlEndereco.add(txtCidade);
		
		txtEstado = new JTextField();
		txtEstado.setColumns(10);
		txtEstado.setBounds(604, 128, 178, 30);
		pnlEndereco.add(txtEstado);
		
		JPanel pnlClientes = new JPanel();
		pnlClientes.setBounds(10, 503, 1013, 270);
		contentPane.add(pnlClientes);
		pnlClientes.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 5, 1000, 254);
		pnlClientes.add(scrollPane);
		
		carregarDados();
		
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//fazer as passagens do elementos do formulário
				//para os respectivos objetos e depois cadastrar
				end.setTipo(cboTipo.getSelectedItem().toString());
				end.setLogradouro(txtLogradouro.getText());
				end.setNumero(txtNumero.getText());
				end.setComplemento(txtComplemento.getText());
				end.setCep(txtCEP.getText());
				end.setBairro(txtBairro.getText());
				end.setCidade(txtCidade.getText());
				end.setEstado(txtEstado.getText());
				//efetuar a gravação do endereço na tabela.
				//O id gerado será alocado em uma variável
				String rse = daoend.create(end);
				
				//Passagem dos dados para o objeto contato
				ct.setTelefoneResidencial(txtResidencial.getText());
				ct.setTelefoneCelular(txtCelular.getText());
				ct.setTelefoneComercial(txtComercial.getText());
				ct.setEmail(txtEmail.getText());
				String rsc = daocontato.create(ct);
				
				//Passagem dos dados para o objeto dados pessoais
				dp.setCpf(txtCPF.getText());
				dp.setDataNascimento( Date.valueOf(txtDataNascimento.getText()));
				dp.setSexo(cboSexo.getSelectedItem().toString());
				String rsdp = daodp.create(dp);
				System.out.println(rsdp);
				
				//Passagem dos dados para o objeto cliente
				cliente.setNomeCliente(txtNomeCliente.getText());
				
				dp.setIdDadosPessoais(Long.parseLong(rsdp));
				cliente.setDadosPessoais(dp);
				
				ct.setIdContato(Long.parseLong(rsc));
				cliente.setContato(ct);
				
				end.setIdEndereco(Long.parseLong(rse));
				cliente.setEndereco(end);
				
				JOptionPane.showMessageDialog(null, daocli.create(cliente));
				
				carregarDados();
				
			}
		});
	}
	
	
	private void carregarDados() {
		//Construir o cabeçalho da tabela
		String[] cabecalho = {
				"Id do Cliente",
				"Nome do Cliente",
				"CPF",
				"Sexo",
				"Tel. Residencial",
				"Tel. Celular",
				"Tel. Comercial",
				"E-Mail",
				"Tipo",
				"Logradouro",
				"Número",
				"Complemento",
				"CEP",
				"Bairro",
				"Cidade",
				"Estado"
		};
		
		
		List<Cliente> lstcliente = new ArrayList<Cliente>();
		lstcliente = daocli.read();
		Object[] dados = new Object[16];
		DefaultTableModel tm = new DefaultTableModel(cabecalho,0);		
		for(int i = 0 ; i < lstcliente.size() ; i++) {
			
			
			dados[0] = lstcliente.get(i).getIdCliente();
			dados[1] = lstcliente.get(i).getNomeCliente();
			dados[2] = lstcliente.get(i).getDadosPessoais().getCpf();
			dados[3] = lstcliente.get(i).getDadosPessoais().getSexo();
			dados[4] = lstcliente.get(i).getContato().getTelefoneResidencial();
			dados[5] = lstcliente.get(i).getContato().getTelefoneCelular();
			dados[6] = lstcliente.get(i).getContato().getTelefoneComercial();
			dados[7] = lstcliente.get(i).getContato().getEmail();
			dados[8] = lstcliente.get(i).getEndereco().getTipo();
			dados[9] = lstcliente.get(i).getEndereco().getLogradouro();
			
			dados[10] = lstcliente.get(i).getEndereco().getNumero();
			dados[11] = lstcliente.get(i).getEndereco().getComplemento();
			dados[12] = lstcliente.get(i).getEndereco().getCep();
			dados[13] = lstcliente.get(i).getEndereco().getBairro();
			dados[14] = lstcliente.get(i).getEndereco().getCidade();
			dados[15] = lstcliente.get(i).getEndereco().getEstado();
			
			tm.addRow(dados);			
		}
		
		table = new JTable(tm);
			
		
		
		scrollPane.setViewportView(table);
	}
	
	
	
	
	
}












