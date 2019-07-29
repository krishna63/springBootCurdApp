package com.learning.market.web;

import com.learning.market.domain.Products;
import com.learning.market.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/productsBoard")
@CrossOrigin
public class ProductsController {

    @Autowired
    private ProductService productService;

    @PostMapping("")
    public ResponseEntity<?> addProductToBoard(@RequestBody Products product, BindingResult result) {

        if(result.hasErrors()) {
            Map<String, String> errorMap = new HashMap<>();

            for(FieldError error: result.getFieldErrors()){
                errorMap.put(error.getField(), error.getDefaultMessage());
            }

            return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
        }

        Products newPrdt = productService.saveOrUpdate(product);
        return new ResponseEntity<Products>(newPrdt, HttpStatus.CREATED);
    }

    @GetMapping("/allProducts")
    public Iterable<Products> getAllProducts(){
        return productService.getAllProducts();
    }

   @GetMapping("/{prdtID}")
    public ResponseEntity<Products> getProductById(@PathVariable Long prdtID) {
        Products foundPrdt = productService.findById(prdtID);
        return new ResponseEntity<Products>(foundPrdt, HttpStatus.OK);
    }

    @DeleteMapping("/{delete_prdtId}")
    public ResponseEntity<?> deleteProductById(@PathVariable Long delete_prdtId) {
        productService.deleteProductsById(delete_prdtId);
        return  new ResponseEntity<String>("Product is deleted", HttpStatus.OK);
    }
}
