
package Negocio.Departamento.Imp;

import Negocio.Departamento.SADepartamento;
import Negocio.Departamento.TDepartamento;
import Negocio.Empleado.Imp.Empleado;
import Negocio.Planta.Imp.RPlantaDepartamento;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.LockModeType;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;


public class SADepartamentoImp implements SADepartamento {
	
	static final String PROJECTNAME="iesoft";

	public Integer alta(TDepartamento departamento) {
		int id = -1;
		if(departamento != null) {
			Departamento dep= new Departamento(departamento.getNombre(),departamento.getTelefono(),departamento.getActivo());

				EntityManagerFactory emfactory = Persistence.createEntityManagerFactory(PROJECTNAME);
				try {
					EntityManager entitymanager = emfactory.createEntityManager();
					EntityTransaction entitytransaction = entitymanager.getTransaction();
					entitytransaction.begin();
					TypedQuery<Departamento> query = entitymanager.createNamedQuery("Negocio.Departamento.Imp.Departamento.findBynombre", Departamento.class).setParameter("nombre", departamento.getNombre());
					List<Departamento> lista = query.getResultList();
					if(lista.isEmpty()) {
						entitymanager.persist(dep);
						entitytransaction.commit();
						id = dep.getId();
					}
					else {
						Departamento depTemp = lista.get(0);
						if(depTemp.getActivo()) {
							id = -3;
							entitytransaction.rollback();
						}
						else {
							depTemp.setActivo(true);
							depTemp.setNombre(departamento.getNombre());
							depTemp.setTelefono(departamento.getTelefono());
							entitytransaction.commit();
							id = depTemp.getId(); 
						}
					}
					entitymanager.close();
					emfactory.close();
				} catch(PersistenceException ex) {
					id = -100;
				}
			}
			
		return id;
	}

	
	/*
	 * TABLA DE ERRORES
	 * 
	 * -1 No existe el departamento
	 * -2 Departamento no activo
	 * -3 Departamento vinculado a planta
	 * -4 Departamento con empleados
	 * -100 Persistance Exception
	 */
	
