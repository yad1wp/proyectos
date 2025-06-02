package org.cibertec.controlador;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.cibertec.model.Producto;

public class ProductoJpaController implements Serializable{

	private static final long serialVersionUID = 1L;
	private EntityManager em;
	private EntityManagerFactory emf=Persistence.createEntityManagerFactory("jpa_sesion02");
	
	public ProductoJpaController(EntityManagerFactory emf) {
		this.emf=emf;
	}	
	
	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
	
	public ProductoJpaController() {		
	}
	
	public void registrar(Producto data) throws Exception {		
		
	}

	public List<Producto> findAll() {
		
	}
	
	public Producto buscarById(int codigo) {		
		
	}
}
