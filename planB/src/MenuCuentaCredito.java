import java.util.Scanner;

/*Realizar una clase CuentaCredito que herede de la clase Cuenta y que cumpla:
◦ Al crear una cuenta de crédito se indica de qué cantidad de crédito se dispone, es decir, a cuánto
puede quedar la cuenta en números rojos. Por ejemplo, si el crédito es de 100€ la cuenta podrá
llegar a tener un saldo igual a –100.
◦ Inicialmente, si no se indica nada, el saldo de la cuenta es 0€.
◦ Inicialmente, si no se indica nada, el crédito es de 100€.
◦ Se deben incluir los métodos get y set para el crédito. El crédito nunca puede superar los 300€.
También habrá que tener en cuenta el saldo actual de la cuenta.
◦ Se deberá modificar los métodos de sacarDinero para incluir el crédito.
Realizar una clase de prueba MenuCuentaCredito que cree una cuenta de crédito y presente un menú
con estas opciones.
1. Ingresar dinero
2. Sacar dinero
3. Mostrar saldo y crédito
4. Salir
Realizar un programa Principal que cree una cuenta ahorro joven y pruebe sus métodos.
*/
public class MenuCuentaCredito {

	private static Scanner teclado = new Scanner(System.in);
	private CuentaCredito cuenta;

	public MenuCuentaCredito(double saldo, String titular, double credito) throws CuentaException {

	
			cuenta = new CuentaCredito(saldo, titular, credito);
		

	}

	private int pedirOpcionMenu() throws CuentaException {

		int opcion;

		MenuCuentaCredito.mostrarMenu();
		opcion = Integer.parseInt(teclado.nextLine());
		
		return opcion;

	}

	public boolean tratarMenu() throws CuentaException {

		int cantidad;
		int opcion;
		boolean salir=false;
		
		opcion=pedirOpcionMenu();
		
		switch (opcion) {

		case 1:
			System.out.println("Introduce la cantidad de dinero que quieres ingresar");
			cantidad=Integer.parseInt(teclado.nextLine());
			
			cuenta.realizarIngreso(cantidad);
			break;
		case 2:
			
			System.out.println("Introduce la cantidad de dinero que quieres sacar");
			cantidad=Integer.parseInt(teclado.nextLine());
			
			cuenta.realizarReintegro(cantidad);
			
			break;
		case 3:
			
			System.out.println("El saldo de la cuenta es "+cuenta.getSaldo() + " y el credito es de " + cuenta.getCredito());
			
			break;
		case 4:
			salir=true;
			break;
		default:
			throw new CuentaException("Opcion fuera de rangos");

		}

		return salir;
	}

	private static void mostrarMenu() {
		System.out.println("Elige una opcion");
		System.out.println("1.Ingresar dinero");
		System.out.println("2.Sacar dinero");
		System.out.println("3.Mostrar saldo y credito");
		System.out.println("4.Salir");
	}

}
