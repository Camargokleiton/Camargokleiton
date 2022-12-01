package Banco;


import java.util.Date;

import conta.Conta;
/**
 * Classe criada para armazenar as operacoes e imprimir no extrato
 * @author Kleiton
 *
 */
public class Operacoes {

	 private String tipoOperacao;
	 private float valor;
	 private Conta conta;
	 private Date data; 
	 
	public Operacoes(Conta c,Date date, String tipoOperacao, float valor2) {
		super();
		this.tipoOperacao = tipoOperacao;
		this.valor = valor2;
		this.conta = c;
		this.data = date;
	}
	/**
	 * Pega a data da operacao
	 * @return Objeto do tipo data de operacao
	 */

	public Date getDataOperacao() {
		return data;
	}
	
	/**
	 * Pega o tipo da operacao feita 
	 * @return String do tipo de operacao
	 */
	public String getTipoOperacao() {
		return tipoOperacao;
	}
	/**
	 * Pega o valor feito na operacao 
	 * @return Valor da operacao
	 */

	public float getValor() {
		return valor;
	}

/**
 * Pega  a conta no qual foi feita a operacao
 * @return Objeto do tip conta
 */
	public Conta getConta() {
		return conta;
	}
	 
	 
	
	
	
	

}
