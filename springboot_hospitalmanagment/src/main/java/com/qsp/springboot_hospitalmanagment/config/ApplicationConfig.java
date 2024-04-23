package com.qsp.springboot_hospitalmanagment.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
//url of swagger:http://localhost:8080/swagger-ui.html#

@Configuration
@EnableSwagger2
public class ApplicationConfig {
	@Bean
	public Docket getDocket() {
		Contact contact = new Contact("Qspiders", "https://qspiders.com", "qspider.gmail");
		List<VendorExtension> extensions = new ArrayList<VendorExtension>();
		ApiInfo apiInfo = new ApiInfo("Hospital Managment System", "this app is used to manage hospitals by admin", "Version1.0",
				"1 year service", contact, "QSP001", "http://qsp001.com", extensions);
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.qsp.springboot_hospitalmanagment")).build()
				.apiInfo(apiInfo).useDefaultResponseMessages(false);
	}

}
