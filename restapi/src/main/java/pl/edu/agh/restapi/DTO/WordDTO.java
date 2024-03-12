package pl.edu.agh.restapi.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class WordDTO {
    private String word;
    private int frequency;

}
