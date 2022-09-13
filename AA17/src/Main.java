import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Aleatorio ejecutarAleatorio = (int max) -> (int) (Math.random() * max + 1);

		Scanner sc = new Scanner(System.in);
		System.out.println("¿Como te llamas?");
		String nombre = sc.nextLine();
		Usuario user=new Usuario(nombre);
		
		int numeroUsuario = 0;
		int numeroMaxAleatorio=1000000;
		int numeroAleatorio = generar(ejecutarAleatorio,numeroMaxAleatorio);
		int i = 0;

		System.out.println(user.getNombre()+" di un numero del 1 al 1.000.000");
		numeroUsuario = sc.nextInt();

		for (i = 0; i <= 4; i++) {
			if (numeroUsuario == numeroAleatorio) {
				System.out.println("¡Has acertado!");
				break;
			} else if (i == 4) {
				System.out.println("Lo siento: ¡has perdido!. El número era el: " + numeroAleatorio);
				break;
			}
			if (i <= 1) {
				System.out.print("Otro intento: ");
				numeroUsuario = sc.nextInt();
			} else if (i == 2) {
				System.out.print("Inténtalo de nuevo: ");
				numeroUsuario = sc.nextInt();
			} else if (i >= 3) {
				System.out.print("Oh, oh... ÚLTIMO intento: ");
				numeroUsuario = sc.nextInt();
			}
		}
	}

	public static int generar(Aleatorio formato,int max) {
		int numeroRandom = formato.ejecutarAleatorio(max);
//		System.out.println(numeroRandom);
		return numeroRandom;
	}

	interface Aleatorio {
		int ejecutarAleatorio(int max);
	}

}
