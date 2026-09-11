<<<<<<< HEAD
package gt.edu.umg.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                // Información de la API
                .info(new Info()
                        .title("API REST - Sistema de Clínicas")
                        .version("1.0.0")
                        .description("Documentación de los endpoints del sistema de gestión de clínicas de la Universidad Mariano Gálvez.")
                        .contact(new Contact()
                                .name("Soporte Técnico / Desarrollo")
                                .email("soporte@umg.edu.gt")
                                .url("https://umg.edu.gt"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://www.apache.org/licenses/LICENSE-2.0")))
                // Seguridad JWT (candado en Swagger)
                .addSecurityItem(new SecurityRequirement().addList("bearerAuth"))
                .components(new Components()
                        .addSecuritySchemes("bearerAuth",
                                new SecurityScheme()
                                        .name("bearerAuth")
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")
                                        .description("Ingresar el token JWT obtenido de /auth/login")));
    }
=======
package gt.edu.umg.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                // Información de la API
                .info(new Info()
                        .title("API REST - Sistema de Clínicas")
                        .version("1.0.0")
                        .description("Documentación de los endpoints del sistema de gestión de clínicas de la Universidad Mariano Gálvez.")
                        .contact(new Contact()
                                .name("Soporte Técnico / Desarrollo")
                                .email("soporte@umg.edu.gt")
                                .url("https://umg.edu.gt"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://www.apache.org/licenses/LICENSE-2.0")))
                // Seguridad JWT (candado 🔒 en Swagger)
                .addSecurityItem(new SecurityRequirement().addList("bearerAuth"))
                .components(new Components()
                        .addSecuritySchemes("bearerAuth",
                                new SecurityScheme()
                                        .name("bearerAuth")
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")
                                        .description("Ingresar el token JWT obtenido de /auth/login")));
    }
>>>>>>> ffcf5a27d8dc35521b8fa58bbb4e95f6aef4e943
}