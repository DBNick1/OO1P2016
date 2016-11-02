package modelo;

import java.util.GregorianCalendar;

import datos.Administrador;
import datos.Lote;
import datos.Producto;
import datos.Stock;

public class Test1Tema3 {
	
	public static void main(String[] args)  {
		
		try{
			
		Administrador a1 = new Administrador();
		
		//Agregamos los productos:
		
		a1.agregarProducto("Queso cremoso", "001", "Quesos");
		a1.agregarProducto("Queso light", "002", "Quesos");
		a1.agregarProducto("Yogurt 1 litro", "010", "Yogurt");	
		a1.agregarProducto("Leche descremada", "101", "Leche");	
		a1.agregarProducto("Queso fresco", "102", "Quesos");	
		a1.agregarProducto("Dulce de leche", "201", "Dulces");	
		
		//Vemos la lista de productos
		
		for (Producto p : a1.getProductos()) {
			System.out.println(p);
			}
		
		System.out.println("\n");
		
		//Agregamos stocks y lotes
		
		a1.agregarStock(100, 200, a1.traerProducto(1));
		a1.traerStock(1).agregarLote(200, 150, true, new GregorianCalendar(2016,10,1));
		a1.traerStock(1).agregarLote(200, 200, false, new GregorianCalendar(2016,10,10));
		
		a1.agregarStock(120, 250, a1.traerProducto(2));
		a1.traerStock(2).agregarLote(250, 0, true, new GregorianCalendar(2016,10,1));
		a1.traerStock(2).agregarLote(250, 0, false, new GregorianCalendar(2016,10,10));
		a1.traerStock(2).agregarLote(250, 150, false, new GregorianCalendar(2016,10,17));
		
		a1.agregarStock(200, 400, a1.traerProducto(3));
		a1.traerStock(3).agregarLote(400, 0, true, new GregorianCalendar(2016,10,1));
		a1.traerStock(3).agregarLote(400, 0, false, new GregorianCalendar(2016,10,10));
		a1.traerStock(3).agregarLote(400, 200, false, new GregorianCalendar(2016,10,14));
		a1.traerStock(3).agregarLote(400, 400, false, new GregorianCalendar(2016,10,17));
		
		a1.agregarStock(180, 230, a1.traerProducto(4));
		a1.traerStock(4).agregarLote(230, 0, true, new GregorianCalendar(2016,10,1));
		a1.traerStock(4).agregarLote(230, 100, false, new GregorianCalendar(2016,10,10));
		
		a1.agregarStock(190, 280, a1.traerProducto(5));
		a1.traerStock(5).agregarLote(280, 0, true, new GregorianCalendar(2016,10,1));
		a1.traerStock(5).agregarLote(280, 150, true, new GregorianCalendar(2016,10,10));
		a1.traerStock(5).agregarLote(280, 280, true, new GregorianCalendar(2016,10,17));
		
		a1.agregarStock(300, 410, a1.traerProducto(6));
		a1.traerStock(6).agregarLote(410, 0, true, new GregorianCalendar(2016,10,1));
		a1.traerStock(6).agregarLote(410, 0, false, new GregorianCalendar(2016,10,10));
		a1.traerStock(6).agregarLote(410, 0, false, new GregorianCalendar(2016,10,14));
		a1.traerStock(6).agregarLote(410, 170, false, new GregorianCalendar(2016,10,17));
		
		
		//Lista de Stock y sus lotes
		
		for (Stock s : a1.getStocks()){
			
			System.out.println(s);
				for(Lote l : s.getLotes())
				{
					System.out.println(l);
				}
			
		}
		
		//Parte tres
		System.out.println("---> calcularCantidadExistente Cantidad existente para el "+a1.traerProducto(1)+" es: " );
		System.out.println(a1.calcularCantidadExistente(a1.traerProducto(1)));
		System.out.println("---> calcularCantidadAProducir");
		System.out.println(a1.calcularCantidadAProducir(a1.traerProducto(1)));
		System.out.println("---> calcularCantidadPorEncimaStockDeseado Cantidad por encima del stock deseado para el " +a1.traerProducto(1)+" es: ");
		System.out.println(a1.calcularCantidadPorEncimaDelStockDeseado(a1.traerProducto(1)));
		
		
		System.out.println("---> calcularCantidadExistente Cantidad existente para el " +a1.traerProducto(2)+ " es: ");
		System.out.println(a1.calcularCantidadAProducir(a1.traerProducto(2)));
		System.out.println("---> calcularCantidadAProducir");
		System.out.println(a1.calcularCantidadAProducir(a1.traerProducto(2)));
		System.out.println("---> calcularCantidadPorEncimaStockDeseado Cantidad por encima del stock deseado para el " +a1.traerProducto(1)+" es: ");
		System.out.println(a1.calcularCantidadPorEncimaDelStockDeseado(a1.traerProducto(2)));
		

	
		int cantidadExistente=0;
		int cantidadAProducir=0;
		int cantidadPorEncimaDelStockDeseado=0;
		
		for (Stock s : a1.getStocks()){
			cantidadExistente=cantidadExistente+(s.calcularCantidadExistente());
			cantidadAProducir=cantidadAProducir+(s.calcularCantidadAProducir());
			cantidadPorEncimaDelStockDeseado=cantidadPorEncimaDelStockDeseado+(s.calcularCantidadPorEncimaDelStockDeseado());
		}
		
		System.out.println("---> calcularCantidadExistente");
		System.out.println("La cantidad existente de todos los productos es:");
		System.out.println(cantidadExistente);
		System.out.println("---> calcularCantidadAProducir");
		System.out.println("La cantidad a producir de todos los productos es:");
		System.out.println(cantidadAProducir);
		System.out.println("---> calcularCantidadPorEncimaStockDeseado");
		System.out.println("Cantidad por encima del stock deseado de todos los productos:");
		System.out.println(cantidadPorEncimaDelStockDeseado);
		
		}catch (Exception e)
		
		{
			System.out.println( "Excepcion: "+e.getMessage());
			
		}
		
	}
	
}
