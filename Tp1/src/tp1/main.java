package tp1;
import java.util.Scanner;
import java.util.regex.Pattern;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
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
		
		/*nroViaje = 0;
		cargarPeones();
		cargarCamiones();
		
		cargarViaje();

		mostrarPeones();
		*/

  
		Calendar fecha = Calendar.getInstance();
		
		System.out.println(fecha.get(Calendar.MONTH)+1);
		 
		    //System.out.println(gc.get(GregorianCalendar.YEAR) + (m < 10 ? "0" + mm : mm) + (d < 10 ? "0" + dd : dd));
		
		
	}


	private static void cargarViaje() {
		
		System.out.println("Ingrese el peso total a transportar en kilogramos.");
		double peso = scn.nextDouble();
		
		System.out.println("Necesita peones para el viaje?. Y - N");
		String choise = scn.nextLine();
		if (choise.equals("Y") || choise.equals("y")) {
			seleccionarPeones();	
		}
		
		System.out.println("Ingrese Kms a recorrer en el viaje.");
		double kms = scn.nextDouble();
		
		System.out.println("Desea contratar la custodia satelital?. Y -N");
		boolean custodia = scn.nextBoolean();
		
		System.out.println("Ingrese el costo basico del viaje.");
		double costo = scn.nextDouble();
		
		Camion camionElegido = seleccionarVehiculo(peso);
		
		cargarPeajes();
		 //ViajeLargo vl = new Viaje(nroViaje, fechaHoy, peso, peones, custodia, costo, camionElegido, peajes);
		if ( kms > 1000 ) {
			Calendar fechaLLegada = Calendar.getInstance();
			
			System.out.println("Ingrese la fecha prevista de llegada. Ej: dd/mm/aaaa");
			String fecha = scn.nextLine();
			
			SimpleDateFormat sdf = new SimpleDateFormat("fecha", Locale.US);
			//fechaLLegada.setTime(sdf.parse("fecha"));
			
			
			
			
			System.out.println("Ingrese las localidades visitadas en el viaje.");
			
		}
		else 
		{
			
		}
		
		
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


	private static void seleccionarPeones() {
		Peon[] peonesParaViaje;
		boolean masPeones = true;
		mostrarPeones();
		System.out.println("Ingrese el CUIL a seleccionar.");
		
		while(masPeones) {
			long cuil = scn.nextLong();
			agregarPeonaAViaje(cuil);
			System.out.println("Necesita peones para el viaje?. Y - N");
			String choise = scn.nextLine();
			if (choise.equals("Y") || choise.equals("y")) {
				masPeones = true;
			} else {
				masPeones = false;
			}
			
		}
		
		
		
	}

	private static void agregarPeonaAViaje(long cuil) {
		// TODO Auto-generated method stub
		
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