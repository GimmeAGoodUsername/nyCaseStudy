package com.ny.api.external;


import java.util.List;
import java.util.Map;

public record Item(String global_item_id, String id,
                   String country, String maintenance_group,
                   String web_category_id, String web_category,
                   String brand, int sales_unit,
                   String customer_group, List<Variants> variants, List<Description> descriptions) {

}
