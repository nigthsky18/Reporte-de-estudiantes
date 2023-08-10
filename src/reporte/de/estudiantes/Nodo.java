package reporte.de.estudiantes;

import javax.swing.JOptionPane;





/**
 *
 * @author Mariana M
 */
public class Nodo {
    // atributos
    private long Cedula;
    private String Nombre, Apellido,Carrera, NomMateria[]; 
    private Nodo Liga;
    private Pila Materia;
    
     public Nodo() {
        this.Cedula = 0;
        this.Nombre = "";
        this.Apellido = "";
        this.Carrera = "";
        this.Liga = null;
        this.Materia = new Pila(4);
        this.NomMateria = new String [4];
    }

    public Nodo(long Cedula, String Nombre, String Apellido, String Carrera, Pila Materia, String[] NomMateria) 
    {
        this.Cedula = Cedula;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Carrera = Carrera;
        this.Liga = null;
        this.Materia = new Pila(4);
        this.NomMateria= new String [4];
       
        
    }

    public Pila getMateria() {
        return Materia;
    }

    public void setMateria(Pila Materia) {
        this.Materia = Materia;
    }

    public long getCedula() {
        return Cedula;
    }
    

    public void setCedula(long Cedula) {
        this.Cedula = Cedula;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }


    public String getCarrera() {
        return Carrera;
    }

    public void setCarrera(String Carrera) {
        this.Carrera = Carrera;
    }

    public Nodo getLiga() {
        return Liga;
    }

    public void setLiga(Nodo Liga) {
        this.Liga = Liga;
    }

    public String[] getNomMateria() {
        return NomMateria;
    }

    public void setNomCarrera(String[] NomMateria) {
        this.NomMateria = NomMateria;
    }
    
    
    //
    
    
    public void LlenarNodo (Cola C)
    {
        Validar Val = new Validar();
        int i ;
        float d;
        long cc;
        cc = Val.ValidarLong("Ingresa el número de cédula");
        
        while (C.ValidarCC(cc) == true)
        {
            JOptionPane.showMessageDialog(null, "La cédula ya ha sido ingresada", "Cédula duplicada", 0);
            cc = Val.ValidarLong("Ingresa el número de cédula");
            C.ValidarCC(cc);
        }
        Cedula = cc;
        Nombre = Val.Validar_String("Ingresa el nombre del estudiante ");
        Apellido = Val.Validar_String("Ingresa primer Apellido");
        Carrera = Val.Validar_String("Ingresa la carrera");
        Materia = new Pila(4);
        NomMateria[0] = "Física";
        NomMateria[1] = "Cálculo";
        NomMateria[2] = "M. Discretas";
        NomMateria[3] = "G. Vectorial";

        for (i = 0; i < 4; i++)
        {
            d = Val.ValidarFloat("Ingresa la nota de la materia de " + NomMateria[i]);
            while(!Materia.ValidarN(d))
            {
                d = Val.ValidarFloat("Ingresa la nota de la materia de  " + NomMateria[i]);
            }
            
            Materia.Apilar(d);
        }
    }
    public void MostrarNodo(boolean t)
    {
      String s;
      
      if(t==true)
      {
          s= "Cédula: " + this.getCedula() +" \n" + "Nombre: "+ this.getNombre() +" \n"+ "Apellido: "
             + this.getApellido()+ "\n"+ "Carrera: " +this.getCarrera()+ "\n"+ "Promedio semestral: "+Materia.Promedio();
          JOptionPane.showMessageDialog(null, s ,"Reporte del semestre",3);
      }else
      {
          s= """
             Modificar\u00e1s datos del siguiente alumno:
             C\u00e9dula: """ + this.getCedula() +" " + "Nombre: "+ this.getNombre() +"  "
             + this.getApellido()+ "  "+ "Carrera: " +this.getCarrera();
          
          JOptionPane.showMessageDialog(null, s ,"Modificar datos",2);
      }
               
    }
    
}
