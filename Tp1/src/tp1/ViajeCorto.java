
package tp1;

import java.util.Calendar;

public class ViajeCorto extends Viajes {

	public ViajeCorto(int nroViaje, Calendar fechaPartida, double peso, Peon[] peones, boolean custodiaSatelital,
			double costo, Camion vehiculo, Peaje[] peajes, String opcion) {
		super(nroViaje, fechaPartida, peso, peones, custodiaSatelital, costo, vehiculo, peajes);
		
		if (opcion.equals("E") || opcion.equals("e")) {
			setEfectivo(true);
		} else {
			setEfectivo(false);
		}
	}

	private boolean efectivo;

	public boolean isEfectivo() {
		return efectivo;
	}

	public void setEfectivo(boolean efectivo) {
		this.efectivo = efectivo;
	}
	
}
