 package Biblioteca;




import java.util.ArrayList;
import java.util.Collections;


public class Biblioteca {

	private String nome;
	private ArrayList<Livro> alLivros;	
	
	private float investimento;

/**
 * Construtor da Biblioteca com um ArrayList de Livros
 * @param nome - nome da Biblioteca
 */
	public Biblioteca(String nome) {
		this.nome = nome;
		this.alLivros = new  ArrayList<Livro>();
		investimento = 0;
	}	

	
	/**
	 * Adiciona um livro na biblioteca
	 * @param titulo - nome do livro
	 * @param autor - nome do autor do livro
	 * @param preco - valor do tipo float do livro
	 * @param dispLivro - disponibilidade do livro
	 * @return id do livro
	 *
	 * 
	 */
	public  int addLivro (String titulo, String autor, float preco, Disponibilidade dispLivro) {
		int idLivro3 = alLivros.size() + 1;
		Livro Livro = new Livro(idLivro3, titulo, autor, preco, dispLivro );
		investimento =investimento+ preco;
		alLivros.add(Livro);
		Collections.sort(alLivros);
		return idLivro3;
	}
	
	/**getter do investimento
	 * @return valor do investimento total
	 */

		public float getInvestimento() {
		return investimento;
	}

		/**Setter do investimento
		 * @param valor do investimento do livro criado
		 */

	public void setInvestimento(float investimento) {
		this.investimento = investimento;
	}
	
	/**getter do nome do livro
	 * @return o nome do livro
	 */
	 
	public String getNome() {
		return nome;
	}

	/**getter do ArrayList de livros
	 * @return ArrayList livros
	 */

	public ArrayList<Livro> getAlLivros() {
		return alLivros;
	}

	/**setter do ArrayList 
	 * @param ArrayList de livros
	 */

	public void setAlLivros(ArrayList<Livro> alLivros) {
		this.alLivros = alLivros;
	}




	

	

}
