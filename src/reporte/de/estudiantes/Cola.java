
package reporte.de.estudiantes;

import javax.swing.JOptionPane;

/**
 *
 * @author Mariana M
 */
public class Cola {

    private Nodo Punta;
    private int Lim,Top;
    
        
    public Cola(int n) {
        
        Punta=null;
        Top =0;
        Lim =n;
        
    }
    
    public Nodo Desencolar()
    {
        Nodo r = new Nodo();
        r=Punta;
        Punta = Punta.getLiga();
        r.setLiga(null);
        Top--;
        return r;
    }
    
    public boolean ColaVacía()
    {
        return Top==0;
    }
    
    public boolean ColaLlena()
    {
        return Top==Lim;
    }
    
    public void Encolar(Nodo x)
    {
        Nodo P;
        Top++;
        if(Punta==null)
        {
            Punta= x;
            
        }
        else
        {
             P = Punta;
            while (P.getLiga() != null)
            {
                P = P.getLiga();
            }
            P.setLiga(x);  
        }
    }
    public void LlenarCola(Cola A)
    {
        while(!A.ColaVacía())
        {
            Encolar(A.Desencolar());
        }
    }
    
    //Métodos
    public void LlenarC(Nodo x, int n)
    {
        if (!this.ColaLlena())
        {
           x.LlenarNodo(this);
           Encolar(x);
           JOptionPane.showMessageDialog(null, "Ingreso exitoso ", "Ingreso exitoso ", 3); 
        }else
        {
            JOptionPane.showMessageDialog(null, "Ya se han ingresado todos los datos ", "Cola llena ", 2); 
        }                     
    }
    public void Mostrar()
   {
        Nodo P = Punta;
        String s = " ", s2 = "";
        int i=1;
        if (P == null)
        {
            JOptionPane.showMessageDialog(null, "No se ha ingresado ningún dato ", "Cola vacía ", 2);
        } else
        {
            while (P != null)
            {
                
                s = s+ i+ ".  " + P.getCedula() +"    " + P.getNombre() +"  "+ P.getApellido()+ "     "+ P.getCarrera()+"\n ";
                P = P.getLiga();
                i++;
            }
            
            s2 = """
                    Cedulas:          Nombres:                   Carrera:
                 
                 """;

            JOptionPane.showMessageDialog(null, s2 + s, "Listado", 3);
        }
    }

    public boolean ValidarCC(long cc) {
        Cola A = new Cola(Lim);
        Nodo Aux = new Nodo();
        boolean r = false;

        while (!ColaVacía())
        {
            Aux = Desencolar();
            if (Aux.getCedula() == cc)
            {
                r = true;
            }
            A.Encolar(Aux);
        }
        LlenarCola(A);
        return r;
    }
    
    public void Buscar(long d, boolean t) 
    {
        Cola A = new Cola(Lim);
        Nodo Aux = new Nodo();
        boolean r=false;
        
        if (ColaVacía())
        {
            JOptionPane.showMessageDialog(null, "No se ha ingresado ningún dato al sistema", "Cédula no encontrada", 0);
        } else
        {
            while (!ColaVacía())
            {
                Aux = Desencolar();
                if (Aux.getCedula() == d)
                {
                    r = true;
                    Aux.MostrarNodo(t);
                }
                A.Encolar(Aux);
            }
            LlenarCola(A);
            if (r == false)
            {
                JOptionPane.showMessageDialog(null, "La cédula no está en la lista", "Cédula no encontrada", 0);
            }
        }
    }
    public void OrdenarColaA()
    {
        Cola A =new Cola(Lim), A2=new Cola(Lim);
        Nodo x=new Nodo();
        if(ColaVacía())
        {
            JOptionPane.showMessageDialog(null, "No hay datos que ordenar", "Cola vacía", 0);
        } else
        {
            A.LlenarCola(this);
            do
            {
                if (!A.ColaVacía())
                {
                    x = A.Desencolar();
                }
                while (!A.ColaVacía())
                {
                    if (x.getCedula() < A.Punta.getCedula())
                    {
                        A2.Encolar(A.Desencolar());
                    } else
                    {
                        A2.Encolar(x);
                        x = A.Desencolar();
                    }
                }
                
                if (x != null)
                {
                    Encolar(x);
                    x=null;
                }
                
                if (!A2.ColaVacía())   
                {
                    x = A2.Desencolar();
                }
                while (!A2.ColaVacía())
                {
                    if (x.getCedula() < A2.Punta.getCedula())
                    {
                        A.Encolar(A2.Desencolar());
                    } else
                    {
                        A.Encolar(x);
                        x = A2.Desencolar();
                    }
                }
                
                if (x != null)
                {
                    Encolar(x);
                    x=null;
                }

            } while ((!A.ColaVacía()) || (!A2.ColaVacía()));

        }
    }
    
