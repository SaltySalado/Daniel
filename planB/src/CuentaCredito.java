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
public class CuentaCredito extends Cuenta {
	
	private static final int SALDO_DEFAULT=0;
	private static final int CREDITO_DEFAULT=100;
	private double credito;
	
	public CuentaCredito(double saldo,String titular,double credito ) throws CuentaException {
		super(saldo,titular);
		
		setCredito(credito);
		setSaldo(saldo);
		
	}
	
	public CuentaCredito(String titular) throws CuentaException {
		super(titular);
		
		this.credito = CREDITO_DEFAULT;
		super.saldo=SALDO_DEFAULT;
	}


	public double getCredito() {
		return credito;
	}

	public void setCredito(double credito) throws CuentaException {
		
		if(credito > 300) {
			throw new CuentaException("Credito fuera de parámetros");
		}
		
		this.credito = credito;
	}
	
	public void setSaldo(double saldo) throws CuentaException {
		
		if(saldo<0) {
			throw new CuentaException("Saldo negativo");
		}
		
		this.saldo = saldo;
	}
	
	public void realizarReintegro(double reintegro) throws CuentaException {
		if (reintegro <= 0){
			throw new CuentaException("Reintegro fuera de limites");
		}
		if (reintegro > this.saldo+this.credito) {
			throw new CuentaException("No tienes suficiente saldo.");
		} 
			
		this.saldo = this.saldo - reintegro;
		this.contadorReintegros++;
	}
	
	public void realizarIngreso(double ingreso) throws CuentaException {
		if (ingreso <= 0){
			throw new CuentaException("El ingreso solo puede realizarse con cantidades positivas."); 
		}
		this.saldo = this.saldo + ingreso;
		this.contadorIngresos++;
	}
	

}
