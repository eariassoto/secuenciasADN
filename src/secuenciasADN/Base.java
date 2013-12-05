/**
 * @author Emmanuel Arias Soto B30640
 * La clase Base es el nodo base de la tira de ADN
 * Contiene punteros a su siguiente y anterior además de 
 * la tira paralela y su respectivo puntero al comentario
 */
package secuenciasADN;

public class Base {
	private Comentario comentario;
	private char letra; // representa la sigla de la base
	private int indice;
	private boolean usado; // controla si la cabea esta usada o no
	private Base baseParalela, baseSiguiente, baseAnterior; // punteros de lista
	private Base[] copia; // punteros para inicio y fin de copia
	private boolean hayCopia;

	/**
	 * Constructor default, crea la cabeza
	 */
	public Base() {
		hayCopia = false;
		usado = false;
		baseSiguiente = null;
		baseAnterior = null;
		baseParalela = this;
		copia = new Base[2];
	}

	/**
	 * Construye la base paralela para el siguiente constructor
	 * 
	 * @param bA
	 *            puntero anterior
	 * @param l
	 *            letra
	 * @param bP
	 *            puntero paralelo
	 */
	public Base(Base bA, char l, Base bP) {
		letra = l;
		usado = true;
		baseParalela = bP;
		baseAnterior = bA;
		baseSiguiente = null;
	}

	/**
	 * Construye una par de bases agregada de forma simple (al final de la
	 * lista)
	 * 
	 * @param bA
	 *            puntero anterior
	 * @param l1
	 *            letra 1
	 * @param l2
	 *            letra 2
	 */
	public Base(Base bA, char l1, char l2) {
		letra = l1;
		usado = true;
		baseParalela = new Base(bA.baseParalela, l2, this);
		baseAnterior = bA;
		baseSiguiente = null;
	}

	/**
	 * Construye la base paralela para el constructor siguiente
	 * 
	 * @param bA
	 *            puntero anterior
	 * @param l
	 *            letra
	 * @param bP
	 *            puntero paralelo
	 * @param bS
	 *            puntero siguiente
	 */
	public Base(Base bA, char l, Base bP, Base bS) {
		letra = l;
		usado = true;
		baseParalela = bP;
		baseAnterior = bA;
		baseSiguiente = bS;
	}

	/**
	 * Construye una par de bases agregada de forma especifica (se indice el
	 * indice) caso del cuerpo
	 * 
	 * @param bA
	 *            puntero anterior
	 * @param l1
	 *            letra 1
	 * @param l2
	 *            letra 2
	 * @param bS
	 *            puntero siguiente
	 */
	public Base(Base bA, char l1, char l2, Base bS) {
		letra = l1;
		usado = true;
		baseParalela = new Base(bA.baseParalela, l2, this, bS.baseParalela);
		baseAnterior = bA;
		baseSiguiente = bS;
	}

	/**
	 * Construye la base paralela para el constructor siguiente
	 * 
	 * @param l
	 *            letra
	 * @param bP
	 *            puntero paralelo
	 * @param bS
	 *            puntero siguiente
	 */
	public Base(char l, Base bP, Base bS) {
		letra = l;
		usado = true;
		baseParalela = bP;
		baseAnterior = null;
		baseSiguiente = bS;
	}

	/**
	 * Construye una par de bases agregada de forma especifica (se indice el
	 * indice) caso de la cabeza
	 * 
	 * @param b
	 *            puntero cabeza actual
	 */
	public Base(char l, Base b) {
		letra = l;
		usado = true;
		comentario = b.comentario;
		baseParalela = new Base(b.baseParalela.letra, this,
				b.baseSiguiente.baseParalela);
		baseSiguiente = b.baseSiguiente;
	}

