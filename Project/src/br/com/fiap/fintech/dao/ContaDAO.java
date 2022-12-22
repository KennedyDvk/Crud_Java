package br.com.fiap.fintech.dao;

import java.util.List;

import br.com.fiap.fintech.bean.Conta;

public interface ContaDAO {
	
	
		
		void adcionar (Conta conta);
		
		
		List<Conta> listartodos();
		
		Conta BuscarTodosAsContasPorCodigo(int codigo);
		
		void atualizarConta(Conta conta);
		
		void removerConta(int codigo);

}



