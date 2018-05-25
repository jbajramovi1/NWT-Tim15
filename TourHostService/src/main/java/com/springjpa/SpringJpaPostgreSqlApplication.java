package com.springjpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.springjpa.repo.TourHostRepository;
import com.springjpa.services.TourHostService;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableAutoConfiguration
@EnableDiscoveryClient
public class SpringJpaPostgreSqlApplication implements CommandLineRunner{

	@Autowired
	TourHostRepository repository;
	
	public static final String TOUR_HOST_SERVICE_URL = "http://TOURHOST-SERVICE";
	
	public static void main(String[] args){
		SpringApplication.run(SpringJpaPostgreSqlApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		
	}
	
	@LoadBalanced    
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public TourHostService tourHostService() {
        return new TourHostService(TOUR_HOST_SERVICE_URL);
    }
}

