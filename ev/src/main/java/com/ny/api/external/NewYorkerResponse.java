package com.ny.api.external;

import java.util.List;

public record NewYorkerResponse(int totalCount, List<Item> items) {
}
