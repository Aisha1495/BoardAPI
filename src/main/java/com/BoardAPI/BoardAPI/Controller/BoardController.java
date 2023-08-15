package com.BoardAPI.BoardAPI.Controller;

import com.BoardAPI.BoardAPI.Models.Board;
import com.BoardAPI.BoardAPI.RequestObject.GetBoardRequestObject;
import com.BoardAPI.BoardAPI.ResponseObject.GetBoardResponseObject;
import com.BoardAPI.BoardAPI.Service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/boards")
@CrossOrigin("*")
public class BoardController {
    @Autowired
    BoardService boardService;

    @PostMapping
    public ResponseEntity<GetBoardResponseObject> createBoard(@RequestBody GetBoardRequestObject request) {

        Board board = new Board();
        board.setName(request.getName());
        Board boardCreate = boardService.createBoard(board);
        GetBoardResponseObject responseObject = new GetBoardResponseObject();
        responseObject.setBoardId(boardCreate.getId()); 
        responseObject.setName(boardCreate.getName());
        responseObject.setColumns(getDefaultColumn());
        return new ResponseEntity<>(responseObject, HttpStatus.OK);

    }

    private Map<Integer, String> getDefaultColumn() {

        Map<Integer, String> columns = new HashMap<>();
        columns.put(1, "To Do");
        columns.put(2, "In Progress");
        columns.put(3, "Done");
        return columns;

    }

    // liat all boards
    @GetMapping
    public List<Board> getAllBoards() {
        return boardService.getAllBoards();

    }

    //get single board by id
    @GetMapping("/{id}")
    public ResponseEntity<GetBoardResponseObject> getBoardById(@PathVariable Long id) {
        
        Board board = boardService.getBoardById(id);
        if (board == null) {
            //  404 error if id not in database
            return ResponseEntity.notFound().build();
        }

        GetBoardResponseObject response = new GetBoardResponseObject(
                board.getId(),
                board.getName(),
                board.getColumns()
        );
        return ResponseEntity.ok(response);

    }

    // Update board by id
    @PutMapping("/{id}")
    public ResponseEntity<GetBoardResponseObject> updateBoard(@PathVariable Long id, @RequestBody GetBoardRequestObject updateBoard) {
       
        GetBoardResponseObject responseObject = boardService.updateBoard(id, updateBoard);
        if (responseObject != null) {
            return ResponseEntity.ok(responseObject);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    //delete board by id
    @DeleteMapping("/{id}")

    public void deleteBoard(@PathVariable Long id) {
        boardService.deleteBoard(id);

    }
}