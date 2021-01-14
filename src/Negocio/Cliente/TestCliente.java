package Negocio.Cliente;
import static org.junit.Assert.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

	import Negocio.Cliente.Imp.*;

	public class TestCliente {
	private SAClienteImp saCliente;
	private TCliente tCliente1, tCliente2;
	private int cliente1;
	private int cliente2;

	public TestCliente(){
	this.saCliente = new SAClienteImp();
	this.tCliente1 = new TCliente(21, "Pepe", true, "52003258E"); 
	this.tCliente2 = new TCliente(2, "jose", true, "52003252E"); 

	}

	@Test
	public void testAltaCliente(){
	cliente1 = saCliente.alta(tCliente1);
	//System.out.println("Cliente "+cliente1);
	assertTrue(cliente1 <0);

	cliente2 = saCliente.alta(tCliente2);
	//System.out.println("Cliente 2 "+cliente2);
	assertTrue(cliente2 <0);

	//cliente repetido
	//int repetido = saCliente.alta(tCliente1);
	//System.out.println(repetido);
	//assertTrue(repetido > 0);
	}


	@Test
	public void testBajaCliente(){
	int baja;

	baja = saCliente.baja(cliente1);
	assertTrue(baja < 0);

	baja = saCliente.baja(cliente2);
	assertTrue(baja < 0);}

	//cliente ya dado de baja
	//baja = saCliente.baja(cliente1);
	//assertTrue(baja < 0);
	@Test
	public void testMostrar(){
	TCliente mostrar;

	mostrar = saCliente.mostrar(cliente1);
	assertNotEquals(mostrar, null);

	mostrar = saCliente.mostrar(cliente2);
	assertNotEquals(mostrar, null);

	//Mostramos un cliente no encontrado
	mostrar = saCliente.mostrar(0);
	assertEquals(mostrar, null);
	}

	@Test
	public void testModificarCliente(){
	int modificar;

	TCliente tCliente1 = saCliente.mostrar(cliente1);
	assertNotEquals(tCliente1, null);
	tCliente1.setNombre("Manolo");

	modificar = saCliente.modificar(tCliente1);
	assertTrue(modificar > 0);

	//cliente con el dni repetido
	TCliente tCliente2 = saCliente.mostrar(cliente2);
	assertNotEquals(tCliente2, null);
	tCliente2.setDni("555555R");
	modificar = saCliente.modificar(tCliente2);
	assertTrue(modificar < 0);
	}

	@Test
	public void testListarClientes(){
	ArrayList<TCliente> clientes = saCliente.listar();
	assertNotEquals(clientes, null);
	}

	
	
	}
	