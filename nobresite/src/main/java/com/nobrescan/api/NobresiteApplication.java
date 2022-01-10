package com.nobrescan.api;
import com.nobrescan.api.controller.MangasController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.delivery.request"})
@ComponentScan(basePackageClasses = MangasController.class)
public class NobresiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(NobresiteApplication.class, args);
	}

}
