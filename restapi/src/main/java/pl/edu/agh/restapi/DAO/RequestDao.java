package pl.edu.agh.restapi.DAO;

import lombok.*;

public class RequestDao {
    private String city;
    private String startDate;
    private String endDate;

    public void setCity(String city) {
        this.city = city;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getCity() {
        return city;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }
}
