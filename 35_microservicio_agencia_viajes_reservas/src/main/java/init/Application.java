package init;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestClient;
@EnableJpaRepositories(basePackages = {"dao"})
@EntityScan(basePackages = {"entities"})
@SpringBootApplication(scanBasePackages = {"controller","service","utilidades"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public RestClient restClientHotel() {
		return RestClient.builder().baseUrl("http://servicio-hoteles/hoteles").build();
	}
	
	@Bean
	public RestClient restClientVuelo() {
		return RestClient.builder().baseUrl("http://servicio-vuelos/vuelos").build();
	}
}
