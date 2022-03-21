import java.util.ArrayList;
import java.util.Scanner;

/**
 * Autor: Joshua Chicoj (20566) y Sofía Escobar (20489) 
 * Descripcion: Responsable de la traducción de lisp a java, aqui se ejecuta el codigo.
 */

public class InterpreteLisp {

	private Reader read = new Reader();
	private Print print = new Print();
	private Define def = new Define();
	private Calculate calcu = new Calculate(def);
	private Pred pre = new Pred(def);
	private ArrayList < String > codigo = new ArrayList < String > ();

	Scanner sc = new Scanner(System.in);

	public InterpreteLisp() {
		codigo = read.readDoc();
	}

	public void Vista() {
		for (String line: codigo) {
			System.out.println(line);
		}
	}

	public void ejecutar() {
		process(codigo);
	}

	public void process(ArrayList < String > codigo) {
		String iterated = "";
		String nameFunction = "";
		ArrayList < String > functionContain = new ArrayList < String > ();
		boolean funtionName = false;
		int counter = 0;
		boolean inside = false;
		boolean calc = false;
		boolean readerFuntion = false;
		boolean fir = false, sec = false;

		for (String line: codigo) {
			if(sec) {   //Hecho para ignorar la linea de un if que se active
				sec = false;
				continue;
			}if(fir) {
				fir = false;
				sec = true;
			}for (char x: line.toCharArray()) {
				iterated += x;
				readerFuntion = iterated.contains("defun");
				if (iterated.equals("\t") || iterated.equals(" ")) {
					iterated = "";
				}if (inside) {
					if (x == '(') {
						counter += 1;
					} else if (x == ')') {
						counter -= 1;
					}
				}if (iterated.contains("princ") && !inside) { //Por si se encuentra un princ
					System.out.println(print.pPrint(line));
					iterated = "";
				} else if (iterated.contains("print") && !inside) { //Por si se encuentra un print
					System.out.println(print.pPrint(line));
					iterated = "";
				} else if (readerFuntion) {
					iterated = "";
					funtionName = true;
					counter = 1;
					inside = true;
				} else if (iterated.contains("setq") && !inside) { //Por si se encuentra un setq
					iterated = "";
					String[] values = print.pRead(line.replace("setq", ""));
					def.saveVariable(values[0], values[1]);
				} else if (iterated.contains("set'") && !inside) { //Por si se encuentra un set'
					iterated = "";
					String[] values = print.pRead(line.replace("set'", ""));
					def.saveVariable(values[0], values[1]);
					System.out.println(values[1]);
				} else if(iterated.contains("if") && !inside) {
					iterated = "";
					boolean resultado = pre.Condicion(line.replace("if", "")); // Por si encuentra un if
					if(!resultado) {
						sec = true;
					}else fir = true;
				} else if ((iterated.contains("/") || iterated.contains("-") || iterated.contains("+") || iterated.contains("*")) && !inside) {
					calc = true;
				}else if (!inside) {
					if (iterated.length() > 2) {
						if (!iterated.substring(iterated.length() - 1).equals(" ")) {
							StringBuilder sb = new StringBuilder(iterated.trim());
							sb.deleteCharAt(iterated.length() - 1);
							sb.deleteCharAt(0);
							sb.deleteCharAt(0);
							String nombre = sb.toString();
							String[] nombre_arreglo = nombre.split(" ");
							ArrayList < String > funcion = new ArrayList<>();
							if(nombre_arreglo.length > 1) {
								funcion = def.getB(nombre + "(n)");
								def.saveVariable("n", nombre_arreglo[1]);
							} else {
								funcion = def.getB(nombre + "()");
							}if (funcion != null) {
								process(funcion);
							}
						}
					}
				}if (funtionName) {
					String caracter = "";
					if (iterated.length() > 1) {
						caracter = iterated.substring(iterated.length() - 1);
					}else {
						caracter = iterated;
					}if (caracter.equals(")")) {
						nameFunction = iterated.trim();
						funtionName = false;
						iterated = "";
					}
				}if (counter > 0 && !funtionName) {
					if (counter == 1) {
						if (iterated.length() > 1) {
							functionContain.add(iterated.trim());
							iterated = "";
						}
					}
				}if (counter == 0) {
					inside = false;
					if (functionContain.size() > 0) {
						ArrayList < String > copia = copia(functionContain);
						def.saveFuntions(nameFunction, copia);
						functionContain.clear();
					}
				}
			}if (calc) {
				System.out.println(calcu.operar(line));
			}
		}
	}

	public ArrayList < String > copia(ArrayList < String > orginal) {
		ArrayList < String > copy = new ArrayList < String > ();
		for (String S: orginal) {
			copy.add(S);
		}return copy;
	}
}