package br.com.fiap.fintech.bean;

import java.io.Serializable;



public class Conta implements Serializable {
	private static final long serialVersionUID = 1L;
	private int codigo;
	private String email;
	private String senha;
	private int numeroTelefone;
	
	
	
	public Conta(int codigo, String email, String senha, int numeroTelefone) {
		super();
		this.codigo = codigo;
		this.email = email;
		this.senha = senha;
		this.numeroTelefone = numeroTelefone;
		
	}
	
	
	public  Conta() {
		super();
	}


	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	public int getnumeroTelefone() {
		return numeroTelefone;
	}


	public void setnumeroTelefone(int numeroTelefone) {
		this.numeroTelefone = numeroTelefone;
	}

	
	@Override
	public String toString() {
		
		return "TableObject              [codigo=" + codigo
										 + ", email=" + email
										 + ", senha=" + senha
										 + ", numeroTelefone=" + numeroTelefone
										 +"]";
	}


	
	
	
	
	

}



