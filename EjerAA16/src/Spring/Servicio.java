package Spring;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import classes.*;

import org.springframework.stereotype.Service;

//Indica que es un servicio.
//Es una operacion ofrecida como una interfaz.
//Es como que decimos que esto se puede usar en el aspecto

@Service
public class Servicio {
	String nombreFichero;
	List<File> array;
	
	String msj2;

	public void generarTxt() {
		System.out.println("Generando txt");
	}

	public String leer(File file) throws FileNotFoundException {
		String line = "";
		int recaudacion = 0;
		String msj="";
		LinkedList<Cancion> canciones = new LinkedList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			while ((line = br.readLine()) != null) {
				String[] partes = line.split("\\|");
				recaudacion = Integer.parseInt((partes[2].replace(".", "")).trim());
				Cancion cancion = new Cancion(line, line, line, recaudacion);
				cancion = new Cancion(partes[1], partes[1], partes[0], cancion.calcularRecaudacion(recaudacion));
				canciones.add(cancion);
			}
			for (Object cancion:canciones) {
				msj+=((Cancion) cancion).getTitulo()+"------"+((Cancion) cancion).getRecaudacion()+"\n";
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return msj;
	}

	public String leerArtistas(File file) {
		// CREAMOS UN ARRAYLYST DE TIPO PELICULA PARA ALMACENAR LOS OBJETOS PELICULA
		String line = "";
		String msj="";
		LinkedList<Artista> artistas = new LinkedList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			while ((line = br.readLine()) != null) {
				Artista artista = new Artista(line, line);
				artistas.add(artista);
			}
			for (Object artista:artistas) {
				msj+=((Artista) artista).getNombre()+"\n";
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return msj;
	}

	public Boolean validarTxt() {
		boolean retorno = false;
		for (int i = 0; i < array.size(); i++) {
			if (array.get(i).toString().contains("txt")) {
				retorno = true;
			} else {
				retorno = false;
			}
		}
		return retorno;
	}

	public void generaArchivo() {
		final String nomFichero = "conjunto.txt";
		// CREACIÓN DEL ARCHIVO
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

	public String getNombreFichero() {
		return nombreFichero;
	}

	public void setNombreFichero(String nombreFichero) {
		this.nombreFichero = nombreFichero;
	}

	public List<File> getArray() {
		return array;
	}

	public void setArray(List<File> array) {
		this.array = array;
	}

	public String getMsj2() {
		return msj2;
	}

	public void setMsj2(String msj2) {
		this.msj2 = msj2;
	}
}
