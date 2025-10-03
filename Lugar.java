package modelo;

public class Lugar {
	private int idLugar;
	private int piso;
	private int numero;
	
	public Lugar(int idLugar, int piso, int numero) {
		super();
		this.idLugar = idLugar;
		this.piso = piso;
		this.numero = numero;
	}
	
	public int getIdLugar() {
		return idLugar;
	}
	public void setIdLugar(int idLugar) {
		this.idLugar = idLugar;
	}
	public int getPiso() {
		return piso;
	}
	public void setPiso(int piso) {
		this.piso = piso;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	@Override
	public String toString() {
		return "Lugar [idLugar=" + idLugar + ", piso=" + piso + ", numero=" + numero + "]\n";
	}
	
	
}
