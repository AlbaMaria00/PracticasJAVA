package spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
//Indicamos qeu es una configuracion
@Configuration
//Componente a escanear
@ComponentScan("spring")
//Lo habilitamos como un proxy(puente entre el AOP y el programa) es la unica forma para unirlos
@EnableAspectJAutoProxy

public class ConfigurarSpring {

}
