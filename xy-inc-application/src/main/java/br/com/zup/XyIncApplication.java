package br.com.zup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@ComponentScan(basePackages = { "br.com.zup.rest.api", "br.com.zup.service" })
@Configuration
@EnableJpaRepositories(basePackages = { "br.com.zup.repository" })
@EnableAutoConfiguration
@EntityScan(basePackages = { "br.com.zup.model" })
@EnableTransactionManagement
public class XyIncApplication {

	public static void main(String[] args) {
		SpringApplication.run(XyIncApplication.class, args);
	}
}
