package Banco;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Scanner;

import Interfaces.Pix;
import Interfaces.Remunerada;
import Main.Main;
import conta.Conta;
import conta.ContaCorrente;
import conta.ContaPoupanca;

public class Banco implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3878450518046899110L;
	static ArrayList<Conta> contas = new ArrayList<Conta>();
	static ArrayList<Operacoes> Operacoes = new ArrayList<Operacoes>();
	static Scanner teclado = new Scanner(System.in);
	
	String nomeBanco;
	
	public Banco(String nome) {
		super();
		this.nomeBanco = nome;
		
	}
		/**
		 * Adiciona a conta no ArrayList contas
		 * @param conta - Objero conta que vai ser adicionado no ArrayList
		 */
		public  void addConta(Conta conta) {
			
		contas.add(conta);

	}
		/**
		 * Adiciona  operacao no ArrayList operacoes
		 * @param operacao - Objeto da Classe operacoes que vai ser inserido no ArrayList operacoes
		 */
		public  void addOperacao(Operacoes operacao) {
			
		Operacoes.add(operacao);

	}
		/**
		 * Entra na conta e se for do tipo poupanca vai para o menu conta poupanca
		 * se for do tipo corrente vai para o menu conta corrente
		 * @param numeroConta
		 * @param senha
		 */
		public void entraNaConta(int numeroConta, int senha){
			
			
			for (Conta c : contas) {
				
			
			if (c.getNumeroConta() == numeroConta ) {
				
				
				if (c.getSenha() == senha && c.getNumeroConta()== numeroConta ) {
							
					if(c instanceof Pix) menuContaCorrente(c);
					if(c instanceof Remunerada)menuContaPoupanca(c);
				
				}	System.out.println("Senha incorreta tente novamente ou numero da conta\n");
					Main.entrarConta();
					
					
				}  
				    
				
				
			}

		}
		
		/**
		 * Menu da conta se for do tipo corrente
		 * @param c - Objeto Conta que foi selecionado no metodo EntraConta 
		 */
		
		
		
		public void menuContaCorrente(Conta c) {
			
			ContaCorrente CC = (ContaCorrente)c;

			
			System.out.println(
					"===== MENU DA CONTA ====\n"+
					"Usuario : "+c.getNome()+"\n"+
					"Saldo :"+c.getSaldo()+"\n\n"+
					"0- Sair \n"+
					"1 - Fazer deposito \n"+
					"2 - Fazer saque \n"+
					"3 - fazer Pix\n" +
					"4 - Criar chave Pix\n"+
					"5 - Fazer transferencia (cobrado)\n"+
				    "6 - Extrato\n"
					);
			if (CC.getChavePix()==null) {
				System.out.println("  Conta ainda sem Chave pix \n");
			}else {System.out.println(" Chave Pix da conta : "+CC.getChavePix());}
			System.out.println(
					"===== MENU DA CONTA ====\n");
			
			int resposta = teclado.nextInt();
			teclado.nextLine();
					
			Iterator<Conta> it = contas.iterator();
				while (it.hasNext()) {
					
					switch (resposta) {
					case 0: {
						
						Main.entrarConta();
						
					}
					
					case 1: {
						
						System.out.println("Digite o Valor que deseja depositar : \n");
						int valor = teclado.nextInt();
						teclado.nextLine();
						deposito(valor, c);
						menuContaCorrente(c);
						
					}
					case 2: {
						
						System.out.println("Digite o Valor que deseja Sacar : \n");
						int valor = teclado.nextInt();
						teclado.nextLine();
						retirada(valor, c);
						menuContaCorrente(c);
					}
					case 3: {
						
						System.out.println("Digite o Valor que deseja transferir : \n");
						int valor = teclado.nextInt();
						teclado.nextLine();
						
						fazerPix(c,valor);
						
						
						menuContaCorrente(c);
					}
					case 4: {
						
						System.out.println("Digite a chave");
						String chavePix = teclado.nextLine();
						criarChavePix(chavePix, c);
						menuContaCorrente(c);
						
					}
					case 5: {
						
						System.out.println("----------- Transferencia ----------");
						System.out.println("Digite o Valor que deseja Transferir : \n");
						int valor = teclado.nextInt();
						teclado.nextLine();				
						tranferencia(valor, c);
						menuContaCorrente(c);

						
					}
					case 6: {
						
						System.out.println("------------ Extrato ---------------");
						extrato(c);
						menuContaCorrente(c);
						
					}
					
					default: menuContaCorrente(c);
					}
					
					
				}
			
		}
		/**
		 * Menu da conta do tipo poupanca que é definida pela interface Remunerada
		 * @param c - objeto conta 
		 */
		public void menuContaPoupanca(Conta c) {
			
			System.out.println(
					"Usuario : "+c.getNome()+"\n"+
					"Saldo :"+c.getSaldo()+"\n"+
					"0- Sair \n"+
					"1 - Fazer deposito \n"+
					"2 - Fazer saque \n"+
					"3 - fazer Transferencia (cobrado)\n"+
				    "4 - Aplicar correcao\n"+
				    "5 - Extrato\n"  
					);
			int resposta = teclado.nextInt();
			teclado.nextLine();
					
			Iterator<Conta> it = contas.iterator();
				while (it.hasNext()) {
					
					switch (resposta) {
					case 0: {
						
						Main.entrarConta();
						
					}
					
					case 1: {
						
						System.out.println("Digite o Valor que deseja depositar : \n");
						int valor = teclado.nextInt();
						teclado.nextLine();
						deposito(valor, c);
						menuContaPoupanca(c);
						
					}
					case 2: {
						
						System.out.println("Digite o Valor que deseja Sacar : \n");
						int valor = teclado.nextInt();
						teclado.nextLine();
						retirada(valor, c);
						menuContaPoupanca(c);
					}
					case 3: {
						System.out.println("----------- Transferencia ----------");
						System.out.println("Digite o Valor que deseja Transferir : \n");
						int valor = teclado.nextInt();
						teclado.nextLine();				
						tranferencia(valor, c);
						
						
						menuContaPoupanca(c);
					}
					case 4: {
						ContaPoupanca CP = (ContaPoupanca)c;	
						c.setSaldo(CP.correcao(c.getSaldo()));
						Operacoes op = new Operacoes(c,Calendar.getInstance().getTime(), "Correcao", c.getSaldo());
						addOperacao(op);
						menuContaPoupanca(c);
					}
					case 5: {
						
						System.out.println("------------ Extrato ---------------");
						extrato(c);
						menuContaPoupanca(c);
						
					}

					
					default: menuContaPoupanca(c);
					}
					
					
				}
			
		}
		
		/**
		 * Adiciona o valor inserido na conta selecionada 
		 * @param valor - Valor escaneado do usuario como se fosse dinheiro 
		 * @param c - objeto conta que foi encontrado dentro do arrayList
		 */
		
		public void deposito(float valor, Conta c) {
			
					c.setSaldo(c.getSaldo()+valor) ;
					System.out.println(valor + " depositado! Seu saldo e de: "+ c.getSaldo());
				    
					Operacoes op = new Operacoes(c,Calendar.getInstance().getTime(), "Deposito", valor);
					addOperacao(op);
					
				    
				    
			
		}
		/**
		 * Subtrai o valor inserido na conta selecionada
		 * @param valor - Valor escaneado do usuario como se fosse dinheiro 
		 * @param c - objeto conta que foi encontrado dentro do arrayList
		 */
		
		public void retirada(float valor,Conta c) {
			
			if (c.getSaldo()>valor) {
				c.setSaldo(c.getSaldo() - valor) ;
				System.out.println(valor + " sacado! Seu saldo e de: "+ c.getSaldo());
			
				Operacoes op = new Operacoes(c,Calendar.getInstance().getTime(), "Retirada", -valor);
				addOperacao(op);
			}else {
				System.out.println("Saldo insuficiente!!");
			}
			
			
		}
		
		/**
		 * Transfere o valor da ContaEnvia para a conta requisitada
		 * @param valor - Valor escaneado do usuario como se fosse dinheiro 
		 * @param contaEnvia - Objeto Conta que é retirado o valor
		 */
		
		
		public void tranferencia(float valor,Conta contaEnvia) {
			
			if(contaEnvia.getSaldo()>valor) {
				System.out.println("Digite o numero da conta que deseja transferir");
				
				int resposta = teclado.nextInt();
				teclado.nextLine();

				contaEnvia.setSaldo(contaEnvia.getSaldo()-valor-10f);// tem desconto por ser transferencia
				
				for (Conta c: contas ) {

				
					if (c.getNumeroConta() == resposta) {
					
						c.setSaldo(c.getSaldo()+valor);
						
						Operacoes op1 = new Operacoes(contaEnvia,Calendar.getInstance().getTime(), "Ted", -10);
						addOperacao(op1);
						Operacoes op = new Operacoes(contaEnvia,Calendar.getInstance().getTime(), "Transferencia", -valor);
						addOperacao(op);
					
						System.out.println("Valor transferido! Seu saldo e de: "+contaEnvia.getSaldo());
						System.out.println("Valor transferido! saldo de "+c.getNome()+ "e de: "+c.getSaldo());
					}
				
				
				}
			}else {
				System.out.println("Saldo insuficiente!!");
			}
		}
		
		
		/**
		 * Transfere através da chave Pix e não cobra nada 
		 * @param c - Objeto Conta que faz o PixOut
		 * @param valor - Valor do Pix 
		 */

		
		
		public void fazerPix(Conta c, int valor) {
			
			
				if (c instanceof Pix) {
					ContaCorrente CCT = (ContaCorrente)c;//Conta q sai o dinheiro
					
					if (c.getSaldo()>=valor) {
							
							
						
						
						System.out.println("Digite o chave Pix da conta a transferir : \n");
						String chavePix = teclado.nextLine();
						for(Conta c2: contas) {
	
								
							if (c2 instanceof Pix) {
								ContaCorrente CCR = (ContaCorrente)c2;//Conta q entra dinheiro
									if (CCR.getChavePix().toLowerCase().contains(chavePix.toLowerCase())) {					
										
										if(c!=c2) {
											float SaldodepoisPixin = CCR.PixIn(c2.getSaldo(),valor);
											c2.setSaldo(SaldodepoisPixin);

											Operacoes op = new Operacoes(c2,Calendar.getInstance().getTime(), "PixIn", +valor);
											addOperacao(op);
										
										
											float SaldodepoisPixout = CCT.PixOut(c.getSaldo(),valor);
											c.setSaldo(SaldodepoisPixout);
										
											Operacoes op2 = new Operacoes(c,Calendar.getInstance().getTime(), "PixOut", -valor);
											addOperacao(op2);
										
											System.out.println("Valor de "+valor+" Transferido, seu saldo agora e: "+c.getSaldo());
									
											menuContaCorrente(c);	
								
										}
									}
								}
						}  System.out.println("Chave Pix inexistente!");
					}else {
						System.out.println("Saldo insuficiente!!!");
			
				}
			}
		}
		
		
		
			/**
			 * Muda ou cria Chave Pix para um Objeto do tipo conta
			 * @param chavePix - String enviada pelo usuário
			 * @param c - objeto conta selecionada
			 */
		
	public void criarChavePix(String chavePix,Conta c) {
		
		ContaCorrente CC = (ContaCorrente)c;
		CC.setChavePix(chavePix);
		System.out.println("Chave Pix criada : "+CC.getChavePix()+"\n");
		
	}	
		/**
		 * Exibe o extrato do Objeto conta 
		 * @param c - Objeto conta selecionada
		 */
	
	public void extrato(Conta c) {
		
		for (Conta c1: contas) {
			if (c1 == c) {
				System.out.println("---Data-----------------------------Operacao--------Valor");
				for (Operacoes op: Operacoes) {
					if(op.getConta().getNumeroConta()== c.getNumeroConta())
					System.out.println(op.getDataOperacao()+"--------"+op.getTipoOperacao()+"--------("+op.getValor()+")");
				}
				System.out.println("-------------------TOTAL: "+c.getSaldo());
			}
		}
		
		
	}
	
	
	/**
	 * Pega o nome do banco
	 * @return String Nome do banco
	 */
	

	public String getNomeBanco() {
		return nomeBanco;
	}

	/**
	 * Pega o ArrayList contas
	 * @return ArrayList Contas
	 */
	
	
	
		public static ArrayList<Conta> getContas() {
		return contas;
	}
	

		
		public static ArrayList<Operacoes> getOperacoes() {
		return Operacoes;
	}


		@Override
	public String toString() {
		return "Banco [contas=" + contas + "]";
	}
		
		
		
		
		
		
}

