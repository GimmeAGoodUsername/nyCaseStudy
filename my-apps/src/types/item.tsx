
export interface Item {
    global_item_id: string;
    id: string;
    country: string;
    maintenance_group: string;
    web_category_id: string;
    web_category: string;
    brand: string;
    sales_unit: number;
    customer_group: string;
    variants: Variants[];
    descriptions: Description[];
}

export interface Variants {
    id: string;
    product_id: string;
    publish_date: string;
    new_in: boolean;
    coming_soon: boolean;
    sale: boolean;
    highlight: boolean;
    color_name: string;
    pantone_color: string;
    pantone_color_name: string;
    red: number;
    green: number;
    blue: number;
    color_group: string;
    basic_color: string;
    currency: string;
    original_price: number;
    current_price: number;
    red_price_change: boolean;
    sizes: Size[];
    images: Image[];
}
export interface Size {
    size_value: number;
    size_name: string;
    bar_code: string;
}

export interface Image {
    key: string;
}

export interface Description{
    language: string;
    description: string;
}