	/**
	 * Agrega un par de bases a la lista de manera simple
	 * 
	 * @param l1
	 *            letra 1
	 * @param l2
	 *            letra 2
	 */
	public void agregarPar(char l1, char l2) {
		if (!usado) {
			letra = l1;
			usado = true;
			baseParalela.letra = l2;
			baseParalela.usado = true;
		} else {
			Base tmp = this;
			while (tmp.baseSiguiente != null)
				tmp = tmp.baseSiguiente;
			Base bT = new Base(tmp, l1, l2);
			tmp.baseSiguiente = bT;
			tmp.baseParalela.baseSiguiente = tmp.baseSiguiente.baseParalela;
		}
		ponerIndices();
	}

	/**
	 * Agrega un par de bases de forma específica
	 * 
	 * @param pos
	 *            posicion deseada para agregar
	 * @param l1
	 *            letra 1
	 * @param l2
	 *            letra 2
	 */
	public void agregarParEn(int pos, char l1, char l2) {
		if (pos == 1) {
			Base bT = new Base(this.letra, this);
			// cc
			if (this.comentario != null)
				comentario.asociarBase(this, bT);
			this.letra = l1;
			this.baseParalela.letra = l2;
			this.baseSiguiente = bT;
			this.baseParalela.baseSiguiente = this.baseSiguiente.baseParalela;
		} else {
			Base tmp = this;
			for (int i = 1; i < pos - 1; i++)
				tmp = tmp.baseSiguiente;
			Base bT = new Base(tmp, l1, l2, tmp.baseSiguiente);
			// cc
			if (tmp.comentario != null)
				comentario.asociarBase(tmp, bT);
			tmp.baseSiguiente.baseAnterior = bT;
			tmp.baseSiguiente.baseParalela.baseAnterior = bT.baseParalela;
			tmp.baseSiguiente = bT;
			tmp.baseParalela.baseSiguiente = tmp.baseSiguiente.baseParalela;
		}
		ponerIndices();
	}

	/**
	 * Solucion rapida de ultimo momento, ineficiente
	 */
	public void ponerIndices() {
		int c = 1;
		Base tmp = this;
		while (tmp != null && tmp.usado) {
			tmp.indice = c;
			c++;
			tmp = tmp.baseSiguiente;
		}
	}

	/**
	 * Guarda los punteros de inicio y fin que se desea copiar
	 * 
	 * @param inicio
	 *            indice de posicion
	 * @param fin
	 *            indice de posicion
	 */
	public void cortar(int inicio, int fin) {
		if (inicio == 1) {
			if (fin == length()) {
				this.usado = false;
				this.baseParalela.usado = false;
				this.baseSiguiente = null;
				this.baseParalela.baseSiguiente = null;
			} else {
				copia[0] = this;
				// obtener el puntero de fin
				for (int i = 1; i < fin; i++)
					copia[0] = copia[0].baseSiguiente;
				this.letra = copia[0].baseSiguiente.letra;
				this.baseParalela.letra = copia[0].baseParalela.baseSiguiente.letra;
				this.baseSiguiente = copia[0].baseSiguiente.baseSiguiente;
				this.baseParalela.baseSiguiente = copia[0].baseSiguiente.baseParalela.baseSiguiente;
			}
		} else {
			copia[0] = this;
			// obtener el puntero de inicio
			for (int i = 1; i < inicio; i++)
				copia[0] = copia[0].baseSiguiente;
			// obtener puntero final
			copia[1] = copia[0];
			for (int j = inicio; j < fin; j++)
				copia[1] = copia[1].baseSiguiente;
			// reemplazo de punteros
			copia[0].baseAnterior.baseSiguiente = copia[1].baseSiguiente;
			copia[0].baseAnterior.baseParalela.baseSiguiente = copia[1].baseParalela.baseSiguiente;
			copia[1].baseSiguiente.baseAnterior = copia[0].baseAnterior;
			copia[1].baseSiguiente.baseParalela.baseAnterior = copia[0].baseParalela.baseAnterior;
		}
		ponerIndices();
	}

