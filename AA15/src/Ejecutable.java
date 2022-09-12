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

import org.json.JSONArray;
import org.json.JSONObject;

public class Ejecutable implements Archivo {

	public static void main(String[] args) {
		leerJson(
				"https://public.opendatasoft.com/api/records/1.0/search/?dataset=provincias-espanolas&q=&rows=0&sort=-provincia&facet=ccaa&facet=provincia");
	}

	// METODOS

	public static void leerJson(String urlJSON) {
		URL url;
		List<Provincia> provincias = new ArrayList<>();
		List<Capital> comunidades = new ArrayList<>();
		Ejecutable ej = new Ejecutable();
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

//				System.out.println(jsonObject.getJSONArray("facet_groups").getJSONObject(1).getJSONArray("facets"));

				JSONArray arraydataProvincias = jsonObject.getJSONArray("facet_groups").getJSONObject(1)
						.getJSONArray("facets");

				for (int i = 0; i < arraydataProvincias.length(); i++) {
					Provincia provincia = new Provincia(arraydataProvincias.getJSONObject(i).get("path").toString(),
							arraydataProvincias.getJSONObject(i).get("name").toString());

					provincias.add(provincia);
				}

				System.out.println(provincias);
				Persona per1 = new Persona("ALba", "Paris");
				LocalDate fechaHoy = LocalDate.now();
				Usuario user = new Usuario("alba301100", per1, fechaHoy, 1);
				System.out.println(user);
				String msj = "El usuario que ha implementado la informacion es: " + ((Usuario) user).getNombre()
						+ " Fecha Login " + ((Usuario) user).getFechaHoy() + "\n";
				for (Object provincia : provincias) {
					msj += "Nombre de la provincia " + ((Provincia) provincia).getNombreProvincia()
							+ " Nombre de la capital " + ((Provincia) provincia).nombreCapital + "\n";
				}
				
				System.out.println(msj);
				ej.generaArchivo(msj);
				
				generaJenkins(provincias,user);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void generaArchivo(String msj) {
		final String nomFichero = "salida.txt";
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

	public static void generaJenkins(List<Provincia> provincias, Usuario usuario) {
		List<String> jenkText = new ArrayList<>();
		jenkText.add("pipeline{");
		jenkText.add("agent any");
		jenkText.add("stages{");
		jenkText.add("stage ('holaMundo'){");
		jenkText.add("steps{");
		jenkText.add("script{");
		jenkText.add("println " + usuario.getNombre() + " con ID " + usuario.getId() + " Login en " + usuario.getFechaHoy() + " ;");
		 for(Provincia provincia:provincias) {
			 jenkText.add("println " + provincia.getNombreProvincia() + ' ' + provincia.getNombreCapital()+ ";");
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

}

//INTERFAZ(LA GENERO SIEMPRE AQUI PARA AHORRAR RECURSOS)
interface Archivo {
	public void generaArchivo(String msj);
}
