package org.skypro.skyshop.controller;


import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.searchresult.SearchResult;
import org.skypro.skyshop.model.service.BasketService;
import org.skypro.skyshop.model.service.SearchService;
import org.skypro.skyshop.model.service.StorageService;
import org.skypro.skyshop.model.userBasket.UserBasket;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.UUID;

@RestController
public class ShopController {
    private final StorageService storageService;
    private final BasketService basketService;
    private final SearchService searchService;

    public ShopController(StorageService storageService, BasketService basketService,SearchService searchService) {
        this.storageService = storageService;
        this.basketService =  basketService;
        this.searchService =  searchService;

    }

    @GetMapping("/products")
    public Collection<Product> getProducts() {
        return storageService.getProducts();
    }

    @GetMapping("/articles")
    public Collection<Article> getArticles() {
        return storageService.getArticles();
    }

    @GetMapping("/search")
    public Collection<SearchResult> search(@RequestParam("pattern") String pattern) {
        return searchService.search(pattern);
    }

    @GetMapping("/shop/basket/{id}")
    public String addProduct(@PathVariable("id") UUID id){
        return  basketService.addProduct(id);
    }

    @GetMapping("/shop/basket")
    public String getUserBasket(){
        /*Вывод корзины решил реализовать при помощи простого выведения строки.
        Иначе, ловлю исключение Spring'a "HttpMediaTypeNotAcceptableException".
        Видимо автоматическое представление класса в виде JSON не может перевести
        поле ArrayList<BasketItem> userBasket класса Userbasket в приемлемый HTML вид.
         */
        return basketService.getUserBasket().toString();
    }
}
