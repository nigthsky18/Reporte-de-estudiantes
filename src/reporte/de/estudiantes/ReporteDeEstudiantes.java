
package reporte.de.estudiantes;

import javax.swing.JOptionPane;

/**
 *
 * @author Mariana M
 */
public class ReporteDeEstudiantes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Validar Val= new Validar(); 
        int op,n = Val.Validar_int("Ingresa el número de estudiantes ");
        long cc;
        boolean t;
        Nodo x;
        Cola C= new Cola(n);

        do
        {
            op = Val.Validar_int("""
                                            Reporte de estudiantes  
                                                                                                                                   
                                            1. Ingresar datos de los estudiantes
                                            2. Listado de estudiantes (Ordenado)
                                            3. Notas de cada Materia 
                                            4. Reporte semestral (Promedio individual).
                                            5. Modificar datos
                                            6. Salir. 
                                                                      
                                            """);
            switch(op)
            {
                case 1 ->
                {
                    x = new Nodo();
                    C.LlenarC(x, n);
                }
                case 2 ->
                {
                    if (C.ColaVacía())
                    {
                        JOptionPane.showMessageDialog(null, "No hay datos para ordenar", "Cola vacía", 0);
                    } else
                    {
                        do
                        {

                            op = Val.Validar_int("""
                                            ¿En que orden desea ver el listado? 
                                                                                                                                   
                                            1. Orden Ascendente (Cédulas)
                                            2. Orden descendente (Cédulas)
                                            3. Mostrar
                                            4. Salir.            
                                            """);
                            switch (op)
                            {
                                case 1 ->
                                {
                                    C.OrdenarColaA();
                                    C.Mostrar();
                                }
                                case 2 ->
                                {
                                    C.OrdenarColaD();
                                    C.Mostrar();
                                }
                                case 3 ->
                                {
                                    C.Mostrar();
                                }
                                case 4 ->
                                {
                                    JOptionPane.showMessageDialog(null, "Devuelta al menú principal", "Salir", 3);
                                }
                            }
                        } while (op != 4);
                    }

                }
                case 3 ->
                        
                {
                    cc = Val.ValidarLong("""
                                            Para ver tus notas ingresa el número de cédula del estudiante                    
                                            """);
          
                                C.Notas(cc);
                    
                    
                }
                case 4 ->
                {
                    t=true;
                    cc = Val.ValidarLong("""
                                            Para ver el reporte semestral
                                            Ingresar el número de cédula del estudiante                    
                                            """);
                    C.Buscar(cc,t);
                }
                case 5 ->
                {
                    t=false;
                    cc = Val.ValidarLong("""
                                            Ingresar el número de cédula del estudiante
                                            Para modificar datos
                                            """);
                    C.Modificar(cc, t);
                    
                }
                case 6->
                {
                    JOptionPane.showMessageDialog(null, "Adiós :)","Salir :(",3);
                }
                default ->
                {
                    JOptionPane.showMessageDialog(null, "Opción inválida","Dato incorrecto",0);
                }
            }
                    

        } while(op != 6);
    
        
     
    }


}
