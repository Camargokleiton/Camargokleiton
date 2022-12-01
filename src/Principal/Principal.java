package Principal;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import Amigo.*;
import Emprestimo.*;
import Biblioteca.*;

public class Principal {
	
	private static Biblioteca bib = new Biblioteca("Biblioteca Pessoal");
	private static ListaEmprestimos emprestimos = new ListaEmprestimos();
	private static ListaAmigos amigos = new ListaAmigos();	
	

	private static Scanner teclado = new Scanner(System.in);
	
	/**
	 * MAIN
	 * @param args - parametros da main
	 */
	public static void main(String[] args) {
		
		
		 bib.addLivro("O rei ","Alexandre Aubuquerque", 15.5f,Disponibilidade.DISPONIVEL);
		 bib.addLivro("A rainha das lamentacoes ","Casa Grande", 135.5f,Disponibilidade.DISPONIVEL);
		 bib.addLivro("Curral de sao francisco "," Maria da Luz ", 320.61f,Disponibilidade.DISPONIVEL);
		 bib.addLivro("coisas de adolecententes "," Elizangela Pereira ", 127.30f,Disponibilidade.DISPONIVEL);
		 
		 amigos.addAmigo("Kleiton de camargo","99662536");
		 amigos.addAmigo("Felipe cosma","99562876");
		 amigos.addAmigo("Rubens augusto","99765830");
		 amigos.addAmigo("fidelis falante","98965432");
		
		MenuPrincipal();
	}
		
	/**
	 * Menu Principal faz a interface com o usuario
	 * Ao digitar numero da lista ele e direcionado para a funcao 
	 */
	public static void MenuPrincipal(){
		
		System.out.println("================"+bib.getNome()+"==============");	
		System.out.println("==================Menu Principal=================\r\n"
							+ "0 - sair                                        =\r\n"
							+ "1 - cadastrar livro                             =\r\n"
							+ "2 - cadastrar amigo                             =\r\n"                             
							+ "3 - emprestar                                   =\r\n"
							+ "4 - devolver                                    =\r\n"
							+ "5 - listar emprestimos atuais                   =\r\n"
							+ "6 - historico de emprestimos                    =\r\n"
							+ "7 - lista da biblioteca                         =\r\n"
							+ "8 - mudar ao estado da disponibilidade          =\r\n"
							+ "9 - Lista de amigos                             =\r\n"  
					        + "=================================================\r\n");
		
		try {
			int resposta = teclado.nextInt();
			 teclado.nextLine();
		
		
			do{
				switch (resposta) {
				case 0: {
					System.out.println("\n bye! \n");
				
					break;
				}

				case 1: {										
					cadastroLivro();
					break;
				}
				case 2: {
					cadastroAmigo();
					break;
						}
				case 3: {
					emprestaLivro();
					break;
						}
				case 4: {
					devolveLivro();
					break;
						}
				case 5: {
					imprimeListaEmprestimoAtuais();
					break;
						}
				case 6: {
					imprimeHistoricoEmprestimo();
					break;
						}
				case 7: {
					imprimeListaLivros();
					break;
						}
				case 8: {					
					 mudaEstado();
					break;
						}
				case 9: {					
					 imprimeListaAmigos();
					break;
						}
				}
			}while (resposta != 0);
		}catch (Exception e) {
			
			System.out.println("digite um valor valido");
			
		}finally {
			teclado.nextLine();
			MenuPrincipal();
		}
		
	}
	
