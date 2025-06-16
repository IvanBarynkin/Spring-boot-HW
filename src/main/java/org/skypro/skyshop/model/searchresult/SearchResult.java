package org.skypro.skyshop.model.searchresult;

import org.skypro.skyshop.model.search.Searchable;

public record SearchResult(String id, String name, String contentType) {

    public static SearchResult fromSearchable(Searchable searchObject) {
        return new SearchResult(searchObject.getId().toString(),
                searchObject.searchName(),
                searchObject.getSearchContentType());
    }

}
