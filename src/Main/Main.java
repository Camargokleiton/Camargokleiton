package Main;

import java.util.Scanner;

import Banco.Banco;
import Banco.Gravacao;
import conta.ContaCorrente;
import conta.ContaPoupanca;
import conta.Valida_Cpf;


public class Main {
		
	static Scanner teclado = new Scanner(System.in);
	
	static Banco banco = new Banco("Banco de Objectcity");
	
	static Valida_Cpf Validador = new  Valida_Cpf();
	static Gravacao Gravador = new  Gravacao();
	
	
	public static void main(String[] args) {
	
		
		
		
		ContaCorrente cc1 = new ContaCorrente("Kleiton de camargo","952329905",456789, "mucosafer");
		ContaCorrente cc2 = new ContaCorrente("Lucas doido","72389173",123456,"arruda"); 

		 banco.addConta(cc1);
		 banco.addConta(cc2);
		 
		 ContaPoupanca cp1 = new ContaPoupanca("Maria do Carmo", "789456136", 1478963);
		 banco.addConta(cp1);
		
		 
		 interfaceEntrada();
		 
	}

	
	
	
	public static void interfaceEntrada() {
		
		System.out.println("====Bem vindo ao "+banco.getNomeBanco()+"=======\n"+
				"Digite o numero da opcao desejada          / \n"+
				"0 - Sair                                   /\n"+
				"1 - Criar conta corrente                   / \n"+
				"2 - Criar conta poupanca                   / \n"+
				"3 - Entrar                                 / \n"+
				"4 - LerArquivo                                 / \n"
				+ "==========================================="
				);
		int resposta = teclado.nextInt();
		teclado.nextLine();
		
		
		 
		do{ 
			 switch (resposta) {

			case 1: {
				
				criaContaCorrente();
				Gravacao.gravarArquivoBinario(banco, "Banco.bin");
				interfaceEntrada();
				
				break;
			
			}
				
			case 2: {
				
					criaContaPoupanca();
					Gravacao.gravarArquivoBinario(banco, "Banco.bin");
					interfaceEntrada();
				
				break;
				
			}
			case 3: {
				
				entrarConta();
				interfaceEntrada();
				
				break;
				
				
			}
			case 4: {
				
					banco = Gravacao.lerArquivoBinario("Banco.bin");
				interfaceEntrada();
				break;
				
				
			}
			 case 0:{
				 System.out.println("Ate logo!! ;)");
				 Gravacao.gravarArquivoBinario(banco,"Banco.bin");
				 break;
			 }
			}
			
		}while(resposta > 0);
	}
	

	
	public static void criaContaCorrente(){
		
		System.out.println("-------------- Criar conta corrente -------------");
		
		  System.out.println("Diga seu nome ou 0 para voltar");
		  String nome = teclado.nextLine();
		  if (nome.equals("0"))interfaceEntrada();
		  
		  System.out.println("Diga seu CPF ou 0 para voltar");
		  String CPF = teclado.nextLine();
		  if (CPF.equals("0"))interfaceEntrada();
		  
		  System.out.println("Diga sua senha ou 0 para voltar");
		  int senha = teclado.nextInt();
		  teclado.nextLine();
		  if (senha == 0)interfaceEntrada();
		  
		  System.out.println("Confirme sua senha ou 0 para voltar");
		  int senhaConfirmada = teclado.nextInt();
		  teclado.nextLine();
		  if (senhaConfirmada == 0)interfaceEntrada();
		  
		  System.out.println("----------------------------------------------");
		 
		  if (senha == senhaConfirmada) {
			  if (Validador.isCPF(CPF)) {
			 ContaCorrente conta = new ContaCorrente(nome,CPF,senha);
			banco.addConta(conta);
			  System.out.println("Conta criada com sucesso!\n\n "
				 		+ conta.getNumeroConta() + "\n\n "
				 		+ "CPF: " + conta.getCPF() + "\n\n "
				 		+ "Nome do usuario: " + conta.getNome());
			  
			  }else {
				  System.out.println("CPF invalido!!Tente de novo");
				  interfaceEntrada();
			  }
		  }
		 
		}
	
	public static void criaContaPoupanca(){
		
		System.out.println("-------------- Criar conta poupanca -------------");
		
		  System.out.println("Diga seu nome ou 0 para voltar");
		  String nome = teclado.nextLine();
		  if (nome.equals("0"))interfaceEntrada();
		  
		  System.out.println("Diga seu CPF ou 0 para voltar");
		  String CPF = teclado.nextLine();
		  if (CPF.equals("0"))interfaceEntrada();
		  
		  System.out.println("Diga sua senha ou 0 para voltar");
		  int senha = teclado.nextInt();
		  teclado.nextLine();
		  if (senha == 0)interfaceEntrada();
		  
		  System.out.println("Confirme sua senha ou 0 para voltar");
		  int senhaConfirmada = teclado.nextInt();
		  teclado.nextLine();
		  if (senhaConfirmada == 0)interfaceEntrada();
		  System.out.println("---------------------------------------");
		 
		  if (senha == senhaConfirmada) {
			  
			  if ( Validador.isCPF(CPF)) {
			  ContaPoupanca conta = new ContaPoupanca(nome,CPF,senha);
			  banco.addConta(conta);
			  
			  System.out.println("Conta criada com sucesso!\n\n "
				 		+ conta.getNumeroConta() + "\n\n "
				 		+ "CPF: " + conta.getCPF() + "\n\n "
				 		+ "Nome do usuario: " + conta.getNome());
			  
			  }else {
				  System.out.println("CPF invalido!!Tente de novo");
				  interfaceEntrada();
			  }
		  }
		
		  
		}	
	
	
	public static void entrarConta(){
		
		System.out.println("------------ Entrar ---------------");
		for (int i=0; i<Banco.getContas().size();i++) {
			 System.out.println("Nome---->"+Banco.getContas().get(i).getNome()+"\n"
				 		+"Numero da conta---->"+Banco.getContas().get(i).getNumeroConta() +"\n"
				 		+ "senha---->"+Banco.getContas().get(i).getSenha() +"\n"
				 		+ "Saldo---->"+Banco.getContas().get(i).getSaldo() +"\n");
		}
		
		
		System.out.println("Digite o numero da conta ou 0 para sair: \n");
		int numCont = teclado.nextInt();
		teclado.nextLine();
		if (numCont == 0)interfaceEntrada();
		
		if (numCont>0) {
			
			System.out.println("Digite a senha ou 0 para sair");
			int senhaDigitada = teclado.nextInt();
			teclado.nextLine();
			if (senhaDigitada == 0)interfaceEntrada();
			if (numCont>0) {
			
			banco.entraNaConta(numCont, senhaDigitada);
			}else {interfaceEntrada();}
		}else {interfaceEntrada();}
		
	
		
	}  
	
	

	
	
	
	
	
}
