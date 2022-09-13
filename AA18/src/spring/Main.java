package spring;

import java.awt.Menu;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import clases.Pais;
import interfaces.Pbi;

public class Main {
	public static void main(String[] args) {
		File file = new File("C:\\Experis\\carpetaTrabajo\\AA18\\INFO_PAISES.txt");
		LinkedList<Pais> paises;
		Pbi pbi_lambda = (t1, t2) -> t1 * t2;
		double pbi;
		// Leemos la configuracion de spring
		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ConfigurarSpring.class)) {
			// Obtener el bean del contenedor
			Servicio servicio = ctx.getBean(Servicio.class);
			servicio.setFile(file);
			paises = servicio.leerArchivo();
			servicio.setPaises(paises);
			for (int i = 0; i < paises.size(); i++) {
				pbi = servicio.calcularpbi(paises.get(i).getHabitantes(), paises.get(i).getSalarioMinimo(), pbi_lambda);
				servicio.setPbi(pbi);
				paises.get(0).setPBI(pbi);
				servicio.generaArchivo();
			}
			servicio.generarTxt();

			ctx.close();
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
