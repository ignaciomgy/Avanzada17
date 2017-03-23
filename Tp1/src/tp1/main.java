package tp1;
import java.util.Scanner;
import java.util.regex.Pattern;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Locale;
import java.util.Random;

public class main {

	static Scanner scn = new Scanner(System.in);
	static Camion[] camiones = new Camion[10];
	static Peon[] peones = new Peon[5];
	static Random rnd;
	static int nroViaje;
	static Calendar fechaHoy = Calendar.getInstance();
	
	static String[] nombres = {"Juan", "Pedro", "Ramon", "Ulises", "Neron"};
	static long[] cuiles = {20123456781L, 12123456781L, 35123456786L, 65123456785L, 88123456785L};
	static double[] costoss = {2500.25, 3685.99, 9500.00, 8500.00, 12600.00};
	
	static Viajes[] viajes;
	static Peaje[] peajes;
	
	
	public static void main(String[] args) {
		
		nroViaje = 0;
		//b
		cargarPeones();
		
		//c
		cargarCamiones();
		
		//d
		cargarViaje();

		//e
		System.out.println("Ingrese un numero de viaje a modificar.");
		int n = scn.nextInt();
		modificarViaje(n);
		
	
		
	}


	private static void modificarViaje(int n) {
		boolean encontrado = false;
		
		for (int i=0; i < viajes.length; i++) {
			if ( (viajes[i].getNroViaje()) == i ) {
				modificarViaje2(viajes[i]);
				encontrado = true;
			}
		}

	}


	private static void modificarViaje2(Viajes viajes2) {
		Camion c = seleccionarVehiculo(viajes2.getPeso());
		Peon[] peonV = null;
		
		peonV = seleccionarPeones(peonV);
		
		viajes2.setPeones(peonV);
		viajes2.setVehiculo(c);
		
	}


	private static void cargarViaje() {
		Peon[] peonesV = null;
		
		System.out.println("Ingrese el peso total a transportar en kilogramos.");
		double peso = scn.nextDouble();
		
		System.out.println("Necesita peones para el viaje?. Y - N");
		String choise = scn.nextLine();
		if (choise.equals("Y") || choise.equals("y")) {
			peonesV = seleccionarPeones(peonesV);	
		}
		
		System.out.println("Realizar un Viaje Corto o Larga ?. C - L");
		String tv = scn.nextLine();
		
		System.out.println("Desea contratar la custodia satelital?. Y -N");
		boolean custodia = scn.nextBoolean();
		
		System.out.println("Ingrese el costo basico del viaje.");
		double costo = scn.nextDouble();
		
		Camion camionElegido = seleccionarVehiculo(peso);
		
		

		if ( tv.equals("L") || tv.equals("l")) 
		{
			cargarPeajes();
			cargarViajeLargo(nroViaje, fechaHoy, peso, peones, custodia, costo, camionElegido, peajes);
			
		}
		else 
		{
			cargarViajeCorto(nroViaje, fechaHoy, peso, peones, custodia, costo, camionElegido, peajes);
			
		}
		
		nroViaje++;
		
	}



	private static void cargarViajeCorto(int nroViaje2, Calendar fechaHoy2, double peso, Peon[] peones2,
			boolean custodia, double costo, Camion camionElegido, Peaje[] peajes2) {
		
		System.out.println("Desea abonar el viaje con Cheque o en Efectivo ?. C - E.");
		String op = scn.nextLine();
		
		if (op.equals("E") || op.equals("e")) {
			costo = costo - (costo*0.05);
		} 
		
		viajes[nroViaje] = new ViajeCorto(nroViaje2, fechaHoy2, peso, peones2, custodia, costo, camionElegido, peajes2, op);

	}


	private static void cargarViajeLargo(int nroViaje2, Calendar fechaHoy2, double peso, Peon[] peones2, boolean custodia, double costo, Camion camionElegido, Peaje[] peajes2) {
		ArrayList<String> localidades = new ArrayList<String>();
		int i = 0;
		Calendar fechaLLegada = Calendar.getInstance();
		
		System.out.println("Ingrese la fecha prevista de llegada. Ej: dd/mm/aaaa");
		String fechaE = scn.nextLine();
		String[] fechaL = fechaE.split("/");		
		
		int dia = Integer.valueOf(fechaL[0]);
		int mes = Integer.valueOf(fechaL[1])-1;
		int anio = Integer.valueOf(fechaL[2]);
		
		fechaLLegada.set(Calendar.DAY_OF_MONTH, dia);
		fechaLLegada.set(Calendar.MONTH, mes);
		fechaLLegada.set(Calendar.YEAR, anio);

		boolean fin = true;
		
		while (fin) {
			System.out.println("Ingrese las localidades visitadas en el viaje.");
			String loc = scn.nextLine();
			localidades.add(loc);
			
			
			System.out.println("Desea cargar otra localidad?. Y - N");
			String choice = scn.nextLine();	
			if (choice.equals("N") || choice.equals("n")) {
				fin = false;
			}
			
			i++;
			
		}
		
		viajes[nroViaje] = new ViajeLargo(nroViaje2, fechaHoy2, peso, peones2, custodia, costo, camionElegido,  peajes2, fechaLLegada, localidades);
		
	}


