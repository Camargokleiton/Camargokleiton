package Biblioteca;


public class Livro implements Comparable<Livro> {
	
	private int idLivro;
	private String titulo;
	private String autor;
	private float preco;
	private Disponibilidade dispLivro;
	
	
	/**
	 * @constructor
	 * @param idLivro - id do livro criado
	 * @param titulo - nome do livro criado
	 * @param autor - nome do autor do livro criado
	 * @param preco - preco do livro criado
	 * @param dispLivro - disponibilidade do livro criado
	 */
	public Livro(int idLivro, String titulo, String autor, float preco, Disponibilidade dispLivro) {
		
		this.idLivro = idLivro;
		this.titulo = titulo;
		this.autor = autor;
		this.preco = preco;
		this.dispLivro = dispLivro;
	}
	/**
	 * Getter do id do livro
	 * @return id do livro
	 */

	public int getIdLivro() {
		return idLivro;
	}
	/**
	 * Setter do id do livro
	 * @param idLivro - id do livro
	 */
	public void setIdLivro(int idLivro) {
		this.idLivro = idLivro;
	}
	/**
	 * Getter do titulo do livro
	 * @return titulo do livro
	 */
	public String getTitulo() {
		return titulo;
	}
	/**
	 * Setter do titulo do livro
	 * @param titulo - titulo do livro
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	/**
	 * Getter do autor do livro
	 * @return autor no livro
	 */
	public String getAutor() {
		return autor;
	}
	/**
	 * Setter do nome do autor
	 * @param autor
	 */
	public void setAutor(String autor) {
		this.autor = autor;
	}
	/**
	 * Getter do preco do livro
	 * @return preco do livro
	 */
	public float getPreco() {
		return preco;
	}
	/**
	 * Setter do preco do livro
	 * @param preco do livro
	 */
	public void setPreco(float preco) {
		this.preco = preco;
	}
	/**
	 * Getter da disponibilidade do livro
	 * @return Disponibilidade do livro
	 */
	public Disponibilidade getDispLivro() {
		return dispLivro;
	}
	/**
	 * Setter da disponibilidade do livro
	 * @param dispLivro - Disponibilidade do livro
	 */
	public void setDispLivro(Disponibilidade dispLivro) {
		this.dispLivro = dispLivro;
	}
	
	@Override
	public String toString() {
		return "Livro [idLivro=" + idLivro + ", titulo=" + titulo + ", autor=" + autor + ", preco=" + preco
				+ ", dispLivro=" + dispLivro + "]";
	}

	@Override
	public int compareTo(Livro outroLivro) {
		
		return this.titulo.compareToIgnoreCase(outroLivro.getTitulo());
			
	}
	

}
