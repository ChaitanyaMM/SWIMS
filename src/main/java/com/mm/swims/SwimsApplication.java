package com.mm.swims;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Controller
@SpringBootApplication
@ComponentScan(basePackages = "com")
@EnableJpaRepositories(basePackages="com.mm.swims.*")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@EntityScan(basePackages = {"com.mm.swims.Entity"})  // scan JPA entities
@EnableTransactionManagement
//@Configuration
//@EnableSwagger2
public class SwimsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwimsApplication.class, args);
	}
	@RequestMapping(value="/")
	@ResponseBody
    public String home() {
        return "Hello SWIMS!!...";
    }
	
	 /* public Docket api(){
	        return new Docket(DocumentationType.SWAGGER_2)
	            .select()
	            .apis(RequestHandlerSelectors.basePackage("com.mm.swims.Controller"))
	            .paths(PathSelectors.any())
	            .build()
	            .apiInfo(apiInfo());
	    }

		    private ApiInfo apiInfo() {
		        return new ApiInfoBuilder()
		            .title("TITLE")
		            .description("DESCRIPTION")
		            .version("VERSION")
		            .termsOfServiceUrl("http://terms-of-services.url")
		            .license("LICENSE")
		            .licenseUrl("http://url-to-license.com")
		            .build();
		    }*/

}
