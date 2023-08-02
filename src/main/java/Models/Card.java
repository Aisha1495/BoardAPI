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


}
