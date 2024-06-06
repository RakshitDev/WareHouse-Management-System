package com.jsp.whms.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
@OpenAPIDefinition
public class ApplicationDoc {
	@Bean
	public OpenAPI openApi() {
		return new OpenAPI().info(new Info()
				.title("The-WareHouse-Manager")
				.version("V1")
				.description("Spring boot project built using restful"+" Architectre,cover all the basic crud operation \n"+
				"- Covers all **CRUD** operation \n"+
						"- Performed field validation\n"+
				"- Used DTO to control inbound and outbound data \n"));
	}

}
