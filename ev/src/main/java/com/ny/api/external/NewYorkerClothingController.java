package com.ny.api.external;

import com.ny.types.WebCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Controller
public class NewYorkerClothingController {

    @Autowired
    private RestTemplate restTemplate;

    public Item getClothingForWebCategory(WebCategory webCategory) {
        NewYorkerResponse response = restTemplate.getForObject("https://api.newyorker.de/csp/products/public/query?" +
                        "filters[country]=DE"  +
                        "&" +
                        "filters[gender]="+webCategory.sex+"" +
                        "&" +
                        "filters[web_category]="+webCategory.query+"",
                NewYorkerResponse.class);
        Collections.shuffle(response.items());
        return response.items().get(0);
    }
}
