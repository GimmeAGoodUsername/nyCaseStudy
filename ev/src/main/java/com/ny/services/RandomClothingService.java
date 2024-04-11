package com.ny.services;

import com.ny.api.external.Item;
import com.ny.api.external.NewYorkerClothingController;
import com.ny.types.Sex;
import com.ny.types.WebCategory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
public class RandomClothingService {
    private final NewYorkerClothingController newYorkerClothingController;

    /*
        Returns Random outfit consisting of 3 Parts (Top, Bot, Jewelery) by Sex.
        Randomly shuffled every time
     */
    public  List<Item> getRandomOutfitBySex(Sex sex) {
        List<WebCategory> randomQuery = this.getRandomQuery(sex);
        List<Item> outfit = new ArrayList<>();
        for (WebCategory webCategory : randomQuery) {
            Item clothingForWebCategory = newYorkerClothingController.getClothingForWebCategory(webCategory);
            Collections.shuffle(clothingForWebCategory.variants());
            clothingForWebCategory.variants().subList(1,clothingForWebCategory.variants().size()).clear();
            outfit.add(clothingForWebCategory);
        }

        return outfit;
    }

    /*
        Gets random query from WebCategory Enum which holds all preset queries for each Clothing Part
     */
    private List<WebCategory> getRandomQuery(Sex sex) {
        boolean top = false, bot = false, jewelry = false;
        List<WebCategory> toQuery = new ArrayList<>();
        List<WebCategory> webCategories = Arrays.asList(WebCategory.values());
        Collections.shuffle(webCategories);

        for (WebCategory webCategory : webCategories) {
            if (!sex.equals(webCategory.sex)) {
                continue;
            }
            switch (webCategory.clothingType) {
                case ACCESSOIRE:
                    if (!jewelry) {
                        jewelry = true;
                        toQuery.add(webCategory);
                    }
                    break;
                case TOP:
                    if (!top) {
                        top = true;
                        toQuery.add(webCategory);
                    }
                    break;
                case UNDER:
                    if (!bot) {
                        bot = true;
                        toQuery.add(webCategory);
                    }
                    break;
            }
        }
        return toQuery;
    }
}
