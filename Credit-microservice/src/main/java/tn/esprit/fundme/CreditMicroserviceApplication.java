package tn.esprit.fundme;

import java.util.Collections;

 import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
 import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
 import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;
 import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
@EnableSwagger2
@EnableEurekaClient
@EnableScheduling
@SpringBootApplication
public class CreditMicroserviceApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(CreditMicroserviceApplication.class, args);
		
	}
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/*").allowedOrigins("http://localhost:4200");
 
 
			}
		};
	}

}
