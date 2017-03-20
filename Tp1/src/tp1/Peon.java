package tp1;

public class Peon {

	private String nombre;
	private long cuil;
	private double costo;
	
	public Peon(){}
	
	public Peon(String nombre, int cuil, double costo) {
		super();
		this.nombre = nombre;
		this.cuil = cuil;
		this.costo = costo;
	}
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public long getCuil() {
		return cuil;
	}
	public void setCuil(long cuiles) {
		this.cuil = cuiles;
	}
	public double getCosto() {
		return costo;
	}
	public void setCosto(double costo) {
		this.costo = costo;
	}
	
	
	
	
}
