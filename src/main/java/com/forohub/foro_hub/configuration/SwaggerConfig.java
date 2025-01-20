package com.forohub.foro_hub.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;


@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "FOROHUB API",
                description = "Demo of a forohub.",
                version = "1.0.0",
                contact = @Contact(
                        name = "byteForgeDev",
                        url = "https://github.com/oscarArismendi"
                )
        ),
        servers = {
                @Server(
                        description = "DEV SERVER",
                        url = "http://localhost:8080"
                )  
        },
        security = @SecurityRequirement(
                name = "Security Token"
        )
)
@SecurityScheme(
        name = "Security Token",
        description = "Access Token For My API",
        type = SecuritySchemeType.HTTP,
        paramName = HttpHeaders.AUTHORIZATION,
        in = SecuritySchemeIn.HEADER,
        scheme = "bearer",
        bearerFormat = "JWT"
)
public class SwaggerConfig {

}
