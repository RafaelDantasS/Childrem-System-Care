package br.com.careSystem.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

public class OpenApiConfig {

	public OpenAPI customerOpenApi() {
		return new OpenAPI().info(new Info()
				.title("Api para cadastro e controle de crianças")
				.version("v1")
				.description("Api para controle de crianças e responsaveis a fim de agilizar o processo de devolução das crianças.")
				);
	}
}
