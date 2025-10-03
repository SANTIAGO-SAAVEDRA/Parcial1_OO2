package modelo;

import java.time.LocalDate;

public class Ocupacion {
	private int idOcupacion;
	private Lugar lugar;
	private Vehiculo vehiculo;
	private LocalDate fechaIngreso;
	private LocalDate fechaSalida;
	
	public Ocupacion(int idOcupacion, Lugar lugar, Vehiculo vehiculo, LocalDate fechaIngreso, LocalDate fechaSalida) {
		super();
		this.idOcupacion = idOcupacion;
		this.lugar = lugar;
		this.vehiculo = vehiculo;
		this.fechaIngreso = fechaIngreso;
		this.fechaSalida = fechaSalida;
	}
	
	public int getIdOcupacion() {
		return idOcupacion;
	}
	public void setIdOcupacion(int idOcupacion) {
		this.idOcupacion = idOcupacion;
	}
	public Lugar getLugar() {
		return lugar;
	}
	public void setLugar(Lugar lugar) {
		this.lugar = lugar;
	}
	public Vehiculo getVehiculo() {
		return vehiculo;
	}
	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}
	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public LocalDate getFechaSalida() {
		return fechaSalida;
	}
	public void setFechaSalida(LocalDate fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	@Override
	public String toString() {
		return "Ocupacion [idOcupacion=" + idOcupacion + ", lugar=" + lugar + ", vehiculo=" + vehiculo
				+ ", fechaIngreso=" + fechaIngreso + ", fechaSalida=" + fechaSalida + "]";
	}

}
