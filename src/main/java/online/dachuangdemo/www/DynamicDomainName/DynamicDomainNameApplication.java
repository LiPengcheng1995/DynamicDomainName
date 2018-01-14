package online.dachuangdemo.www.DynamicDomainName;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = "online.dachuangdemo.www.DynamicDomainName")
public class DynamicDomainNameApplication {

	public static void main(String[] args) {
		SpringApplication.run(DynamicDomainNameApplication.class, args);
	}
}
