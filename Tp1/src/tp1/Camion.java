package tp1;

public class Camion {

	private String patente;
	private int anioPatentamiento;
	private double capacidad;
	private boolean disponible;
	
	public int getAnioPatentamiento() {
		return anioPatentamiento;
	}
	public void setAnioPatentamiento(int anioPatentamiento) {
		this.anioPatentamiento = anioPatentamiento;
	}
		
	public String getPatente() {
		return patente;
	}
	public void setPatente(String patente) {
		this.patente = patente;
	}

	public double getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(double capacidad) {
		this.capacidad = capacidad;
	}
	public boolean isDisponible() {
		return disponible;
	}
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
	
}
