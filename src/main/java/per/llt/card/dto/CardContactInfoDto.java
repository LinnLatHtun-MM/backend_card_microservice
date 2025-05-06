package per.llt.card.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

/**
 * ConfigurationProperties Usage need to add this annotation in CardApplication
 *
 * @EnableConfigurationProperties(value = {CardContactInfoDto.class})
 **/
@ConfigurationProperties(prefix = "cards")
@Getter
@Setter
public class CardContactInfoDto{
    private String message;
    private Map<String, String> contactDetails;
    private List<String> onCallSupport;
}
