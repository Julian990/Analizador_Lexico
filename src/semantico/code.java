package semantico;
import java.io.*;
public class code {
	public static void main (String[] args) {
            
            for(int i= 0; i < 10; i++ )
            {
                    System.out.println(i);
            }
            
            int n1 = 0;	
            while(n1 <= 20)
            {
                n1++;
                System.out.println(n1);
            }

            int x=9;
            do
            {
                    x = x + 1;
                    System.out.println(x);
            }            
            while(x < 5);
            
            String[] names = new String[2];
            names[0] = "Hola";
            names[1] = "Profe";
            
            for (String name : names) {
                System.out.println(name);
            }
            int n2 = 2;        
            int n3 = 2;
            
            if( n1 >= 0 )
            {
                    n1 = n3 / n2;
            }
            
            if (n1 < 10)
            { 
                    n1 = n2 - n3; 
            }
            else
            {
                    System.out.println("Ninguna opcion");
            }
            
            switch(n3)
            {
                case 3:
                        n1 = 6 + 2;
                break;
                default:
                        n1 = 10;
                break;	
            }
            
            int entero = 7;
            String texto = "Rocio";
            double decimal = 3.5;
            char caracter = 'R';
				
	}
}
