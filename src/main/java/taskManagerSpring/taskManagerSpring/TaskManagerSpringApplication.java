package taskManagerSpring.taskManagerSpring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import taskManagerSpring.taskManagerSpring.model.Block;
import taskManagerSpring.taskManagerSpring.service.BlockService;
import taskManagerSpring.taskManagerSpring.service.TaskService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@SpringBootApplication
public class TaskManagerSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskManagerSpringApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(TaskService taskService, BlockService blockService) throws IOException {

		return args -> {
			blockService.saveBlock(new Block(100L, "All tasks"));



		};
	}

}

