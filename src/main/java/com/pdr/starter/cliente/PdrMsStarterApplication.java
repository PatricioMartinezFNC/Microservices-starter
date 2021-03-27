package com.pdr.starter.cliente;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import lombok.extern.slf4j.Slf4j;

/**
 * @author BS2
 */
@SpringBootApplication
@ComponentScan
@Slf4j
public class PdrMsStarterApplication {

	private String urlServicio = "/starter/project";

	public static void main(String[] args) {
		SpringApplication.run(PdrMsStarterApplication.class, args);
	}
	
//	@Bean
//	public PdrExceptionAspect pdrExceptionAspect() {
//		return new PdrExceptionAspect();
//	}

	@Bean
	public WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> webServerFactoryCustomizer() {
		log.info("webServerFactoryCustomizer[]::inicia servicio web de cliente");
		log.info("webServerFactoryCustomizer[]::uri-->"+ urlServicio);
		return factory -> factory.setContextPath(this.urlServicio);
	}
}
