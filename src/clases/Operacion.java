
package clases;

public class Operacion {
    
    int x,y;

    public Operacion(int a, int b){
        x=a;
        y=b;
    }
    
    public int getResta(){
        return x-y;
    }
   
    public int getSuma(){
        return x+y;
    }
    
    public int getMultiplicacion(){
        return x*y;
    }
    
    public int getDivision(){
        return x/y;
    }
    
    public int getPotencia(){
        for(int i=1; i<= y;i++){
            x=x*x;
        }
        return x;
    }
}
