package sidecar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.sidecar.EnableSidecar;


@SpringBootApplication
@EnableSidecar
@EnableDiscoveryClient
@EnableHystrix
public class SideCarApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(SideCarApplication.class, args);
	}

}
