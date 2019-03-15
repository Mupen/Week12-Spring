package se.lexicon.daniel.spring.service;

import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ScannerInputService implements UserInputService {
	private Scanner scan;
	
	@Autowired
	public ScannerInputService(Scanner scan, String input) {
		this.scan = scan;
	}

	@Override
    public String getString(String inputString) {
		System.out.println(inputString);
        return scan.nextLine();
    }
	
	@Override
	public Integer getInteger(Integer number) {
		System.out.println(number);
        return scan.nextInt(); // not sure if it can take Integer
	}
}
