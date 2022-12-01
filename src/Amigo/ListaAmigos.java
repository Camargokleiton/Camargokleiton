package Amigo;
import java.util.ArrayList;
import java.util.Collections;


public class ListaAmigos{
	

	private  ArrayList<Amigo> alAmigos;
	
	/**@constructor ListaAmigos
	 * Construtor da classe Lista de amigos - vazio
	 */
	public ListaAmigos() {
		super();
		this.alAmigos = new ArrayList<Amigo>();
	}
	/**
	 * Adiciona um amigo no ArrayList de amigos
	 * @param nome - nome do amigo a ser adicionado
	 * @param celular - Numero do celular do amigo a ser adicionado
	 * @return id do amigo cadastrado
	 */
	public int addAmigo (String nome, String celular) {
		int idAmigo = alAmigos.size() + 1; 
		Amigo amigo = new Amigo(idAmigo, nome,celular);
		alAmigos.add(amigo);
		Collections.sort(alAmigos);
		return idAmigo;
	}
	/**
	 * Getter do tamanho da ArrayList
	 * @return int do tamanho do ArrayList
	 */

	public int getListaAmigosSize(){
		return alAmigos.size();
	}
	/**
	 * Getter para devolver uma instancia de amigo armazenada na posicao indicada.
	 * 
	 * @param i indice do amigo
	 * @return o objeto amigo
	 * 
	 */
	public Amigo getAmigo(int i){
		return alAmigos.get(i);
	}
	/**
	 * Getter da lista de amigos
	 * @return o objeto da lista de amigos
	 */
	public  ArrayList<Amigo> getAlAmigos() {
		return alAmigos;
	}
	/**
	 * Setter do ArrayList de amigos
	 * @param alAmigos - Array List de amigos
	 */
	public void setAlAmigos(ArrayList<Amigo> alAmigos) {
		this.alAmigos = alAmigos;
	}



}
