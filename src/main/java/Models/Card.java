package Models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@Entity
@Data

// Card model
public class Card extends BaseEntity{
     private String id;
     private String title;
     private String description;
     private String section;

     public Card() {
          // Default constructor for serialization/deserialization or JPA.
     }

     public Card(String id, String title, String description, String section) {
          this.id = id;
          this.title = title;
          this.description = description;
          this.section = section;
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

     public String getDescription() {
          return description;
     }

     public void setDescription(String description) {
          this.description = description;
     }

     public String getSection() {
          return section;
     }

     public void setSection(String section) {
          this.section = section;
     }
}
