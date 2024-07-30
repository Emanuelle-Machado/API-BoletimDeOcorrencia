package br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia")
public class WebApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(WebApiApplication.class, args);
	}
}
