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

	public Base(char l1, char l2, Base bS) {
		letra = l1;
		usado = true;
		baseParalela = new Base(l2, this, bS.baseParalela);
		baseSiguiente = bS;
	}
	
	public Base(Base b, char l){
		letra = l;
		usado = true;
		baseParalela = new Base(this, b.baseParalela);
		baseSiguiente = b;
	}

	public Base(Base bP, Base bS){
		usado = false;
		baseParalela = bP;
		baseSiguiente = bS;
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
			Base bT = new Base(l1, l2);
			tmp.baseSiguiente = bT;
			tmp.baseParalela.baseSiguiente = tmp.baseSiguiente.baseParalela;
		}
	}

	public void agregarParEn(int pos, char l1, char l2) {
		if (pos == 1) {
			Base bT = new Base(this.letra, this.baseParalela.letra,
					this.baseSiguiente);
			this.letra = l1;
			this.baseParalela.letra = l2;
			this.baseSiguiente = bT;
			this.baseParalela.baseSiguiente = this.baseSiguiente.baseParalela;
		} else {
			Base tmp = this;
			for (int i = 1; i < pos - 1; i++)
				tmp = tmp.baseSiguiente;
			Base bT = new Base(l1, l2, tmp.baseSiguiente);
			tmp.baseSiguiente = bT;
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
			Base bT = new Base(tmp.baseSiguiente, l)
			tmp.baseSiguiente = bT;
			tmp.baseParalela.baseSiguiente = tmp.baseSiguiente.baseParalela;
					}
					
					}
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

	public String getSecuencia(String s) {
		String str = "";
		Base tmp = this;
		str += "tira actual " + s + " ";
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
