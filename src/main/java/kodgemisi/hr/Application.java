package kodgemisi.hr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
@SpringBootApplication
public class Application extends WebMvcAutoConfiguration{

	public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
	

	public void run(String... args) throws Exception {
	}
}
