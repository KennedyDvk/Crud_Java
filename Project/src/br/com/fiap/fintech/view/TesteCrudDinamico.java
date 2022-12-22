package br.com.fiap.fintech.view;



import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import br.com.fiap.fin.dao.impl.OraclePessoaDAOImpl;
import br.com.fiap.fintech.bean.Pessoa;
import br.com.fiap.fintech.dao.PessoaDAO;
import br.com.fiap.fintech.exception.DBException;


public class TesteCrudDinamico {
	
	public static void main(String[] args) throws DBException {
			
			PessoaDAO dao = new OraclePessoaDAOImpl();
			
			Pessoa pessoa = new Pessoa();
			
			pessoa.setNome("Ricardo Alves");
			pessoa.setNumeroRg("30745932-9");
			pessoa.setNumeroCpf("932290038/08");
			Calendar calendar = new GregorianCalendar(1988, 01, 03);
			pessoa.setDataNascimento(calendar);
			
			// responsavel por INSERIR obejetos na tabela
//			dao.cadastrar(pessoa);
			System.out.println("novo usuario cadastrado.");
			
			
			
			
			// responsavel por fazer um UPDATE na tabela
			pessoa.setCodigo(1);
			pessoa.setNome("João Victor");
			pessoa.setNumeroRg("144444/12");
			pessoa.setNumeroCpf("7745477/08");
			pessoa.setDataNascimento(calendar);
			
			try {
				dao.atualizar(pessoa);
				System.out.println("Usuario Atualizado");
			}catch (DBException e) {
				e.printStackTrace();
		    }
			
			
			
			
			// responsavel por fazer um SELECT na tabela
			List<Pessoa> pessoas = dao.buscarTodos();
			
			for(Pessoa pess: pessoas) {
				System.out.println(pess.toString());
			}
			
		
			// responsavel por remover na tabela
			try {
				dao.remover(102);
				System.out.println("Usuario Removido com Sucesso!");
			}catch (DBException e) {
				e.printStackTrace();
			}
			
		 

   
	}
	

	
}