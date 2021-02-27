package ec.ups.edu.envio.servicio;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;

import ec.ups.edu.envio.modelo.Solicituds;

@Remote
public interface GestionProveedorRemoto {
	public boolean insertarSolicitud(Solicituds soli) throws Exception ;
	public List<Solicituds> obtenerProductos();
}
