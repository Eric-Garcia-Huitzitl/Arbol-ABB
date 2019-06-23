
class Nodo {

	    private Object dato;
		private Nodo hijoIzq, hijoDer;

        public Nodo()
          {
           dato=null;
           hijoIzq=null;
           hijoDer=null;
          }

		public Nodo(Object dato)
		   {
			this.dato = dato;
			hijoIzq=null;
			hijoDer=null;
		   }

	    public Nodo(Object dato, Nodo hijoIzq, Nodo hijoDer)
		   {
			this.dato = dato;
			this.hijoIzq=hijoIzq;
			this.hijoDer=hijoDer;
		   }

		public void insertaDato(Object dato)
		   {
			this.dato = dato;
		   }

		public Object obtenDato()
		   {
			return dato;
		   }

		public boolean tieneHijoIzq()
		   {
			return (hijoIzq != null);
		   }

		public boolean tieneHijoDer()
		   {
			return (hijoDer != null);
		   }

		public Nodo obtenHijoIzq()
		   {
			return hijoIzq;
		   }

		public Nodo obtenHijoDer()
		   {
			return hijoDer;
		   }

		public Nodo insertaHijoIzq(Object dato)
		   {
			Nodo tempNodo = new Nodo(dato);
			hijoIzq = tempNodo;
			return tempNodo;
		   }

		public Nodo insertaHijoDer(Object dato)
		   {
			Nodo tempNodo = new Nodo(dato);
			hijoDer = tempNodo;
			return tempNodo;
		   }

		public Nodo eliminaHijoIzq()
		   {
			Nodo tempNodo = hijoIzq;
			hijoIzq = null;
			return tempNodo;
		   }

		public Nodo eliminaHijoDer()
		   {
			Nodo tempNodo = hijoDer;
			hijoDer = null;
			return tempNodo;
		   }

		public int grado()
		   {
			int i = 0;
			if (hijoIzq != null) i++;
			if (hijoDer != null) i++;
			return i;
		   }
	}
