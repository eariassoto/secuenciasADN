package secuenciasADN;

public class Base {

	private char letra;
	private boolean usado;
	private Base baseParalela, baseSiguiente;
	private Comentario comentario;

	public Base() {
		usado = false;
		baseSiguiente = null;
		baseParalela = null;
	}

	public Base(char l) {
		letra = l;
		usado = true;
		baseParalela = null;
		baseSiguiente = null;
	}

	public Base(char l, Base bP) {
		letra = l;
		usado = true;
		baseParalela = bP;
		baseSiguiente = null;
	}

	public Base(char l1, char l2) {
		letra = l1;
		usado = true;
		baseParalela = new Base(l2, this);
		baseSiguiente = null;
	}

	public Base(char l, Base bP, Base bS) {
		letra = l;
		usado = true;
		baseParalela = bP;
		baseSiguiente = bS;
	}

	public Base(Base tmp) {
		letra = tmp.letra;
		usado = tmp.usado;
		baseParalela = tmp.baseParalela;
		baseSiguiente = tmp.baseSiguiente;
	}

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
			Base b1 = new Base(l1, l2);
			tmp.baseSiguiente = b1;
			tmp.baseParalela.baseSiguiente = tmp.baseSiguiente.baseParalela;
		}
	}

	public void agregar(char l) {
		if (!usado) {
			letra = l;
			usado = true;
		} else {
			Base tmp = this;
			while (tmp.baseSiguiente != null)
				tmp = tmp.baseSiguiente;
			Base bT = (tmp.baseParalela != null) ? new Base(l,
					tmp.baseParalela.baseSiguiente) : new Base(l);
			tmp.baseSiguiente = bT;
		}
	}

	/*
	 * todo malo, contemplar caso de la cabeza, el otro bucle pararlo antes
	 */
	public void agregarParEn(int pos, char l1, char l2) {
		Base tmp = this;
		for (int i = 1; i < pos; i++)
			tmp = tmp.baseSiguiente;
		Base bT = new Base(tmp);
		tmp.letra = l1;
		tmp.baseParalela = new Base(l2, tmp);
		tmp.baseSiguiente = bT;
		tmp.baseParalela.baseSiguiente = bT.baseParalela;
	}

	public int length() {
		int c = 0;
		Base tmp = this;
		while (tmp != null) {
			c++;
			tmp = tmp.baseSiguiente;
		}
		return c;
	}

	public String getSecuencia() {
		String str = "";
		Base tmp = this;
		str += "tira actual ";
		while (tmp != null) {
			str += tmp.getLetra() + " ";
			tmp = tmp.baseSiguiente;
		}
		tmp = this.baseParalela;
		str += "\ntira paralela ";
		while (tmp != null) {
			str += tmp.getLetra() + " ";
			tmp = tmp.baseSiguiente;
		}
		tmp = this;
		str += "\n";
		while (tmp != null) {
			str += tmp.getLetra();
			str += (tmp.baseParalela != null) ? " "
					+ tmp.baseParalela.getLetra() + "\n" : "\n";
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

	public char getLetra() {
		return letra;
	}

	public boolean estaUsada() {
		return usado;
	}

	public boolean haySiguiente() {
		return baseSiguiente != null;
	}

}
