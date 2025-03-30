package per.llt.card.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import per.llt.card.entity.BaseEntity;

import java.time.LocalDateTime;

/**
 * This DTO can't show as a schema in OpenAPI documentation because it uses for Exception handling
 * we need to configure OpenAPI to mention this in the AccountController class in update API using keyword @Content
 */
@Data
@AllArgsConstructor
@Schema(name = "Error Response", description = "Schema to hold error response")
public class ErrorResponseDto extends BaseEntity {

    @Schema(description = "API path invoked by Clients")
    private String apiPath;

    @Schema(description = "Error code representing the error happened")
    private HttpStatus errorCode;

    @Schema(description = "Error message representing the error happened")
    private String errorMessage;

    @Schema(description = "Time representing when the error happened")
    private LocalDateTime errorTime;
}

