package ashes.accountservice;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class AccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountServiceApplication.class, args);
	}

	@Bean
	NewTopic notification() {
		return new NewTopic("notification", 2, (short) 1);
	}

	@Bean
	NewTopic statistic () {
		return new NewTopic("statistic", 2, (short) 1);
	}
}
