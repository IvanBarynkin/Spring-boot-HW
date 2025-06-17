package org.skypro.skyshop.model.service;

import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.DiscountedProduct;
import org.skypro.skyshop.model.product.FixPriceProduct;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.product.SimpleProduct;
import org.skypro.skyshop.model.search.Searchable;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.UUID;
import java.util.stream.Stream;


@Service
public class StorageService {

    private final HashMap<UUID, Product> productStorage;
    private final HashMap<UUID, Article> articleStorage;

    public StorageService() {
        this.productStorage = new HashMap<UUID, Product>();
        this.articleStorage = new HashMap<UUID, Article>();

        fillProductStorage(productStorage);
        fillArticleStorage(articleStorage);

    }

    public Collection<Product> getProducts() {
        return productStorage.values();
    }

    public Collection<Article> getArticles() {
        return articleStorage.values();
    }

    public Collection<Searchable> getAll() {
        return Stream.concat(productStorage.values().stream()
                        .map(o -> (Searchable) o),
                articleStorage.values().stream()
                        .map(o -> (Searchable) o)).toList();
    }

    private void fillProductStorage(HashMap productStorage) {

        Product p1 = new SimpleProduct("1", 100, UUID.randomUUID());
        Product p2 = new DiscountedProduct("2", 500, 50, UUID.randomUUID());
        Product p3 = new FixPriceProduct("3", 500, UUID.randomUUID());

        productStorage.put(p1.getId(), p1);
        productStorage.put(p2.getId(), p2);
        productStorage.put(p3.getId(), p3);


    }

    private void fillArticleStorage(HashMap articleStorage) {

        Article a1 = new Article("1", "111", UUID.randomUUID());
        Article a2 = new Article("2", "222", UUID.randomUUID());
        Article a3 = new Article("3", "333", UUID.randomUUID());

        articleStorage.put(a1.getId(), a1);
        articleStorage.put(a2.getId(), a2);
        articleStorage.put(a3.getId(), a3);

    }

}
