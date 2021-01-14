
package Negocio.Planta.Imp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import Negocio.Planta.Imp.Planta;
import Negocio.Departamento.TDepartamento;
import Negocio.Departamento.Imp.Departamento;
import Negocio.Planta.SAPlanta;
import Negocio.Planta.TEnsamblado;
import Negocio.Planta.TPlanta;
import Negocio.Planta.TPlantaDepartamento;


public class SAPlantaImp implements SAPlanta {
	
	static final String PROJECTNAME="iesoft";
	/*
	 * TABLA DE ERRORES
	 * 
	 * -1 Transfer null
	 * -2 Planta ya existe
	 * -100 Persistance Exception
	 */
	public Integer alta(TPlanta tPlanta){
		int id = -1;
		if(tPlanta != null) {
			Planta planta= new Planta(tPlanta);

				EntityManagerFactory emfactory = Persistence.createEntityManagerFactory(PROJECTNAME);
				try {
					EntityManager entitymanager = emfactory.createEntityManager();
					EntityTransaction entitytransaction = entitymanager.getTransaction();
					entitytransaction.begin();
					TypedQuery<Planta> query = entitymanager.createNamedQuery("Negocio.Planta.Imp.Planta.findBynumero", Planta.class).setParameter("numero", planta.getNumero());
					List<Planta> plantaRepetida = query.getResultList();
					if(plantaRepetida.isEmpty()) {
						entitymanager.persist(planta);
						entitytransaction.commit();
						id = planta.getId();
					}
					else {
						if(plantaRepetida.get(0).getActivo()) {
							id = -2;
							entitytransaction.rollback();
						}
						else {
							planta = plantaRepetida.get(0);
							planta.setActivo(true);
							entitymanager.persist(planta);
							entitytransaction.commit();
							id = plantaRepetida.get(0).getId(); 
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
	 * -1 Planta tiene departamentos
	 * -2 Planta no activa
	 * -3 Planta no existe
	 * -100 Persistance Exception
	 */
	public Integer baja(Integer id){
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory(PROJECTNAME);
		try {
			EntityManager entitymanager = emfactory.createEntityManager();
			EntityTransaction entitytransaction = entitymanager.getTransaction();
			entitytransaction.begin();
			Planta planta = entitymanager.find(Planta.class, id);
			if(planta != null) {
				if(planta.getActivo()) {
					
					List<RPlantaDepartamento> lista = planta.getContiene();
					if(lista.isEmpty()) {
						planta.setActivo(false);
						entitymanager.persist(planta);
						entitytransaction.commit();
					}
					else {
						id = -1;
						entitytransaction.rollback();
					}
				}
				else {
					id = -2;
					entitytransaction.rollback();
				}
			}
			else {
				id = -3;
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
	 * TABLA DE ERRORES
	 * 
	 * -1 Transfer null
	 * -2 Numero de planta ya existe
	 * -3 Planta no activa
	 * -4 Planta no existe
	 * -100 Persistance Exception
	 */
	public Integer modificar(TPlanta tPlanta){
		int id = -1;
		if(tPlanta != null) {
				EntityManagerFactory emfactory = Persistence.createEntityManagerFactory(PROJECTNAME);
				try {
					EntityManager entitymanager = emfactory.createEntityManager();
					EntityTransaction entitytransaction = entitymanager.getTransaction();
					entitytransaction.begin();
					Planta planta = entitymanager.find(Planta.class, tPlanta.getId());
					if(planta != null) {
						if(planta.getActivo()) {
							TypedQuery<Planta> query = entitymanager.createNamedQuery("Negocio.Planta.Imp.Planta.findBynumero", Planta.class);
							query.setParameter("numero", tPlanta.getNumero());
							List<Planta> plantaExistente = query.getResultList();
							if(plantaExistente.isEmpty()) {
								if (tPlanta.getNumero() != null)planta.setNumero(tPlanta.getNumero());
								entitymanager.persist(planta);
								entitytransaction.commit();
								id = planta.getId();
							}
							else {
								id = -2;
								entitytransaction.rollback();
							}
								
						}
						else {
							id = -3;
							entitytransaction.rollback();
						}
					}
					else {
						id = -4;
						entitytransaction.rollback();
					}
					entitymanager.close();
					emfactory.close();
				} catch(PersistenceException ex) {
					id = -100;
				}
		}
		return id;	
	}

	
	
	public TEnsamblado mostrar(Integer id){
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory(PROJECTNAME);
		try {
			EntityManager entitymanager = emfactory.createEntityManager();
			EntityTransaction entitytransaction = entitymanager.getTransaction();
			entitytransaction.begin();
			
			Planta planta = entitymanager.find(Planta.class, id);
			List<TPlantaDepartamento> listaTRPD = new ArrayList<TPlantaDepartamento>();
			List<TDepartamento> listaTDep = new ArrayList<TDepartamento>();
			
			if(planta != null){
				List<RPlantaDepartamento> lista = planta.getContiene();
				for (RPlantaDepartamento RPD : lista){
					listaTRPD.add(RPD.toTransfer());
					listaTDep.add(entitymanager.find(Departamento.class, RPD.toTransfer().getIdDepartamento()).toTransfer());
				}
				entitytransaction.commit();
			}	
			else {
				entitytransaction.rollback();
				return null;
			}
			entitymanager.close();
			emfactory.close();
			return new TEnsamblado(planta.toTransfer(), listaTRPD, listaTDep);
		} catch(PersistenceException ex) {
			return null;
		}
	}

	public ArrayList<TPlanta> listar(){
		List<Planta> plantas = null;
		ArrayList<TPlanta> tPlantas = new ArrayList<TPlanta>();
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory(PROJECTNAME);
		try {
			EntityManager entitymanager = emfactory.createEntityManager();
			EntityTransaction entitytransaction = entitymanager.getTransaction();
			entitytransaction.begin();
				
			TypedQuery<Planta> query = entitymanager.createNamedQuery("Negocio.Planta.Imp.Planta.readAll", Planta.class);
			plantas = query.getResultList();
			for(Planta p: plantas){
				tPlantas.add(p.toTransfer());
			}
			entitytransaction.commit();
				
			entitymanager.close();
			emfactory.close();
		} catch(PersistenceException ex) {}
		
		return tPlantas;
	}
	
	/*
	 * TABLA DE ERRORES
	 * 
	 * -1 Parametros null
	 * -2 Metros no validos
	 * -3 Planta no existe
	 * -4 Planta no activa
	 * -5 Departamento no existe
	 * -6 Departamento no activo
	 * -7 Ya estan vinculados
	 * -100 Persistance Exception
	 */
	public Integer vincularDepartamentoaLaPlanta(Integer idPlanta, Integer idDepar, Float metros){
		int id = -1;
		if (metros <= 0) return -2;
		if (idPlanta != null && idDepar != null && metros != null) {

				EntityManagerFactory emfactory = Persistence.createEntityManagerFactory(PROJECTNAME);
				try {
					EntityManager entitymanager = emfactory.createEntityManager();
					EntityTransaction entitytransaction = entitymanager.getTransaction();
					entitytransaction.begin();
					
					Planta planta = entitymanager.find(Planta.class, idPlanta);
					Departamento departamento = entitymanager.find(Departamento.class, idDepar);
					if (planta != null){
						if (planta.getActivo()){
							if (departamento != null){
								if (departamento.getActivo()){
									
									RPlantaDepartamentoId contiene = new RPlantaDepartamentoId(idPlanta, idDepar);
									RPlantaDepartamento relacionExiste = entitymanager.find(RPlantaDepartamento.class, contiene);
									
									if(relacionExiste == null){
										RPlantaDepartamento relacion = new RPlantaDepartamento(departamento, metros, planta);		
										entitymanager.persist(relacion);
										entitytransaction.commit();
										id = contiene.hashCode();
									} else id = -7;
									
									
								} else id = -6;
							} else id = -5;
						} else id = -4;
					}else id = -3;
					
					if ( id < 0)entitytransaction.rollback();
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
	 * -1 Parametros null
	 * -2 Planta no existe
	 * -3 Planta no activa
	 * -4 Departamento no existe
	 * -5 Departamento no activo
	 * -6 No estan vinculados
	 * -100 Persistance Exception
	 */
	public Integer desvincularDepartamentoaLaPlanta(Integer idPlanta, Integer idDepar){
		int id = -1;
		if (idPlanta != null && idDepar != null) {
				EntityManagerFactory emfactory = Persistence.createEntityManagerFactory(PROJECTNAME);
				try {
					EntityManager entitymanager = emfactory.createEntityManager();
					EntityTransaction entitytransaction = entitymanager.getTransaction();
					entitytransaction.begin();
					
					Planta planta = entitymanager.find(Planta.class, idPlanta);
					Departamento departamento = entitymanager.find(Departamento.class, idDepar);
					
					if (planta != null){
						if (planta.getActivo()){
							if (departamento != null){
								if (departamento.getActivo()){
									
									RPlantaDepartamentoId contiene = new RPlantaDepartamentoId(idPlanta, idDepar);
									RPlantaDepartamento relacionExiste = entitymanager.find(RPlantaDepartamento.class, contiene);
									
									if(relacionExiste != null){
										entitymanager.remove(relacionExiste);
										entitytransaction.commit();
										id = contiene.hashCode();
									}else id = -6;
									
								} else id = -5;
							} else id = -4;
						} else id = -3;
					} else id = -2;
					
					if (id < 0) entitytransaction.rollback();
					entitymanager.close();
					emfactory.close();
						
				} catch(PersistenceException ex) {
					id = -100;
				}
			}
		return id;
	}
	
}