
package reporte.de.estudiantes;

import javax.swing.JOptionPane;

/**
 *
 * @author Mariana M
 * 
 */
public class Pila {
     private int L;
    private int T;
    private float  Vp[];
    
    // Metodos
//n tamaño de la pila
    public Pila(int n) {
        
        L= n-1;
        T= -1;
        Vp= new float [n];
    }

    public int getL() {
        return L;
    }

    public void setL(int L) {
        this.L = L;
    }

    public int getT() {
        return T;
    }

    public void setT(int T) {
        this.T = T;
    }

    public float[] getVp() {
        return Vp;
    }

    public void setVp(float[] Vp) {
        this.Vp = Vp;
    }
   
    public float Desapilar()
    {
        float r;
        r  = Vp[T];
        T--;
        return r;
        
    }
    public void Apilar(float d)
    {
        T++;
        Vp[T]=d;
        
    }
    
    public boolean Pilavacía()
    {
        boolean r =false;
        if(T==-1)
        {
            r=true;
        }
        return r;
        
    }
    public boolean Pilallena()
    {
        boolean r =false;
        if(T==L)
        {
            r=true;
        }
        return r;
    }
    
    public void LlenarPila(Pila A)
    {
        while(!A.Pilavacía())
        {
            Apilar(A.Desapilar());
        }
    }
    
    // Métodos
    public void MostrarP()
    {
        
        String s = " ";
        int i, j,b= L - T; 
          for(i=0;i<b;i++)
        {
            s = s + "[    ]\n ";
        }
        
          for(j=0;j<T+1; j++)
          {
              s = s + "[  " + Vp[T-j] + " ]\n";
          }
          
          s= s + "---------";
          
          JOptionPane.showMessageDialog(null, s, "Impresión Pilas", 3);
    }
    public boolean ValidarN(float d)
     {
         boolean r = false;
         if(d>=0 && d<=5)
         {
             r =true;
         }
         else
         {
            JOptionPane.showMessageDialog(null, "Ingresa una nota válida", "Impresión Pilas", 3); 
         }
         return r;
     }
    public void ModificarPila(int op)
    {
        Pila P = new Pila(L+1);
        Validar Val = new Validar();
        float not;
        op--;
        
        while(op!=T)
        {
            P.Apilar(Desapilar());
        }
        if(op==T)
        {
            Desapilar();
            do
            {
                not =Val.ValidarFloat("Ingresa nueva nota");
            }
            while(!ValidarN(not));
            Apilar(not);
        }
        while(!Pilallena())
        {
            LlenarPila(P);
        }
        
    }
    public float Promedio()
    {
        float p=0;
        
        Pila A= new Pila(4);
        while(!this.Pilavacía())
        {
            p+=Vp[T];
            A.Apilar(Desapilar());
        }
        LlenarPila(A);
        p=p/4;
        return p;
        
    }
   

    public void Ordenar() {
        float aux;
        Pila p2, p3;
        if (Pilavacía()) {
            JOptionPane.showConfirmDialog(null, "pila vacia");
        } else {
            p2 = new Pila(L + 1);
            p3 = new Pila(L + 1);
            while (!p2.Pilavacía()|| !Pilavacía()) {
                aux = Desapilar();
                while (!Pilavacía()) {
                    if (Vp[T] > aux) {
                        p2.Apilar(aux);
                        aux = Desapilar();
                    } else {
                        p2.Apilar(Desapilar());
                    }
                }
                p3.Apilar(aux);
                this.LlenarPila(p2);

            }
            while (!p3.Pilavacía()||Pilavacía()) {
                this.Apilar(p3.Desapilar());
            }
        }
    }
}
