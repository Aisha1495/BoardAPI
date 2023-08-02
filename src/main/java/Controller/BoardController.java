package Controller;

import Models.Board;
import Models.Card;
import Response.CardResponse;
import Service.BoardService;
import Service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/boards")
public class BoardController {
    private final BoardService boardService;
    private final CardService cardService; // Add CardService here

    @Autowired
    public BoardController(BoardService boardService, CardService cardService) {
        this.boardService = boardService;
        this.cardService = cardService;
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

    // Other methods for BoardController

    @GetMapping("/{boardId}/cards")
    public List<Card> getCards(@PathVariable String boardId) {
        return cardService.getCards(boardId);
    }
}