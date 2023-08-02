package Controller;

import Models.Card;
import Request.CardRequest;
import Service.CardService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/boards/{boardId}/cards")
public class CardController {
    private final CardService cardService;

    @Autowired
    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @PostMapping
    public Card createCard(@PathVariable String boardId, @RequestBody CardRequest request) {
        return cardService.createCard(boardId, request.getTitle(), request.getDescription(), request.getSection());
    }

    @GetMapping
    public List<Card> getCards(@PathVariable String boardId) {
        return cardService.getCards(boardId);
    }

    @GetMapping("/{cardId}")
    public Card getCard(@PathVariable String boardId, @PathVariable String cardId) {
        return cardService.getCard(boardId, cardId);
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
}




