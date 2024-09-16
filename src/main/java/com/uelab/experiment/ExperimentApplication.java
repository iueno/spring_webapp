package com.uelab.experiment;
import com.uelab.experiment.used.Greet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ExperimentApplication {
	public static void main(String[] args) {
		SpringApplication.run(ExperimentApplication.class, args)
				.getBean(ExperimentApplication.class).execute();
	}

	@Autowired
	private Greet g;

	private void execute() {
		String msg = g.greeting();
		System.out.println(msg);
	}

	@GetMapping("/")
	public String top() {
		return "top page";
	}
	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}
}