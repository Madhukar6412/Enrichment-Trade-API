package com.myassignment.trade.controller;

import com.myassignment.trade.model.Tradedatafile;
import com.myassignment.trade.model.Tradeproduct;
import com.myassignment.trade.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("***productcontroller")
public class ProductController {

    @Autowired
    private ProductService productService;



   // insert a product into database
    @PostMapping("/product")
    public ResponseEntity<Tradeproduct> saveProduct(@RequestBody Tradeproduct product) {
      Tradeproduct savedProduct = productService.saveProduct(product);
      return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

   //get a single product by its id
    @GetMapping("/product")
    public ResponseEntity<Tradeproduct> getProduct(@RequestParam(name = "productId") long productId) {
        Tradeproduct product = productService.getProduct(productId);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    //get all the products in the table in our database
    @GetMapping("/products")
    public List<Tradeproduct> getProducts() {
        List<Tradeproduct> products = productService.getProducts();
        return products;
    }

    //update an existing product in the database
    @PatchMapping("/product")
    public ResponseEntity<Tradeproduct> updateProduct(@RequestParam(name ="productId") long productId, @RequestBody Tradeproduct product) {
        Tradeproduct updatedProduct = productService.updateProduct(productId, product);
        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }

    // delete an existing product in the database
    @DeleteMapping("/product")
    public ResponseEntity<Tradeproduct> deleteProduct(@RequestParam(name ="productId") long productId) {
        Tradeproduct deletedProduct = productService.deleteproduct(productId);
        return new ResponseEntity<>(deletedProduct, HttpStatus.OK);
    }

    // get product by name using a raw SQL statement
    @GetMapping("/products-by-name")
    public List<Tradeproduct> getProductsByName(@RequestParam(name ="productName") String productName) {
        return productService.getProductsByName(productName);
    }


    //get all the tradedatafile in the table in our database
    @GetMapping("/tradedata")
    public List<Tradedatafile> gealltradeData() {
        List<Tradedatafile> products = productService.getalltradedatafile();
        return products;
    }



}
