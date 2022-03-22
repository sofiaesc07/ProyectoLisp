import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
* Autor: Joshua Chicoj (20566) y Sofía Escobar (20489) 
* Descripcion: Se encarga de los HashMaps y de guardar y mostrar funciones y variables. 
*/

public class Define {

	//Variables
	private HashMap<String, ArrayList<String>> funtions;
	private HashMap<String, String> variables;
	
	//Constructor
	public Define() {
		funtions = new HashMap <String, ArrayList<String>>();
		variables = new HashMap <String, String>();
	}
	 
	//Guarda una funcion en el HashMap
	public void saveFuntions(String name, ArrayList<String> instruc) {
		funtions.put(name, instruc);
	}
	 
	//Metodo para guardar una variable en el HashMap
	public void saveVariable(String name, String val) {
		variables.put(name, val);
	}
	
	//Muestra las funciones
	public ArrayList<String> showFuntions(String keyV) {
		ArrayList<String> result = new ArrayList<String>();
		result = null;
		for(Map.Entry<String, ArrayList<String>> IndividFuntio: funtions.entrySet()) {	
			if(IndividFuntio.getKey().equals(keyV)) {
				result = IndividFuntio.getValue();
			}
		}return result;
	}
	 
	//Muestra las variables
	public String showVariable(String keyV) {
		String valueToReturn = "";
		for(Map.Entry<String, String> IndivVar: variables.entrySet()) {	
			if(IndivVar.getKey().equals(keyV)) {
				valueToReturn = IndivVar.getValue();
			}
		}if(valueToReturn.equals("")) {
			return "Funcion inexistente";
		}else {
			return valueToReturn;
		}
	}
	 
	//Método para obtener las funciones del HashMap
	public HashMap<String, ArrayList<String>> getFuntions() {
		return funtions;
	}

	//Método para obtener las Variables del HashMap
	public HashMap<String, String> getVariables() {
		return variables;
	}
	
	/** 
	* @return ArrayList<String>
	*/ 
	public ArrayList<String> getB(String key) {
		return funtions.get(key);
	}
	
	//Obtener el tamaño de las funciones
	public int getSize() {
		return funtions.size();
	}

	//Obtener el nombre de las variables
	public String getValue(String name) {
		return variables.get(name);
	}
}