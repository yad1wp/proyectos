package org.cibertec.controlador;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.cibertec.model.Proveedor;

public class ProveedorJpaController implements Serializable{

	private static final long serialVersionUID = 1L;
	private EntityManager em;
	private EntityManagerFactory emf=Persistence.createEntityManagerFactory("jpa_sesion02");
	
	public ProveedorJpaController(EntityManagerFactory emf) {
		this.emf=emf;
	}
	
	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
	
	public ProveedorJpaController() {		
	}
	
	public List<Proveedor> findAllProveedor() {
		em = getEntityManager();
		em.getTransaction().begin();
		TypedQuery<Proveedor> q = em.createQuery("select e from Proveedor e", Proveedor.class);

		List<Proveedor> res = q.getResultList();

		em.getTransaction().commit();
		em.close();
		return res;
	}
	
   public Proveedor buscarById(int codigo) {		
		em = getEntityManager();
		em.getTransaction().begin();
		
		Proveedor prov =em.find(Proveedor.class, codigo);
		
		
		if (prov==null) {
			System.out.println("Proveedor con id: " + String.valueOf(codigo) + " no encontrado");
		}else {
			System.out.println("Proveedor con id: " + String.valueOf(codigo) + " encontrado");
		}
		em.getTransaction().commit();
		em.close();		
		return prov;
	}
}
