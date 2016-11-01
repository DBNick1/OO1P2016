package datos;

import java.util.GregorianCalendar;

public class Lote {
	
	private int idLote;
	private int cantidadInicial;
	private int cantidadExistente;
	private boolean enUso;
	private GregorianCalendar fechaProduccion;
	
	public Lote()
	{}
	
	private static int id = 0;
	
	public Lote(int cantidadInicial, int cantidadExistente, boolean enUso, GregorianCalendar fechaProduccion) {
		super();
		id++;
		this.idLote = id;
		this.cantidadInicial = cantidadInicial;
		this.cantidadExistente = cantidadExistente;
		this.enUso = enUso;
		this.fechaProduccion = fechaProduccion;
	}

	public Lote(int idLote, int cantidadInicial, int cantidadExistente, boolean enUso, GregorianCalendar fechaProduccion) {
		super();
		this.idLote = idLote+1;
		this.cantidadInicial = cantidadInicial;
		this.cantidadExistente = cantidadExistente;
		this.enUso = enUso;
		this.fechaProduccion = fechaProduccion;
	}
	
	public int getIdLote() {
		return idLote;
	}
	public void setIdLote(int idLote) {
		this.idLote = idLote;
	}
	public int getCantidadInicial() {
		return cantidadInicial;
	}
	public void setCantidadInicial(int cantidadInicial) {
		this.cantidadInicial = cantidadInicial;
	}
	public int getCantidadExistente() {
		return cantidadExistente;
	}
	public void setCantidadExistente(int cantidadExistente) {
		this.cantidadExistente = cantidadExistente;
	}
	public boolean isEnUso() {
		return enUso;
	}
	public void setEnUso(boolean enUso) {
		this.enUso = enUso;
	}
	public GregorianCalendar getFechaProduccion() {
		return fechaProduccion;
	}
	public void setFechaProduccion(GregorianCalendar fechaProduccion) {
		this.fechaProduccion = fechaProduccion;
	}
	
	public String toString()
	{
		return("Lote: (ID: "+idLote+", Cantidad inicial: "+cantidadInicial+", Cantidad existente: "+cantidadExistente+", En uso: "+enUso+", Fecha producción: "+Funciones.traerFechaCorta(fechaProduccion)+" "+Funciones.traerHoraSimple(fechaProduccion));
	}
	
	

}
