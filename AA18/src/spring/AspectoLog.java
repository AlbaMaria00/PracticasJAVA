package spring;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import clases.Pais;
import clases.Usuario;

@Aspect
@Component
public class AspectoLog {
	// Esto va antes de generartxt
	@Before("execution(* generarTxt())")
	public void log1() {
		System.out.println("Analizando la funcion que genera los archivos");
	}

	@After("execution(* generarTxt())")
	public void log3() {
		Usuario userUsuario= new Usuario(1, "", "");
		userUsuario.generaDatosUser();
	}

	@After("execution(* generarTxt())")
	public void log2() {
		System.out.println("Finalizacion");
	}

}
