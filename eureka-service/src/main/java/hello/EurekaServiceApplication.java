package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaServiceApplication {
    
    public static void main(String[] args) {
    	System.setProperty("spring.config.name", "registration-server");
        SpringApplication.run(EurekaServiceApplication.class, args);
    }
}
