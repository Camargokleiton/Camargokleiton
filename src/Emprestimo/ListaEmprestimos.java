package Emprestimo;
import java.time.LocalDate;
import java.util.ArrayList;


import Biblioteca.Disponibilidade;


public class ListaEmprestimos {

	private ArrayList<Emprestimo> alEmprestimos;
	/**@constructor
	 * Construtor da classe Lista de emprestimos
	 */
	public ListaEmprestimos() {
		super();
		this.alEmprestimos = new ArrayList<Emprestimo>();
		
	}
	/**
	 * Adiciona emprestimo na lista de emprestimos e aumenta o ArrayList
	 * @param nomeAmigo - nome do amigo que emprestou
	 * @param idLivro - numero da lista da biblioteca do livro emprestado
	 * @param dataEmprestimo - data do emprestimo
	 * @param dataDevolucao - data da devolucao
	 * @param dispLivro - disponibilidade que muda para emprestado
	 * @param titulo - nome do livro emprestado
	 * @return
	 */
	public  int addEmprestimo (String nomeAmigo, int idLivro, LocalDate dataEmprestimo, LocalDate dataDevolucao, Disponibilidade dispLivro, String titulo) {
		int idEmprestimo = alEmprestimos.size() + 1;
		Emprestimo emprestimo = new Emprestimo(nomeAmigo, idLivro, dataEmprestimo, dataDevolucao,dispLivro, titulo);
		alEmprestimos.add(emprestimo);
		System.out.println("Emprestimo adicionado a lista");
		System.out.println(alEmprestimos.size());
		return idEmprestimo;
	}
	/**
	 * Getter do ArrayList de emprestimos
	 * @return o ArrayList de emprestimos
	 */
	public ArrayList<Emprestimo> getAlEmprestimos() {
		return alEmprestimos;
	}
	/**
	 * Setter ArrayList de emprestimos
	 * @param alEmprestimos - ArrayList de emprestimos
	 */
	public void setAlEmprestimos(ArrayList<Emprestimo> alEmprestimos) {
		this.alEmprestimos = alEmprestimos;
	}
	/**
	 * Getter do tamanho do ArrayList de emprestimos
	 * @return tamanho do ArrayList de emprestimos
	 */
	public int getAlEmprestimossize() {
		return alEmprestimos.size();
	}

	
	
		
	
	
	
}
