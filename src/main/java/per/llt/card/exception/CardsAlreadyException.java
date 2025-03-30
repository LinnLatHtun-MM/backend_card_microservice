package per.llt.card.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class CardsAlreadyException extends RuntimeException {

    public CardsAlreadyException(String message) {
        super(message);
    }
}

