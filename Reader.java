import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Autor: Joshua Chicoj (20566) y Sofía Escobar (20489) 
 * Descripcion: Responsable de leer el archivo en lisp. 
 */

public class Reader {
	
	/** 
	 * @return ArrayList<String>
	 * Metodo para leer documento y enviar lineas de codigo
	 */ 
	public ArrayList<String> readDoc() {
		ArrayList<String> codigo = new ArrayList<String>();
		try {
			FileReader fr = new FileReader("Convertidor.txt");
			//FileReader fr = new FileReader("Factorial.txt");
			//FileReader fr = new FileReader("Convertidor.txt");
			BufferedReader begin = new BufferedReader(fr);
			String S;
				
			while((S = begin.readLine()) != null) {
				codigo.add(S);
			}
		}catch(java.io.FileNotFoundException fnfex) {
			System.out.println("Archivo no encontrado: " + fnfex);}
		catch(java.io.IOException ioex) {}
		return codigo;
	}
}