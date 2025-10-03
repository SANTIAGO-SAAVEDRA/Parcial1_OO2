package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SistemaEstacionamiento {
	
	private List<Vehiculo> lstVehiculos = new ArrayList<>();
	private List<Lugar> lstLugares = new ArrayList<>();
	private List<Ocupacion> lstOcupaciones = new ArrayList<>();
	
	public SistemaEstacionamiento() {
		super();
		this.lstVehiculos = new ArrayList<>();
		this.lstLugares = new ArrayList<>();
		this.lstOcupaciones = new ArrayList<>();
	}
	public List<Vehiculo> getLstVehiculos() {
		return lstVehiculos;
	}
	public void setLstVehiculos(List<Vehiculo> lstVehiculos) {
		this.lstVehiculos = lstVehiculos;
	}
	public List<Lugar> getLstLugares() {
		return lstLugares;
	}
	public void setLstLugares(List<Lugar> lstLugares) {
		this.lstLugares = lstLugares;
	}
	public List<Ocupacion> getLstOcupaciones() {
		return lstOcupaciones;
	}
	public void setLstOcupaciones(List<Ocupacion> lstOcupaciones) {
		this.lstOcupaciones = lstOcupaciones;
	}
	
	@Override
	public String toString() {
		return "SistemaEstacionamiento [lstVehiculos=" + lstVehiculos + ", lstLugares=" + lstLugares
				+ ", lstOcupaciones=" + lstOcupaciones + "]";
	}
	
	public Vehiculo traerVehiculo(String dominio) {
		
		boolean encontrado = false;
		Vehiculo vehiculo = null;
		int i = 0;
		
		while(!encontrado || i<lstVehiculos.size()) {
			if(lstVehiculos.get(i).getDominio() == dominio) {
				encontrado = true;
				vehiculo = lstVehiculos.get(i);
			}
			i++;
		}
		return vehiculo;
	}
	
	public boolean agregarVehiculo(String dominio, String tipo, long dniConductor) throws Exception {
		int id = 1;
		if(!lstVehiculos.isEmpty()) {
			id = lstVehiculos.get(lstVehiculos.size()-1).getIdVehiculo() + 1;
			for(Vehiculo v : lstVehiculos) {
				if(dominio == v.getDominio()) throw new Exception("Error, ya existe un vehiculo con ese dominio");
			}
		}
		lstVehiculos.add(new Vehiculo(id, dominio, tipo, dniConductor));
		
		
		return true;
	}
	
	public Lugar traerLugar(int piso, int numero) {
		
		boolean encontrado = false;
		Lugar lugar = null;
		int i = 0;
		
		while(!encontrado || i<lstVehiculos.size()) {
			if(lstLugares.get(i).getPiso() == piso && lstLugares.get(i).getNumero() == numero) {
				encontrado = true;
				lugar = lstLugares.get(i);
			}
			i++;
		}
		return lugar;
	}
	
	public boolean agregarLugar(int piso, int numero) {
		
		int id = 1;
		if(!lstLugares.isEmpty()) {
			id = lstLugares.get(lstLugares.size()-1).getIdLugar()+1;
		}
		lstLugares.add(new Lugar(id, piso, numero));
		
		return true;
	}
	
	public boolean estaLibre(LocalDate fecha, Lugar lugar) {
		
		int i = 0;
		boolean verificado = true;
		while(i<lstOcupaciones.size() && !verificado) {
			if(!((lstOcupaciones.get(i).getFechaIngreso().isBefore(fecha)) && (lstOcupaciones.get(i).getLugar().equals(lugar)))){
				verificado = false;
			}
			i++;
		}
		return verificado;
	}
	
	public boolean agregarOcupacion(Lugar lugar, Vehiculo vehiculo, LocalDate fechaIngreso) throws Exception {
		
		int id = 1;
		if(!lstOcupaciones.isEmpty()) {
			id = lstOcupaciones.get(lstOcupaciones.size()-1).getIdOcupacion()+1;
		}
		if(!estaLibre(fechaIngreso, lugar)) {
			throw new Exception("La fecha solicitada no esta disponible");
		}else {
			lstOcupaciones.add(new Ocupacion(id, lugar, vehiculo, fechaIngreso, null));
		}
		
		return true;
	}
	
	public boolean marcarSalida(Vehiculo vehiculo, LocalDate fechaSalida) {
		// BUSCAR VEHICULO EN lstOcupaciones 
		// donde fechaSalida == null
		// vehiculo.setFechaSalida
		
		boolean encontrado = false;
		int i = 0;
		
		while((!encontrado) && (i<lstOcupaciones.size())) {
			if((vehiculo.equals(lstOcupaciones.get(i)))) {
				encontrado = true;
				lstOcupaciones.get(i).setFechaSalida(fechaSalida);
			}
			i++;
		}
		return true;
		//traerVehiculo(vehiculo.getDominio());
	}
	
	public List<Ocupacion> traerOcupacionesPorFechaIngreso(LocalDate fechaDesde, LocalDate fechaHasta){
		List<Ocupacion> listaOcupacionesPorIngreso = new ArrayList<>();
		int i = 0;
		while(i<lstOcupaciones.size()) {
			
			if((lstOcupaciones.get(i).getFechaIngreso().isAfter(fechaDesde.minusDays(1))/* && (lstOcupaciones.get(i).getFechaSalida().isAfter(fechaHasta.plusDays(1)))*/)){
				listaOcupacionesPorIngreso.add(lstOcupaciones.get(i));
			}
			
			i++;
		}
		
		return listaOcupacionesPorIngreso;
	}
	
	public List<Vehiculo> traerVehiculosEstacionadosActuales(){
		List<Vehiculo> estacionados = new ArrayList<>();
		
		int i = 0;
		
		while(i<lstOcupaciones.size()) {
			
			
			if((lstOcupaciones.get(i).getFechaSalida() == null) && (lstOcupaciones.get(i).getFechaIngreso().isBefore(LocalDate.now()))){
				estacionados.add(lstOcupaciones.get(i).getVehiculo());
			}
			
			i++;
		}
		
		return estacionados;
	}
	
	public List<Ocupacion> traerOcupacionesPorTipoVehiculo(String tipoVehiculo){
		
		List<Ocupacion> ocupacionPorVehiculo = new ArrayList<>();
		
		for(int i = 0; i < lstOcupaciones.size(); i++) {
			if(lstOcupaciones.get(i).getVehiculo().getTipoVehiculo() == tipoVehiculo) {
				ocupacionPorVehiculo.add(lstOcupaciones.get(i));
			}
		}
		
		return ocupacionPorVehiculo;
	}
	
	
	
}
