package ec.ups.edu.envio.servicio;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.ups.edu.envio.datos.daoSolicitud;
import ec.ups.edu.envio.modelo.Solicituds;

@Stateless
public class GestionProveedorON implements GestionProveedorLocale {
	@Inject
	private daoSolicitud daoProveedor;

	@Override
	public boolean insertarSolicitud(Solicituds soli) throws Exception {
		try {
			if (soli == null) {

				System.out.println("prodcuto nulo");
			} else {
				double numero = (int) (Math.random() * 100) + 1;
				System.out.println(numero);
				soli.setPrecio(numero);
				daoProveedor.insertarSolicitud(soli);
				System.out.println("insertado" + soli);
			}
		} catch (Exception e) {
			throw new Exception("Error al momento de insertar producto on" + e.getLocalizedMessage());
		}
		return false;
	}

	public List<Solicituds> obtenerProductos() {
		List<Solicituds> produc = daoProveedor.obtenerProductos();
		System.out.println("producto" + " " + produc);
		return produc;
	}
}
