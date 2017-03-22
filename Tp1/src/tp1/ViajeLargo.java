package tp1;

import java.util.ArrayList;
import java.util.Calendar;

public class ViajeLargo extends Viajes {

	private double distancia;
	private Calendar fechaLlegada;
	private ArrayList<String> localidades;
	
	public ViajeLargo(int nroViaje, Calendar fechaHoy, double peso, Peon[] peones, boolean custodia, double costo,
			Camion camionElegido, Peaje[] peajes, Calendar fechaLLegada2, ArrayList<String> localidades2) {
		super(nroViaje, fechaHoy, peso, peones, custodia, costo, camionElegido, peajes);
		fechaLlegada = fechaLLegada2;
		localidades = localidades2;		
	}
	
	public double getDistancia() {
		return distancia;
	}
	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}
	public Calendar getFechaLlegada() {
		return fechaLlegada;
	}
	public void setFechaLlegada(Calendar fechaLlegada) {
		this.fechaLlegada = fechaLlegada;
	}
	public ArrayList<String> getLocalidades() {
		return localidades;
	}
	public void setLocalidades(ArrayList<String> localidades) {
		this.localidades = localidades;
	}
	
	
}
