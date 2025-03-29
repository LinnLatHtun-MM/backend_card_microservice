package per.llt.card.service.impl;

import per.llt.card.dto.CardsDto;
import per.llt.card.service.ICardsService;

public class CardServiceImpl implements ICardsService {
    @Override
    public void createCard(String mobileNumber) {

    }

    @Override
    public CardsDto fetchCard(String mobileNumber) {
        return null;
    }

    @Override
    public boolean updateCard(CardsDto cardsDto) {
        return false;
    }

    @Override
    public boolean deleteCard(String mobileNumber) {
        return false;
    }
}