	/**
	 * Guarda los punteros de inicio y fin que se desea copiar
	 * 
	 * @param inicio
	 *            indice de posicion
	 * @param fin
	 *            indice de posicion
	 */
	public void copiar(int inicio, int fin) {
		copia[0] = this;
		// obtener el puntero de inicio
		for (int i = 1; i < inicio; i++)
			copia[0] = copia[0].baseSiguiente;
		// obtener puntero final
		copia[1] = copia[0];
		for (int j = inicio; j < fin; j++)
			copia[1] = copia[1].baseSiguiente;
		hayCopia = true;
	}

	/**
	 * Busca la cola
	 * 
	 * @return puntero con el ultimo elemento de la lista
	 */
	private Base getCola() {
		Base tmp = this;
		while (tmp.baseSiguiente != null)
			tmp = tmp.baseSiguiente;
		return tmp;
	}

	/**
	 * pega una tira indicada por los punteros copia[]
	 * @param pos posicion inicial para pegar
	 */
	public void pegar(int pos) {
		if (hayCopia) {
			Base controlCopia = copia[0];
			Base pegado = new Base();
			Base pP = new Base();
			pegado.asociarParalela(pP);
			pP.asociarParalela(pegado);
			while (controlCopia != null
					&& controlCopia.baseAnterior != copia[1]) {
				pegado.agregarPar(controlCopia.letra,
						controlCopia.baseParalela.letra);
				controlCopia = controlCopia.baseSiguiente;
			}
			Base tmp = this;
			for (int i = 1; i < pos; i++)
				tmp = tmp.baseSiguiente;
			// clon de cabeza
			pegado.agregarPar(tmp.letra, tmp.baseParalela.letra);
			// agrego punteros a cola
			Base cola = pegado.getCola();
			cola.baseSiguiente = tmp.baseSiguiente;
			cola.baseParalela.baseSiguiente = tmp.baseParalela.baseSiguiente;
			// le caigo encima
			tmp.letra = pegado.letra;
			tmp.baseParalela.letra = pegado.baseParalela.letra;
			tmp.baseSiguiente = pegado.baseSiguiente;
			tmp.baseParalela.baseSiguiente = pegado.baseParalela.baseSiguiente;
		}
		ponerIndices();
	}

	/**
	 * Invierte una parte de la secuencia de ADN
	 * @param inicio indice inicial
	 * @param fin indice final
	 */
	public void invertir(int inicio, int fin) {
		// encuentra el inicio de la inversion
		Base punteroInicio = this;
		for (int i = 1; i < inicio; i++)
			punteroInicio = punteroInicio.baseSiguiente;
		// coloco los punteros al inicio
		Base baseDerecha = punteroInicio;
		Base baseIzquierda = punteroInicio;
		// ayuda para intercambio
		Base aux = new Base();
		aux.baseParalela = new Base();
		// indices de control
		int izq = inicio;
		int der = fin;
		while (izq < der) {
			// pongo puntero al inicio
			baseDerecha = punteroInicio;
			// lo muevo al final actual
			for (int i = inicio; i < der; i++)
				baseDerecha = baseDerecha.baseSiguiente;
			// intercambio todo
			aux.letra = baseIzquierda.letra;
			aux.baseParalela.letra = baseIzquierda.baseParalela.letra;
			baseIzquierda.letra = baseDerecha.letra;
			baseIzquierda.baseParalela.letra = baseDerecha.baseParalela.letra;
			baseDerecha.letra = aux.letra;
			baseDerecha.baseParalela.letra = aux.baseParalela.letra;
			// muevo indices
			izq++;
			der--;
			// muevo el puntero de inicio
			baseIzquierda = baseIzquierda.baseSiguiente;
		}
	}

