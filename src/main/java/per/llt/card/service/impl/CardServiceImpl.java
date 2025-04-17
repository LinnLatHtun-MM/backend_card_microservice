package per.llt.card.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import per.llt.card.constants.CardsConstants;
import per.llt.card.dto.CardsDto;
import per.llt.card.entity.Cards;
import per.llt.card.exception.CardsAlreadyException;
import per.llt.card.exception.ResourceNotFoundException;
import per.llt.card.mapper.CardsMapper;
import per.llt.card.mapper.GenericMapper;
import per.llt.card.repo.CardsRepository;
import per.llt.card.service.ICardsService;

import java.util.Optional;
import java.util.Random;

@Service
public class CardServiceImpl implements ICardsService {

    @Autowired
    private CardsRepository cardsRepository;

    @Override
    public void createCard(String mobileNumber) {
        Optional<Cards> existingCard = cardsRepository.findByMobileNumber(mobileNumber);
        if (existingCard.isPresent()) {
            throw new CardsAlreadyException("Card already registered with given mobileNumber " + mobileNumber);
        }
        cardsRepository.save(createNewCard(mobileNumber));
    }


    /**
     * @param mobileNumber - Mobile Number of the Customer
     * @return the new card details
     */
    private Cards createNewCard(String mobileNumber) {
        Cards newCard = new Cards();
        long randomCardNumber = 100000000000L + new Random().nextInt(900000000);
        newCard.setCardNumber(Long.toString(randomCardNumber));
        newCard.setMobileNumber(mobileNumber);
        newCard.setCardType(CardsConstants.CREDIT_CARD);
        newCard.setTotalLimit(CardsConstants.NEW_CARD_LIMIT);
        newCard.setAmountUsed(0);
        newCard.setAvailableAmount(CardsConstants.NEW_CARD_LIMIT);
        return newCard;
    }

    /**
     * @param mobileNumber - Input mobile Number
     * @return Card Details based on a given mobileNumber
     */
    @Override
    public CardsDto fetchCard(String mobileNumber) {
        Cards cards = cardsRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Card", "mobileNumber", mobileNumber));

        return GenericMapper.mapper(cards, CardsDto.class);

//        return CardsMapper.mapToCardsDto(cards, new CardsDto());
    }


    /**
     * @param cardsDto - CardsDto Object
     * @return boolean indicating if the update of card details is successful or not
     */
    @Override
    public boolean updateCard(CardsDto cardsDto) {
        boolean isUpdated = false;
        if (cardsDto != null) {
            Cards cards = cardsRepository.findByCardNumber(cardsDto.getCardNumber()).orElseThrow(
                    () -> new ResourceNotFoundException("Card", "CardNumber", cardsDto.getCardNumber()));
            CardsMapper.mapToCards(cardsDto, cards);
            cardsRepository.save(cards);
            return isUpdated = true;
        }
        return isUpdated;
    }

    /**
     * @param mobileNumber - Input MobileNumber
     * @return boolean indicating if the delete of card details is successful or not
     */
    @Override
    public boolean deleteCard(String mobileNumber) {
        boolean isDeleted = false;
        if (mobileNumber != null) {
            Cards cards = cardsRepository.findByMobileNumber(mobileNumber).orElseThrow(
                    () -> new ResourceNotFoundException("Card", "mobileNumber", mobileNumber));
            cardsRepository.delete(cards);
            return isDeleted = true;
        }
        return isDeleted;
    }
}
