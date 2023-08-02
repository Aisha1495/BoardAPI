package Controller;

import Models.Board;
import Service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}