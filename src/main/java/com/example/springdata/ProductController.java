package com.example.springdata;

import com.example.springdata.repository.ProductRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/products")
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @EventListener(ApplicationReadyEvent.class)
    public void create() {
        productRepository.save(createNewProduct("chocolate"));
        productRepository.save(createNewProduct("chop"));
        productRepository.save(createNewProduct("veal"));
        productRepository.save(createNewProduct("whisky"));
        productRepository.save(createNewProduct("yoghurt"));
        productRepository.save(createNewProduct("chili"));
        productRepository.save(createNewProduct("orange"));
        productRepository.save(createNewProduct("apricot"));
        productRepository.save(createNewProduct("apricot"));
        productRepository.save(createNewProduct("bread"));
        productRepository.save(createNewProduct("butter"));
        productRepository.save(createNewProduct("condiment"));
        productRepository.save(createNewProduct("currant"));
        productRepository.save(createNewProduct("eel"));
        productRepository.save(createNewProduct("croissant"));
        productRepository.save(createNewProduct("garlic"));
    }

    @GetMapping("/products/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        productRepository.deleteById(id);
    }

    private Product createNewProduct(String title) {
        Product product = new Product();
        product.setTitle(title);
        return product;
    }
}
