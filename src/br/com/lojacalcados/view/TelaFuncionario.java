package br.com.lojacalcados.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import br.com.lojacalcados.dao.DAOContato;
import br.com.lojacalcados.dao.DAODadosPessoais;
import br.com.lojacalcados.dao.DAOEndereco;
import br.com.lojacalcados.dao.DAOFuncionario;
import br.com.lojacalcados.dao.DAOUsuario;
import br.com.lojacalcados.pojo.Contato;
import br.com.lojacalcados.pojo.DadosPessoais;
import br.com.lojacalcados.pojo.Endereco;
import br.com.lojacalcados.pojo.Funcionario;
import br.com.lojacalcados.pojo.Usuario;

public class TelaFuncionario extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomeFuncionario;
	private JTextField txtEmail;
	private JTextField txtLogradouro;
	private JTextField txtNumero;
	private JTextField txtComplemento;
	private JTextField txtBairro;
	private JTextField txtCidade;
	private JTextField txtEstado;
	private JTextField txtCargo;
	private JTextField txtSetor;
	private JTextField txtGestor;
	private JTextField txtUsuario;
	private JPasswordField txtSenha;
	private JTextField txtNivelAcesso;
	private JFormattedTextField txtCEP;
	private JFormattedTextField txtResidencial;
	private JFormattedTextField txtCelular;
	private JFormattedTextField txtComercial;
	private JFormattedTextField txtDataNascimento;
	private JFormattedTextField txtCPF;
	
	//Instância dos pojos
	private Funcionario funcionario = new Funcionario();
	private DadosPessoais dp = new DadosPessoais();
	private Contato ct = new Contato();
	private Endereco end = new Endereco();
	private Usuario us = new Usuario();
	
	//Instância dos DAOS
	private DAODadosPessoais daodp = new DAODadosPessoais();
	private DAOContato daoct = new DAOContato();
	private DAOEndereco daoend = new DAOEndereco();
	private DAOUsuario daous = new DAOUsuario();
	private DAOFuncionario daofun = new DAOFuncionario();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaFuncionario frame = new TelaFuncionario();
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
	public TelaFuncionario() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\edilson.jsilva7\\Documents\\LojaCalcados\\imagens\\user.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1082, 727);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(220, 220, 220));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pnlDP = new JPanel();
		pnlDP.setBackground(new Color(255, 255, 255));
		pnlDP.setLayout(null);
		pnlDP.setBounds(24, 158, 1013, 235);
		contentPane.add(pnlDP);
		
		JLabel lblNomeFuncionario = new JLabel("Nome do Funcionario");
		lblNomeFuncionario.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNomeFuncionario.setFont(new Font("Swis721 LtEx BT", Font.PLAIN, 14));
		lblNomeFuncionario.setBounds(10, 22, 176, 14);
		pnlDP.add(lblNomeFuncionario);
		
		JLabel lblCPF = new JLabel("CPF do Funcionario");
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
		
		txtNomeFuncionario = new JTextField();
		txtNomeFuncionario.setFont(new Font("Swis721 LtEx BT", Font.PLAIN, 14));
		txtNomeFuncionario.setColumns(10);
		txtNomeFuncionario.setBounds(196, 15, 345, 30);
		pnlDP.add(txtNomeFuncionario);
		
		try {
		txtCPF = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		txtCPF.setFont(new Font("Swis721 LtEx BT", Font.PLAIN, 14));
		txtCPF.setBounds(196, 51, 144, 30);
		pnlDP.add(txtCPF);
		
		
		
		txtDataNascimento = new JFormattedTextField(new MaskFormatter("####-##-##"));
		txtDataNascimento.setFont(new Font("Swis721 LtEx BT", Font.PLAIN, 14));
		txtDataNascimento.setBounds(196, 87, 144, 30);
		pnlDP.add(txtDataNascimento);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		JComboBox cboSexo = new JComboBox();
		cboSexo.setModel(new DefaultComboBoxModel(new String[] {"Masculino", "Feminino", "Outros"}));
		cboSexo.setFont(new Font("Swis721 LtEx BT", Font.PLAIN, 14));
		cboSexo.setBounds(196, 123, 144, 30);
		pnlDP.add(cboSexo);
		
		JLabel lblCargo = new JLabel("Cargo:");
		lblCargo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCargo.setFont(new Font("Swis721 LtEx BT", Font.PLAIN, 14));
		lblCargo.setBounds(551, 22, 75, 14);
		pnlDP.add(lblCargo);
		
		txtCargo = new JTextField();
		txtCargo.setFont(new Font("Swis721 LtEx BT", Font.PLAIN, 14));
		txtCargo.setColumns(10);
		txtCargo.setBounds(636, 14, 178, 30);
		pnlDP.add(txtCargo);
		
		JLabel lblSetor = new JLabel("Setor:");
		lblSetor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSetor.setFont(new Font("Swis721 LtEx BT", Font.PLAIN, 14));
		lblSetor.setBounds(551, 59, 75, 14);
		pnlDP.add(lblSetor);
		
		txtSetor = new JTextField();
		txtSetor.setFont(new Font("Swis721 LtEx BT", Font.PLAIN, 14));
		txtSetor.setColumns(10);
		txtSetor.setBounds(636, 51, 178, 30);
		pnlDP.add(txtSetor);
		
		JLabel lblGestor = new JLabel("Gestor:");
		lblGestor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGestor.setFont(new Font("Swis721 LtEx BT", Font.PLAIN, 14));
		lblGestor.setBounds(551, 95, 75, 14);
		pnlDP.add(lblGestor);
		
		txtGestor = new JTextField();
		txtGestor.setFont(new Font("Swis721 LtEx BT", Font.PLAIN, 14));
		txtGestor.setColumns(10);
		txtGestor.setBounds(636, 87, 178, 30);
		pnlDP.add(txtGestor);
		
		JLabel lblExpediente = new JLabel("Expediente:");
		lblExpediente.setHorizontalAlignment(SwingConstants.RIGHT);
		lblExpediente.setFont(new Font("Swis721 LtEx BT", Font.PLAIN, 14));
		lblExpediente.setBounds(528, 131, 98, 14);
		pnlDP.add(lblExpediente);
		
		JFormattedTextField txtExpediente = new JFormattedTextField();
		txtExpediente.setBounds(636, 123, 178, 30);
		pnlDP.add(txtExpediente);
		
		JLabel lblFoto = new JLabel("Foto do Funcion\u00E1rio");
		lblFoto.setBackground(new Color(255, 255, 255));
		lblFoto.setBounds(861, 15, 129, 138);
		pnlDP.add(lblFoto);
		
		JButton btnFoto = new JButton("");
		btnFoto.setIcon(new ImageIcon("C:\\Users\\edilson.jsilva7\\Documents\\LojaCalcados\\imagens\\camera.png"));
		btnFoto.setBounds(911, 158, 35, 23);
		pnlDP.add(btnFoto);
		
		JLabel lblUsuario = new JLabel("Usu\u00E1rio:");
		lblUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsuario.setFont(new Font("Swis721 LtEx BT", Font.PLAIN, 14));
		lblUsuario.setBounds(83, 201, 98, 14);
		pnlDP.add(lblUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setFont(new Font("Swis721 LtEx BT", Font.PLAIN, 14));
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(191, 194, 169, 30);
		pnlDP.add(txtUsuario);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSenha.setFont(new Font("Swis721 LtEx BT", Font.PLAIN, 14));
		lblSenha.setBounds(370, 201, 68, 14);
		pnlDP.add(lblSenha);
		
		txtSenha = new JPasswordField();
		txtSenha.setBounds(448, 194, 169, 30);
		pnlDP.add(txtSenha);
		
		JLabel lblNivelAcesso = new JLabel("N\u00EDvel Acesso:");
		lblNivelAcesso.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNivelAcesso.setFont(new Font("Swis721 LtEx BT", Font.PLAIN, 14));
		lblNivelAcesso.setBounds(631, 201, 98, 14);
		pnlDP.add(lblNivelAcesso);
		
		txtNivelAcesso = new JTextField();
		txtNivelAcesso.setFont(new Font("Swis721 LtEx BT", Font.PLAIN, 14));
		txtNivelAcesso.setColumns(10);
		txtNivelAcesso.setBounds(739, 194, 169, 30);
		pnlDP.add(txtNivelAcesso);
		
		JPanel pnlContato = new JPanel();
		pnlContato.setBackground(new Color(255, 255, 255));
		pnlContato.setLayout(null);
		pnlContato.setBounds(24, 402, 1013, 91);
		contentPane.add(pnlContato);
		
		JLabel lblTelefoneResidencial = new JLabel("Telefone Residencial:");
		lblTelefoneResidencial.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefoneResidencial.setFont(new Font("Swis721 LtEx BT", Font.PLAIN, 14));
		lblTelefoneResidencial.setBounds(10, 19, 157, 14);
		pnlContato.add(lblTelefoneResidencial);
		
		JLabel lblTelefoneCelular = new JLabel("Telefone Celular:");
		lblTelefoneCelular.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefoneCelular.setFont(new Font("Swis721 LtEx BT", Font.PLAIN, 14));
		lblTelefoneCelular.setBounds(440, 19, 157, 14);
		pnlContato.add(lblTelefoneCelular);
		
		JLabel lblTelefoneComercial = new JLabel("Telefone Comercial:");
		lblTelefoneComercial.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefoneComercial.setFont(new Font("Swis721 LtEx BT", Font.PLAIN, 14));
		lblTelefoneComercial.setBounds(10, 58, 157, 14);
		pnlContato.add(lblTelefoneComercial);
		
		JLabel lblEmail = new JLabel("E-Mail:");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setFont(new Font("Swis721 LtEx BT", Font.PLAIN, 14));
		lblEmail.setBounds(440, 57, 157, 14);
		pnlContato.add(lblEmail);
		

		try {
		txtResidencial = new JFormattedTextField(new MaskFormatter("(##) ####-####"));
		txtResidencial.setFont(new Font("Swis721 LtEx BT", Font.PLAIN, 14));
		txtResidencial.setBounds(177, 11, 253, 30);
		pnlContato.add(txtResidencial);
		
		txtCelular = new JFormattedTextField(new MaskFormatter("(##) 9####-####"));
		txtCelular.setFont(new Font("Swis721 LtEx BT", Font.PLAIN, 14));
		txtCelular.setBounds(607, 11, 253, 30);
		pnlContato.add(txtCelular);
		
		txtComercial = new JFormattedTextField(new MaskFormatter("(##) ####-####"));
		txtComercial.setFont(new Font("Swis721 LtEx BT", Font.PLAIN, 14));
		txtComercial.setBounds(177, 50, 253, 30);
		pnlContato.add(txtComercial);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(607, 50, 253, 30);
		pnlContato.add(txtEmail);
		
		JPanel pnlEndereco = new JPanel();
		pnlEndereco.setBackground(new Color(255, 255, 255));
		pnlEndereco.setLayout(null);
		pnlEndereco.setBounds(24, 504, 1013, 173);
		contentPane.add(pnlEndereco);
		
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
		cboTipo.setBounds(168, 17, 148, 30);
		cboTipo.setModel(new DefaultComboBoxModel(new String[] {"Rua", "Avenida", "Pra\u00E7a", "Alameda", "Viela", "Estrada", "Travessa"}));
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
		txtLogradouro.setColumns(10);
		txtLogradouro.setBounds(168, 54, 345, 30);
		pnlEndereco.add(txtLogradouro);
		
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
		
		JPanel pnlTitulo = new JPanel();
		pnlTitulo.setBackground(new Color(255, 255, 255));
		pnlTitulo.setBounds(0, 0, 1066, 147);
		contentPane.add(pnlTitulo);
		pnlTitulo.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\edilson.jsilva7\\Documents\\LojaCalcados\\imagens\\user.png"));
		lblNewLabel.setBounds(0, 0, 136, 147);
		pnlTitulo.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tela de Cadastro dos Funcion\u00E1rios");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblNewLabel_1.setBounds(175, 46, 579, 64);
		pnlTitulo.add(lblNewLabel_1);
		
		JButton btnSalvar = new JButton("Salvar");
		
		btnSalvar.setIcon(new ImageIcon("C:\\Users\\edilson.jsilva7\\Documents\\LojaCalcados\\imagens\\salve.png"));
		btnSalvar.setFont(new Font("Swis721 LtEx BT", Font.PLAIN, 18));
		btnSalvar.setBounds(729, 30, 160, 80);
		pnlTitulo.add(btnSalvar);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setIcon(new ImageIcon("C:\\Users\\edilson.jsilva7\\Documents\\LojaCalcados\\imagens\\lupa.png"));
		btnConsultar.setFont(new Font("Swis721 LtEx BT", Font.PLAIN, 18));
		btnConsultar.setBounds(896, 30, 160, 80);
		pnlTitulo.add(btnConsultar);
		
		
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Passagem dos dados para o objeto endereco
				end.setTipo(cboTipo.getSelectedItem().toString());
				end.setLogradouro(txtLogradouro.getText());
				end.setNumero(txtNumero.getText());
				end.setComplemento(txtComplemento.getText());
				end.setCep(txtCEP.getText());
				end.setBairro(txtBairro.getText());
				end.setCidade(txtCidade.getText());
				end.setEstado(txtEstado.getText());
				String rsend = daoend.create(end);
				end.setIdEndereco(Long.parseLong(rsend));
				
				//Passagem dos dados para o objeto contato
				ct.setTelefoneResidencial(txtResidencial.getText());
				ct.setTelefoneCelular(txtCelular.getText());
				ct.setTelefoneComercial(txtComercial.getText());
				ct.setEmail(txtEmail.getText());
				String rsct = daoct.create(ct);
				ct.setIdContato(Long.parseLong(rsct));
				
				//Passagem dos dados para o objeto DadosPessoais
				dp.setCpf(txtCPF.getText());
				dp.setSexo(cboSexo.getSelectedItem().toString());
				dp.setDataNascimento(Date.valueOf(txtDataNascimento.getText()));
				String rsdp = daodp.create(dp);
				dp.setIdDadosPessoais(Long.parseLong(rsdp));
				
				//Passagem dos dados para o objeto Usuario
				us.setNomeUsuario(txtUsuario.getText());
				us.setSenha(txtSenha.getText());
				us.setNivelAcesso(txtNivelAcesso.getText());
				String rsus = daous.create(us);
				us.setIdUsuario(Long.parseLong(rsus));
				
				//Passagem dos dados para o objeto Funcionario
				funcionario.setNomeFuncionario(txtNomeFuncionario.getText());
				funcionario.setCargo(txtCargo.getText());
				funcionario.setSetor(txtSetor.getText());
				funcionario.setGestor(Long.parseLong(txtGestor.getText()));
				funcionario.setExpediente(txtExpediente.getText());
				funcionario.setFoto("funcionario.jpg");
				funcionario.setDadosPessoais(dp);
				funcionario.setEndereco(end);
				funcionario.setContato(ct);
				funcionario.setUsuario(us);
				JOptionPane.showMessageDialog(null, daofun.create(funcionario));
		
			}
		});
		
		
	}
}


