package pl.edu.agh.restapi.DAO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ActivityDAO {
    private String activity;
    private String type;
    private int participants;
    private double price;
    private String link;
}