	private static void cargarPeajes() {
		boolean cargar = true;
		int i = 0;
		while (cargar) {
			System.out.println("______PEAJES________________________________");
			System.out.println("Ingrese el lugar del peaje a cargar al viaje.");
			String lugar = scn.nextLine();
			System.out.println("Ingrese el importe del peaje.");
			double costo = scn.nextDouble();
			
			Peaje p = new Peaje(lugar, costo);
			peajes[i] = p;
			i++;
			
			System.out.println("Desea cargar un nuevo peaje ? Y - N");
			if ((scn.nextLine()).equals("N")) {
				cargar = false;
			}
		}
	}


	private static Camion seleccionarVehiculo(double peso) {
		System.out.println("___________CAMIONES____DISPONIBLES__________________________");
		Camion ca = new Camion();
		boolean seleccion = false;
		
		for(Camion c: camiones) {
			if (c.isDisponible() && c.getCapacidad() >= peso) {
				System.out.println("Patente del Camion: " + c.getPatente());
				System.out.println("Año de patentamiento: " + c.getAnioPatentamiento());
				System.out.println("Capacidad de carga: " + c.getCapacidad());
			}
		}
		
		while (!seleccion) {
			System.out.println("Ingrese la patente del vehiculo sleccionado.");
			String pat = scn.nextLine();
			
			for(int i =0 ; i< camiones.length; i++) {
				if ((camiones[i].getPatente()).equals(pat)) {
					ca = camiones[i];
					seleccion = true;
				}
			}
			
			if(!seleccion) {
				System.out.println("No se ha encontrado dicho vehiculo. Ingrese una patente existente.");
				scn.nextLine();
			}
		}
		
		return ca;
	}


	private static Peon[] seleccionarPeones(Peon[] peonesDeViaje) {
		boolean masPeones = true;
		int i =0;
		mostrarPeones();
		
		while(masPeones) {
			System.out.println("Ingrese el CUIL a seleccionar.");
			long cuil = scn.nextLong();
			peonesDeViaje[i] = agregarPeonaAViaje(cuil);
			i++;
			System.out.println("Necesita peones para el viaje?. Y - N");
			String choise = scn.nextLine();
			if (choise.equals("Y") || choise.equals("y")) {
				masPeones = true;
			} else {
				masPeones = false;
			}
			
		}
		
		return peonesDeViaje;
		
	}

	private static Peon agregarPeonaAViaje(long cuil) {
		Peon p = new Peon();
		
		for ( int i =0; i<peones.length; i++) {
			if ((peones[i].getCuil()) == cuil ) {
				p = peones[i];
			}
		}
		
		return p;

	}

	private static void mostrarPeones() {
		System.out.println("_________PEONES______________________________________");
		
		for (Peon p: peones) {
			System.out.println("Nombre: "+p.getNombre());
			System.out.println("CUIL: "+p.getCuil());
			System.out.println("Costo: "+p.getCosto());
			System.out.println("\n"+"------------------------"+"\n");			
		}
		
	}



	private static void cargarPeones() {
		for (int i=0; i<5; i++) {
			Peon p = new Peon();
			p.setNombre(nombres[i]);
			p.setCuil(cuiles[i]);
			p.setCosto(costoss[i]);
		
			peones[i] = p;
		}
	}



	private static void cargarCamiones() {
		String patente = null;
		int anioP;
		double capa;
		
		for (int i=0; i<1; i++) {
			Camion c = new Camion();
			
			System.out.println("Ingrese la patente del Camion en formato valido. Ej 'ABC123' o 'AB123CD'.");	
			patente = scn.nextLine();
			
			System.out.println("Ingrese el año de patentamiento del camion.");
			anioP = validar_anio(scn.hasNextInt());
			
			System.out.println("Ingrese la capacidad en Kilos que posee el camion." );
			capa = validar_peso(scn.hasNextDouble());
			
			System.out.println("--------------------------------------");
			scn.nextLine();
			
			c.setPatente(validar_patente(patente));
			c.setAnioPatentamiento(anioP);
			c.setCapacidad(capa);
			c.setDisponible(true);
			
			camiones[i] = c;
		}
		
	}


	private static double validar_peso(boolean hasNextDouble) {
		double anio = scn.nextInt();
		
		while ((!hasNextDouble) || (0 > anio) || (anio > 5000)) {
			System.out.println("Ingrese un peso valido. 0 a 5000'");
			hasNextDouble = scn.hasNextInt();
			anio = scn.nextInt();
		}
		
		return anio;
	}



	private static int validar_anio(boolean b) {
		Integer anio = scn.nextInt();
						
		while ((!b) || (1900 > anio) || (anio > 2017)) {
			System.out.println("Ingrese un año valido. AAAA'");
			b = scn.hasNextInt();
			anio = scn.nextInt();
		}
		
		return anio;
	}



	private static String validar_patente(String patente) {
		boolean cumplePatron = Pattern.matches("[A-Z]{3,}+[0-9]{3,}", patente) || Pattern.matches("[A-Z]{2,}+[0-9]{3,}+[A-Z]{2,}", patente);
		while (!cumplePatron) {
			System.out.println("Ingrese la patente del Camion en formato valido. Ej 'ABC123' o 'AB123CD'.");
			patente = scn.nextLine();
			cumplePatron = Pattern.matches("[A-Z]{3,}+[0-9]{3,}", patente) || Pattern.matches("[A-Z]{2,}+[0-9]{3,}+[A-Z]{2,}", patente);
		}
		
		return patente;		
	}
	

}