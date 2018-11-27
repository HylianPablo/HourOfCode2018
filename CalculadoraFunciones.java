//Ejemplo de calculadora con funciones
//Tambien contiene arrays, pero simples
//Se pueden comentar los compuestos, ej matrices
//

import java.util.Scanner;
import java.util.InputMismatchException;

public class CalculadoraFunciones{

	public static Scanner teclado = new Scanner(System.in);
	public static double [] array = new double[3]; 

	public static double argumento2(){								//Se toman argumentos erroneos en el main y resetea el programa ya sea arg1 o arg2 erroneos
		System.out.println("Introduzca el segundo argumento.");		//Se podrian hacer excepciones separadas con try/catch/finally pero seria liarse
		double arg2=teclado.nextDouble();
		System.out.println("");
		while(arg2!=((double)arg2)){
			System.out.println("Segundo argumento invalido, vuelva a introducir por favor.");
			arg2=teclado.nextDouble();
			System.out.println("");
		}
		array[1]=arg2;
		return arg2;
	}

	public static double suma(double a, double b){
		return (a+b);
	}

	public static double resta(double a,double b){
		return (a-b);
	}

	public static double multiplicacion(double a,double b){
		return (a*b);
	}

	public static double division(double a, double b){
		return(a/b);
	}

	public static void main(String args[]){
		
		int constante=0;
		System.out.println("BIENVENIDO A SU CALCULADORA.");
		while(constante==0){
		
			try{	
				System.out.println("");
				System.out.println("#######################################################");
				System.out.println("");
		
				//teclado = new Scanner(System.in);

				System.out.println("Introduzca el primer argumento.");
	       		double arg1=teclado.nextDouble();
				System.out.println("");
				while(arg1 != ((double)arg1)){		//Se podria comprobar tambien que no se salga del rango de double
					System.out.println("Primer argumento invalido, vuelva a introducir por favor.");
					arg1=teclado.nextDouble();
					System.out.println("");
				}
				array[0]=arg1;

				int operacion;
				System.out.println("¿Que operacion desea realizar?");
				System.out.println("1--Suma.");
				System.out.println("2--Resta.");
				System.out.println("3--Multiplicacion");
				System.out.println("4--Division");
				System.out.println("0--Salir");

				operacion=teclado.nextInt();
				System.out.println("");
				while(operacion <0 || operacion >4){
					System.out.println("Por favor, introduzca una operacion valida.");
					operacion=teclado.nextInt();
					System.out.println("");
				}

				double arg2;
				//La idea de hacerlo tan tedioso es hacer una funcion que tome numeros por teclado y reducir mucho el programa
				switch(operacion){
				
				case 1:
					arg2=argumento2();
					array[2]=(suma(arg1,arg2));
					System.out.println(array[2]);
					break;

				case 2:
					arg2=argumento2();
					array[2]=(resta(arg1,arg2));
					System.out.println(array[2]);
					break;

				case 3:
					arg2=argumento2();
					array[2]=(multiplicacion(arg1,arg2));
					System.out.println(array[2]);
					break;

				case 4:
					arg2=argumento2();
					array[2]=(division(arg1,arg2));
					System.out.println(array[2]);
					break;
				

				default:
					constante=-1;
					break;
				}

				System.out.println("Si desea continuar pulse 1, en caso contrario pulse 0.");
				int continuar=teclado.nextInt();
				System.out.println("");
				while(continuar !=((int)continuar) || continuar<0 || continuar>1){
					System.out.println("Argumento incorrecto, por favor, introduzca de nuevo.");
					continuar=teclado.nextInt();
					System.out.println("");
				}

				if(continuar==0){
					System.out.println("Hasta luego!");
					constante=-1;
				}
			}catch(InputMismatchException e){
				System.out.println("");
				System.out.println("ARGUMENTO DE TIPO ERRONEO. LA CALCULADORA PROCEDERA A RESETEARSE.");
				System.out.println("");
				teclado.next();
			}	
		}
	}
}
