package com.uelab.experiment;
import com.uelab.experiment.service.BusinessLogic;
import com.uelab.experiment.used.Greet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ExperimentApplication {
	public static void main(String[] args) {
		//通常の起動
		//SpringApplication.run(ExperimentApplication.class, args);

		//pattern1 @Component+@Autowiredを使う場合
		//SpringApplication.run(ExperimentApplication.class, args).getBean(ExperimentApplication.class).execute();

		//pattern2 @Configuration+@Qualifier+@Autowiredを使う場合
		SpringApplication.run(ExperimentApplication.class, args).getBean(ExperimentApplication.class).execute2();
	}

	//pattern1 @Component+@Autowiredを使う場合
	@Autowired
	private Greet g;

	private void execute() {
		String msg = g.greeting();
		System.out.println(msg);
	}

	//pattern2 @Configuration+@Qualifier+@Autowiredを使う場合
	@Autowired
	@Qualifier("test")
	private BusinessLogic business1;

	@Autowired
	@Qualifier("sample")
	private BusinessLogic business2;

	private void execute2() {
		business1.doLogic();
		business2.doLogic();
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