package Banco;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Gravacao {

 
/**
 * Grava no arquivo seriealizado .bin
 * @param p1 - objeto a ser gravado
 * @param nomeArq - nome do arquivo onde vai ser gravado
 */
      
      
      public static void gravarArquivoBinario(Object p1, String nomeArq) {
    		ObjectOutputStream saida = null; 
    		try {
    			saida = new ObjectOutputStream(new FileOutputStream(nomeArq));
    			saida.writeObject(p1);

    		} catch (IOException e1) {
    			System.out.println(e1.getMessage());
    			// varias excecoes tentando contornar o problema 
    			// para voltar a funcionar corretamente
    		} finally {
    			try {
    				if (saida != null) {
    					saida.close();
    				}
    			} catch (IOException e2) {
    				System.out.println(e2.getMessage());
    			}
    		} 
    	}
         
        

        
   /**
    * Le do arquivo .bin
    * @param nomeArq - arquivo no qual vai ser
    * @return
    */
      
  	public static  Banco lerArquivoBinario(String nomeArq) {
        	ObjectInputStream entrada = null;

    		
			Banco p1 = null;

			try {
    			entrada = new ObjectInputStream(new FileInputStream(nomeArq));
    			p1 = (Banco) entrada.readObject();
    			
    			

    		} catch (IOException e1) {
    			
    			System.out.println(e1.getMessage()); 
    		} catch (ClassNotFoundException e2) {
    			System.out.println(e2.getMessage());
    		} finally {
    			try {
    				if (entrada != null) 
    					entrada.close();
    			} catch (IOException e3) {
    				System.out.println(e3.getMessage());
    			}
    		}
    		System.out.println("\nPrimeiro objeto:\n" + p1);
    		return p1;
    	}
  	
        
      
	
}
