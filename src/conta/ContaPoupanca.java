package conta;

import java.io.Serializable;

import Interfaces.Remunerada;
	/**
	 * Classe Conta poupanca que faz a correcao
	 * @author kleiton
	 *	
	 */
public class ContaPoupanca extends Conta implements Serializable,Remunerada{
	/**
		 * 
		 */
		private static final long serialVersionUID = -6400337023644534001L;
	/**
	 * 
	 */
	
	int tipo;
	public ContaPoupanca(String nome, String CPF, int senha) {
		super(nome, CPF, senha);
		this.tipo = Conta.POUPANCA;
	}
	/**
	 * @param saldo - saldo antes do valor de correcao
	 * @return correcao - saldo depois da correcao
	 */
	@Override
	
	public float correcao(float saldo) {
		float correcao = saldo + saldo*0.0015f;		
				return correcao;
	}

	
	
	
}
