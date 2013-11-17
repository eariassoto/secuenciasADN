package secuenciasADN;

import java.util.Calendar;

public class Comentario {
	private Comentario comentarioAnterior, comentarioSiguiente;
	private int inicio, fin, idCaso;
	private Calendar fecha;
	private String tipo, descripcion, nombreAutor, apellAutor, email,
			referencia, baseDatos, linkBD;
	private boolean usado;

	public Comentario() {
		usado = false;
		comentarioAnterior = null;
		comentarioSiguiente = null;
	}

	public Comentario(int i, int f, int id, Calendar fe, String t, String d,
			String n, String a, String e, String r, String bD, String l) {
		usado = true;
		inicio = i;
		fin = f;
		idCaso = id;
		fecha = fe;
		tipo = t;
		descripcion = d;
		nombreAutor = n;
		apellAutor = a;
		email = e;
		referencia = r;
		baseDatos = bD;
		linkBD = l;
		comentarioAnterior = null;
		comentarioSiguiente = null;
	}

	public Comentario(Comentario com, Comentario cA) {
		usado = true;
		comentarioSiguiente = null;
		comentarioAnterior = cA;
		this.inicio = com.inicio;
		this.fin = com.fin;
		this.idCaso = com.idCaso;
		this.fecha = com.fecha;
		this.tipo = com.tipo;
		this.descripcion = com.descripcion;
		this.nombreAutor = com.nombreAutor;
		this.apellAutor = com.apellAutor;
		this.email = com.email;
		this.referencia = com.referencia;
		this.baseDatos = com.baseDatos;
		this.linkBD = com.linkBD;
	}

	public Comentario(Comentario com, Comentario cA, Comentario cS) {
		usado = true;
		comentarioSiguiente = cS;
		comentarioAnterior = cA;
		this.inicio = com.inicio;
		this.fin = com.fin;
		this.idCaso = com.idCaso;
		this.fecha = com.fecha;
		this.tipo = com.tipo;
		this.descripcion = com.descripcion;
		this.nombreAutor = com.nombreAutor;
		this.apellAutor = com.apellAutor;
		this.email = com.email;
		this.referencia = com.referencia;
		this.baseDatos = com.baseDatos;
		this.linkBD = com.linkBD;
	}

	public Comentario(Comentario com) {
		usado = true;
		comentarioSiguiente = null;
		comentarioAnterior = com;
		this.inicio = com.inicio;
		this.fin = com.fin;
		this.idCaso = com.idCaso;
		this.fecha = com.fecha;
		this.tipo = com.tipo;
		this.descripcion = com.descripcion;
		this.nombreAutor = com.nombreAutor;
		this.apellAutor = com.apellAutor;
		this.email = com.email;
		this.referencia = com.referencia;
		this.baseDatos = com.baseDatos;
		this.linkBD = com.linkBD;
	}

	// recordar validar fin en inicio iguales
	public void addOrdered(Comentario comentario) {
		if (!usado) {
			this.inicio = comentario.inicio;
			this.fin = comentario.fin;
			this.idCaso = comentario.idCaso;
			this.fecha = comentario.fecha;
			this.tipo = comentario.tipo;
			this.descripcion = comentario.descripcion;
			this.nombreAutor = comentario.nombreAutor;
			this.apellAutor = comentario.apellAutor;
			this.email = comentario.email;
			this.referencia = comentario.referencia;
			this.baseDatos = comentario.baseDatos;
			this.linkBD = comentario.linkBD;
			usado = true;
		} else {
			if (comentario.inicio >= this.inicio) {
				if (comentarioSiguiente == null)
					comentarioSiguiente = new Comentario(comentario, this);
				else {
					Comentario tmp = this;
					boolean insertado = false;
					while ((tmp.inicio <= comentario.inicio)
							&& (tmp.comentarioSiguiente != null)
							&& (!insertado)) {
						if (tmp.comentarioSiguiente.inicio < comentario.inicio)
							tmp = tmp.comentarioSiguiente;
						else {
							tmp.comentarioSiguiente = new Comentario(
									comentario, tmp, tmp.comentarioSiguiente);
							tmp.comentarioSiguiente.comentarioSiguiente.comentarioAnterior = tmp.comentarioSiguiente;
							insertado = true;
						}
					}
				}
			} else if (usado) {
				Comentario tmp = new Comentario(this);
				this.inicio = comentario.inicio;
				this.fin = comentario.fin;
				this.idCaso = comentario.idCaso;
				this.fecha = comentario.fecha;
				this.tipo = comentario.tipo;
				this.descripcion = comentario.descripcion;
				this.nombreAutor = comentario.nombreAutor;
				this.apellAutor = comentario.apellAutor;
				this.email = comentario.email;
				this.referencia = comentario.referencia;
				this.baseDatos = comentario.baseDatos;
				this.linkBD = comentario.linkBD;
				tmp.comentarioSiguiente = this.comentarioSiguiente;
				this.comentarioSiguiente = tmp;
			} else {
				this.inicio = comentario.inicio;
				this.fin = comentario.fin;
				this.idCaso = comentario.idCaso;
				this.fecha = comentario.fecha;
				this.tipo = comentario.tipo;
				this.descripcion = comentario.descripcion;
				this.nombreAutor = comentario.nombreAutor;
				this.apellAutor = comentario.apellAutor;
				this.email = comentario.email;
				this.referencia = comentario.referencia;
				this.baseDatos = comentario.baseDatos;
				this.linkBD = comentario.linkBD;
				usado = true;
			}
		}
	}

}
