import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONObject;
//Este es un comentario para probar si estoy en la rama desarrollo
//hola merge?
public class Ejecutable {
	public static void main(String[] args) {
		try {
			URL url = new URL("https://www.el-tiempo.net/api/json/v2/provincias/28");
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
				JSONObject jsonObj = new JSONObject(informacionString.toString());
				String msj = (String) jsonObj.get("title") + " " + jsonObj.get("today");

				System.out.println(msj);

				Scanner input = new Scanner(System.in);

				System.out.println("¿Como te llamas?");
				String nombre = input.nextLine();
				System.out.println("Bienvenid@ " + nombre);
			}
		} catch (MalformedURLException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
	}
}
