package br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;

public class JerseyConfig extends ResourceConfig {
	public JerseyConfig() {
		this.register(RequestContextFilter.class);
		this.packages("br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.endpoint");
	}
}
