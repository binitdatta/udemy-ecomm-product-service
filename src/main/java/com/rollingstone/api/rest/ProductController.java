package com.rollingstone.api.rest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rollingstone.RestControllerAspect;
import com.rollingstone.domain.Product;
import com.rollingstone.exception.HTTP400Exception;
import com.rollingstone.service.EcommProductService;

/*
 * Demonstrates how to set up RESTful API endpoints using Spring MVC
 */

@RestController
@RequestMapping(value = "/productsservice/v1/products")
public class ProductController extends AbstractRestController {

	private static final Logger log = LoggerFactory.getLogger(ProductController.class);
	 
    @Autowired
    private EcommProductService productService;

    @RequestMapping(value = "",
            method = RequestMethod.POST,
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody Product product,
                                 HttpServletRequest request, HttpServletResponse response) {
        Product createdProduct = this.productService.createProduct(product);
        response.setHeader("Location", request.getRequestURL().append("/").append(createdProduct.getId()).toString());
    }

    @RequestMapping(value = "",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public
    @ResponseBody
    Page<Product> getAllProducts(@RequestParam(value = "page", required = true, defaultValue = DEFAULT_PAGE_NUM) Integer page,
                                      @RequestParam(value = "size", required = true, defaultValue = DEFAULT_PAGE_SIZE) Integer size,
                                      HttpServletRequest request, HttpServletResponse response) {
        return this.productService.getAllProducts(page, size);
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public
    @ResponseBody
    Product getProduct(@PathVariable("id") Long id,
    		HttpServletRequest request, HttpServletResponse response) throws Exception {
        Product product = this.productService.getProduct(id);
        checkResourceFound(product);
        return product;
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.PUT,
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateProduct(@PathVariable("id") Long id, @RequestBody Product product,
                                 HttpServletRequest request, HttpServletResponse response) {
        checkResourceFound(this.productService.getProduct(id));
        log.info("received id :"+id);
        
        if (id != product.getId()) throw new HTTP400Exception("ID doesn't match!");
        this.productService.updateProduct(product);
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.DELETE,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable("id") Long id, HttpServletRequest request,
                                 HttpServletResponse response) {
        checkResourceFound(this.productService.getProduct(id));
        this.productService.deleteProduct(id);
    }
}
