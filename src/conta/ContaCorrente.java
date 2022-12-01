package conta;

import java.io.Serializable;


import Interfaces.Pix;
	/**
	 * Classe Conta corrente que implementa Pix  
	 * @author Kleiton
	 *
	 */
public class ContaCorrente extends Conta implements Pix, Serializable  {

	
	 /**
		 * 
		 */
		private static final long serialVersionUID = 1820841349424757260L;
	private int tipo = 0;
	 private String chavePix; 
	 
	 
	public ContaCorrente(String nome, String CPF, int senha) {
		super(nome, CPF, senha);
		this.tipo = Conta.CORRENTE;
	}
	public ContaCorrente(String nome, String CPF, int senha,String chavePix) {
		super(nome, CPF, senha);
		this.tipo = Conta.CORRENTE;
		this.chavePix = chavePix;
	}

	/**
	 * Pega a chave pix da conta
	 * @return chavePix -  String Chave Pix da conta
	 */

	public String getChavePix() {
		return chavePix;
	}
	/**
	 * Escreve a chave pix da conta
	 * @param chavePix -  String Chave Pix da conta
	 */
	public void setChavePix(String chavePix) {
		this.chavePix = chavePix;
	}
/**
 * Pega o tipo da conta
 * @return Tipo - valor 1 de conta corrente
 */
	public int getTipo() {
		return tipo;
	}

	/**
	 * @param saldoAtual - VAlor atual do saldo
	 * @param Valor - Valor a ser transferido 
	 * @return saldo atual - Saldo depois de adicionado o valor
	 */

	@Override
	public float PixIn(float saldoAtual, float Valor) {
		
		return saldoAtual=saldoAtual+Valor;
	}

	/**
	 * @param saldoAtual - VAlor atual do saldo
	 * @param Valor - Valor a ser transferido 
	 * @return saldo atual - Saldo depois de subtraido o valor
	 */

	@Override
	public float PixOut(float saldoAtual, float Valor) {
		
		return saldoAtual=saldoAtual-Valor;
	}



}
