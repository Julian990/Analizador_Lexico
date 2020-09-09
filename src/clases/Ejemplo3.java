import java.io.*;
public class Ejemplo3{

	public static void main(String [] args){
		
			System.out.println("Digite un valor entero: ");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			try{
				int x = Integer.parseInt(br.readLine());
				suma(x);
			}catch(Exception w){
			}
			

	}

	public static void suma(int x, int y){
		System.out.println("La suma es: "+ (x+y));
	}
}