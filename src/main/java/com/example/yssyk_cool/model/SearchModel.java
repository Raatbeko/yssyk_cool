package com.example.yssyk_cool.model;

import com.example.yssyk_cool.enums.SearchType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SearchModel {

    String title;

    SearchType searchType;
}
