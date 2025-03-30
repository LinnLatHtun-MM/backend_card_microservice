package per.llt.card.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import per.llt.card.entity.BaseEntity;

@Data
@AllArgsConstructor
@Schema(name = "Response", description = "Schema to hold successful response")
public class ResponseDto extends BaseEntity {

    @Schema(description = "Status Code in the response", example = "200")
    private String statusCode;

    @Schema(description = "Status Message in the response", example = "Request processed successfully")
    private String statusMsg;
}
