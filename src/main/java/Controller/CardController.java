package Controller;

import Models.Card;
import Request.CardRequest;
import Response.CardResponse;
import Service.CardService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/boards/{boardId}/cards")
public class CardController {
    private final CardService cardService;

    @Autowired
    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @PostMapping
    public CardResponse createCard(@PathVariable String boardId, @RequestBody CardRequest request) {
        Card card = cardService.createCard(boardId, request.getTitle(), request.getDescription(), request.getSection());
        return convertToCardResponse(card);
    }

    @GetMapping
    public CardResponse.CardsResponse getCards(@PathVariable String boardId) {
        List<Card> cards = cardService.getCards(boardId);
        List<CardResponse> cardResponses = cards.stream()
                .map(this::convertToCardResponse)
                .collect(Collectors.toList());
        return new CardResponse.CardsResponse(cardResponses);
    }

    @GetMapping("/{cardId}")
    public CardResponse getCard(@PathVariable String boardId, @PathVariable String cardId) {
        Card card = cardService.getCard(boardId, cardId);
        return convertToCardResponse(card);
    }

    @PutMapping("/{cardId}")
    public void updateCard(
            @PathVariable String cardId,
            @RequestBody CardRequest request
    ) {
        cardService.updateCard(cardId, request.getTitle(), request.getDescription(), request.getSection());
    }

    @DeleteMapping("/{cardId}")
    public void deleteCard(@PathVariable String cardId) {
        cardService.deleteCard(cardId);
    }

    private CardResponse convertToCardResponse(Card card) {
        if (card == null) {
            return null;
        }
        CardResponse cardResponse = new CardResponse();
        cardResponse.setId(card.getId());
        cardResponse.setTitle(card.getTitle());
        cardResponse.setDescription(card.getDescription());
        cardResponse.setSection(card.getSection());
        return cardResponse;
    }
}

