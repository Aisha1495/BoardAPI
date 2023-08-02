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


    public static class CardsResponse {
        private List<CardResponse> cards;
    }
}