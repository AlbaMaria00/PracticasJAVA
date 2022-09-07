package clases;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public class Main implements Calculo , archivo{
	public static void main(String[] args) {
		
		Main calculo = new Main();
		Videojuego arrayObjetos[]=new Videojuego[5];
		arrayObjetos[0] = new Videojuego("FIFA", 6000, 15);
		arrayObjetos[1] = new Videojuego("DARK SOULS 3", 10000, 5);
		arrayObjetos[2] = new Videojuego("THE LAST OF US", 50000, 10);
		arrayObjetos[3] = new Videojuego("MARIO BROS", 45000, 1);
		arrayObjetos[4] = new Videojuego("DOOM 2", 100000, 1);
		double ventasTotal = 0;
		int monto = 0;
		String titulos="";
		for (int i=0;i<arrayObjetos.length;i++) {
			ventasTotal+=calculo.calcularRecaudacion(arrayObjetos[i].cantidad_registros, arrayObjetos[i].precio);
			monto+=calculo.calculoMonto(arrayObjetos[i].cantidad_registros);
			titulos+=arrayObjetos[i].titulo+"\t \n";
		}
		String msj = "TITULO \t \t \t \n";
		msj+=titulos;
		msj+="Se vendieron "+monto+" unidades en total "+ " se recaudó "+ ventasTotal +" de dinero";
		calculo.generaArchivo(msj);	
		
	}

	@Override
	public double calcularRecaudacion(int ventas, double precio) {
		// TODO Esbozo de método generado automáticamente
		return ventas*precio;
	}

	@Override
	public int calculoMonto(int ventas) {
		// TODO Esbozo de método generado automáticamente
		return ventas;
	}

	@Override
	public void generaArchivo(String msj) {
		final String nomFichero = "infoVentas.txt";
		// CREACIÓN DEL ARCHIVO
		File archivo = new File(nomFichero);
		if (!archivo.exists()) {
			// Creamos la ruta del fichero
			Path file = Paths.get(nomFichero);

			List<String> salida = Arrays.asList(msj);
			try {
				Files.write(file, salida, StandardCharsets.UTF_8);
			} catch (IOException e) {
				// TODO Bloque catch generado automáticamente
				e.printStackTrace();
			}
		}
	}


}

interface Calculo {
	double calcularRecaudacion(int ventas, double precio);
	int calculoMonto(int ventas);
}

interface archivo {
	public void generaArchivo(String msj);
}

