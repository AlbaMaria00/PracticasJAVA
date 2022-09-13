package spring;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import clases.*;
import interfaces.Genera;
import interfaces.Pbi;

//Indica que es un servicio.
//Es una operacion ofrecida como una interfaz.
//Es como que decimos que esto se puede usar en el aspecto

@Service
public class Servicio{
	
	File file;
	String msj2;
	LinkedList<Pais> paises;
	double pbi;

	public double getPbi() {
		return pbi;
	}

	public void setPbi(double pbi) {
		this.pbi = pbi;
	}

	public LinkedList<Pais> getPaises() {
		return paises;
	}

	public void setPaises(LinkedList<Pais> paises) {
		this.paises = paises;
	}

	public String getMsj2() {
		return msj2;
	}

	public void setMsj2(String msj2) {
		this.msj2 = msj2;
	}

	// Getters y Setters
	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	// METODOS
	public void generarTxt() {
		System.out.println("Generando txt");
		generaArchivo();
	}

	public LinkedList<Pais> leerArchivo() {
		FileReader fr = null;
		BufferedReader br = null;
		String linea = "";
		LinkedList<Pais> paises = new LinkedList<>();
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			while ((linea = br.readLine()) != null) {
				String[] partes = linea.split("\\|");
				int habitantes = Integer.parseInt(partes[3].replace(".", "").replace(",", "").trim());
				double salario = Double.parseDouble(partes[5].replace(".", "").replace(",", "").trim());
				Pais pais = new Pais(partes[0].trim(), partes[1].trim(), partes[4].trim(), habitantes, partes[2].trim(),
						salario, pbi);
				paises.add(pais);
			}
		} catch (

		FileNotFoundException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
		return paises;

	}

	public static double calcularpbi(int n1, double n2, Pbi formato) {
		double resultado = formato.calcular(n1, n2);
//		System.out.println("El PBI es: " + resultado);
		return resultado;
	}

	public void generaArchivo() {
		// SE CREAN 4 ARCHIVOS
		for (int i = 0; i < paises.size(); i++) {
			final String nomFichero = paises.get(i).getNombre() + "_datos.txt";
			msj2 = "CONTINENTE " + paises.get(i).getPais() + "\n" + "PAIS " + paises.get(i).getNombre() + "\n"
					+ "CAPITAL " + paises.get(i).getCapital() + "\n" + "CLIMA " + paises.get(i).getClima() + "\n"
					+ "HABITANTES " + paises.get(i).getHabitantes() + "\n" + "PIB " + pbi + "\n" + "SALARIO MINIMO "
					+ paises.get(i).getSalarioMinimo();
			// CREACIóN DEL ARCHIVO
			File archivo = new File(nomFichero);
			if (!archivo.exists()) {
				// Creamos la ruta del fichero
				Path file = Paths.get(nomFichero);
				List<String> salida = Arrays.asList(msj2);
				try {
					Files.write(file, salida, StandardCharsets.UTF_8);
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		}

	}

}
