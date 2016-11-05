package com.rollingstone.service;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.boot.actuate.metrics.GaugeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.rollingstone.dao.jpa.EcommProductRepository;
import com.rollingstone.domain.Product;

/*
 * Service class to do CRUD for Product through JPA Repository
 */
@Service
public class EcommProductService {

    private static final Logger log = LoggerFactory.getLogger(EcommProductService.class);

    @Autowired
    private EcommProductRepository productRepository;

    @Autowired
    CounterService counterService;

    @Autowired
    GaugeService gaugeService;

    public EcommProductService() {
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product getProduct(long id) {
        return productRepository.findOne(id);
    }

    public void updateProduct(Product product) {
    	productRepository.save(product);
    }

    public void deleteProduct(Long id) {
    	productRepository.delete(id);
    }

    public Page<Product> getAllProducts(Integer page, Integer size) {
        Page pageOfProducts = productRepository.findAll(new PageRequest(page, size));
        // example of adding to the /metrics
        if (size > 50) {
            counterService.increment("com.rollingstone.getAll.largePayload");
        }
        return pageOfProducts;
    }
}
