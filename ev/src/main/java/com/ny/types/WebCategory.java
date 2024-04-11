package com.ny.types;

public enum WebCategory {
    FEMALE_ACCESSOIR(Sex.FEMALE,ClothingType.ACCESSOIRE, "Accessoires,WCA01156,WCA01159,WCA01155,WCA01152,WCA01158,WCA01153,WCA0" +
            "1157,WCA01154"),
    FEMALE_BLUSEN(Sex.FEMALE, ClothingType.TOP,"Blusen,WCA00122,WCA00121"),
    FEMALE_TOPS(Sex.FEMALE, ClothingType.TOP,"tops_t-shirts,WCA00111,WCA00112,WCA00110"),
    FEMALE_SWEATSHIRTS(Sex.FEMALE, ClothingType.TOP,"Sweatshirts,WCA00132,WCA00131"),
    FEMALE_PANTS(Sex.FEMALE, ClothingType.UNDER,"Hosen,WCA00172,WCA00173,WCA00171"),
    FEMALE_SKIRT(Sex.FEMALE,ClothingType.UNDER, "roecke,WCA00161,WCA00162,WCA00163"),
    MALE_ACCESSOIR(Sex.MALE,ClothingType.ACCESSOIRE, "Accessoires,WCA02305,WCA02306,WCA02304,WCA02303,WCA02308,WCA02309,W" +
            "CA02307,WCA02301,WCA02302"),
    MALE_SHIRT(Sex.MALE, ClothingType.TOP,"Hemden,WCA02211"),
    MALE_TSHIRT(Sex.MALE, ClothingType.TOP,"T-Shirts,WCA00221,WCA00223,WCA00222,WCA00220"),
    MALE_SWEATSHIRT(Sex.MALE, ClothingType.TOP,"sweatshirts_pullover,WCA02222,WCA02223,WCA02224,WCA02221"),
    MALE_PANTS(Sex.MALE,ClothingType.UNDER, "Hosen,WCA02252,WCA02251,WCA02253"),
    MALE_DENIM(Sex.MALE,ClothingType.UNDER, "denim,WCA02246,WCA02242,WCA02241,WCA02243,WCA02245,WCA02244");


    public Sex sex;
    public String query = "";
    public ClothingType clothingType;
    private WebCategory(Sex sex, ClothingType clothingType, String query) {
        this.sex = sex;
        this.query = query;
        this.clothingType = clothingType;
    }

}
