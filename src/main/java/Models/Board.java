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

     public Board(String id, String title, List<Card> cards) {
          this.id = id;
          this.title = title;
          this.cards = cards;
     }

}