package Controller;

import Models.Board;
import Models.Card;
import Response.CardResponse;
import Service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/boards")
public class BoardController {
    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @PostMapping
    public Board createBoard(@RequestBody String title) {
        return boardService.createBoard(title);
    }

    @GetMapping
    public List<Board> getBoards() {
        return boardService.getBoards();
    }

    @GetMapping("/{id}")
    public Board getBoard(@PathVariable String id) {
        return boardService.getBoard(id);
    }

    @DeleteMapping("/{id}")
    public void deleteBoard(@PathVariable String id) {
        boardService.deleteBoard(id);

    }

        @GetMapping("/{boardId}/cards")
        public CardResponse.CardsResponse getCards(@PathVariable String boardId) {
            List<Card> cards = cardService.getCards(boardId);
            List<CardResponse> cardResponses = cards.stream()
                    .map(this::convertToCardResponse)
                    .collect(Collectors.toList());
            return new CardResponse.CardsResponse(cardResponses);
        }

        private CardResponse convertToCardResponse(Card card) {
            CardResponse cardResponse = new CardResponse();
            cardResponse.setId(card.getId());
            cardResponse.setTitle(card.getTitle());
            cardResponse.setDescription(card.getDescription());
            cardResponse.setSection(card.getSection());
            return cardResponse;
        }
    }

