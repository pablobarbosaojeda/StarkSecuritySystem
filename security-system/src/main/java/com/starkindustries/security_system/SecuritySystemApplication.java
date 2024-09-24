package com.starkindustries.security_system;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.SimpleCommandLinePropertySource;

@SpringBootApplication
public class SecuritySystemApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(SecuritySystemApplication.class);

		// Añade un listener para personalizar el entorno
		app.addListeners((ApplicationListener<ApplicationEnvironmentPreparedEvent>) event -> {
			ConfigurableEnvironment environment = event.getEnvironment();
			configureEnvironment(environment, args);
		});

		ConfigurableApplicationContext context = app.run(args);

		// Lógica adicional después de que la aplicación ha iniciado
	}

	private static void configureEnvironment(ConfigurableEnvironment environment, String[] args) {
		MutablePropertySources sources = environment.getPropertySources();

		// Agrega la lógica necesaria para configurar el entorno, como propiedades de Docker, sensores, MySQL, etc.
		configurePropertySources(environment, args);
	}

	protected static void configurePropertySources(ConfigurableEnvironment environment, String[] args) {
		MutablePropertySources sources = environment.getPropertySources();

		// Agregar propiedades de línea de comandos si es necesario
		if (args.length > 0) {
			sources.addFirst(new SimpleCommandLinePropertySource(args));
		}

		// Aquí puedes agregar otras propiedades o fuentes necesarias
	}
}
