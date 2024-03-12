package pl.edu.agh.restapi.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import pl.edu.agh.restapi.DAO.ActivityDAO;
import pl.edu.agh.restapi.DAO.BreweryDAO;
import pl.edu.agh.restapi.DTO.StatsDTO;

import java.util.Arrays;


@Controller
@RequestMapping("/api/v1")
public class WebController {


    @RequestMapping(value = "/")
    public String defaultPage() {
        return "index";
    }


    @RequestMapping(value = "/index")
    public String homePage() {
        return "index";
    }

    /**
     * Handles the request.
     *
     * @param city  the city
     * @param type  the type
     * @param state  the state
     * @param name  the name
     * @param activityType  the activity type
     * @param model  the model
     * @return the template of the request result page
     */
    @RequestMapping(value = "/request", method = RequestMethod.POST)
    public String resultPage(@RequestParam(value = "city") String city,
                             @RequestParam(value = "type") String type,
                             @RequestParam(value = "state") String state,
                             @RequestParam(value = "name") String name,
                             @RequestParam(value = "activity") String activityType,
                             Model model) {

        BreweryDAO[] breweries = requestBreweries(city, type, state, name);
        System.out.println("==========================================");
        System.out.println(Arrays.toString(breweries));
        System.out.println("==========================================");
        ActivityDAO activity = requestActivity(activityType);

        System.out.println("==========================================");
        System.out.println(activity);
        System.out.println("==========================================");

        model.addAttribute("breweries", breweries);
        model.addAttribute("activity", activity);
        model.addAttribute("words", new StatsDTO().findTop3Words(breweries));

        return "result";
    }

    /**
     * Creates the request URI for the brewery request.
     *
     * @param city  the city
     * @param type  the type
     * @param state  the state
     * @param name  the name
     * @return the request URI
     */
    private String createRequestUri(String city, String type, String state, String name){
        StringBuilder uriBuilder = new StringBuilder("https://api.openbrewerydb.org/breweries?");

        if (city != null && !city.isEmpty()){
            uriBuilder.append("by_city=");
            uriBuilder.append(city.replace(' ', '_'));
            uriBuilder.append("&");
        }

        if (type != null && !type.isEmpty()){
            uriBuilder.append("by_type=");
            uriBuilder.append(type.replace(' ', '_'));
            uriBuilder.append("&");
        }

        if (state != null && !state.isEmpty()){
            uriBuilder.append("by_state=");
            uriBuilder.append(state.replace(' ', '_'));
            uriBuilder.append("&");
        }


        if (name != null && ! name.isEmpty()){
            uriBuilder.append("by_name=");
            uriBuilder.append(name.replace(' ', '_'));
            uriBuilder.append("&");
        }

        return uriBuilder.toString();
    }

    /**
     * Makes a request to Open Brewery DB (https://www.openbrewerydb.org).
     *
     * @param city  the city
     * @param type  the type
     * @param state  the state
     * @param name  the name
     * @return the array of returned breweries
     */
    private BreweryDAO[] requestBreweries(String city, String type, String state, String name){
        String uri = createRequestUri(city, type, state, name);
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(uri, BreweryDAO[].class);
    }

    /**
     * Makes a request to the Bored API (https://www.boredapi.com).
     *
     * @param activityType  the activity type
     * @return the returned activity
     */
    private ActivityDAO requestActivity(String activityType){
        RestTemplate restTemplate = new RestTemplate();

        String activityUri = String.format("https://www.boredapi.com/api/activity?type=%s", activityType);
        ActivityDAO activity = restTemplate.getForObject(activityUri, ActivityDAO.class);

        assert activity != null;
        if (activity.getLink() == null || activity.getLink().isEmpty()){
            activity.setLink("-");
        }

        return activity;
    }

}

