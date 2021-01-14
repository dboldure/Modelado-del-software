package Negocio.Factura;
import static org.junit.Assert.*;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import Negocio.Factura.Imp.SAFacturaImp;
import Negocio.LineaFactura.TLineaFactura;

	public class TestFactura {
	private SAFacturaImp saFactura;
	private TFactura tFactura1, tFactura2;
	private int factura1;
	private int factura2;
	private ArrayList<TLineaFactura> lineasFactura;
	public TestFactura(){
	this.saFactura = new SAFacturaImp();
	this.tFactura1 = new TFactura(12, 21, (float) 22.3, null, false); 
	this.tFactura1 = new TFactura(13, 23, (float) 27.3, null, false); 

	}

	@Test
	public void testAltaFactura(){
	factura1 = saFactura.abrir(tFactura1);
	assertTrue(factura1 <0);

	factura2 = saFactura.abrir(tFactura2);
	assertTrue(factura2 <0);

	//factura repetido
	//int repetido = saFactura.abrir(tFactura1);
	//System.out.println(repetido);
	//assertTrue(repetido > 0);
	}


	@Test
	public void testCerrarFactura(){
	int baja;

	baja = saFactura.cerrar(lineasFactura,tFactura1);
	assertTrue(baja < 0);

	baja = saFactura.cerrar(lineasFactura,tFactura2);
	assertTrue(baja < 0);}

	@Test
	public void testMostrar(){
	TEnsamblado mostrar;

	mostrar = saFactura.mostrar(factura1);
	assertNotEquals(mostrar, null);

	mostrar = saFactura.mostrar(factura2);
	assertNotEquals(mostrar, null);

//Mostrar factura no encotnrado
	mostrar = saFactura.mostrar(0);
	assertEquals(mostrar, null);
	}

	@Test
	public void testQuitarProducto(){
	ArrayList<TLineaFactura> modificar;

	TEnsamblado tEnsamb1 = saFactura.mostrar(factura1);
	assertNotEquals(tEnsamb1, null);
	tEnsamb1.setFactura(tFactura2);

	modificar = saFactura.quitarProducto(lineasFactura, null);
	assertNotEquals(modificar,null);

	}
	@Test
	public void testAñadirProducto(){
	ArrayList<TLineaFactura> modificar;

	TEnsamblado tEnsamb1 = saFactura.mostrar(factura1);
	assertNotEquals(tEnsamb1, null);
	tEnsamb1.setFactura(tFactura2);

	TLineaFactura lineaFact = null;
	modificar = saFactura.añadirProducto(lineasFactura, lineaFact);
	assertNotEquals(modificar,null);

	}
	@Test
	public void testListarFacturas(){
	ArrayList<TFactura> facturas = saFactura.listar();
	assertNotEquals(facturas, null);
	}

	
	
	}
	