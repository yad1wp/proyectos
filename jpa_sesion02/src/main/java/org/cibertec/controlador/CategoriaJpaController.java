package org.cibertec.controlador;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.cibertec.model.Categoria;

public class CategoriaJpaController implements Serializable{

	private static final long serialVersionUID = 1L;
	private EntityManager em;
	private EntityManagerFactory emf=Persistence.createEntityManagerFactory("jpa_sesion02");
	
	public CategoriaJpaController(EntityManagerFactory emf) {
		this.emf=emf;
	}
		
	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
	
	public CategoriaJpaController() {		
	}
	
	public List<Categoria> findAllCategoria() {
		em = getEntityManager();
		em.getTransaction().begin();
		TypedQuery<Categoria> q = em.createQuery("select e from Categoria e", Categoria.class);

		List<Categoria> res = q.getResultList();

		em.getTransaction().commit();
		em.close();
		return res;
	}
 
	
	public Categoria buscarById(int codigo) {		
		em = getEntityManager();
		em.getTransaction().begin();
		
		Categoria cat =em.find(Categoria.class, codigo);		
		
		if (cat==null) {
			System.out.println("Categoria con id: " + String.valueOf(codigo) + " no encontrado");
		}else {
			System.out.println("Categoria con id: " + String.valueOf(codigo) + " encontrado");
		}
		em.getTransaction().commit();
		em.close();		
		return cat;
	}
}