    public void OrdenarColaD()
    {
        Cola A =new Cola(Lim), A2=new Cola(Lim);
        Nodo x=new Nodo();
        if(ColaVacía())
        {
            JOptionPane.showMessageDialog(null, "No hay datos que ordenar", "Cola vacía", 0);
        } else
        {
            A.LlenarCola(this);
            do
            {
                if (!A.ColaVacía())
                {
                    x = A.Desencolar();
                }
                while (!A.ColaVacía())
                {
                    if (x.getCedula() > A.Punta.getCedula())
                    {
                        A2.Encolar(A.Desencolar());
                    } else
                    {
                        A2.Encolar(x);
                        x = A.Desencolar();
                    }
                }
                
                if (x != null)
                {
                    Encolar(x);
                    x=null;
                }
                
                if (!A2.ColaVacía())   
                {
                    x = A2.Desencolar();
                }
                while (!A2.ColaVacía())
                {
                    if (x.getCedula() > A2.Punta.getCedula())
                    {
                        A.Encolar(A2.Desencolar());
                    } else
                    {
                        A.Encolar(x);
                        x = A2.Desencolar();
                    }
                }
                
                if (x != null)
                {
                    Encolar(x);
                    x=null;
                }

            } while ((!A.ColaVacía()) || (!A2.ColaVacía()));

        }
    }
    public void Modificar(long d, boolean t)
    {
        Cola A = new Cola(Lim);
        Nodo Aux = new Nodo();
        long cc;
        Validar Val =new Validar();
        int op;
       
        if(!ValidarCC(d))
        {
            JOptionPane.showMessageDialog(null, "No tienes datos para modificar", "Cédula no encontrada", 0);
        }else
        {
            while (!ColaVacía())
            {
                Aux = Desencolar();
                if (Aux.getCedula()!=d)
                {
                    A.Encolar(Aux);
                }else
                {
                    Aux.MostrarNodo(t);
                    do
                    {
                        op = Val.Validar_int("""
                                       ¿Qué dato deseas modificar?
                                       1.Cédula
                                       2.Nombre
                                       3.Apellido
                                       4. Carrera
                                       5. Notas
                                       6. Salir
                                            """);
                        switch(op)
                        {
                            case 1 ->
                            {
                                cc = Val.ValidarLong("Ingresa la nueva cédula:");
                                while (ValidarCC(cc)==true)
                                {
                                    cc = Val.ValidarLong("Ingresa la nueva cédula:");
                                    ValidarCC(cc);
                                }
                                Aux.setCedula(cc);
                            }
                            case 2 ->
                            {
                                Aux.setNombre(Val.Validar_String("Ingresa Nuevo nombre"));
                            }
                            case 3 ->
                            {
                                Aux.setApellido(Val.Validar_String("Ingresa nuevo Apellido"));
                            }
                            case 4 ->
                            {
                                Aux.setCarrera(Val.Validar_String("Ingresa Nombre de la carrera"));
                            }
                            case 5 ->
                            {
                                op = Val.Validar_int("""
                                                ¿Qué nota deseas modificar?
                                                1.Fisica
                                                2.Cáculo
                                                3.M. Discretas
                                                4.G. vectorial
                                             
                                            """);
                               Aux.getMateria().ModificarPila(op);

                            }
                            case 6 ->
                            {
                               JOptionPane.showMessageDialog(null, "Devuelta al menú principal", "Salir", 3); 
                            }
                            default ->
                            {
                                JOptionPane.showMessageDialog(null, "Opción incorrecta", "Opcion incorrecta", 0);
                            }
                        }
                            
                    } while (op != 6);

                    A.Encolar(Aux);
                }
                
            }
            LlenarCola(A);
        }
    }
    public void Notas(long cc)
    {
        Nodo Aux=new Nodo();
        Cola A =new Cola(Lim);
    
         if(!ValidarCC(cc))
        {
            JOptionPane.showMessageDialog(null, "No La cédula no ha sido ingresada", "Cédula no encontrada", 0);
        }else
        {
            while (!ColaVacía())
            {
                Aux = Desencolar();
                if (Aux.getCedula()!=cc)
                {
                    A.Encolar(Aux);
                }else
                {
                    Aux.getMateria().Ordenar();
                    Aux.getMateria().MostrarP();
                    A.Encolar(Aux);
                }
            }
            LlenarCola(A);
        }
    }
}
   
    