	/**
	 * Cadastra um livro na biblioteca
	 *  
	 */
	public static void cadastroLivro() {
		 
		 ArrayList<Livro> biblioteca = bib.getAlLivros();
		 

		 
		 	int flag  = biblioteca.size();
		 	
			System.out.println("\n Diga o nome do livro \n");
			String titulo = teclado.nextLine();
			
			System.out.println("\n Diga o nome do autor do livro \n");
			String autor = teclado.nextLine();
		
			System.out.println("\n Diga o preco do livro \n");
			float preco = teclado.nextFloat();
			
			bib.addLivro(titulo,autor, preco,Disponibilidade.DISPONIVEL);
			
			System.out.println("\n livro : "+(flag+1)+" - "+titulo+" cadastrado\n\n");
	
			MenuPrincipal();
	 }
	/**
	 * Cadastra amigo na lista de amigos
	 */
	public static void cadastroAmigo() {
		 	
			System.out.println("\n Diga o nome do Amigo \n");
			String nome = teclado.nextLine();
			
			System.out.println("\n Diga o numero do celular \n");
			String celular = teclado.nextLine();
			
			amigos.addAmigo(nome,celular);

			MenuPrincipal();
			
	}
	/**
	 * Empresta Livro para amigo cadastrado
	 * se o amigo nao estiver cadastrado nao empresta
	 * se o livro nao estiver disponivel nao empresta
	 * se nao houver livros nao empresta
	 * se nao houver amigos nao empresta
	 * sempre volta para o metodo Menu principal
	 */
	public static void emprestaLivro() {
		
		try {
		
		ArrayList<Livro> biblioteca = bib.getAlLivros();
		
		
		 if (amigos.getListaAmigosSize()>0) {
			 if (biblioteca.size()>0) {
	
			System.out.println("\n Diga o nome do Amigo \n");
			String nome = teclado.nextLine();
			if (nome.equalsIgnoreCase("0")) {Principal.MenuPrincipal();}
				
			System.out.println("\n Diga o id do livro \n");
			int idLivro = teclado.nextInt();
			if (idLivro == 0) {Principal.MenuPrincipal();}
			
			 if (amigos.getListaAmigosSize()>=idLivro) {
			int i =0;
			
          do {
			String tituloLivroEmprestado = biblioteca .get(idLivro-1).getTitulo();
			String nomeAmigo = amigos.getAmigo(i).getNome();
			Disponibilidade disponibilidadeLivro = biblioteca .get(idLivro-1).getDispLivro();
						
					if( nomeAmigo.toLowerCase().contains(nome.toLowerCase())) {

						if (disponibilidadeLivro  == Disponibilidade.DISPONIVEL) {
							
							biblioteca .get(idLivro-1).setDispLivro(Disponibilidade.EMPRESTADO);
						
							emprestimos.addEmprestimo(nomeAmigo, idLivro-1, LocalDate.now(), null, Disponibilidade.EMPRESTADO, tituloLivroEmprestado);
							
							System.out.println("Livro: " + tituloLivroEmprestado + " foi emprestado para: " + nomeAmigo + "\n");
							Principal.MenuPrincipal();
						
						}else{
						System.out.println(" Desculpa,Livro "+tituloLivroEmprestado+" esta "+ disponibilidadeLivro+"\n");
						Principal.MenuPrincipal();
						}
				    }
					i++;
                  } while(i < amigos.getListaAmigosSize());
			 }System.out.println("nao existe esse Livro na biblioteca, tente emprestar de novo!\n\n");
			 Principal.MenuPrincipal();
			 }
			 System.out.println("nao ha Livros na biblioteca!!\n\n");
			 Principal.MenuPrincipal();
		 }
		 System.out.println("nao ha ninguem cadastrado!!\n\n");
		 Principal.MenuPrincipal();
	}catch (Exception e) {
		
		System.out.println("digite um valor valido");
		
	}finally {
		teclado.nextLine();
		MenuPrincipal();
	}	 	 
	 }
	/**
	 * Devolve livro emprestado
	 * se nao houver emprestimos nao devolve
	 * nao retira da lista de emorestimos 
	 * fica como historico
	 */
	public static void devolveLivro() {
		
		try {
		
		ArrayList<Livro> biblioteca = bib.getAlLivros();
		
		System.out.println("\n Diga o id do livro que esta devolvendo ou zero para sair \n");
		int idLivro = teclado.nextInt(); 
		
		for (int i = 0; i< biblioteca.size(); i++) {
			
				if (idLivro !=0) {
					if(emprestimos.getAlEmprestimossize()>0) {
						if(biblioteca.get(idLivro-1).getDispLivro()==Disponibilidade.EMPRESTADO) {
				String tituloLivroEmprestado = biblioteca.get(idLivro-1).getTitulo();
				biblioteca.get(idLivro-1).setDispLivro(Disponibilidade.DISPONIVEL);
				
			for (int j = 0; j< emprestimos.getAlEmprestimossize(); j++) {
				
				if(emprestimos.getAlEmprestimos().get(j).getIdLivro() == idLivro-1) {
					
					emprestimos.getAlEmprestimos().get(j).setDispLivro(Disponibilidade.DISPONIVEL);
					emprestimos.getAlEmprestimos().get(j).setDataDevolucao(LocalDate.now());
			
				}
			}
			System.out.println("Livro: "+ tituloLivroEmprestado+"foi devolvido\n\n");
			MenuPrincipal();
						}else {
							System.out.println("Livro nao pode ser devolvido pois esta "+biblioteca.get(idLivro-1).getDispLivro()+" \n\n");
						}
				}else {
					System.out.println("nenhum Livro foi emprestado\n\n");	
				MenuPrincipal();
				}
				}
				MenuPrincipal();
			}
	
		}catch (Exception e) {
			
			System.out.println("digite um valor valido");
			
		}finally {
			teclado.nextLine();
			MenuPrincipal();
		}
	}
	/**
	 * Imprime todos os livros da biblioteca que estao emprestados e para quem foi emprestado
	 */
	public static void imprimeListaEmprestimoAtuais() {
		
		ArrayList<Emprestimo> Emprestimo = emprestimos.getAlEmprestimos();
		
		if (Emprestimo.size() > 0) {
			
		System.out.println("===Lista de Emprestimos Atuais===");
		for (int i = 0; i < Emprestimo.size(); i++) {
			
			if(Emprestimo.get(i).getDispLivro() == Disponibilidade.EMPRESTADO ) {
			Emprestimo emprestimo = Emprestimo.get(i);
			System.out.println("\nEmprestimo "+ (i+1) + ": \n");
			System.out.println("   Livro: "+ emprestimo.getTituloLivroEmprestado()+"\n");
			System.out.println("   Amigo: " + emprestimo.getNomeAmigo()+"\n");
			System.out.println("   IdLivro: "+ (emprestimo.getIdLivro()+1)+"\n");
			System.out.println("   Data do emprestimo: "+ emprestimo.getDataEmprestimo()+ "\n");	
			System.out.println("   Data da devolucao: ainda nao devolvido\n");
			}
			}
		System.out.println("===Fim da Lista de Emprestimos Atuais===\n\n");
		MenuPrincipal();
		
	}else{ 
	System.out.print(" Sem emprestimos cadastrados\n");
	MenuPrincipal();
	}
}
	/**
	 * imprime a lista de todos os emprestimos que foram feitos 
	 */
	public static void imprimeHistoricoEmprestimo() {
		
		ArrayList<Emprestimo> Emprestimo = emprestimos.getAlEmprestimos();
		
		System.out.println(Emprestimo.size());
		if (Emprestimo.size()>0) {
		System.out.println("===Historico de Emprestimos===");
		for (int i = 0; i < Emprestimo.size(); i++) {
			Emprestimo emprestimo = Emprestimo.get(i);
			System.out.println("\nEmprestimo "+ (i+1) + ": \n");
			System.out.print("   Livro: "+ emprestimo.getTituloLivroEmprestado()+"\n");
			System.out.print("   Amigo: " + emprestimo.getNomeAmigo()+"\n");
			System.out.print("   IdLivro: "+ (emprestimo.getIdLivro()+1)+"\n");
			System.out.print("   Data do emprestimo: "+ emprestimo.getDataEmprestimo()+ "\n");
			if(emprestimo.getDataDevolucao()==null) {
			System.out.print("   Data da devolucao: Ainda nao devolvido\n");
			}else {
				System.out.print("   Data da devolucao: "+ emprestimo.getDataDevolucao()+ "\n");
				}
		}
		System.out.println("===Historico de Emprestimos===");
		MenuPrincipal();
	}else {
		System.out.print(" Sem emprestimos cadastrados\n");
		MenuPrincipal();
		}
}
	/**
	 * Imprime a lista de livros que existem na biblioteca e seus respectivos status
	 */
	public static void imprimeListaLivros () {
		
		ArrayList<Livro> biblioteca = bib.getAlLivros();
			
			float investimento = bib.getInvestimento();
			
			if (biblioteca.size()>0) {
			System.out.println("===Lista de Livros===");
			for (int i = 0; i < biblioteca.size(); i++ ) {
				Livro Livro = biblioteca.get(i);
				System.out.println("\nLivro "+ (i+1) + ": \n");
				System.out.print("   Titulo: "+ Livro.getTitulo()+"\n");
				System.out.print("   Autor: " + Livro.getAutor()+"\n");			
				System.out.print("   Disponibilidade: "+ Livro.getDispLivro()+"\n");
				System.out.print("   Preco: "+ Livro.getPreco()+ "\n\n");
			}
			System.out.println("Investimento total = "+investimento+"\n");
			Principal.MenuPrincipal();
			}
			System.out.println("Nao ha livros!\n\n");
			Principal.MenuPrincipal();	
		}
	/**
	 * Muda o status do livro em questao, indicado pelo id do mesmo
	 */
	public static void mudaEstado() {;
		 
	
		try {
		 ArrayList<Livro> biblioteca = bib.getAlLivros();
		 System.out.println("\n Qual o id do livro?\n");
			int idLivro = teclado.nextInt()-1;
		 if (biblioteca.size()>idLivro) {
			
			System.out.println("\n Diga a nova disponibilidade do livro \n"
					+ "0-Sair \n"
					+ "1-Disponivel\n"
					+ "2-Consulta Local\n"
					+ "3-Emprestado\n"
					+ "4-Extraviado\n"
					+ "5-Danificado\n");
			
			int disp = teclado.nextInt();
			teclado.nextLine();
				do {
					switch(disp) {
					
					case 0: {
						MenuPrincipal();
					}
						
					case 1: {
						biblioteca.get(idLivro).setDispLivro(Disponibilidade.DISPONIVEL);
						System.out.println("O livro: "+biblioteca.get(idLivro).getTitulo()+"foi alterado para: "+biblioteca.get(idLivro).getDispLivro());
							MenuPrincipal();
						break;
					}
					case 2: {
						biblioteca.get(idLivro).setDispLivro(Disponibilidade.CONSULTALOCAL);
						System.out.println("O livro: "+biblioteca.get(idLivro).getTitulo()+"foi alterado para: "+biblioteca.get(idLivro).getDispLivro());
							MenuPrincipal();
						break;
					}
					case 3: {
						biblioteca.get(idLivro).setDispLivro(Disponibilidade.EMPRESTADO);
							System.out.println("O livro: "+biblioteca.get(idLivro).getTitulo()+"foi alterado para: "+biblioteca.get(idLivro).getDispLivro());
							MenuPrincipal();
						break;
					}
					case 4: {
						biblioteca.get(idLivro).setDispLivro(Disponibilidade.EXTRAVIADO);
						System.out.println("O livro: "+biblioteca.get(idLivro).getTitulo()+"foi alterado para: "+biblioteca.get(idLivro).getDispLivro());
							MenuPrincipal();
						break;
					}
					case 5: {
						biblioteca.get(idLivro).setDispLivro(Disponibilidade.DANIFICADO);
						System.out.println("O livro: "+biblioteca.get(idLivro).getTitulo()+"foi alterado para: "+biblioteca.get(idLivro).getDispLivro());
							MenuPrincipal();							
						break;	
					}
			
								}
				}while(disp != 0 && disp < 5);
			}
		 System.out.println("Cadastre livro antes!!\n");
		}catch (Exception e) {
			
			System.out.println("digite um valor valido");
			
		}finally {
			teclado.nextLine();
			MenuPrincipal();
		}
		}
	/** 
	 * Imprime a lista de amigos que estao cadastrados
	 */
	public static void imprimeListaAmigos () {
		
		int tamanhoAmigos = amigos.getListaAmigosSize();
		
		if( tamanhoAmigos > 0) {
		System.out.println("===Lista de Amigos Cadastrados===");
		for (int i = 0; i < tamanhoAmigos; i++) {
			Amigo Amigo = amigos.getAmigo(i);
			System.out.println("\n Amigo "+ (i+1) + ": ");
			System.out.println("   Nome: "+ Amigo.getNome());
			System.out.println("   Celular: " + Amigo.getCelular());
			
		}
		}else {
			System.out.println("nao ha amigos cadastrados \n");
			Principal.MenuPrincipal();
		}
		Principal.MenuPrincipal();
	}
	
}
