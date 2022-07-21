package br.com.lojacalcados.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.lojacalcados.crud.ICR;
import br.com.lojacalcados.pojo.Cliente;
import br.com.lojacalcados.pojo.Contato;
import br.com.lojacalcados.pojo.DadosPessoais;
import br.com.lojacalcados.pojo.Endereco;

public class DAOCliente extends Conexao implements ICR<Cliente> {

	@Override
	public String create(Cliente obj) {
		String msg = "";

		try {
			if (abrirBanco()) {
				String query = "INSERT INTO cliente(nomecliente,iddadospessoais,idendereco,idcontato) values (?,?,?,?)";
				pst = cx.prepareStatement(query);// prepara a consulta para ser executada(Aloca em memória)
				pst.setString(1, obj.getNomeCliente());
				pst.setLong(2, obj.getDadosPessoais().getIdDadosPessoais());
				pst.setLong(3, obj.getEndereco().getIdEndereco());
				pst.setLong(4, obj.getContato().getIdContato());

				int r = pst.executeUpdate();
				if (r > 0) {
					msg = "Cadastro efetuado com sucesso!";
				} else {
					msg = "Não foi cadastrado.";
				}
			}
		} catch (SQLException se) {
			msg = "Erro ao tentar cadastrar -> " + se.getMessage();
		} catch (Exception e) {
			msg = "Erro inesperado -> " + e.getMessage();
		} finally {
			fecharBanco();
		}

		return msg;
	}

	@Override
	public Cliente read(Cliente obj) {
		Cliente cliente = new Cliente();

		try {
			if (abrirBanco()) {
				String query = "SELECT * FROM cliente WHERE idCliente = ?";
				pst = cx.prepareStatement(query);
				pst.setLong(1, obj.getIdCliente());

				rs = pst.executeQuery();
				if (rs.next()) {
					cliente.setIdCliente(rs.getLong(1));
					cliente.setNomeCliente(rs.getString(2));

					cliente.getDadosPessoais().setIdDadosPessoais(rs.getLong(3));

					cliente.getEndereco().setIdEndereco(rs.getLong(4));

					cliente.getContato().setIdContato(rs.getLong(5));
				}
			}
		} catch (SQLException se) {
			System.out.println("Erro ao tentar executar a consulta -> " + se.getMessage());
		} catch (Exception e) {
			System.out.println("Erro inesperado -> " + e.getMessage());
		} finally {
			fecharBanco();
		}
		return cliente;
	}

	@Override
	public List<Cliente> read() {
		
		
		List<Cliente> lst = new ArrayList<Cliente>();

		try {
			if (abrirBanco()) {
				String query = "SELECT  "
						+ "	cliente.idCliente, "
						+ "    cliente.nomeCliente, "
						+ "    dp.cpf, "
						+ "    dp.sexo, "
						+ "    contato.telefoneResidencial, "
						+ "    contato.telefoneCelular, "
						+ "    contato.telefoneComercial, "
						+ "    contato.email, "
						+ "    endereco.tipo, "
						+ "    endereco.logradouro, "
						+ "    endereco.numero, "
						+ "    endereco.complemento,"
						+ "    endereco.cep, "
						+ "    endereco.bairro, "
						+ "    endereco.cidade, "
						+ "    endereco.estado "
						+ "    from cliente inner join contato  "
						+ "    on cliente.idcontato = contato.idcontato  "
						+ "    inner join endereco on endereco.idendereco = cliente.idendereco  "
						+ "    inner join dadospessoais dp on dp.iddadospessoais = cliente.iddadospessoais";
				pst = cx.prepareStatement(query);
				
				rs = pst.executeQuery();
				while(rs.next()) {
					
					Cliente cliente = new Cliente();
					DadosPessoais dp = new DadosPessoais();
					Contato ct = new Contato();
					Endereco end = new Endereco();
					
					cliente.setIdCliente(rs.getLong(1));
					cliente.setNomeCliente(rs.getString(2));

					dp.setCpf(rs.getString(3));
					dp.setSexo(rs.getString(4));
					
					ct.setTelefoneResidencial(rs.getString(5));
					ct.setTelefoneCelular(rs.getString(6));
					ct.setTelefoneComercial(rs.getString(7));
					ct.setEmail(rs.getString(8));
					
					end.setTipo(rs.getString(9));
					end.setLogradouro(rs.getString(10));
					end.setNumero(rs.getString(11));
					end.setComplemento(rs.getString(12));
					end.setCep(rs.getString(13));
					end.setBairro(rs.getString(14));
					end.setCidade(rs.getString(15));
					end.setEstado(rs.getString(16));
					
					cliente.setDadosPessoais(dp);
					cliente.setContato(ct);
					cliente.setEndereco(end);
					
					lst.add(cliente);
				}
			}
		} catch (SQLException se) {
			System.out.println("Erro ao tentar executar a consulta -> " + se.getMessage());
		} catch (Exception e) {
			System.out.println("Erro inesperado -> " + e.getMessage());
		} finally {
			fecharBanco();
		}
		return lst;
	}

}
