package desafio.via.cep.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.apache.commons.lang3.builder.ToStringSummary;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Consulta de Endereços",
                version = "1.0",
                description = "Esta API permite consultar endereços a partir de CEPs.",
                contact = @Contact(
                        name = "Fernando Dias Costa",
                        email = "fdias132@gmail.com",
                        url = "https://www.linkedin.com/in/fernandodiascosta-dotnet/"
                )))
public class OpenApiConfig {
}
