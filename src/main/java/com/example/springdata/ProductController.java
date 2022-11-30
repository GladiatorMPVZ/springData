package com.example.springdata;

import com.example.springdata.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id) {
        return productRepository.getReferenceById(id);
    }

    @GetMapping
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @EventListener(ApplicationReadyEvent.class)
    public void create() {
        productRepository.save(createNewProduct("Meat"));
        productRepository.save(createNewProduct("Butter"));
        productRepository.save(createNewProduct("Orange"));
    }

//    @PostMapping("/{title}")
//    public Product create(@PathVariable String title) {
//        Product product = new Product();
//        product.setTitle(title);
//        return productRepository.saveAndFlush(product);
//    }

    @GetMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        productRepository.deleteById(id);
    }

    private Product createNewProduct(String title) {
        Product product = new Product();
        product.setTitle(title);
        return product;
    }
}
