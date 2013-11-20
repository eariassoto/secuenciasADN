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

	/**
	 * Constructor por default
	 * 
	 * @param i
	 *            indice puntero inicio
	 * @param f
	 *            indice puntero fin
	 * @param id
	 *            id del caso
	 * @param fe
	 *            fecha
	 * @param t
	 *            tipo de comentario
	 * @param d
	 *            descripcion
	 * @param n
	 *            nombre del autor
	 * @param a
	 *            apellidos del autor
	 * @param e
	 *            email del autor
	 * @param r
	 *            referencia
	 * @param bD
	 *            base de datos
	 * @param l
	 *            link a la base
	 */
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

	public Comentario(Comentario com, Comentario cS) {
		usado = true;
		comentarioSiguiente = cS;
		asignarDatos(this, com);
	}

	public Comentario(Comentario com) {
		usado = true;
		comentarioSiguiente = null;
		comentarioAnterior = com;
		asignarDatos(this, com);
	}

	// recordar validar fin en inicio iguales
	public void agregar(Comentario comentario) {
		if (!usado) {
			// meta en la cabeza
			asignarDatos(this, comentario);
			usado = true;
		} else {
			if (comentario.inicio == this.inicio) {
				if(comentario.fin <= this.fin){
					// meter de primero
					this.comentarioSiguiente = new Comentario(this, this.comentarioSiguiente);				
					asignarDatos(this, comentario);
				}else{
					Comentario tmp = this;
					while (tmp.comentarioSiguiente != null
							&& tmp.comentarioSiguiente.inicio == comentario.inicio
							&& tmp.comentarioSiguiente.fin <= comentario.fin)
						tmp = tmp.comentarioSiguiente;
					if (tmp.comentarioSiguiente != null) {
						tmp.comentarioSiguiente.comentarioAnterior = comentario;
						comentario.comentarioSiguiente = tmp.comentarioSiguiente;
					}
					tmp.comentarioSiguiente = comentario;
					comentario.comentarioAnterior = tmp;
				}
			} else {
				if (comentario.inicio < this.inicio) {
					// meter de primero
					this.comentarioSiguiente = new Comentario(this);
					asignarDatos(this, comentario);
				} else {
					Comentario tmp = this;
					while (tmp.comentarioSiguiente != null
							&& comentario.inicio > tmp.comentarioSiguiente.inicio)
						tmp = tmp.comentarioSiguiente;
					// encontre o uno igual o uno mayor
					if (comentario.inicio == tmp.inicio) {
						while (tmp.comentarioSiguiente != null
								&& tmp.comentarioSiguiente.inicio == comentario.inicio
								&& tmp.comentarioSiguiente.fin <= comentario.fin)
							tmp = tmp.comentarioSiguiente;
					}
					if (tmp.comentarioSiguiente != null) {
						tmp.comentarioSiguiente.comentarioAnterior = comentario;
						comentario.comentarioSiguiente = tmp.comentarioSiguiente;
					}
					tmp.comentarioSiguiente = comentario;
					comentario.comentarioAnterior = tmp;
				}
			}
		}
	}

	/**
	 * copia la informacion de un comentario a otro
	 * 
	 * @param r
	 *            comentario receptor
	 * @param o
	 *            comentario origen
	 */
	public void asignarDatos(Comentario r, Comentario o) {
		r.inicio = o.inicio;
		r.fin = o.fin;
		r.idCaso = o.idCaso;
		r.fecha = o.fecha;
		r.tipo = o.tipo;
		this.descripcion = o.descripcion;
		r.nombreAutor = o.nombreAutor;
		r.apellAutor = o.apellAutor;
		r.email = o.email;
		r.referencia = o.referencia;
		r.baseDatos = o.baseDatos;
		r.linkBD = o.linkBD;
	}

	public void mostrar() {
		Comentario c = this;
		while (c != null) {
			System.out.println(c.inicio + " " + c.fin);
			c = c.comentarioSiguiente;
		}
	}

}
