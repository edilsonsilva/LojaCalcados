package br.com.lojacalcados.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.lojacalcados.crud.ICR;
import br.com.lojacalcados.pojo.Funcionario;

public class DAOFuncionario extends Conexao implements ICR<Funcionario>{

	@Override
	public String create(Funcionario obj) {

		String msg = "";
		
		try {
			if(abrirBanco()) {
				String query = "INSERT INTO funcionario("
						+ "nomefuncionario,"
						+ "cargo,"
						+ "setor,"
						+ "gestor,"
						+ "expediente,"
						+ "foto,"
						+ "iddadospessoais,"
						+ "idendereco,"
						+ "idcontato,"
						+ "idusuario) values (?,?,?,?,?,?,?,?,?,?)";
				pst = cx.prepareStatement(query);
				pst.setString(1, obj.getNomeFuncionario());
				pst.setString(2, obj.getCargo());
				pst.setString(3, obj.getSetor());
				pst.setLong(4, obj.getGestor());
				pst.setString(5, obj.getExpediente());
				pst.setString(6, obj.getFoto());
				pst.setLong(7, obj.getDadosPessoais().getIdDadosPessoais());
				pst.setLong(8, obj.getEndereco().getIdEndereco());
				pst.setLong(9, obj.getContato().getIdContato());
				pst.setLong(10, obj.getUsuario().getIdUsuario());
				
				int r = pst.executeUpdate();
				if(r > 0)
					msg = "Cadastro realizados com sucesso!";
				else
					msg = "Não cadastrou";
			}
		}
		catch(SQLException se) {
			msg = "Erro na consulta -> "+se.getMessage();
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
	public Funcionario read(Funcionario obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Funcionario> read() {
		// TODO Auto-generated method stub
		return null;
	}

}
