import java.util.HashMap;

/**
 * Autor: Joshua Chicoj (20566) y Sofía Escobar (20489) 
 * Descripcion: 
 */

public class Pred {

	private HashMap<String, String> variables;
    
	public Pred(Define def) {
		variables = def.getVariables();
	}
	
	/**
	 * @return boolean
	 */
	public boolean Condicion(String condition) {
		int variab1 = 0, variab2 = 0;
		condition = condition.replace("(", "");
		condition = condition.replace(")", "");
		String[] temp =  condition.trim().split(" ");
		
		try {
			variab1 = Integer.parseInt(temp[1]);
		}catch(NumberFormatException e){
			variab1 = Integer.parseInt(variables.get(temp[1]));
		}
		
		try {
			variab2 = Integer.parseInt(temp[2]);
		}catch(NumberFormatException e){
			variab2 = Integer.parseInt(variables.get(temp[2]));
		}
	
		switch(temp[0]) {
		case ">":
			if(variab1 > variab2) {
				return true;
			}else return false;
		case "<":
			if(variab1 < variab2) {
				return true;
			}else return false;
		case "=":
			if(variab1 == variab2) {
				return true;
			}else return false;
		default:
			return false;
		}
	}
}