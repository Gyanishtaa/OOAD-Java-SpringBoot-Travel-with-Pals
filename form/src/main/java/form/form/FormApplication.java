package form.form;

import form.form.controller.UsersController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.File;
@SpringBootApplication
public class FormApplication {

	public static void main(String[] args) {
		new File(UsersController.uploadDirectory).mkdir();

		SpringApplication.run(FormApplication.class, args);
	}

}
