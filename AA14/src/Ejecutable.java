import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.json.JSONObject;

public class Ejecutable implements Produccion {
	public static void main(String[] args) {

		Ejecutable ejecutable = new Ejecutable();

//		int temperatura = getTemperaturaFromJson("https://www.el-tiempo.net/api/json/v2/provincias/41");

//		System.out.println(temperatura);

		if (ejecutable.produccionActiva(37)) {
//			System.out.println("menor de 40");
			ArrayList<Chocolate> chocolates = new ArrayList();
			chocolates = generarObjetos();
			String msjFichero = "NOMBRE \t \t \t PRODUCCION \n";
			for (Object chocolate : chocolates) {
				msjFichero += ((Chocolate) chocolate).getNombre() + "\t" + ((Chocolate) chocolate).getProduccion()
						+ "\n";
			}
			System.out.println("SI PUEDE PRODUCIRSE \n"+msjFichero);
			generaArchivo(msjFichero);
			generaJenkins(chocolates);

		} else {
//			System.out.println("MAYOR");
		}

		
	}

	public static ArrayList<Chocolate> generarObjetos() {
		ArrayList<Chocolate> chocolates = new ArrayList();
		Chocolate chBlanco = new Chocolate("Golosina1", "nata", "Chocolate Blanco", 1000);
		Chocolate chNegro = new Chocolate("Choco", "Chocolate", "Chocolate Negro", 1500);
		Chocolate chAlmendra = new Chocolate("almendra", "almendrado", "Chocolate con castañas de caju", 1200);
		Chocolate chCastañas = new Chocolate("Castaña", "castaña", "Chocolate Blanco", 1300);
		Chocolate chRama = new Chocolate("Golosina3", "chocolate", "Chocolate en rama", 100);
		Chocolate ch70 = new Chocolate("Golosina3", "chocolate cacao", "Chocolate 70% de cacao", 1500);
		chocolates.add(chBlanco);
		chocolates.add(chNegro);
		chocolates.add(chAlmendra);
		chocolates.add(chCastañas);
		chocolates.add(chRama);
		chocolates.add(ch70);
		return chocolates;

	}

	public static int getTemperaturaFromJson(String urlJSON) {
		URL url;
		int temperaturaMax = 0;
		try {
			url = new URL(urlJSON);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.connect();

			int tiempoRespuesta = conn.getResponseCode();
			if (tiempoRespuesta != 200) {
				throw new RuntimeException("HttpResponse " + tiempoRespuesta);
			} else {
				StringBuilder informacionString = new StringBuilder();
				Scanner sc = new Scanner(url.openStream());
				while (sc.hasNext()) {
					informacionString.append(sc.nextLine());
				}
				sc.close();
				JSONObject jsonObject = new JSONObject(informacionString.toString());
//				System.out.println(jsonObject.getClass());
				// Aqui voy accediendo a las propiedades del objeto....
				temperaturaMax = jsonObject.getJSONArray("ciudades").getJSONObject(0).getJSONObject("temperatures")
						.getInt("max");
				System.out.println(temperaturaMax);
			}
			return temperaturaMax;

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return temperaturaMax;

	}

	public static void generaArchivo(String msj) {
		// FECHA ACTUAL//FECHA ACTUAL
		LocalDate fechaHoy = LocalDate.now();
		final String nomFichero = "salida_" + fechaHoy + ".txt";
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

	public static void generaJenkins(List<Chocolate> chocolates) {
		List<String> jenkText = new ArrayList<>();
		jenkText.add("import java.time.LocalDate");
		jenkText.add("pipeline{");
		jenkText.add("agent any");
		jenkText.add("stages{");
		jenkText.add("stage ('holaMundo'){");
		jenkText.add("steps{");
		jenkText.add("script{");
		jenkText.add("println '¡Hola, hoy es un dia espectacular para producir chocolate! Mira lo que se ha producido: '");
		for (Chocolate chocolate : chocolates) {
			jenkText.add("println '" + chocolate.getNombre() + ' ' + chocolate.getNombre() + ' ' + chocolate.getProduccion() + "';");
		}
		jenkText.add("}");
		jenkText.add("}");
		jenkText.add("}");
		jenkText.add("}");
		jenkText.add("}");
		Path file = Paths.get("Jenkinsfile");
		try {
			Files.write(file, jenkText, StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean produccionActiva(int temperatura) {
		if (temperatura < 40) {
			return true;
		} else {
			return false;
		}
	}

}

interface Produccion {
	boolean produccionActiva(int temperatura);
}
