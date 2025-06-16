package org.skypro.skyshop.model.service;

import org.skypro.skyshop.model.searchresult.SearchResult;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class SearchService {
    private static StorageService storageService;

    public SearchService(StorageService storageService) {
        SearchService.storageService = storageService;
    }

    public static Collection<SearchResult> search(String pattern) {
        return storageService.getAll().stream()
                .map(SearchResult::fromSearchable)
                .filter(o -> o.name().contains(pattern) || o.contentType().contains(pattern))
                .toList();
    }


}
