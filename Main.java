/**
 * Autor: Joshua Chicoj (20566) y Sofía Escobar (20489) 
 * Descripcion: Clase responsable de dar inicio al programa. 
 */

public class Main {
    public static void main(String[] args) {
        System.out.println("Interprete de Lisp: ");

        InterpreteLisp interp = new InterpreteLisp();

        interp.ejecutar();   
    }
}
