package br.com.fiap.fintech.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.fin.jdbc.FintechDbManager;
import br.com.fiap.fintech.bean.Conta;


public class ContaDAOImpl implements ContaDAO {
	

		
		private Connection conexao;
		PreparedStatement pstmt = null;
		
		@Override
		public void adcionar(Conta conta) {
			
			try {
				conexao = FintechDbManager.obterConexao();
				
				
				PreparedStatement pstmt = conexao
						.prepareStatement("INSERT INTO T_FIN_CONTA_PESSOA"
								+ "(ID_CONTA, DS_EMAIL, DS_SENHA, NR_TELEFONE) "
								+ "VALUES (SEQ_F_PESSOA.NEXTVAL, ?, ?, ?)");
				
				
				pstmt.setString(1, conta.getEmail());
				pstmt.setString(2, conta.getSenha());
				pstmt.setInt(3, conta.getnumeroTelefone());
				pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					
					
					conexao.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
	}		
		
		
		public List<Conta> listartodos() {
			
			List<Conta> contas = new ArrayList<Conta>();
			ResultSet rs = null;
			try {
				
				conexao = FintechDbManager.obterConexao();
				pstmt = conexao.prepareStatement("SELECT * FROM T_FIN_CONTA_PESSOA");
				rs = pstmt.executeQuery();
			
			
				//Percorre todos os Registros encontrados
				while (rs.next()) {
					
					
					//Cria um objeto Pessoa com as informaçoes encontradas
					Conta conta = new Conta(rs.getInt("ID_CONTA"), rs.getString("DS_EMAIL"), rs.getString("DS_SENHA"), 
							rs.getInt("NR_TELEFONE"));
					
					//Adciona a Pessoa na lista
					 contas.add(conta);
			
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
			return contas;
			
		}
		
		@Override
		public Conta BuscarTodosAsContasPorCodigo(int codigo) {
			
			return null;
		}
		
		@Override
		public void atualizarConta(Conta conta) {
			
			try {
			conexao = FintechDbManager.obterConexao();
			pstmt = conexao.prepareStatement("UPDATE T_FIN_CONTA_PESSOA SET DS_EMAIL = ?, DS_SENHA = ?, NR_TELEFONE = ? WHERE ID_CONTA = ?");
			pstmt.setString(1, conta.getEmail());
			pstmt.setString(2, conta.getSenha());
			pstmt.setInt(3, conta.getnumeroTelefone());
			pstmt.setInt(4, conta.getCodigo());
			pstmt.executeUpdate();
			
		}catch (SQLException e) {
			e.printStackTrace();
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
		public void removerConta(int codigo) {
			
			try {
			Connection conexao = FintechDbManager.obterConexao();
			pstmt = conexao.prepareStatement("DELETE FROM T_FIN_CONTA_PESSOA WHERE ID_CONTA = ?");
			pstmt.setInt(1, codigo);
			pstmt.executeUpdate();
			pstmt.executeUpdate();
			
		   }catch (SQLException e) {
				e.printStackTrace();
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

