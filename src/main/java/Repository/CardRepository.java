package Repository;

import Models.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CardRepository extends JpaRepository<Card, String> {
    List<Card> findByBoardId(String boardId);
    Optional<Card> findByIdAndBoardId(String cardId, String boardId);
}