import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// CREAMOS UN ARRAY DE TIPO PELICULAS PARA INSERTAR LOS OBJETOS PELICULA MAS
		// ADELANTE
		LinkedList<Pelicula> pelis = new LinkedList<>();
		// CREAMOS UN ARRAY DE FICHEROS PARA NO REPETIR DOS VECES LA MISMA OPERACION
		List<File> FicheroPeliculas = new ArrayList<>();
		// CREAMOS LOS FICHEROS CON SUS RUTAS
		File file1 = new File("C:\\Experis\\carpetaTrabajo\\AA13\\Peliculas_11_20.txt");
		File file2 = new File("C:\\Experis\\carpetaTrabajo\\AA13\\Peliculas_0_10.txt");
		// EL FILEREADER
		FileReader fr = null;
		BufferedReader br = null;
		// AÑADIMOS LOS FICHEROS AL arraylist
		FicheroPeliculas.add(file1);
		FicheroPeliculas.add(file2);
		//Llamamos el metodo
		pelis = leerFicheros(FicheroPeliculas);
		//Esto es para ordenar
		Collections.sort(pelis, Comparator.comparing(Pelicula::getRecaudacion));
		Collections.reverse(pelis);
		System.out.println("con orden" + pelis);
		
		
		//Creamos el fichero de salida
		String nomFichero = "salida_top20.txt";
		File arch_salida = new File(nomFichero);
		FileWriter fw;
		if (!arch_salida.exists()) {
			Path file = Paths.get(nomFichero);

			List<String> salida;

			try {
				fw = new FileWriter(nomFichero);
				BufferedWriter bfw = new BufferedWriter(fw);
				var i = 1;
				for (Pelicula pelicula : pelis) {

					bfw.write(i++ + "  LA PELICULA==" + pelicula.getNombre() + "RECAUDÓ==" + pelicula.getRecaudacion()
							+ "$\n");
				}
				bfw.close();
			} catch (IOException e) {
				// TODO Bloque catch generado automáticamente
				e.printStackTrace();
			}
		}
		// ORDENAR DE MENOR A MAYOR(OTRA OPCION)
//        Collections.sort(pelis, new Comparator<Pelicula>(){
//		     public int compare(Pelicula o1, Pelicula o2){
//		         if(o1.getRecaudacion() == o2.getRecaudacion())
//		             return 0;
//		         return o1.getRecaudacion() < o2.getRecaudacion() ? -1 : 1;
//		     }
//		});	
		
		generarJenkins();

	}
//METODO AL QUE LE PASAMOS UN ARRAYLIST(EN ESTE CASO DE TIPO FILE) CON LOS FICHERO A LEER
	public static LinkedList<Pelicula> leerFicheros(List<File> arrayList) {
		//CREAMOS UN ARRAYLYST DE TIPO PELICULA PARA ALMACENAR LOS OBJETOS PELICULA
		LinkedList<Pelicula> peliculas = new LinkedList<>();
		//RECORREMOS LOS ARRAYS
		for (int i = 0; i < arrayList.size(); i++) {
			try {
				// escaneamos los ficheros
				Scanner sc = new Scanner(arrayList.get(i));
				// mientras encuentre lineas, es decir, no termine
				while (sc.hasNext()) {
					// creamos un string y almacenamos cada linea del fichero
					String linea = sc.nextLine();
					// Creamos un array donde almacenamos la linea dividida por |
					String[] partes = linea.split("\\|");
//					System.out.println(partes[0].toString());
					// QUITAMOS EL DOLAR PARA METERLO EN EL OBJETO(ES DE TIPO DOUBLE EL ATRIBUTO
					// CORRESPONDIENTE)
					partes[1] = partes[1].replace("$", "");
//					 System.out.println(partes[1]);
					// AÑADIMOS EL ARRAY AL ARRAY DE LAS PELICULAS(POSICION 0 Y 1 QUE CORRESPONDA) Y CREARÁ UN OBJETO POR CADA LINE
					peliculas.add(new Pelicula(partes[0], Double.parseDouble(partes[1])));
				}
				sc.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		return peliculas;
	}
	
	public static void generarJenkins() {
		StringBuilder textJenkins=new StringBuilder();
		textJenkins.append("pipeline{\n");
		textJenkins.append("agent any\n");
		textJenkins.append("stages{\n");
		textJenkins.append("stage('Saludo'){\n");
		textJenkins.append("steps{\n");
		textJenkins.append("script{ \n");
		textJenkins.append("def fecha = LocalDate.now()\n");
		textJenkins.append("def saludo = 'Hola Mundo! EL día de hoy es ' + fecha.getDayOfWeek() + \n");
		textJenkins.append("def texto = 'Este curso me hizo programar mas de lo que me hubiese gustado \n'");
		textJenkins.append("println saludo \n");
		textJenkins.append("println texto \n");
		textJenkins.append("}\n");
		textJenkins.append("}\n");
		textJenkins.append("}\n");
		textJenkins.append("}\n");
		textJenkins.append("}\n");
		File jenkins=new File("JenkinsAA13.txt");
		if(!jenkins.exists()) {
			
			Path file=Paths.get("JenkinsAA13.txt");
			
			List<String> salida=Arrays.asList(textJenkins.toString());
			
			try {
				Files.write(file, salida, StandardCharsets.UTF_8);
			} catch (IOException e) {
				// TODO Bloque catch generado automáticamente
				e.printStackTrace();
			}
		}
		
	}

}
