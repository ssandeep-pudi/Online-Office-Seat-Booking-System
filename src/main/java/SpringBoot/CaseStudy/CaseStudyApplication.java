package SpringBoot.CaseStudy;

import org.springframework.boot.SpringApplication;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;

import com.model.FloorDetails;
//import com.config.UserRepo;
import com.model.User_org;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages= {"com.controller,com.model"})
@EntityScan(basePackages="com.model")
@EnableJpaRepositories(basePackages= {"com.model"})
@EnableSwagger2
public class CaseStudyApplication{

	@Autowired
	static SessionFactory sessionFactory;
	
	public static void main(String[] args) {
		SpringApplication.run(CaseStudyApplication.class, args);
		System.out.print("Hello");
	
		
	}
	
	@Bean
	public Docket productApi() {
		
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com.controller")).build();

	}
}
