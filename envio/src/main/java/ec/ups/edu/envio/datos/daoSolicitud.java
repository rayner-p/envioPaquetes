package ec.ups.edu.envio.datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.ups.edu.envio.modelo.Solicituds;


@Stateless
public class daoSolicitud {
	@Inject
	private EntityManager em;

	public daoSolicitud() {
		// TODO Auto-generated constructor stub
	}
	public boolean insertarSolicitud(Solicituds soli) {
		em.persist(soli);
		return true;
	}

	public List<Solicituds> obtenerProductos() {
		String jpql = "Select c from Solicituds c";
		Query q = em.createQuery(jpql, Solicituds.class);
		return q.getResultList();

	}

	

}
