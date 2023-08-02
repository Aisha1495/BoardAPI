package Service;

import Models.Board;
import Repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class BoardService {
    private final BoardRepository boardRepository;

    @Autowired
    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public Board createBoard(String title) {
        String id = String.valueOf(boardRepository.count() + 1);
        Board board = new Board(id, title, new ArrayList<>());
        return boardRepository.save(board);
    }

    public List<Board> getBoards() {
        return boardRepository.findAll();
    }

    public Board getBoard(String id) {
        return boardRepository.findById(id).orElse(null);
    }

    public void deleteBoard(String id) {
        boardRepository.deleteById(id);
    }
}