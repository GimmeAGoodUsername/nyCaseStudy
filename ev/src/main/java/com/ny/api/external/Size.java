package com.ny.api.external;

/*
    #todo refactor sizes into enum and can barcodes be numerical values or is a leading 0 a thing?
 */
public record Size(int size_value, String size_name, String bar_code) {
}
