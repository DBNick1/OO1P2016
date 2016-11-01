package datos;

import java.util.ArrayList;
import java.util.List;

public class Administrador {
	
	private List<Producto> productos;
	private List<Stock> stocks;
	
	public Administrador() {
		super();
		this.productos = new ArrayList<Producto>();
		this.stocks = new ArrayList<Stock>();
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public List<Stock> getStocks() {
		return stocks;
	}
	
	public boolean agregarProducto(String nombreProducto, String codigo, String tipo) throws Exception
	{
		boolean respuesta =false;
		boolean encontro =false;;
		int i = 0;
		while(i<productos.size() && !encontro)
		{
			if(productos.get(i).getCodigo()==codigo)
			{
				encontro=true;
				throw new Exception("Ya existe el producto");
			}
			else i++;
			
		}
		if(!encontro)
		{
		Producto p1 = new Producto(traerMaximoId()+1,nombreProducto,codigo,tipo);
		productos.add(p1);
		respuesta=true;
		}
		
		return respuesta;
	}
	
	public boolean agregarStock(int puntoAprovisionamiento, int puntoStockDeseado, Producto producto) throws Exception
	{
		boolean respuesta =false;
		boolean encontro =false;;
		int i = 0;
		while(i<stocks.size() && !encontro)
		{
			if(stocks.get(i).getProducto()==producto)
			{
				encontro=true;
				throw new Exception("Ya existe el producto");
			}
			else i++;
			
		}
		if(!encontro)
		{
		Stock s1 = new Stock(traerMaximoIdStock()+1,puntoAprovisionamiento,puntoStockDeseado,producto);
		stocks.add(s1);
		respuesta=true;
		}
		
		return respuesta;
	}
	
	public Producto traerProducto(int idProducto)
	{
		Producto p = new Producto();
		for(int i=0;i<productos.size();i++)
		{
			if(productos.get(i).getIdProducto()==idProducto)
			{
				p = productos.get(i);
			}
			
		}
		return p;
	}
	
	public Stock traerStock(int idStock)
	{
		Stock s = new Stock();
		for(int i=0;i<stocks.size();i++)
		{
			if(stocks.get(i).getIdStock()==idStock)
			{
				s = stocks.get(i);
			}
			
		}
		return s;
	}
	
	
	public int traerMaximoId()
	{
		int i=0;
		int max=0;
		while(i<productos.size())
		{
			if(productos.get(i).getIdProducto()>max)
				max=productos.get(i).getIdProducto();
			i++;
		}
		return max;
	}
	
	public int traerMaximoIdStock()
	{
		int i=0;
		int max=0;
		while(i<stocks.size())
		{
			if(stocks.get(i).getIdStock()>max)
				max=stocks.get(i).getIdStock();
			i++;
		}
		return max;
	}
	

}
