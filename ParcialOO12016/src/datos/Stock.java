package datos;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class Stock {
	
	private int idStock;
	private int puntoAprovisionamiento;
	private int puntoStockDeseado;
	private Producto producto;
	private List<Lote> lotes;
	
	public Stock()
	{}
	
	public Stock(int idStock, int puntoAprovisionamiento, int puntoStockDeseado, Producto producto) {
		super();
		this.idStock = idStock;
		this.puntoAprovisionamiento = puntoAprovisionamiento;
		this.puntoStockDeseado = puntoStockDeseado;
		this.producto = producto;
		this.lotes = new ArrayList<Lote>();
	}
	
	public int getIdStock() {
		return idStock;
	}
	public void setIdStock(int idStock) {
		this.idStock = idStock;
	}
	public int getPuntoAprovisionamiento() {
		return puntoAprovisionamiento;
	}
	public void setPuntoAprovisionamiento(int puntoAprovisionamiento) {
		this.puntoAprovisionamiento = puntoAprovisionamiento;
	}
	public int getPuntoStockDeseado() {
		return puntoStockDeseado;
	}
	public void setPuntoStockDeseado(int puntoStockDeseado) {
		this.puntoStockDeseado = puntoStockDeseado;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public List<Lote> getLotes() {
		return lotes;
	}
	
	
	public boolean agregarLote(int cantidadInicial, int cantidadExistente, boolean enUso, GregorianCalendar fechaProduccion) throws Exception
	{
		boolean respuesta =false;
		Lote l1 = new Lote(cantidadInicial, cantidadExistente, enUso, fechaProduccion);
		lotes.add(l1);
		respuesta=true;
		
		
		return respuesta;
	}

	
	public int traerMaximoId()
	{
		int i=0;
		int max=0;
		while(i<lotes.size())
		{
			if(lotes.get(i).getIdLote()>max)
				max=lotes.get(i).getIdLote();
			i++;
		}
		return max;
	}
	
	public int calcularCantidadExistente()
	{
		int sum=0;
		int i=0;
		while(i<lotes.size())
				{
					sum=sum+lotes.get(i).getCantidadExistente();
					i++;
				}
		return sum;
	}
	
	public int calcularCantidadAProducir()
	{
		int cantidadExistente = calcularCantidadExistente();
		int cantidadAProducir = 0;
		cantidadAProducir=puntoStockDeseado-cantidadExistente;
		if(cantidadAProducir<0)
		{
			cantidadAProducir=0;
		}
		
		return cantidadAProducir;
	}
	
	public int calcularCantidadPorEncimaDelStockDeseado()
	{
		int cantidadExistente = calcularCantidadExistente();
		int cantidadPorEncimaDelStockDeseado = 0;
		cantidadPorEncimaDelStockDeseado = cantidadExistente - puntoStockDeseado;
		if(cantidadPorEncimaDelStockDeseado<0)
		{
			cantidadPorEncimaDelStockDeseado=0;
		}
		return cantidadPorEncimaDelStockDeseado;
	}

	public String toString()
	{
		return 
		("Stock: (ID: "+idStock+", P. de aprovisionamiento: "+puntoAprovisionamiento+""
				+ ", P. de stock deseado: "+puntoStockDeseado
				+"\n"+producto);
	}
	
}