	/**
	 * Devuelve la posición donde se detecte el bloque de inicio en cada tira
	 * 
	 * @param t
	 *            tira
	 * @return informe con el inicio de bloque
	 */
	public String getInicio(int t) {
		String s = "";
		s += "Inicio de bloque de tira " + t + ": ";
		if (t == 1 || t == 2) {
			Base tmp = (t == 1) ? this : this.baseParalela;
			boolean encontrado = false;
			int c = 1;
			while (tmp.baseSiguiente.baseSiguiente != null && !encontrado) {
				if (tmp.letra == 'A' && tmp.baseSiguiente.letra == 'U'
						&& tmp.baseSiguiente.baseSiguiente.letra == 'G') {
					s += c;
					encontrado = true;
				} else {
					c++;
					tmp = tmp.baseSiguiente;
				}
			}
			s += (!encontrado) ? "no hay inicio de bloque" : "";
		}
		return s;
	}

	/**
	 * Devuelve las tiras invertidas incluyendo el índice de cada base
	 * 
	 * @return bases invertidas
	 */
	public String getMoleculaInvertida() {
		String str = "";
		Base tmp = this;
		int c = 1;
		if (tmp.usado)
			str += "\n" + c++ + " " + tmp.letra + " " + tmp.baseParalela.letra;
		while (tmp.baseSiguiente != null) {
			tmp = tmp.baseSiguiente;
			if ((tmp != null) && (tmp.usado))
				str = "\n" + c++ + " " + tmp.letra + " "
						+ tmp.baseParalela.letra + str;
		}
		return str;
	}

	/**
	 * Devuelve una subsecuencia de ADN para darsela al usuario
	 * @param inicio indice
	 * @param fin indice
	 * @return subsecuencia
	 */
	public String getSubsecuencia(int inicio, int fin) {
		String str = "";
		Base tmp = this;
		// encontrar el inicio
		for (int i = 1; i < inicio; i++)
			tmp = tmp.baseSiguiente;
		// agarre la cantidad n de bases
		for (int j = 0; j < (fin - inicio + 1); j++) {
			str += tmp.letra + " " + tmp.baseParalela.letra + "\n";
			tmp = tmp.baseSiguiente;
		}
		return str;
	}

	/**
	 * Devuelve la tira de ADN con su respectiva paralela
	 * @return hilera con informacion
	 */
	public String getSecuencia() {
		String str = "";
		Base tmp = this;
		while (tmp != null) {
			if (tmp.usado)
				str += tmp.indice + " " + tmp.letra + " "
						+ tmp.baseParalela.letra + "\n";
			tmp = tmp.baseSiguiente;
		}
		return str;
	}

	/**
	 * Devuelve solo una tira indicada
	 * @param tira 1 o 2
	 * @return hilera con lista de bases
	 */
	public String getSecuencia(int tira) {
		String str = "";
		Base tmp = this;
		while (tmp != null) {
			if (tmp.usado)
				str += (tira == 1) ? tmp.letra : tmp.baseParalela.letra;
			tmp = tmp.baseSiguiente;
		}
		return str;
	}

	/**
	 * Devuelve un nodo indicado
	 * @param pos indice de la base
	 * @return base indicada
	 */
	public Base getBase(int pos) {
		Base tmp = this;
		for (int i = 1; i < pos; i++)
			tmp = tmp.baseSiguiente;
		return tmp;
	}

	/**
	 * Usado para asociar las tiras paralelas
	 * luego de la creación de ambas
	 * @param b nodo cabeza de la tira
	 */
	public void asociarParalela(Base b) {
		baseParalela = b;
	}

	/**
	 * Calcula la longitud de la secuencia
	 * @return entero con la longitud
	 */
	public int length() {
		int c = 0;
		Base tmp = this;
		while (tmp != null) {
			if (tmp.usado)
				c++;
			tmp = tmp.baseSiguiente;
		}
		return c;
	}

	/**
	 * Devuelve el indice de dicho nodo
	 * @return indice
	 */
	public int getIndice() {
		return indice;
	}

	/**
	 * Asocia el respectivo comentario con la base
	 * @param pos indice de la base
	 * @param c objeto comentario
	 */
	public void asociarComentario(int pos, Comentario c) {
		Base tmp = this;
		for (int i = 1; i < pos; i++)
			tmp = tmp.baseSiguiente;
		tmp.comentario = comentario;
	}
}
