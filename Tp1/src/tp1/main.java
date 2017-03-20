package tp1;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.Calendar;
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
	
	
	public static void main(String[] args) {
		nroViaje = 0;
		cargarPeones();
		cargarCamiones();
		
		cargarViaje();

		mostrarPeones();
		

		
	}

/*
	Cada viaje es numerado de forma automática y consecutiva, registrándose en cada uno la fecha de partid
	(fecha del sistema), el peso total en kilos transportado, los peones que fuesen necesarios, si se requiere /
	o no custodia satelital, el costo básico del viaje, el vehículo con el cual se llevará a cabo y los peajes 
	abonados durante el trayecto. De cada peaje abonado, se conoce el lugar y el importe correspondiente. */
	
	private static void cargarViaje() {
		
		System.out.println("Ingrese el peso total a transportar en kilogramos.");
		scn.nextDouble();
		
		System.out.println("Necesita peones para el viaje?. Y - N");
		String choise = scn.nextLine();
		if (choise.equals("Y") || choise.equals("y")) {
			seleccionarPeones();	
		}
		
		
		
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