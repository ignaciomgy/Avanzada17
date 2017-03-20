package tp1;

import java.util.Calendar;

public class Viajes {

	protected int nroViaje;
	protected Calendar fechaPartida;
	protected double peso;
	protected Peon[] peones;
	protected boolean custodiaSatelital;
	protected double costo;
	protected Camion vehiculo;
	protected Peaje[] peajes;
	
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
