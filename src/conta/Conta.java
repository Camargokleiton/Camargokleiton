package conta;

import java.util.Random;

public abstract class  Conta{
	
	//ArrayList<operacoes> contas = new ArrayList<operacoes>();
	
	final static int CORRENTE = 1;
	final static int POUPANCA = 2;
	
	private String nome;
	private String CPF;
	private int senha;
	private int numeroConta;
	protected float Saldo = 0f;
	
	Random geradorNumeroConta = new Random();
	

	public Conta(String nome,String CPF,int senha) {
		super();
		this.nome = nome;
		this.CPF = CPF;
		this.senha = senha;
		this.numeroConta = geradorNumeroConta.nextInt(100001);
	}

	

	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String  cPF) {
		CPF = cPF;
	}
	
	
	public int getSenha() {
		return senha;
	}


	public void setSenha(int senha) {
		this.senha = senha;
	}


	public int getNumeroConta() {
		return numeroConta;
	}


	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}

	public float getSaldo() {
		return Saldo;
	}


	public float setSaldo(float saldo) {
		return Saldo = saldo;
	}



	@Override
	public String toString() {
		return "Conta [nome=" + nome + ", CPF=" + CPF + ", senha=" + senha + ", numeroConta=" + numeroConta + ", Saldo="
				+ Saldo + "]";
	}



	

}
