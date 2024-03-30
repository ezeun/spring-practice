package leeju.springpractice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringPracticeApplication {

	public static void main(String[] args) {

		Hello hello = new Hello();
		hello.setData("leeju");
		String data = hello.getData();
		System.out.println("data = "+data);

		SpringApplication.run(SpringPracticeApplication.class, args);
	}

}
