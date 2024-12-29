package crud.crud.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import crud.crud.Entity.Product;
import crud.crud.Entity.Category;
import crud.crud.Repository.ProductRepository;
import crud.crud.Repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProductController {

	 private final ProductRepository pr;
	 private final CategoryRepository cr;
	    public ProductController(ProductRepository pr, CategoryRepository cr) {
		super();
		this.pr = pr;
		this.cr = cr;
	}


		


    @GetMapping("/categories/{categoryId}/products")
    public ResponseEntity<List<Product>> getAllProductsByCategoryId(@PathVariable(value = "categoryId") Long categoryId) {
        if (!cr.existsById(categoryId)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        List<Product> products = pr.findByCategoryId(categoryId);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

 
    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable(value = "id") Long id) {
        Optional<Product> product = pr.findById(id);
        if (product.isPresent()) {
            return new ResponseEntity<>(product.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PostMapping("/categories/{categoryId}/products")
    public ResponseEntity<Product> createProduct(@PathVariable(value = "categoryId") Long categoryId,
                                                 @RequestBody Product productRequest) {
        Optional<Category> category = cr.findById(categoryId);
        if (category.isPresent()) {
            productRequest.setCategory(category.get());
            Product product = pr.save(productRequest);
            return new ResponseEntity<>(product, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

 
    @PutMapping("/products/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable(value = "id") Long id,
                                                 @RequestBody Product productRequest) {
        Optional<Product> productData = pr.findById(id);
        if (productData.isPresent()) {
            Product product = productData.get();
            product.setName(productRequest.getName());
            product.setPrice(productRequest.getPrice());
            product.setCategory(productRequest.getCategory());
            return new ResponseEntity<>(pr.save(product), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @DeleteMapping("/products/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable(value = "id") Long id) {
        if (pr.existsById(id)) {
            pr.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    
    @DeleteMapping("/categories/{categoryId}/products")
    public ResponseEntity<Void> deleteAllProductsByCategoryId(@PathVariable(value = "categoryId") Long categoryId) {
        if (cr.existsById(categoryId)) {
            pr.deleteByCategoryId(categoryId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
