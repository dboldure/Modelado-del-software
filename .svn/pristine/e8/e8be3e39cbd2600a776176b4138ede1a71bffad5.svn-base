/**
 * 
 */
package Negocio.Empleado.Imp;

import Negocio.Departamento.Imp.Departamento;
import Negocio.Empleado.SAEmpleado;
import Negocio.Empleado.TEmpleado;
import Negocio.Empleado.TEmpleadoCompleto;
import Negocio.Empleado.TEmpleadoParcial;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.LockModeType;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;


public class SAEmpleadoImp implements SAEmpleado {
	
		
		static final String PROJECTNAME="iesoft";
		/*
		 * Error:
		 * -1: empleado null o departamento null
		 * -2: Dep no existe
		 * -3: Dni ya existe
		 * -4: No se puede reactivar el empleado porque no es del mismo tipo
		 * -5: Dep no activo
		 * -100: Error en la gestión de la BDD.
		 */
		public Integer alta(TEmpleado templeado) {
			int id = -1;
			Empleado emp=null;
			if(templeado != null && templeado.getIdDepartamento() != null) {
				
				EntityManagerFactory emfactory = Persistence.createEntityManagerFactory(PROJECTNAME);
				try {
					EntityManager entitymanager = emfactory.createEntityManager();
					EntityTransaction entitytransaction = entitymanager.getTransaction();
					entitytransaction.begin();	
				
					Departamento depart = entitymanager.find(Departamento.class, templeado.getIdDepartamento(),LockModeType.OPTIMISTIC_FORCE_INCREMENT);
				
					if (depart != null){

						if(depart.getActivo()){
							if(templeado instanceof TEmpleadoCompleto) { 
								emp =new EmpleadoCompleto(templeado.getNombre(),templeado.getDni(), templeado.getTelefono(), depart ,templeado.getSueldo(), true,((TEmpleadoCompleto) templeado).getHorasSemana());
							}
							else  {
								emp =new EmpleadoParcial(templeado.getNombre(),templeado.getDni(), templeado.getTelefono(), depart, templeado.getSueldo(), true,((TEmpleadoParcial) templeado).getHorasDia());
							}
					
								
							TypedQuery<Empleado> query = entitymanager.createNamedQuery("Negocio.Empleado.Imp.Empleado.findBydni", Empleado.class).setParameter("dni", templeado.getDni());
							List<Empleado> lista = query.getResultList();
							if(lista.isEmpty()) {
								
								entitymanager.persist(emp);
								entitytransaction.commit();
								id = emp.getId();
								
							}	
							else {
								if (!lista.get(0).getActivo()){
									if ((lista.get(0) instanceof EmpleadoCompleto && emp instanceof EmpleadoCompleto) || (lista.get(0) instanceof EmpleadoParcial && emp instanceof EmpleadoParcial)){
										emp = lista.get(0);
										emp.setActivo(true);
										emp.setDepartamento(depart);
										emp.setNombre(templeado.getNombre());
										emp.setSueldo(templeado.getSueldo());
										emp.setTelefono(templeado.getTelefono());
										if(templeado instanceof TEmpleadoCompleto) ((EmpleadoCompleto) emp).setHorasSemana(((TEmpleadoCompleto) templeado).getHorasSemana());
										else ((EmpleadoParcial) emp).setHorasDia(((TEmpleadoParcial) templeado).getHorasDia());
										entitymanager.persist(emp);
										entitytransaction.commit();
										id = emp.getId();
									} else {
										id = -4;
									}
								}
								else {
									// dni ya existe
									id = -3;
								}
							}
						}else {
							id = -5;
						}
					}else{
					/// dep no existe
					id = -2;
					}
					entitymanager.close();
					emfactory.close();
					
				}catch(PersistenceException ex) {
					id = -100;
				}	
			}
			return id;
		}
		
		/*
		 * Errores:
		 * -2: empleado no encontrado
		 * -3: empleado ya esta dado de baja
		 * -4: empleado  no puede darse de baja
		 */
		public Integer baja(Integer id) {
				EntityManagerFactory emfactory = Persistence.createEntityManagerFactory(PROJECTNAME);
				try {
					EntityManager entitymanager = emfactory.createEntityManager();
					EntityTransaction entitytransaction = entitymanager.getTransaction();
					entitytransaction.begin();
					Empleado empleado = entitymanager.find(Empleado.class, id);
					if(empleado != null) {
						if(empleado.getActivo()) {
							
								empleado.setActivo(false);
								entitymanager.persist(empleado);
								entitytransaction.commit();
							
						}
						else {
							id = -3;
							entitytransaction.rollback();
						}
					}
					else {
						id = -2;
						entitytransaction.rollback();
					}
					entitymanager.close();
					emfactory.close();
				} catch(PersistenceException ex) {
					id = -100;
				}
			
			return id;
		}

