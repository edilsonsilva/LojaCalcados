package br.com.lojacalcados.dao;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.lojacalcados.crud.ICR;
import br.com.lojacalcados.pojo.Endereco;
import br.com.lojacalcados.pojo.Usuario;

public class DAOEndereco extends Conexao implements ICR<Endereco>{

	@Override
	public String create(Endereco obj) {
		String msg = "";
		try {
			if(abrirBanco()) {
				String query = "Insert Into endereco(tipo,logradouro,numero,complemento,cep,bairro,cidade,estado)values(?,?,?,?,?,?,?,?)";
				pst = cx.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
				
				pst.setString(1, obj.getTipo());
				pst.setString(2, obj.getLogradouro());
				pst.setString(3,obj.getNumero());		
				pst.setString(4,obj.getComplemento());		
				pst.setString(5,obj.getCep());		
				pst.setString(6,obj.getBairro());		
				pst.setString(7,obj.getCidade());		
				pst.setString(8,obj.getEstado());		
						
				
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
	public Endereco read(Endereco obj) {
		Endereco endereco = new Endereco();
		
		try {
			if(abrirBanco()) {
				String query = "SELECT * FROM endereco WHERE idendereco=?";
				pst = cx.prepareStatement(query);
				
				pst.setLong(1, obj.getIdEndereco());
				
				rs = pst.executeQuery();
				if(rs.next()) {
					endereco.setIdEndereco(rs.getLong(1));
					endereco.setTipo(rs.getString(2));
					endereco.setLogradouro(rs.getString(3));
					endereco.setNumero(rs.getString(4));		
					endereco.setComplemento(rs.getString(5));		
					endereco.setCep(rs.getString(6));		
					endereco.setBairro(rs.getString(7));		
					endereco.setCidade(rs.getString(8));		
					endereco.setEstado(rs.getString(9));	
					
				}
				else {
					System.out.println("Endereço não localizado");
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
		return endereco;
	}

	@Override
	public List<Endereco> read() {
		List<Endereco> lst = new ArrayList<Endereco>();
		
		try {
			if(abrirBanco()) {
				String query = "SELECT * FROM endereco";
				pst = cx.prepareStatement(query);
				rs = pst.executeQuery();
				while(rs.next()) {
					
					Endereco endereco = new Endereco();
					
					endereco.setIdEndereco(rs.getLong(1));
					endereco.setTipo(rs.getString(2));
					endereco.setLogradouro(rs.getString(3));
					endereco.setNumero(rs.getString(4));		
					endereco.setComplemento(rs.getString(5));		
					endereco.setCep(rs.getString(6));		
					endereco.setBairro(rs.getString(7));		
					endereco.setCidade(rs.getString(8));		
					endereco.setEstado(rs.getString(9));	
					
					lst.add(endereco);
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

}
