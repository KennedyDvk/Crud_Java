package br.com.fiap.fintech.dao;

import java.util.List;

import br.com.fiap.fintech.bean.Pessoa;
import br.com.fiap.fintech.exception.DBException;




public interface PessoaDAO {
	
	void cadastrar (Pessoa pessoa) throws DBException;
	
	
	List<Pessoa> buscarTodos();
	
	Pessoa BuscarTodosPorCodigo(int codigo);
	
	void atualizar(Pessoa pessoa)throws DBException;
	
	void remover(int codigo)throws DBException;

}
