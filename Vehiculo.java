package modelo;

public class Vehiculo {
	
	private int idVehiculo;
	private String dominio;
	private String tipoVehiculo;
	private long dniConductor;
	
	public Vehiculo(int idVehiculo, String dominio, String tipoVehiculo, long dniConductor) {
		super();
		this.idVehiculo = idVehiculo;
		this.dominio = dominio;
		this.tipoVehiculo = tipoVehiculo;
		this.dniConductor = dniConductor;
	}
	
	public int getIdVehiculo() {
		return idVehiculo;
	}
	public void setIdVehiculo(int idVehiculo) {
		this.idVehiculo = idVehiculo;
	}
	public String getDominio() {
		return dominio;
	}
	public void setDominio(String dominio) {
		this.dominio = dominio;
	}
	public String getTipoVehiculo() {
		return tipoVehiculo;
	}
	public void setTipoVehiculo(String tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}
	public long getDniConductor() {
		return dniConductor;
	}
	public void setDniConductor(long dniConductor) {
		this.dniConductor = dniConductor;
	}
	@Override
	public String toString() {
		return "Vehiculo [idVehiculo=" + idVehiculo + ", dominio=" + dominio + ", tipoVehiculo=" + tipoVehiculo
				+ ", dniConductor=" + dniConductor + "]\n";
	}
}
