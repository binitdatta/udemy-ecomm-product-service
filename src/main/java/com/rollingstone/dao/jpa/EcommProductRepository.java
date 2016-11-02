package com.rollingstone.dao.jpa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.rollingstone.domain.Product;




public interface EcommProductRepository extends PagingAndSortingRepository<Product, Long> {
	Product findUserByProductType(String productType);
    Page findAll(Pageable pageable);
}
