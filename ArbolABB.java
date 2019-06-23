
import java.util.Scanner;


public class ArbolABB
  {
   private Nodo raiz;

   public ArbolABB()
     {
      raiz=null;
     }

   public boolean buscaDatoABB(Object valor)
     {
      Nodo aux=raiz;
      boolean encontrado= false;

      while((!encontrado)&&(aux!=null))
        {
         if(((Integer)valor)<((Integer)aux.obtenDato()))
         	aux=aux.obtenHijoIzq();
         else {
               if(((Integer)valor)>((Integer)aux.obtenDato()))
         	        aux=aux.obtenHijoDer();
         	   else encontrado=true;
              }
        }
      return encontrado;
     }

   public void insertaNodoABB(Nodo n)
   {
   	Nodo aux2=raiz, aux3=null;

   	while(aux2!=null)
   	  {
   	   aux3=aux2;
   	   if(((Integer)n.obtenDato())<((Integer)aux2.obtenDato()))
   	   	  aux2=aux2.obtenHijoIzq();
   	   else aux2=aux2.obtenHijoDer();
   	  }
   	if (aux3==null)
   		raiz=n;
   	else {
   		  if(((Integer)n.obtenDato())<((Integer)aux3.obtenDato()))
   	   	     aux3.insertaHijoIzq(n.obtenDato());
   	      else aux3.insertaHijoDer(n.obtenDato());
   	     }
   }

   public void borrarNodoABB(Object valor)
     {
      Nodo aux=raiz, aux2=null;
      boolean encontrado= false;

      while((!encontrado)&&(aux!=null))
        {
         if(((Integer)valor)<((Integer)aux.obtenDato()))
           {
         	aux2=aux;
         	aux=aux.obtenHijoIzq();
           }
         else {
               if(((Integer)valor)>((Integer)aux.obtenDato()))
                  {
                  	aux2=aux;
                  	aux=aux.obtenHijoDer();
                  }
         	   else encontrado=true;
              }
        }
      Nodo temp=aux;
      if((aux.obtenHijoIzq()==null)&&(aux.obtenHijoDer()==null))
        {
         if(aux2==null)
           {
           	raiz=null;
           }
         else {
               if (((Integer)aux.obtenDato())<((Integer)aux2.obtenDato()))
         	      aux2.eliminaHijoIzq();
               else aux2.eliminaHijoDer();
              }
        }
      else {
      	    if((aux.obtenHijoIzq()!=null)&&(aux.obtenHijoDer()==null))
      	      {
      	       if (aux2==null)
      	         {
      	       	  aux.insertaDato((aux.obtenHijoIzq()).obtenDato());
      	       	  aux.eliminaHijoIzq();
      	         }
      	       else {
      	             if (((Integer)aux.obtenDato())<((Integer)aux2.obtenDato()))
      	                 aux2.insertaHijoIzq((aux.obtenHijoIzq()).obtenDato());
      	             else aux2.insertaHijoDer((aux.obtenHijoIzq()).obtenDato());
      	            }
      	      }
      	    else {
      	    	  if((aux.obtenHijoIzq()==null)&&(aux.obtenHijoDer()!=null))
      	    	    {
      	    	     if (aux2==null)
      	                 {
      	       	           aux.insertaDato((aux.obtenHijoDer()).obtenDato());
      	       	           aux.eliminaHijoDer();
      	                 }
      	             else {
      	    	            if (((Integer)aux.obtenDato())<((Integer)aux2.obtenDato()))
      	                        aux2.insertaHijoIzq((aux.obtenHijoDer()).obtenDato());
      	                    else aux2.insertaHijoDer((aux.obtenHijoDer()).obtenDato());
      	                  }
      	    	    }
      	    	  else {
      	    	  	    Nodo aux3=temp;
      	    	  	    boolean band=false;

      	    	  	    temp= temp.obtenHijoIzq();
      	    	  	    if (temp.obtenHijoDer()==null)
      	    	  	       band=true;

      	    	  	    while(temp.obtenHijoDer()!=null)
      	    	  	      {
      	    	  	      	aux3=temp;
      	    	  	      	temp=temp.obtenHijoDer();
      	    	  	      }
      	    	  	    aux.insertaDato(temp.obtenDato());

      	    	  	    if((temp.obtenHijoIzq()==null)&&(temp.obtenHijoDer()==null))
                          {
                          	if (band)
                          		aux.eliminaHijoIzq();
                          	else {
                                  if (((Integer)temp.obtenDato())<((Integer)aux3.obtenDato()))
                            	       aux3.eliminaHijoIzq();
                                  else aux3.eliminaHijoDer();
                          	     }
                          }
                        else {
                        	  if((temp.obtenHijoIzq()!=null)&&(temp.obtenHijoDer()==null))
      	                         {
      	                          if (band)
      	                          {
      	                          	temp.insertaDato((temp.obtenHijoIzq()).obtenDato());
      	                          	temp.eliminaHijoIzq();
      	                          }
      	                          else {
      	                                if (((Integer)temp.obtenDato())<((Integer)aux3.obtenDato()))
      	                                   aux3.insertaHijoIzq((temp.obtenHijoIzq()).obtenDato());
      	                                else aux3.insertaHijoDer((temp.obtenHijoIzq()).obtenDato());
      	                               }
      	                         }
                             }
      	    	       }
      	         }
           }

     }

   public void enOrden(Nodo n)
	  {
	   if (n!=null)
	    {
	     enOrden(n.obtenHijoIzq());
	     System.out.print("--> "+((Integer)n.obtenDato()).intValue());
	     enOrden(n.obtenHijoDer());
	    }
	  }

    public void preOrden(Nodo n)
	  {
	   if (n!=null)
	    {
	     System.out.print("--> "+((Integer)n.obtenDato()).intValue());
	     preOrden(n.obtenHijoIzq());
	     preOrden(n.obtenHijoDer());
	    }
	  }

	public void posOrden(Nodo n)
	  {
	   if (n!=null)
	    {
	     posOrden(n.obtenHijoIzq());
	     posOrden(n.obtenHijoDer());
	     System.out.print("--> "+((Integer)n.obtenDato()).intValue());
	    }
	  }


   public static int menu()
    {
     int opc;
     Scanner leer=new Scanner(System.in);

     System.out.println("\n---- MENU DE OPCIONES ----");
     System.out.println("[1] Insertar Nodo");
     System.out.println("[2] Borrar Nodo");
     System.out.println("[3] Buscar Nodo");
     System.out.println("[4] Recorre arbol en PreOrden");
     System.out.println("[5] Recorre arbol EnOrden");
     System.out.println("[6] Recorre arbol en PosOrden");
     System.out.println("[7] Salir");
     System.out.println("Opcion: ");
     opc=leer.nextInt();
     return opc;
    }

   public static void main(String args[])
      {
       boolean encontrado;
       int opc;
       Scanner leer=new Scanner(System.in);
       Integer num;
       ArbolABB arbol=new ArbolABB();

       try{
           opc=menu();
           while(opc!=7)
             {
              switch(opc)
                {
         	     case 1: System.out.print("Dame el numero a insertar en el arbol: ");
         	             num=new Integer(leer.nextInt());
         	             encontrado=arbol.buscaDatoABB(num);
         	             if (encontrado)
         	             	System.out.println("El numero: "+num+ " YA se encuentra en el arbol...");
         	             else {
         	             	   arbol.insertaNodoABB(new Nodo(num));
         	             	   System.out.println("Numero "+num+" Insertado en el arbol...");
         	                  }
         	             break;
                 case 2: System.out.print("Dame el numero a borrar en el arbol: ");
         	             num=new Integer(leer.nextInt());
         	             encontrado=arbol.buscaDatoABB(num);
         	             if (encontrado)
         	               {
         	               	arbol.borrarNodoABB(num);
         	               	System.out.println("El numero: "+num+ " ha sido borrado del arbol...");
         	               }
         	             else System.out.println("El numero: "+num+ " NO se encuentra en el arbol...");
         	             break;
         	     case 3: System.out.print("Dame el numero a buscar en el arbol: ");
         	             num=new Integer(leer.nextInt());
         	             encontrado=arbol.buscaDatoABB(num);
         	             if (encontrado)
         	             	System.out.println("El numero: "+num+ " si se encuentra en el arbol...");
         	             else  System.out.println("Numero: "+num+ " NO ENCONTRADO en el arbol...");
         	             break;
         	     case 4: arbol.preOrden(arbol.raiz);
         	             break;
         	     case 5: arbol.enOrden(arbol.raiz);
         	             break;
         	     case 6: arbol.posOrden(arbol.raiz);
         	             break;
                 default:System.out.println("ERROR...");
                         break;
                }
              opc=menu();
             }
          }catch(Exception e)
          	 {
          	  System.out.println(e);
          	  return;
          	 }
      }
  }
