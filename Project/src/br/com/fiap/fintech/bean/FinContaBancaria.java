package br.com.fiap.fintech.bean;

import java.io.Serializable;

public class FinContaBancaria implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int codigo;
	private int numeroAgencia;
	private int numeroConta;
	private Float saldo;
	private Float limite;
	
	
	public FinContaBancaria(int codigo, int numeroAgencia, int numeroConta, Float saldo, Float limite) {
		super();
		this.codigo = codigo;
		this.numeroAgencia = numeroAgencia;
		this.numeroConta = numeroConta;
		this.saldo = saldo;
		this.limite = limite;
		
	}
	
	
	public  FinContaBancaria() {
		super();
	}


	

	
	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public int getNumeroAgencia() {
		return numeroAgencia;
	}


	public void setNumeroAgencia(int numeroAgencia) {
		this.numeroAgencia = numeroAgencia;
	}


	public int getNumeroConta() {
		return numeroConta;
	}


	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}


	public Float getSaldo() {
		return saldo;
	}


	public void setSaldo(Float saldo) {
		this.saldo = saldo;
	}


	public Float getLimite() {
		return limite;
	}


	public void setLimite(Float limite) {
		this.limite = limite;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		
		return "TableObject              [codigo=" + codigo
										 + ", numeroAgencia=" + numeroAgencia
										 + ", numeroConta=" + numeroConta
										 + ", saldo=" +  saldo
										 + ", limite="+  limite
										 +"]";
	}


}
