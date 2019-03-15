package se.lexicon.daniel.spring.config;
import java.util.Scanner;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import se.lexicon.daniel.spring.service.ScannerInputService;

@Configuration
@ComponentScan("se.lexicon.daniel.spring")
public class ComponentScanConfig {

	@Bean
	public Scanner scan() {
		return new Scanner(System.in);
	}
}
