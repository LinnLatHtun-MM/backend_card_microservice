package per.llt.card;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(info = @Info(
        title = "Cards API Microservice Documentation",
        version = "1.0",
        description = "ABC Bank Cards Microservice Documentation",
        contact = @Contact(name = "Lin Lat Htun", email = "linnlathtun99.mm@gmail.com", url = " https://github.com/linlathtun99"),
        license = @License(name = "Apache 2.0", url = " https://github.com/linlathtun99")),
        externalDocs = @io.swagger.v3.oas.annotations.ExternalDocumentation(
                url = "https://github.com/linlathtun99",
                description = "Find me on GitHub"
        ))
public class CardApplication {

    public static void main(String[] args) {
        SpringApplication.run(CardApplication.class, args);
    }

}
