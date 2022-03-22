import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.HashMap;

/**
* Autor: Joshua Chicoj (20566) y Sofía Escobar (20489) 
* Descripcion: Encargada de hacer los calculos que se encuentren dentro del programa. 
*/

public class Calculate {
    
    //Variables
    private HashMap<String, String> variables;
    private ArrayList<String> operators;
    private ArrayList<String> characts;
    private ArrayList<String> numbers;

    //Constructor
    public Calculate(Define def){
        operators= new ArrayList<String>(List.of("+", "-", "/", "*"));
        String caracteresString="qwertyuiopasdfghjklñzxcvbnmQWERTYUIOPASDFGHJKLÑZXCVBNM-_";
        characts= new ArrayList<String>(Arrays.asList(caracteresString.split("")));
        String numerosString="1234567890";
        numbers = new ArrayList<String>(Arrays.asList(numerosString.split("")));
        variables= def.getVariables();
    }

    //String encargado de las operaciones que se podrían encontrar en el codigo lisp
    public String operar (String Operar){
        boolean operatorFind=false;
        boolean operatorFind1=false;
        boolean operatorFind2=false;
        boolean operatorNumb=false;
        boolean operatorVar=false;
        boolean operatorExpression=false;
        String operador="";
        String Op1="";
        String Op2="";
        String temporal="";
        Operar= Operar.trim();
        String[] listaCadena = Operar.split("");
        listaCadena[0]="";
        for (String caracter: listaCadena) {
            if(!operatorFind){
                if(operators.contains(caracter)) {
                    operatorFind=true;
                    operador=caracter;
                }
            }else if(!operatorFind1){
                if(!operatorExpression &&
                        !operatorNumb &&
                        !operatorVar) {
                    if (caracter.equals("(")) {
                        operatorExpression = true;}
                    else if (characts.contains(caracter)){
                        operatorVar = true;}
                    else if (numbers.contains(caracter)) {
                        operatorNumb = true;}
                }if(operatorExpression){
                    temporal=temporal+caracter;
                    if(caracter.equals(")")){
                        Op1= operar(temporal);
                        temporal="";
                        operatorFind1=true;
                    }
                }if(operatorVar){
                    if(!caracter.equals(" ")) temporal=temporal+caracter;
                    else{
                        Op1=variables.get(temporal);
                        temporal="";
                        operatorFind1=true;
                    }
                }if(operatorNumb){
                    if(!caracter.equals(" ")) temporal=temporal+caracter;
                    else{
                        Op1=temporal;
                        temporal="";
                        operatorFind1=true;
                        operatorExpression=false;
                        operatorNumb=false;
                        operatorVar=false;
                    }
                }if(operatorFind1){
                    operatorExpression=false;
                    operatorNumb=false;
                    operatorVar=false;
                }
            }else if(!operatorFind2){   
                if(!operatorExpression &&
                    !operatorNumb &&
                    !operatorVar) {
                if (caracter.equals("(")) {
                    operatorExpression = true;}
                else if (characts.contains(caracter)){
                    operatorVar = true;}
                else if (numbers.contains(caracter)) {
                    operatorNumb = true;}
            }if(operatorExpression){
                    temporal=temporal+caracter;
                    if(caracter.equals(")")){
                        Op2= operar(temporal);
                        temporal="";
                        operatorFind2=true;
                    }
                }if(operatorVar){
                    if(!caracter.equals(" ")&&!caracter.equals(")")) temporal=temporal+caracter;
                    else{
                        Op2=variables.get(temporal);
                        temporal="";
                        operatorFind2=true;
                    }
                }if(operatorNumb){
                    if(!caracter.equals(" ")&&!caracter.equals(")")) temporal=temporal+caracter;
                    else{
                        Op2=temporal;
                        temporal="";
                        operatorFind2=true;
                    }
                }
            }
        }if(!operador.equals("")&&!Op1.equals("")&&!Op2.equals("")){
            switch (operador){
                case "*":return String.valueOf(Float.parseFloat(Op1)*Float.parseFloat(Op2));
                case "/":return String.valueOf(Float.parseFloat(Op1)/Float.parseFloat(Op2));
                case "+":return String.valueOf(Float.parseFloat(Op1)+Float.parseFloat(Op2));
                case "-":return String.valueOf(Float.parseFloat(Op1)-Float.parseFloat(Op2));
                default: return "Error";
            }
        }else return "";
    }
}