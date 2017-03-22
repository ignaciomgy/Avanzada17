package tp1;

import java.util.Calendar;

public abstract class Viajes {

	protected int nroViaje;
	protected Calendar fechaPartida;
	protected double peso;
	protected Peon[] peones;
	protected boolean custodiaSatelital;
	protected double costo;
	protected Camion vehiculo;
	protected Peaje[] peajes;
	
	
	public Viajes(int nroViaje, Calendar fechaPartida, double peso, Peon[] peones, boolean custodiaSatelital,
			double costo, Camion vehiculo, Peaje[] peajes) {
		super();
		this.nroViaje = nroViaje;
		this.fechaPartida = fechaPartida;
		this.peso = peso;
		this.peones = peones;
		this.custodiaSatelital = custodiaSatelital;
		this.costo = costo;
		this.vehiculo = vehiculo;
		this.peajes = peajes;
	}
	
	public int getNroViaje() {
		return nroViaje;
	}
	public void setNroViaje(int nroViaje) {
		this.nroViaje = nroViaje;
	}
	public Calendar getFechaPartida() {
		return fechaPartida;
	}
	public void setFechaPartida(Calendar fechaPartida) {
		this.fechaPartida = fechaPartida;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public Peon[] getPeones() {
		return peones;
	}
	public void setPeones(Peon[] peones) {
		this.peones = peones;
	}
	public boolean isCustodiaSatelital() {
		return custodiaSatelital;
	}
	public void setCustodiaSatelital(boolean custodiaSatelital) {
		this.custodiaSatelital = custodiaSatelital;
	}
	public double getCosto() {
		return costo;
	}
	public void setCosto(double costo) {
		this.costo = costo;
	}
	public Camion getVehiculo() {
		return vehiculo;
	}
	public void setVehiculo(Camion vehiculo) {
		this.vehiculo = vehiculo;
	}
	
	public Peaje[] getPeajes() {
		return peajes;
	}
	public void setPeajes(Peaje[] peajes) {} //rehacer!!
	
}
