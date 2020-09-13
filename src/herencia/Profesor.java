package herencia;

public class Profesor extends Persona {
    
    private String idProfesor;

    public Profesor (String nombre, String apellidos, int edad, String idProfesor) {

        super(nombre, apellidos, edad);

        this.idProfesor = idProfesor;   
    }
  
    public void setIdProfesor (String IdProfesor) { this.idProfesor = IdProfesor;   }

    public String getIdProfesor () { return idProfesor;   }

    public void mostrarDatosProfesor() {

        System.out.println ("Profesor de nombre " + getNombre() + " " +  getApellidos() +

         " con Id de profesor " + getIdProfesor() ); 
    }

}
