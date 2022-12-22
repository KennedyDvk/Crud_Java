package br.com.fiap.fintech.bean;


import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class Pessoa implements Serializable {

		private static final long serialVersionUID = 1L;
		private int codigo;
		private String nome;
		private String numeroRg;
		private String numeroCpf;
		private Calendar dataNascimento;
		
		
		public Pessoa(int codigo, String nome, String numeroRg, String numeroCpf, Calendar dataNascimento) {
			super();
			this.codigo = codigo;
			this.nome = nome;
			this.numeroRg = numeroRg;
			this.numeroCpf = numeroCpf;
			this.dataNascimento = dataNascimento;
		}
		
		
		public  Pessoa() {
			super();
		}


		public int getCodigo() {
			return codigo;
		}


		public void setCodigo(int codigo) {
			this.codigo = codigo;
		}


		public String getNome() {
			return nome;
		}


		public void setNome(String nome) {
			this.nome = nome;
		}


		public String getNumeroRg() {
			return numeroRg;
		}


		public void setNumeroRg(String numeroRg) {
			this.numeroRg = numeroRg;
		}


		public String getNumeroCpf() {
			return numeroCpf;
		}


		public void setNumeroCpf(String numeroCpf) {
			this.numeroCpf = numeroCpf;
		}


		public Calendar getDataNascimento() {
			return dataNascimento;
		}


		public void setDataNascimento(Calendar dataNascimento) {
			this.dataNascimento = dataNascimento;
		}
		
		@Override
		public String toString() {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
			return "TableObject              [codigo=" + codigo
											 + ", nome=" + nome
											 + ", numeroRg=" + numeroRg
											 + ", numeroCpf=" + numeroCpf
											 + ", dataNascimento="
											 + sdf.format(dataNascimento.getTime())
											 +"]";
		}


		
		
		
		
		
	
}
