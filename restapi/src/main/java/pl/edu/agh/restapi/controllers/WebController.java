package pl.edu.agh.restapi.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import pl.edu.agh.restapi.DAO.ActivityDAO;
import pl.edu.agh.restapi.DAO.BreweryDAO;
import pl.edu.agh.restapi.DTO.StatsDTO;
import pl.edu.agh.restapi.exceptions.ActivityNotProvidedException;
import pl.edu.agh.restapi.exceptions.UnauthorizedException;
import pl.edu.agh.restapi.services.ClientAuthenticationHelper;


@Controller
@RequestMapping("/api/v1")
public class WebController {

    private final ClientAuthenticationHelper clientAuthenticationHelper;

    public WebController(ClientAuthenticationHelper clientAuthenticationHelper) {
        this.clientAuthenticationHelper = clientAuthenticationHelper;
    }

    @GetMapping(value = "")
    public String defaultPage() throws UnauthorizedException {

        return "index";
    }


    @GetMapping(value = "/index")
    public String homePage() throws UnauthorizedException {

        return "index";
    }

    @PostMapping(value = "/request")
    public String resultPage(@RequestParam(value = "city") String city,
                             @RequestParam(value = "type") String type,
                             @RequestParam(value = "state") String state,
                             @RequestParam(value = "name") String name,
                             @RequestParam(value = "activity") String activityType,
                             @RequestParam(value = "api_key") String apiKey,
                             Model model) {

        validateApiKey(apiKey);

        city = city.trim();
        type = type.trim();
        state = state.trim();
        name = name.trim();
        activityType = activityType.trim();

        BreweryDAO[] breweries = requestBreweries(city, type, state, name);
        ActivityDAO activity = requestActivity(activityType);

        model.addAttribute("breweries", breweries);
        model.addAttribute("activity", activity);
        model.addAttribute("words", new StatsDTO().findTopNWords(breweries, 5));

        return "result";
    }

    private String createRequestUri(String city, String type, String state, String name) {
        StringBuilder uriBuilder = new StringBuilder("https://api.openbrewerydb.org/breweries?");

        if (city != null && !city.isEmpty()) {
            uriBuilder.append("by_city=");
            uriBuilder.append(city.replace(' ', '_'));
            uriBuilder.append("&");
        }

        if (type != null && !type.isEmpty()) {
            uriBuilder.append("by_type=");
            uriBuilder.append(type.replace(' ', '_'));
            uriBuilder.append("&");
        }

        if (state != null && !state.isEmpty()) {
            uriBuilder.append("by_state=");
            uriBuilder.append(state.replace(' ', '_'));
            uriBuilder.append("&");
        }

        if (name != null && !name.isEmpty()) {
            uriBuilder.append("by_name=");
            uriBuilder.append(name.replace(' ', '_'));
            uriBuilder.append("&");
        }

        return uriBuilder.toString();
    }

    private BreweryDAO[] requestBreweries(String city, String type, String state, String name) {
        String uri = createRequestUri(city, type, state, name);
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(uri, BreweryDAO[].class);
    }

    private ActivityDAO requestActivity(String activityType) throws ActivityNotProvidedException {
        RestTemplate restTemplate = new RestTemplate();

        String activityUri = String.format("https://www.boredapi.com/api/activity?type=%s", activityType);
        ActivityDAO activity = restTemplate.getForObject(activityUri, ActivityDAO.class);
        assert activity != null;
        if (activity.getActivity() == null) {
            throw new ActivityNotProvidedException("Activity `" + activityType + "` not found");
        }


        if (activity.getLink() == null || activity.getLink().isEmpty()) {
            activity.setLink("-");
        }

        return activity;
    }

    private void validateApiKey(String apiKey) {
        if (!clientAuthenticationHelper.validateApiKey(apiKey)) {
            throw new UnauthorizedException("Invalid API key");
        }
    }
}

