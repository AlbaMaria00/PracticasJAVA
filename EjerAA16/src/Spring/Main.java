package Spring;

import java.awt.Menu;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import classes.*;
import excepciones.MiExcepcion;

public class Main {
	public static void main(String[] args) {
		// archivo de los artistas
		File art20 = new File("C:\\Experis\\carpetaTrabajo\\EjerAA16\\Artistas_2020.txt");
		File art21 = new File("C:\\Experis\\carpetaTrabajo\\AA16\\Artistas_2021.txt");
		// archvios de las canciones+reproducciones
		File can20 = new File("C:\\Experis\\carpetaTrabajo\\AA16\\Canciones_2020.txt");
		File can21 = new File("C:\\Experis\\carpetaTrabajo\\AA16\\Canciones_2021.txt");
		List<File> ficheros = new ArrayList<>();
		// Metemos en un array los 4 ficheros(LO NECESITAREMOS PARA VALIDAR SI EL STRING
		// TERMINA EN TXT)
		ficheros.add(art20);
		ficheros.add(art21);
		ficheros.add(can20);
		ficheros.add(can21);

		// El mesj de salida a escribir en el txt
		String msjsalida = "";

		// Leemos la configuracion de spring
		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ConfigurarSpring.class)) {
			// Obtener el bean del contenedor
			Servicio servicio = ctx.getBean(Servicio.class);

			msjsalida += "TOP 10 ARTISTAS DE 2020 \n";
			msjsalida += servicio.leerArtistas(art20) + "\n";
			msjsalida += "TOP 10 ARTISTAS DE 2021 \n";
			msjsalida += servicio.leerArtistas(art21) + "\n";
			msjsalida += "\nTOP 10 CANCIONES 2020 + RECAUDACION\n";
			msjsalida += servicio.leer(can20) + "\n";
			msjsalida += "\nTOP 10 CANCIONES 2021 + RECAUDACION\n";
			msjsalida += servicio.leer(can21) + "\n";

			
			//En la variable que hemos creado en servicio metemos el array de los ficheros
			servicio.setArray(ficheros);
			//Llamamos al metodo validar(en el usamos la variable anterior)
			if (servicio.validarTxt() == true) {
				servicio.setMsj2(msjsalida);
				servicio.generaArchivo();
			}else {
				//Esto es para si hay un archivo que no termina en txt , sale una excepcion
				throw new MiExcepcion(111);
			}

			ctx.close();
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (MiExcepcion e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}

	}

}
