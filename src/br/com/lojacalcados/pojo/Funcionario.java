package br.com.lojacalcados.pojo;

import java.util.Date;

public class Funcionario {
	private Long idFuncionario;
	private String nomeFuncionario;
	private String cargo;
	private String setor;
	private Long gestor;
	private String expediente;
	private String foto;
	private DadosPessoais dadosPessoais;
	private Endereco endereco;
	private Contato contato;
	private Usuario usuario;
	
	
	public Funcionario() {
	}


	public Funcionario(Long idFuncionario, String nomeFuncionario, String cargo, String setor, Long gestor,
			String expediente, String foto, DadosPessoais dadosPessoais, Endereco endereco, Contato contato,
			Usuario usuario) {
		this.idFuncionario = idFuncionario;
		this.nomeFuncionario = nomeFuncionario;
		this.cargo = cargo;
		this.setor = setor;
		this.gestor = gestor;
		this.expediente = expediente;
		this.foto = foto;
		this.dadosPessoais = dadosPessoais;
		this.endereco = endereco;
		this.contato = contato;
		this.usuario = usuario;
	}


	public Long getIdFuncionario() {
		return idFuncionario;
	}


	public void setIdFuncionario(Long idFuncionario) {
		this.idFuncionario = idFuncionario;
	}


	public String getNomeFuncionario() {
		return nomeFuncionario;
	}


	public void setNomeFuncionario(String nomeFuncionario) {
		this.nomeFuncionario = nomeFuncionario;
	}


	public String getCargo() {
		return cargo;
	}


	public void setCargo(String cargo) {
		this.cargo = cargo;
	}


	public String getSetor() {
		return setor;
	}


	public void setSetor(String setor) {
		this.setor = setor;
	}


	public Long getGestor() {
		return gestor;
	}


	public void setGestor(Long gestor) {
		this.gestor = gestor;
	}


	public String getExpediente() {
		return expediente;
	}


	public void setExpediente(String expediente) {
		this.expediente = expediente;
	}


	public String getFoto() {
		return foto;
	}


	public void setFoto(String foto) {
		this.foto = foto;
	}


	public DadosPessoais getDadosPessoais() {
		return dadosPessoais;
	}


	public void setDadosPessoais(DadosPessoais dadosPessoais) {
		this.dadosPessoais = dadosPessoais;
	}


	public Endereco getEndereco() {
		return endereco;
	}


	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}


	public Contato getContato() {
		return contato;
	}


	public void setContato(Contato contato) {
		this.contato = contato;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


		
}
