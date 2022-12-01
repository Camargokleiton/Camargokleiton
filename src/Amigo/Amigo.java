package Amigo;
public class Amigo implements Comparable<Amigo>{
	
	private int idAmigo;
	private String nome;
	private String celular;

	/**@constructor
	 * Construtor da classe Amigo
	 * @param idAmigo - Numero da lista em que o Amigo foi cadastrado
	 * @param nome - Nome do Amigo
	 * @param celular - Numero do Celular do Amigo
	 */
	public Amigo (int idAmigo, String nome, String celular) {
		super();
		this.idAmigo = idAmigo;
		this.nome = nome;
		this.celular = celular;
	}
	/**
	 * getter do nome do amigo
	 * @return nome do amigo
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * Setter do nome do amigo 
	 * @param nomeAmigo - nome do amigo
	 */
	public void setNome(String nomeAmigo) {
		this.nome = nomeAmigo;
	}
	/**
	 * getter do id do amigo 
	 * @return numero do celular do amigo
	 */
	public String getCelular() {
		return celular;
	}
	/**
	 * Setter do numero do celular do amigo 
	 * @param celular - numero do celular do amigo
	 */
	public void setCelular(String celular) {
		this.celular = celular;
	}
	/**	
	 * getter do id do amigo 
	 * @return numero da lista que o amigo foi cadastrado
	 */
	public int getIdAmigo() {
		return idAmigo;
	}
	/**
	 * Setter do id do amigo 
	 * @param idAmigo - numero da lista que o amigo foi cadastrado
	 */
	public void setIdAmigo(int idAmigo) {
		this.idAmigo = idAmigo;
	}

	@Override
	public String toString() {
		return "Amigo [idAmigo =" + idAmigo + ", nome =" + nome + "]";
	}

	@Override
	public int compareTo(Amigo outroAmigo) {
		
		return this.nome.compareToIgnoreCase(outroAmigo.nome);
	}




}
