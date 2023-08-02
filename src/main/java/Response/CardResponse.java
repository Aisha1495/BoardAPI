package Response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CardResponse {

    private String id;
    private String title;
    private String description;
    private String section;

    public CardResponse() {
        // Default constructor for serialization/deserialization.
    }

    public CardResponse(String id, String title, String description, String section) {
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

    public static class CardsResponse {
        private List<CardResponse> cards;

        public CardsResponse() {
            // Default constructor for serialization/deserialization.
        }

        public CardsResponse(List<CardResponse> cards) {
            this.cards = cards;
        }

        // Getters and setters
        public List<CardResponse> getCards() {
            return cards;
        }

        public void setCards(List<CardResponse> cards) {
            this.cards = cards;
        }
    }
}
