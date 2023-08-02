package Service;

import Models.Board;
import Models.Card;
import Repository.BoardRepository;
import Repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {
    private final BoardRepository boardRepository;
    private final CardRepository cardRepository;

    @Autowired
    public CardService(BoardRepository boardRepository, CardRepository cardRepository) {
        this.boardRepository = boardRepository;
        this.cardRepository = cardRepository;
    }

    public Card createCard(String boardId, String title, String description, String section) {
        Board board = boardRepository.findById(boardId).orElse(null);
        if (board == null) {
            return null;
        }

        String cardId = String.valueOf(board.getCards().size() + 1);
        Card card = new Card(cardId, title, description, section);
        board.getCards().add(card);
        boardRepository.save(board);

        return card;
    }

    public List<Card> getCards(String boardId) {
        return cardRepository.findByBoardId(boardId);
    }

    public Card getCard(String boardId, String cardId) {
        return cardRepository.findByIdAndBoardId(cardId, boardId).orElse(null);
    }

    public void updateCard(String cardId, String title, String description, String section) {
        Card card = cardRepository.findById(cardId).orElse(null);
        if (card != null) {
            card.setTitle(title);
            card.setDescription(description);
            card.setSection(section);
            cardRepository.save(card);
        }
    }

    public void deleteCard(String cardId) {
        cardRepository.deleteById(cardId);
    }
}