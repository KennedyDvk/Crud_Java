package br.com.fiap.fin.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.fiap.fin.jdbc.FintechDbManager;
import br.com.fiap.fintech.bean.Pessoa;
import br.com.fiap.fintech.dao.PessoaDAO;
import br.com.fiap.fintech.exception.DBException;

public class OraclePessoaDAOImpl implements PessoaDAO {
	
	private Connection conexao;
	PreparedStatement pstmt = null;
	
	
	@Override
	public void cadastrar(Pessoa pessoa) throws DBException {
		
		try {
			conexao = FintechDbManager.obterConexao();
			
			
			PreparedStatement pstmt = conexao
					.prepareStatement("INSERT INTO T_FIN_PESSOA "
							+ "(ID_USUARIO, NM_USUARIO, NR_RG, NR_CPF, DT_NASCIMENTO) "
							+ "VALUES (SEQ_T_USUARIO.NEXTVAL, ?, ?, ?, ?)");
			
			
			pstmt.setString(1, pessoa.getNome());
			pstmt.setString(2, pessoa.getNumeroRg());
			pstmt.setString(3, pessoa.getNumeroCpf());
			pstmt.setDate(4, new java.sql.Date(pessoa.getDataNascimento().getTimeInMillis()));
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao Cadastrar.");
		} finally {
			try {
				
				
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
}		
	
	
	@Override
	public List<Pessoa> buscarTodos() {
		
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		ResultSet rs = null;
		try {
			
			conexao = FintechDbManager.obterConexao();
			pstmt = conexao.prepareStatement("SELECT * FROM T_FIN_PESSOA");
			rs = pstmt.executeQuery();
		
		
			//Percorre todos os Registros encontrados
			while (rs.next()) {
				java.sql.Date data = rs.getDate("DT_NASCIMENTO");
				Calendar dtNascimento = Calendar.getInstance();
				dtNascimento.setTimeInMillis(data.getTime());
				
				//Cria um objeto Pessoa com as informaçoes encontradas
				Pessoa pessoa = new Pessoa(rs.getInt("ID_USUARIO"), rs.getString("NM_USUARIO"), rs.getString("NR_RG"), 
						rs.getString("NR_CPF"), dtNascimento);
				
				//Adciona a Pessoa na lista
				 pessoas.add(pessoa);
		
			}
		
		
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				
				pstmt.close();
				rs.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return pessoas;
		
	}
	
	
	@Override
	public Pessoa BuscarTodosPorCodigo(int codigo) {
		
		return null;
	}
	
	
	@Override
	public void atualizar(Pessoa pessoa) throws DBException {
		
		try {
		conexao = FintechDbManager.obterConexao();
		pstmt = conexao.prepareStatement("UPDATE T_FIN_PESSOA SET NM_USUARIO = ?, NR_RG = ?, NR_CPF = ?, DT_NASCIMENTO = ? WHERE ID_USUARIO = ?");
		pstmt.setString(1, pessoa.getNome());
		pstmt.setString(2, pessoa.getNumeroRg());
		pstmt.setString(3, pessoa.getNumeroCpf());
		pstmt.setDate(4, new java.sql.Date (pessoa.getDataNascimento().getTimeInMillis()));
		pstmt.setInt(5, pessoa.getCodigo());
		pstmt.executeUpdate();
		
	}catch (SQLException e) {
		e.printStackTrace();
		throw new DBException("Erro ao Atualizar.");
	} finally {
		try {
			
			pstmt.close();
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		
}	
	
	
	@Override
	public void remover(int codigo) throws DBException {
		
		try {
		Connection conexao = FintechDbManager.obterConexao();
		pstmt = conexao.prepareStatement("DELETE FROM T_FIN_PESSOA WHERE ID_USUARIO = ?");
		pstmt.setInt(1, codigo);
		pstmt.executeUpdate();
		pstmt.executeUpdate();
		
	   }catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao Remover.");
		} finally {
			try {
				
				pstmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
