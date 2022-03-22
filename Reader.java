import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
* Autor: Joshua Chicoj (20566) y Sofía Escobar (20489) 
* Descripcion: Responsable de leer el archivo en lisp. 
*/

public class Reader {
	
	//Metodo para leer documento y enviar lineas de codigo
	public ArrayList<String> readDoc() {
		ArrayList<String> codigo = new ArrayList<String>();
		try {
			FileReader lispar = new FileReader("Convertidor.txt");
			//FileReader fr = new FileReader("Factorial.txt"); Por si quieren probar con otro programa Lisp.
			BufferedReader begin = new BufferedReader(lispar);
			String string;
				
			while((string = begin.readLine()) != null) {
				codigo.add(string);
			}
		}catch(java.io.FileNotFoundException noEnc) {
			System.out.println("Archivo no encontrado: " + noEnc);
		}catch(java.io.IOException ioex){
		}return codigo;
	}
}