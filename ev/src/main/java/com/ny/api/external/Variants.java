package com.ny.api.external;

import java.util.Date;
import java.util.List;

public record Variants(String id, String product_id,
                       Date publish_date, boolean new_in,
                       boolean coming_soon, boolean sale,
                       boolean highlight, String color_name,
                       String pantone_color,
                       String pantone_color_name, int red,
                       int green, int blue,
                       String color_group,
                       String basic_color, String currency,
                       double original_price,
                       double current_price,
                       boolean red_price_change, List<Size> sizes, List<Image> images) {
}
