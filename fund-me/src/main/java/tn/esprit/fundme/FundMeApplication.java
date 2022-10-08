package tn.esprit.fundme;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.scheduling.annotation.EnableScheduling;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableEurekaClient
@EnableScheduling
@SpringBootApplication
@EnableSwagger2
public class FundMeApplication {

	public static void main(String[] args) {
		SpringApplication.run(FundMeApplication.class, args);
	}

}
