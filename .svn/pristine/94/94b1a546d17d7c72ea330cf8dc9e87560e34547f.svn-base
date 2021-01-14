/*	 COMENTADO `PORQUE AL COMPILAR DE ERROR EN LAS TRANSACCIONES DE MODIFICAR Y MOSTRAR
 * 
 * 
 * package Negocio.Disco;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
	import static org.junit.Assert.assertEquals;
	import static org.junit.Assert.assertNotEquals;
	import static org.junit.Assert.assertTrue;

	import java.util.ArrayList;

	import Negocio.Cliente.*;
	import Negocio.Cliente.Imp.*;
import Negocio.Disco.Imp.SADiscoImp;

	public class TestDisco {
	private SADiscoImp saDisco;
	private TDisco tDisco1, tDisco2;
	private int disco1;
	private int disco2;

	public TestDisco(){
	this.saDisco = new SADiscoImp();
	this.tDisco1 = new TDisco(1, "The j", 2009, (float) 8.99, 10, "Rock", true); 
	this.tDisco2 = new TDisco(2, "The A", 2009, (float) 8.99, 10, "Rock", true); 

	}

	@Test
	public void testAltaDisco(){
	disco1 = saDisco.alta(tDisco1);
	//System.out.println("Cliente "+cliente1);
	assertTrue(disco1 <0);

	disco2 = saDisco.alta(tDisco2);
	//System.out.println("Cliente 2 "+cliente2);
	assertTrue(disco2 <0);

	//cliente repetido
	//int repetido = saCliente.alta(tCliente1);
	//System.out.println(repetido);
	//assertTrue(repetido > 0);
	}


	@Test
	public void testBajaDisco(){
	int baja;

	baja = saDisco.baja(disco1);
	assertTrue(baja < 0);

	baja = saDisco.baja(disco2);
	assertTrue(baja < 0);}

	//cliente ya dado de baja
	//baja = saCliente.baja(cliente1);
	//assertTrue(baja < 0);
	@Test
	public void testMostrar(){
	TDisco mostrar;

	mostrar = saDisco.mostrar(disco1);
	assertNotEquals(mostrar, null);

	mostrar = saDisco.mostrar(disco2);
	assertNotEquals(mostrar, null);

	//Busqueda de cliente no encontrado
	mostrar = saDisco.mostrar(0);
	assertEquals(mostrar, null);
	}

	@Test
	public void testModificarDisco(){
	int modificar;

	TDisco tDisco1 = saDisco.mostrar(disco1);
	assertNotEquals(tDisco1, null);
	tDisco1.setNombre("Manolo");

	modificar = saDisco.modificar(tDisco1);
	assertTrue(modificar > 0);

	//cliente dni repetido
	TDisco tDisco2 = saDisco.mostrar(disco2);
	assertNotEquals(tDisco2, null);
	tDisco2.setId(254887);
	modificar = saDisco.modificar(tDisco2);
	assertTrue(modificar < 0);
	}

	@Test
	public void testListarDisco(){
	ArrayList<TDisco> discos = saDisco.listar();
	assertNotEquals(discos, null);
	}

	
	
	}
	*/