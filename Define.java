import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 * Autor: Joshua Chicoj (20566) y Sofía Escobar (20489) 
 * Descripcion: 
 */

public class Define {

	 private HashMap<String, ArrayList<String>> funtions;
	 private HashMap<String, String> variables;
	 
	 public Define() {
		 funtions = new HashMap <String, ArrayList<String>>();
		 variables = new HashMap <String, String>();
	 }
	 
	 
	 //Guarda una funcion en el HashMap
	 public void saveFuntions(String name, ArrayList<String> instruc) {
		funtions.put(name, instruc);
	 }
	 
	 /** 
	 * @return ArrayList<String>
	 * Muestra las funciones guardadas en el Array
	 */ 
	 public ArrayList<String> showFuntions(String keyV) {
		 ArrayList<String> result = new ArrayList<String>();
		 result = null;
		 for(Map.Entry<String, ArrayList<String>> IndividFuntio: funtions.entrySet()) {	
			if(IndividFuntio.getKey().equals(keyV)) {
				result = IndividFuntio.getValue();
			}
		}return result;
	}
	 
	 //Metodo para guardar una variable en el HashMap
	 public void saveVariable(String name, String val) {
		 variables.put(name, val);
	 }
	 
	 /** 
	 * @return String
	 */ 
	//Muestra una variable seleccionada por su valor.
	 public String showVariable(String keyV) {
		 String valueToReturn = "";
		 for(Map.Entry<String, String> IndivVar: variables.entrySet()) {	
			if(IndivVar.getKey().equals(keyV)) {
				valueToReturn = IndivVar.getValue();
			}
		}if(valueToReturn.equals("")) {
			return "Error, esta funcion no existe";
		}else {
			return valueToReturn;
		}
	}
	 
	 /**
	 * @return the funciones
	 */
	public HashMap<String, ArrayList<String>> getFuntions() {
		return funtions;
	}

	/**
	 * @return the variables
	 */
	public HashMap<String, String> getVariables() {
		return variables;
	}
		
	/**
	 * @return ArraySize
	 */
	public int getSize() {
		return funtions.size();
	}

	/**
	 * @return the variables
	 */
	public String getValue(String name) {
		return variables.get(name);
	}

	/**
	 * @return Funtions body
	 */
	public ArrayList<String> getB(String key) {
		return funtions.get(key);
	}
}