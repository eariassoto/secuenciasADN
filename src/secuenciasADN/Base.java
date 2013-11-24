package secuenciasADN;

public class Base {

	private char letra; // representa la sigla de la base
	private boolean usado; // controla si la cabea esta usada o no
	private Base baseParalela, baseSiguiente, baseAnterior; // punteros de lista
	private Base[] copia; // punteros para inicio y fin de copia
	private Comentario comentario; // puntero al comentario
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
			this.letra = l1;
			this.baseParalela.letra = l2;
			this.baseSiguiente = bT;
			this.baseParalela.baseSiguiente = this.baseSiguiente.baseParalela;
		} else {
			Base tmp = this;
			for (int i = 1; i < pos - 1; i++)
				tmp = tmp.baseSiguiente;
			Base bT = new Base(tmp, l1, l2, tmp.baseSiguiente);
			tmp.baseSiguiente.baseAnterior = bT;
			tmp.baseSiguiente.baseParalela.baseAnterior = bT.baseParalela;
			tmp.baseSiguiente = bT;
			tmp.baseParalela.baseSiguiente = tmp.baseSiguiente.baseParalela;

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

	// TODO considerar despues los comentarios
	public void pegar(int pos) {
		if (hayCopia) {
			// considere caso cabeza antes
			// puntero donde hay que pegar
			Base controlInicio = this;
			for (int i = 1; i < pos; i++)
				controlInicio = controlInicio.baseSiguiente;
			Base controlCopia = copia[0];
			// hago una lista nueva
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
			if (controlInicio.baseSiguiente != null) {
				Base colaPegado = pegado.getCola();
				colaPegado.baseSiguiente = controlInicio.baseSiguiente;
				colaPegado.baseParalela.baseSiguiente = controlInicio.baseParalela.baseSiguiente;
				controlInicio.baseSiguiente.baseAnterior = colaPegado;
				controlInicio.baseSiguiente.baseParalela.baseAnterior = colaPegado.baseParalela;
			}
			controlInicio.baseSiguiente = pegado;
			controlInicio.baseParalela.baseSiguiente = pegado.baseParalela;
			pegado.baseAnterior = controlInicio;
			pegado.baseParalela.baseAnterior = controlInicio.baseParalela;
		}
	}

	// TODO considere los comentarios
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
			// intercambio todo (ojo al TODO)
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

	public String getSubsecuencia(int n, int p) {
		String str = "";
		Base tmp = this;
		// encontrar el inicio
		for (int i = 1; i < p; i++)
			tmp = tmp.baseSiguiente;
		// agarre la cantidad n de bases
		for (int j = 0; j < n; j++) {
			str += tmp.letra + " " + tmp.baseParalela.letra + "\n";
			tmp = tmp.baseSiguiente;
		}
		return str;
	}

	/**
	 * Metodo de prueba, imprime las bases
	 * 
	 * @return hilera con informacion
	 */
	public String getSecuencia() {
		String str = "";
		Base tmp = this;
		int c = 1;
		while (tmp != null) {
			if (tmp.usado) {
				str += c + " " + tmp.letra + " " + tmp.baseParalela.letra
						+ "\n";
				c++;
			}
			tmp = tmp.baseSiguiente;
		}
		return str;
	}

	public void asociarParalela(Base b) {
		baseParalela = b;
	}

	public void asociarComentario(Comentario c) {
		comentario = c;
	}

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
}
