package ec.ups.edu.envio.vista;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import ec.ups.edu.envio.modelo.Solicituds;
import ec.ups.edu.envio.servicio.GestionProveedorLocale;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@SessionScoped
public class SoliBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private GestionProveedorLocale on;
	private Solicituds newProducto;
	private double newStock;
	private List<Solicituds> lstSol;

	

	public GestionProveedorLocale getOn() {
		return on;
	}

	public void setOn(GestionProveedorLocale on) {
		this.on = on;
	}

	public Solicituds getNewProducto() {
		return newProducto;
	}

	public void setNewProducto(Solicituds newProducto) {
		this.newProducto = newProducto;
	}

	public double getNewStock() {
		return newStock;
	}

	public void setNewStock(double newStock) {
		this.newStock = newStock;
	}

	public List<Solicituds> getLstSol() {
		return lstSol;
	}

	public void setLstSol(List<Solicituds> lstSol) {
		this.lstSol = lstSol;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@PostConstruct
	public void init() {
		newProducto = new Solicituds();
		lstSol = new ArrayList<Solicituds>();
		try {
			listarProductos();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void registrarProducto() throws Exception {
		try {
			on.insertarSolicitud(newProducto);
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Info ",
					"Solcitud Registrado");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		} catch (Exception e) {
			throw new Exception("Error al insertar producto" + e.getLocalizedMessage());
		}
	}

	public void listarProductos() throws Exception {
		try {
			if (on.obtenerProductos() == null) {
				System.out.println("lista nula");
			} else {
				lstSol = on.obtenerProductos();
			}
		} catch (Exception e) {
			throw new Exception("Error al listar producto" + e.getLocalizedMessage());

		}
	}

	
	

}
