package com.ny.api.internal;

import com.ny.api.external.Item;
import com.ny.services.RandomClothingService;
import com.ny.types.Sex;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class RandomClothingController {

    private final RandomClothingService randomClothingService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/random/{sex}")
    @ResponseBody
    @CrossOrigin(origins = "http://localhost:3000")
    public List<Item> getRandomClothingForSexAndLanguage(@PathVariable String sex) {
        return randomClothingService.getRandomOutfitBySex(Sex.valueOf(sex));
    }
}