		/*
		 * Error:
		 * -1: Empleado null
		 * -2: Empleado no existe
		 * -3: Empleado no activo
		 * -4: Dep no existe
		 * -5: Dep no activo
		 * -6: Empleado de distinto tipo al de la base de datos
		 * -7: Dni ya existe
		 * -100: Error en la gestión de la BDD.
		 */
		public Integer modificar(TEmpleado templeado) {
			int id = -1;
			if(templeado != null) {
				
				EntityManagerFactory emfactory = Persistence.createEntityManagerFactory(PROJECTNAME);
				try {
					EntityManager entitymanager = emfactory.createEntityManager();
					EntityTransaction entitytransaction = entitymanager.getTransaction();
					entitytransaction.begin();	
					Departamento depart = null;
					if (templeado.getIdDepartamento() != null) depart = entitymanager.find(Departamento.class, templeado.getIdDepartamento());
					Empleado empleado = entitymanager.find(Empleado.class, templeado.getId());
					
					if (empleado != null){	
						if(empleado.getActivo()){
							if (templeado.getIdDepartamento() == null || depart != null){
								if(templeado.getIdDepartamento() == null || depart.getActivo()){
					
									if (templeado.getIdDepartamento() != null){
										empleado.setDepartamento(depart);
									}
									if (!templeado.getNombre().equals("")){
										empleado.setNombre(templeado.getNombre());
									}
									if (!templeado.getTelefono().equals("")){
										empleado.setTelefono(templeado.getTelefono());							
																		}
									if (templeado.getSueldo() != null){
										empleado.setSueldo(templeado.getSueldo());
									}
									
									if ((templeado instanceof TEmpleadoCompleto && empleado instanceof EmpleadoCompleto) || (templeado instanceof TEmpleadoParcial && empleado instanceof EmpleadoParcial)){
										if (templeado instanceof TEmpleadoCompleto && empleado instanceof EmpleadoCompleto && ((TEmpleadoCompleto) templeado).getHorasSemana() != null) { 
											((EmpleadoCompleto) empleado).setHorasSemana(((TEmpleadoCompleto) templeado).getHorasSemana());
										}
										else if(templeado instanceof TEmpleadoParcial && empleado instanceof EmpleadoParcial && ((TEmpleadoParcial) templeado).getHorasDia() != null) {
											((EmpleadoParcial) empleado).setHorasDia(((TEmpleadoParcial) templeado).getHorasDia());
										}
										
										
										List<Empleado> lista = new ArrayList<Empleado>();
										
										if (!templeado.getDni().equals("")){
											TypedQuery<Empleado> query = entitymanager.createNamedQuery("Negocio.Empleado.Imp.Empleado.findBydni", Empleado.class).setParameter("dni", templeado.getDni());
											lista = query.getResultList();
											empleado.setDni(templeado.getDni());
										}
										
										if(lista.isEmpty() || lista.get(0).getId() == templeado.getId()) {
											entitymanager.persist(empleado);
											entitytransaction.commit();
											id = empleado.getId();
											
										}	
										else {
											id = -7;
											entitytransaction.rollback();
										}
									}
									else {
										id = -6;
										entitytransaction.rollback();
									}
							
								}else {
									id = -5;
									entitytransaction.rollback();
								}
							}else{
								id = -4;
								entitytransaction.rollback();
							}
						}else{
							id = -3;
							entitytransaction.rollback();
						}
					}else{
						id = -2;
						entitytransaction.rollback();
						
					}
					entitymanager.close();
					emfactory.close();
					
				}catch(PersistenceException ex) {
					id = -100;
				}	
			}
			return id;
		}

		
		public TEmpleado mostrar(Integer id) {
			Empleado empleado = null;	
			TEmpleado tEmpleado = null;
				try {
					EntityManagerFactory emfactory = Persistence.createEntityManagerFactory(PROJECTNAME);
					EntityManager entitymanager = emfactory.createEntityManager();
					EntityTransaction entitytransaction = entitymanager.getTransaction();
					entitytransaction.begin();
					empleado = entitymanager.find(Empleado.class, id);
					
					if(empleado == null){
						entitytransaction.rollback();
					}
						
					else{
						tEmpleado = empleado.toTransfer();
						entitytransaction.commit();
					}
					
					entitymanager.close();
					emfactory.close();
				}
				catch(PersistenceException ex) {}
			
			return tEmpleado;
		}

		
		public ArrayList<TEmpleado> listar() {
			List<Empleado> lista = null;
			ArrayList<TEmpleado> listaT = new ArrayList<TEmpleado>();
			EntityManagerFactory emfactory = Persistence.createEntityManagerFactory(PROJECTNAME);
			try {
				EntityManager entitymanager = emfactory.createEntityManager();
				EntityTransaction entitytransaction = entitymanager.getTransaction();
				entitytransaction.begin();
					
				TypedQuery<Empleado> query = entitymanager.createNamedQuery("Negocio.Empleado.Imp.Empleado.readALL", Empleado.class);
				lista = query.getResultList();
				for (Empleado e : lista){
					listaT.add(e.toTransfer());
				}
				entitytransaction.commit();
					
				entitymanager.close();
				emfactory.close();
			} catch(PersistenceException ex) {}
			
			return listaT;
		}
		/*
		 * Error:
		 * -1: Empleado no existe
		 * -100: Error en la gestión de la BDD.
		 */
		public Float mostrarNomina(Integer id)
		{
			float suma=0f;
			Empleado empleado = null;	
				try {
					EntityManagerFactory emfactory = Persistence.createEntityManagerFactory(PROJECTNAME);
					EntityManager entitymanager = emfactory.createEntityManager();
					EntityTransaction entitytransaction = entitymanager.getTransaction();
					entitytransaction.begin();
					empleado = entitymanager.find(Empleado.class, id);
					
					if(empleado == null){
						
						suma = -1;
							
						entitytransaction.rollback();
					}
						
					else{
						suma=empleado.calcularNominaMes();
						entitytransaction.commit();
					}
					
					entitymanager.close();
					emfactory.close();
				}
				catch(PersistenceException ex) {
					suma = -100;
				}
			
			return suma;
		}

}