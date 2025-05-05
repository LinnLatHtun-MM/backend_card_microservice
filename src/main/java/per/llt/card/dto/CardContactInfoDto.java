package per.llt.card.dto;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

/**
 * ConfigurationProperties Usage need to add this annotation in CardApplication
 *
 * @EnableConfigurationProperties(value = {CardContactInfoDto.class})
 **/
@ConfigurationProperties(prefix = "cards")
public record CardContactInfoDto(
        String message, Map<String, String> contactDetails, List<String> onCallSupport) {
}
