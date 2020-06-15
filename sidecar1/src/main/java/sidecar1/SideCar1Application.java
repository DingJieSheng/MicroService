package sidecar1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.sidecar.EnableSidecar;


@SpringBootApplication
@EnableSidecar
public class SideCar1Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(SideCar1Application.class, args);
	}

}