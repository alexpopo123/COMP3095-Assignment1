package gbc.ca.comp3095assignment1.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ExternalService {
    private final RestTemplate restTemplate;
    private final String externalAppBaseUrl;

    public ExternalService(RestTemplate restTemplate, @Value("${external.app.base.url}") String externalAppBaseUrl) {
        this.restTemplate = restTemplate;
        this.externalAppBaseUrl = externalAppBaseUrl;
    }

    public String getPostsFromExternalApp() {
        String endpoint = "/api/posts"; // actual endpoint
        return restTemplate.getForObject(externalAppBaseUrl + endpoint, String.class);
    }
}
