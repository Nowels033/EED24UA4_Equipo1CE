package proyecto;


import java.util.Random;
import java.util.Scanner;



//- Tarea 2(3) crear Clase Cliente con los atributos identificador, password

public class Cliente {
	Random rnd = new Random();

	// atributos
	int identificador;
	int password;
	int indice;
	double monedero = rnd.nextDouble(1000, 20001);

	// constructor
	public Cliente(int identificador, int password, int indice) {
		this.identificador = identificador;
		this.password = password;
		this.indice=indice;
	}

	
	//OLD
//	// metodo para mostrar el saldo
//	static double mostrarSaldo(Cliente cliente) {
//		return cliente.monedero;
//	}
//
//	// metodo para ingresar importe
//	static void ingresarImporte(Cliente cliente) {
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Indica el importe a ingresar: ");
//		double importe = sc.nextDouble();
//		cliente.monedero = importe + cliente.monedero;
//		System.out.println("Ha ingresado " + importe + "€");
//	}
//
//	// metodo para sacar importe
//	static void obtenerImporte(Cliente cliente) {
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Indica el importe a obtener: ");
//		double importe = sc.nextDouble();
//		cliente.monedero = cliente.monedero - importe;
//		System.out.println("Ha obtenido " + importe + "€");
//	}
//	
//	//metodo para transferir dinero
//	static void transferirImporte(Cliente cliente, Cliente cliente1) {
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Indica el importe a transferir: ");
//		double importe = sc.nextDouble();
//		cliente.monedero = cliente.monedero - importe;
//		cliente1.monedero = cliente1.monedero + importe;
//		System.out.println("Ha transferdo " + importe + "€");
//	}

	
	//NEW
	static void verMonedero(Cliente[] array, int identificador) {

		for (int i = 0; i < array.length; i++) {

			if (array[i].identificador == identificador) {

				System.out.println("El saldo de tu monedero es : " + array[i].monedero + "€");
			}
		}

	}

	static void traspasarMonedero(Cliente[] array, int identificadorEmisor) {
		Scanner sc = new Scanner(System.in);
		int identificadorReceptor;
		double transferencia;
		boolean error = true;
		boolean error2 = true;
		System.out.println("Introduce el identificador del receptor de la transferencia");
		identificadorReceptor = sc.nextInt();
		System.out.println("Introduce el importe de la transferencia");
		transferencia = sc.nextDouble();

		for (int i = 0; i < array.length; i++) {

			if (array[i].identificador == identificadorEmisor) {

				for (int j = 0; j < array.length; j++) {

					if (array[j].identificador == identificadorReceptor) {

						array[j].monedero = array[j].monedero + transferencia;
						array[i].monedero = array[i].monedero - transferencia;

						System.out.println("Tranferecia realizada correctamente");
						System.out.println("Tu saldo es ahora de : " + array[i].monedero + "€");
						error = false;

					}

				}

				error2 = false;
			}
		}

		if (error) {

			System.out.println("Error..El Identificador :" + identificadorReceptor + " No existe.");

		}
		if (error2) {
			
			System.out.println("Error en tu identificador vuelve a logearte");

		}

	}

	static void ingresoMonedero(Cliente[] array, int identificador) {

		Scanner sc = new Scanner(System.in);

		boolean error = true;

		System.out.println("Introduce el importe a ingresar");
		double ingreso = sc.nextDouble();

		for (int i = 0; i < array.length; i++) {

			if (identificador == array[i].identificador) {

				array[i].monedero = array[i].monedero + ingreso;
				System.out.println("Acabas de ingresar : " + ingreso);
				System.out.println("Tu monedero es de : " + array[i].monedero);
				System.out.println();
				error = false;
			}

		}
		if (error) {
			System.err.println("Error..No se pudo realizar el ingreso");
		}

	}

	static void retiradaMonedero(Cliente[] array, int identificador) {
		Scanner sc = new Scanner(System.in);
		boolean error = true;

		System.out.println("Introduce el importe a retirar");
		double retirada = sc.nextDouble();

		if (retirada > 0) {

			for (int i = 0; i < array.length; i++) {

				if (identificador == array[i].identificador) {

					if (array[i].monedero >= retirada) {
						array[i].monedero = array[i].monedero - retirada;
						System.out.println("Acabas de retirar : " + retirada + "€");
						System.out.println("Tu monedero es de : " + array[i].monedero + "€");
						System.out.println();
						error = false;
					} else {
						error = true;
					}

				}

			}
		} else if (error || retirada <= 0) {
			System.out.println(
					"No se puede realizar la retirada, Monedero insuficiente o el importe de la retirada son 0 € o menos");
		}

	}

	
	static boolean verificarIdentidicador(Cliente[] cliente, int identificador) {
		boolean correcto = false;

		for (int i = 0; i < cliente.length; i++) {
			if (cliente[i].identificador == identificador) {
				correcto = true;
				return correcto;
			}
		}
		return correcto;
	}

	static boolean verificarPassword(Cliente[] cliente, int password) {
		boolean correcto = false;

		for (int i = 0; i < cliente.length; i++) {
			if (cliente[i].password == password) {
				correcto = true;
				return correcto;
			} 
//			else {
//				correcto = false;
//				return false;
//			} old ............????no entiendo ese else, si la password no esta en la primera posicion siempre dara error
		}
		return correcto;
	}

	@Override
	public String toString() {
		return "Cliente [identificador=" + identificador + ", password=" + password + ", monedero=" + monedero + "€]";
	}

}