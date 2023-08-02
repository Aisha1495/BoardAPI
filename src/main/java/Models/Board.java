package Models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Data

// Board model
public class Board extends BaseEntity {
     private String id;
     private String title;
     private List<Card> cards;


     public Board() {
          // Default constructor for serialization/deserialization or JPA.
     }

     public Board(String id, String title, List<Card> cards) {
          this.id = id;
          this.title = title;
          this.cards = cards;
     }

     // Getters and setters
     public String getId() {
          return id;
     }

     public void setId(String id) {
          this.id = id;
     }

     public String getTitle() {
          return title;
     }

     public void setTitle(String title) {
          this.title = title;
     }

     public List<Card> getCards() {
          return cards;
     }

     public void setCards(List<Card> cards) {
          this.cards = cards;
     }

}