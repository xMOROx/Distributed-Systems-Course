package pl.edu.agh.restapi.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ClientAuthenticationHelper {
    @Value("${api.key}")
    private String apiKey;

    public boolean validateApiKey(String requestApiKey) {
        return apiKey.equals(requestApiKey);
    }

}