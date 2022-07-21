package br.com.lojacalcados.dao;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.lojacalcados.crud.ICRUsuario;
import br.com.lojacalcados.pojo.Contato;
import br.com.lojacalcados.pojo.Usuario;

public class DAOUsuario extends Conexao implements ICRUsuario {

	@Override
	public String create(Usuario obj) {
		String msg = "";
		try {
			if(abrirBanco()) {
				String query = "Insert Into usuario(nomeusuario,senha,nivelacesso)values(?,?,?)";
				pst = cx.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
				
				pst.setString(1, obj.getNomeUsuario());
				pst.setString(2, obj.getSenha());
				pst.setString(3,obj.getNivelAcesso());				
				
				//Executar o cadastro no banco
				int r = pst.executeUpdate();
				rs = pst.getGeneratedKeys();
				if(r>0) {
					if(rs.next()) {
						msg =String.valueOf(rs.getLong(1));
					}
				}
				else 
					msg = "Não foi possível cadastrar";				
			}else {
				msg = "Erro ao abrir o banco";
			}
		}
		catch(SQLException se) {
			msg = "Erro ao tentar cadastrar -> "+se.getMessage();
		}
		catch(Exception e) {
			msg = "Erro inesperado -> "+e.getMessage();
		}
		finally {
			fecharBanco();
		}
		return msg;
	}
	

	@Override
	public Usuario read(Usuario obj) {
		Usuario usuario = new Usuario();
		
		try {
			if(abrirBanco()) {
				String query = "SELECT * FROM usuario WHERE nomeusuario=?";
				pst = cx.prepareStatement(query);
				
				pst.setString(1, obj.getNomeUsuario());
				
				rs = pst.executeQuery();
				if(rs.next()) {
					usuario.setIdUsuario(rs.getLong(1));
					usuario.setNomeUsuario(rs.getString(2));
					usuario.setNivelAcesso(rs.getString(3));
					usuario.setCriadoEm(rs.getDate(4));
					
				}
				else {
					System.out.println("Usuário não localizado");
				}
			}
			else {
				System.out.println("Erro ao abrir o banco");
			}
		}
		catch(SQLException se) {
			System.out.println("Erro ao tentar selecionar -> "+se.getMessage());
		}
		catch(Exception e) {
			System.out.println("Erro inesperado -> "+e.getMessage());
		}
		finally {
			fecharBanco();
		}
		return usuario;
	}

	@Override
	public List<Usuario> read() {
		
		List<Usuario> lst = new ArrayList<Usuario>();
		
		try {
			if(abrirBanco()) {
				String query = "SELECT * FROM usuario";
				pst = cx.prepareStatement(query);
				rs = pst.executeQuery();
				while(rs.next()) {
					
					Usuario usuario = new Usuario();
					
					usuario.setIdUsuario(rs.getLong(1));
					usuario.setNomeUsuario(rs.getString(2));
					usuario.setNivelAcesso(rs.getString(3));
					usuario.setCriadoEm(rs.getDate(4));
					
					lst.add(usuario);
				}
			}
			else {
				System.out.println("Erro ao abrir o banco");
			}
		}
		catch(SQLException se) {
			System.out.println("Erro ao tentar selecionar -> "+se.getMessage());
		}
		catch(Exception e) {
			System.out.println("Erro inesperado -> "+e.getMessage());
		}
		finally {
			fecharBanco();
		}
		return lst;	
	}

	@Override
	public String alterarSenha(Usuario user) {
		
		String msg = "";
		
		try {
			
			if(abrirBanco()) {
				
				String query = "UPDATE usuario set senha = ? where nomeusuario=?";
				
				pst = cx.prepareStatement(query);
				
				pst.setString(1, user.getSenha());
				pst.setString(2, user.getNomeUsuario());
				
				
				int rs = pst.executeUpdate();
				if(rs > 0) {
					msg = "Dados atualizados";
				}
				else {
					msg = "Não foi possível atualizar";
				}
			}
			else {
				msg = "Não foi possível abrir o banco";
			}
			
		}
		catch(SQLException se) {
			msg = "Erro ao tentar atualizar -> "+se.getMessage();
		}
		catch(Exception e) {
			msg = "Erro inesperado -> "+e.getMessage();
		}
		finally {
			fecharBanco();
		}
		return msg;	
	}

	@Override
	public String login(Usuario user) {
		String msg = "";
		
		try {
			if(abrirBanco()) {
				String query = "SELECT * FROM usuario WHERE nomeusuario=? and senha=?";
				pst = cx.prepareStatement(query);
				
				pst.setString(1, user.getNomeUsuario());
				pst.setString(2, user.getSenha());
				
				rs = pst.executeQuery();
				if(rs.next()) {
					msg = "Usuário loagdo";
					
				}
				else {
					msg = "Usuário ou senha incorretos.";
				}
			}
			else {
				msg = "Erro ao abrir o banco";
			}
		}
		catch(SQLException se) {
			msg = "Erro ao tentar selecionar -> "+se.getMessage();
		}
		catch(Exception e) {
			msg = "Erro inesperado -> "+e.getMessage();
		}
		finally {
			fecharBanco();
		}
		return msg;
	}

}
