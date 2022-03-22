import java.util.Scanner;

/**
* Autor: Joshua Chicoj (20566) y Sofía Escobar (20489) 
* Descripcion: Se encarga de la impresión de códigó dentro del documento. 
*/

public class Print {

	//Variables
	Scanner sc = new Scanner(System.in);
	
	//Constructor
	public Print() {}
	
	//Se encarga de leer el código
	public String[] pRead(String code) {
		code = code.replace("(", "");
		code = code.replace(")", "");
		String nameVariableSetQ;
		String nameValueVariableSetQ;
		String[] temp = code.trim().split(" ");
		nameVariableSetQ = temp[0];
		
		if(temp[1].equals("read")) {
			nameValueVariableSetQ = sc.nextLine();
		}else {
			nameValueVariableSetQ = temp[1];
		}return new String[] {nameVariableSetQ, nameValueVariableSetQ};
	}

	//Se encarga de imprimir el código
	public String pPrint(String code) {
		String iterated = "";
		int stateString = 0;
		for(char x: code.toCharArray()) {
			if(stateString == 1) {		
				iterated += x;
			}if(x == '\"') {
				if(stateString == 0) {
					stateString = 1;
				}else{
					iterated = iterated.substring(0, iterated.length() - 1).trim();
					stateString = 0;
				}
			}
		}return iterated;
	}
}