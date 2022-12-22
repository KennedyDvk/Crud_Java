package br.com.fiap.factory;

import br.com.fiap.fin.dao.impl.OraclePessoaDAOImpl;
import br.com.fiap.fintech.dao.PessoaDAO;

public class DAOFactory {
	
	public static PessoaDAO getPessoaDAO() {
		return new OraclePessoaDAOImpl();
	}


}
