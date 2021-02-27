package ec.ups.edu.envio.servicio;

import java.util.List;

import javax.ejb.Local;

import ec.ups.edu.envio.modelo.Solicituds;

@Local
public interface GestionProveedorLocale {
	public boolean insertarSolicitud(Solicituds soli) throws Exception ;
	public List<Solicituds> obtenerProductos();
}