	public Integer baja(Integer id) {
	
			EntityManagerFactory emfactory = Persistence.createEntityManagerFactory(PROJECTNAME);
			try {
				EntityManager entitymanager = emfactory.createEntityManager();
				EntityTransaction entitytransaction = entitymanager.getTransaction();
				entitytransaction.begin();
				Departamento depart = entitymanager.find(Departamento.class, id);
				if(depart != null) {
					if(depart.getActivo()) {
						
						
						
						
						List<RPlantaDepartamento> lista1 = depart.getContiene();
						if(lista1.isEmpty()) {
							
							List<Empleado> lista2 = depart.getEmpleados();
							if(lista2.isEmpty()) {
								depart.setActivo(false);
								entitymanager.persist(depart);
								entitytransaction.commit();
							}
							else {
								
								for (Empleado e : lista2){
									if (e.getActivo()){
										id = -4;
										break;
									}
								}
								if (id != -4){
									depart.setActivo(false);
									entitymanager.persist(depart);
									entitytransaction.commit();
								}
								else{
									entitytransaction.rollback();
								}
								
							}
							
							
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
				}
				else {
					id = -1;
					entitytransaction.rollback();
				}
				entitymanager.close();
				emfactory.close();
			} catch(PersistenceException ex) {
				id = -100;
			}
		
		
		return id;
	}


	public Integer modificar(TDepartamento departamento) {
		int idEnt = -1;
		if(departamento != null) {
	
				EntityManagerFactory emfactory = Persistence.createEntityManagerFactory(PROJECTNAME);
				try {
					EntityManager entitymanager = emfactory.createEntityManager();
					EntityTransaction entitytransaction = entitymanager.getTransaction();
					entitytransaction.begin();
					Departamento departamentoResult = entitymanager.find(Departamento.class, departamento.getId());
					if(departamentoResult != null) {
						if(departamentoResult.getActivo()) {
							
							
							List<Departamento> lista = new ArrayList<Departamento>();
							
							if (!departamento.getNombre().equals("")){
								TypedQuery<Departamento> query = entitymanager.createNamedQuery("Negocio.Departamento.Imp.Departamento.findBynombre", Departamento.class).setParameter("nombre", departamento.getNombre());
								lista = query.getResultList();
								departamentoResult.setNombre(departamento.getNombre());
							}
							
							if (lista.isEmpty() || lista.get(0).getId() ==departamento.getId()){
									//departamentoResult.setNombre(departamento.getNombre());
									if (!departamento.getTelefono().equals("")){
										departamentoResult.setTelefono(departamento.getTelefono());							
									}
									entitymanager.persist(departamentoResult);
									entitytransaction.commit();
									idEnt = departamento.getId();
							}
							else{
								idEnt = -4;
								entitytransaction.rollback();
							}
						}
						else {
							idEnt = -3;
							entitytransaction.rollback();
						}
					}
					else {
						idEnt = -2;
						entitytransaction.rollback();
					}
					entitymanager.close();
					emfactory.close();
				} catch(PersistenceException ex) {
					idEnt = -100;
				}
		}
		return idEnt;	
	}


	public TDepartamento mostrar(Integer id) {
		Departamento departamento = null;
		TDepartamento departResult = null;
			EntityManagerFactory emfactory = Persistence.createEntityManagerFactory(PROJECTNAME);
			try {
				EntityManager entitymanager = emfactory.createEntityManager();
				EntityTransaction entitytransaction = entitymanager.getTransaction();
				entitytransaction.begin();
				
				departamento = entitymanager.find(Departamento.class, id);
				
				if(departamento != null){
					
					departResult = departamento.toTransfer();
					entitytransaction.commit();
				}	
				else {
					entitytransaction.rollback();
				}
					
				entitymanager.close();
				emfactory.close();
			} catch(PersistenceException ex) {}
		
		
		return departResult;
	}

	
	public ArrayList<TDepartamento> listar() {
		
		List<TDepartamento> listaTDep = new ArrayList<TDepartamento>();
		 List<Departamento> departamentos = new ArrayList<Departamento>();
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory(PROJECTNAME);
		try {
			EntityManager entitymanager = emfactory.createEntityManager();
			EntityTransaction entitytransaction = entitymanager.getTransaction();
			entitytransaction.begin();
				
			TypedQuery<Departamento> query = entitymanager.createNamedQuery("Negocio.Departamento.Imp.Departamento.readAll", Departamento.class);
		
			departamentos = query.getResultList();
			 for(Departamento depTemp: departamentos){
				 listaTDep.add(depTemp.toTransfer());
			 }
			entitytransaction.commit();
				
			entitymanager.close();
			emfactory.close();
		} catch(PersistenceException ex) {}
		
		return  (ArrayList<TDepartamento>) listaTDep;
	}

	/*
	 * Error:
	 * -1: Empleado no existe
	 * -100: Error en la gestión de la BDD.
	 */
	public float calcularNominaPorDepartamento(Integer id) {
		float suma = 0f;

			EntityManagerFactory emfactory = Persistence.createEntityManagerFactory(PROJECTNAME);
			try {
				EntityManager entitymanager = emfactory.createEntityManager();
				EntityTransaction entitytransaction = entitymanager.getTransaction();
				entitytransaction.begin();
				Departamento departamento = entitymanager.find(Departamento.class, id, LockModeType.OPTIMISTIC);
			
				if(departamento != null) {
					for(Empleado emp :departamento.getEmpleados()){
						if(emp.getActivo()){
							
							entitymanager.lock(emp, LockModeType.OPTIMISTIC);
							suma+=emp.calcularNominaMes();
						}
					}
					entitytransaction.commit();
				}
				else {
					suma = -1;
					entitytransaction.rollback();
				}
				
				entitymanager.close();
				emfactory.close();
			} catch(PersistenceException ex) {
				suma = -100;
			}
		
		return suma;
	
	}
}