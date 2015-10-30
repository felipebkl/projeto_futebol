package util;
import java.util.Scanner;

/**
 * Classe responsavel por conter os metodos de entradas externas
 * por meio da classe Scanner.
 *
 * Created by marcus.rodrigues on 07/03/2015.
 */
public class Console {

    /**
     * Metodo para entrada de dados do tipo String
     *
     * @param input Parametro do tipo Object com a mensagem informando tipo de dado de entrada.
     * @return ler.nextLine() retorna a chamada do metodo de entrada da classe Scanner
     */
    public static String lerString(Object input){

        System.out.print(input);
        Scanner ler = new Scanner(System.in);
        return(ler.nextLine());
    }
  
    /**
     * Metodo para entrada de dados do tipo Int
     *
     * @param input Parametro do tipo Object com a mensagem informando tipo de dado de entrada.
     * @return ler.nextInt() retorna a chamada do metodo de entrada da classe Scanner
     */
    public static int lerInt(Object input){

        System.out.print(input);
        Scanner ler = new Scanner(System.in);
        return (ler.nextInt());
    }

    /**
     * Metodo para entrada de dados do tipo Double
     *
     * @param input Parametro do tipo Object com a mensagem informando tipo de dado de entrada.
     * @return ler.nextDouble() retorna a chamada do metodo de entrada da classe Scanner
     */
    public static Double lerDouble(Object input){

        System.out.print(input);
        Scanner ler = new Scanner(System.in);
        return (ler.nextDouble());
    }

    /**
     * Metodo para entrada de dados do tipo Boolean
     *
     * @param input Parametro do tipo Object com a mensagem informando tipo de dado de entrada.
     * @return ler.nextBoolean() retorna a chamada do metodo de entrada da classe Scanner
     */
    public static Boolean lerBoolean(Object input){

        System.out.print(input);
        Scanner ler = new Scanner(System.in);
        return (ler.nextBoolean());
    }
    /**
     * Metodo para entrada de dados do tipo Float
     *
     * @param input Parametro do tipo Object com a mensagem informando tipo de dado de entrada.
     * @return ler.nextFloat() retorna a chamada do metodo de entrada da classe Scanner
     */
    public static float lerFloat(Object input){

        System.out.print(input);
        Scanner ler = new Scanner(System.in);
        return (ler.nextFloat());
    }

    /**
     * Metodo para entrada de dados do tipo Char
     *
     * @param input Parametro do tipo Object com a mensagem informando tipo de dado de entrada.
     * @return ler.next() retorna a chamada do metodo de entrada da classe Scanner
     */
    public static char lerChar(Object input){

        System.out.print(input);
        Scanner ler = new Scanner(System.in);
        return (ler.next().charAt(0));
    }
    
    // le outros
    
    public static String scanString(Object out)
	{
		System.out.print(out);
		Scanner scanner = new Scanner (System.in);
		return(scanner.nextLine());
	}
	
	public static int scanInt(Object out)
	{
		System.out.print(out);
		Scanner scanner = new Scanner (System.in);
		return(scanner.nextInt());		
	}

	public static double scanDouble(Object out)
	{
		System.out.print(out);
		Scanner scanner = new Scanner (System.in);
		return(scanner.nextDouble());		
	}

	public static float scanFloat(Object out)
	{
		System.out.print(out);
		Scanner scanner = new Scanner (System.in);
		return(scanner.nextFloat());		
	}

	public static boolean scanBoolean(Object out)
	{
		System.out.print(out);
		Scanner scanner = new Scanner (System.in);
		return(scanner.nextBoolean());		
	}
	
	public static char scanChar(Object out)
	{
		System.out.print(out);
		Scanner scanner = new Scanner (System.in);
		return(scanner.next().charAt(0));				
	}
}
