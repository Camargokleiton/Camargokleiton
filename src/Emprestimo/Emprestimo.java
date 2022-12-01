package Emprestimo;
import java.time.LocalDate;


import Biblioteca.Disponibilidade;
;

public class Emprestimo {

	private String nomeAmigo;
	private String tituloLivroEmprestado;
	private int idLivro;
	private LocalDate dataEmprestimo;
	private LocalDate dataDevolucao;
	private Disponibilidade DispLivro;
	
	
	/**
	 * @constructor
	 * Construtor da classe emprestimo
	 * @param nomeAmigo - nome do amigo que emprestou
	 * @param idLivro - numero do livro na biblioteca
	 * @param dataEmprestimo - dia - mes - ano que o livro foi emprestado
	 * @param dataDevolucao - dia - mes - ano que o livro foi devolvido
	 * @param dispLivro - disponibilidade que sera modificada para emprestado
	 * @param titulo - nome do livro que foi emprestado
	 */
	public Emprestimo(String nomeAmigo, int idLivro, LocalDate dataEmprestimo, LocalDate dataDevolucao, Disponibilidade dispLivro, String titulo) {
		super();
		this.nomeAmigo = nomeAmigo;
		this.idLivro = idLivro;
		this.dataEmprestimo = dataEmprestimo;
		this.dataDevolucao = dataDevolucao;
		this.DispLivro = dispLivro;
		this.tituloLivroEmprestado = titulo;	

	}
	/**
	 * Getter do numero do livro que foi emprestado
	 * @return numero do livro que foi emprestado
	 */

	public int getIdLivro() {
		return idLivro;
	}
	/**
	 * Setter do numero do livro que foi emprestado
	 * @param idLivro  - numero do livro que foi emprestado
	 */
	public void setIdLivro(int idLivro) {
		this.idLivro = idLivro;
	}
	/**
	 * Getter do dia mes e ano do emprestimo
	 * @return data do emprestimo
	 */
	public LocalDate getDataEmprestimo() {
		return dataEmprestimo;
	}
	/**
	 * Setter do dia mes e ano do emprestimo
	 * @param dataEmprestimo - data do emprestimo
	 */
	public void setDataEmprestimo(LocalDate dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}
	/**
	 *Getter do dia mes e ano da devolucao 
	 * @return data de devolucao
	 */
	public LocalDate getDataDevolucao() {
		return dataDevolucao;
	}
	/**
	 *Setter do dia mes e ano da devolucao 
	 * @param dataDevolucao -  data de devolucao
	 */
	public void setDataDevolucao(LocalDate dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}
	/**
	 * Getter disponibilidade do livro emprestado
	 * @return disponibilidade do livro emprestado
	 */

	public Disponibilidade getDispLivro() {
		return DispLivro;
	}
	/**
	 * Setter Disponibilidade do livro emprestado
	 * @param dispLivro - Disponibilidade do livro emprestado
	 */
	public void setDispLivro(Disponibilidade dispLivro) {
		DispLivro = dispLivro;
	}
	/**
	 * Getter do nome do amigo que emprestou o livro 
	 * @return nome do amigo
	 */
	public String getNomeAmigo() {
		return nomeAmigo;
	}
	/**
	 * Setter nome do amigo que emprestou o livro 
	 * @param nomeAmigo - nome do amigo que emprestou o livro 
	 */
	public void setNomeAmigo(String nomeAmigo) {
		this.nomeAmigo = nomeAmigo;
	}
	/**
	 * Getter do titulo do livro emprestado
	 * @return o nome do livro emprestado
	 */
	public String getTituloLivroEmprestado() {
		return tituloLivroEmprestado;
	}
	/**
	 * Setter do livro emprestado
	 * @param tituloLivroEmprestado - nome do livro emprestado
	 */
	public void setTituloLivroEmprestado(String tituloLivroEmprestado) {
		this.tituloLivroEmprestado = tituloLivroEmprestado;
	}

	

}
