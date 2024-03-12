package pl.edu.agh.restapi.DAO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class BreweryDAO {
    private String id;
    private String obdb_id;
    private String name;
    private String brewery_type;
    private String street;
    private String address_2;
    private String address_3;
    private String city;
    private String state;
    private String county_province;
    private String postal_code;
    private String country;
    private double longitude;
    private double latitude;
    private String phone;
    private String website_url;
    private String updated_at;
    private String created_at;
}
