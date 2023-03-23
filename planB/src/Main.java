import java.util.Scanner;

public class Main {

	private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		double saldo, credito;
		String titular;
		MenuCuentaCredito cuenta;
		boolean salir = false;

		try {

			System.out.println("Introduce el saldo, el credito y el titular de la cuenta");
			saldo = Double.parseDouble(teclado.nextLine());
			credito = Double.parseDouble(teclado.nextLine());
			titular = teclado.nextLine();

			cuenta = new MenuCuentaCredito(saldo, titular, credito);

			do {

				salir = cuenta.tratarMenu();

			} while (salir == false);
			
		} catch (CuentaException e) {

			System.out.println(e.getMessage());
		}

	}

}
