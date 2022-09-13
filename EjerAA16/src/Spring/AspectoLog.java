package Spring;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import classes.Cancion;

@Aspect
@Component
public class AspectoLog {
	// Esto va antes de generartxt
	@Before("execution(* generaArchivo())")
	public void log1() {
		System.out.println("Generando el archivo salida");

	}

	@Before("execution(* validarTxt())")
	public void log2() {
		System.out.println("Validando que el archivo tenga terminacion .txt");
	}

	@After("execution(* generaArchivo())")
	public void log3() {
		System.out.println("Archivo generado. Finalizacion del programa. Gracias.");
	}

}
