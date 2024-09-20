package marketplace.repository;

import marketplace.model.Product;

import java.util.List;

public interface ProductRepository {
    void addProduct(Product product);
    List<Product> getAllProducts();
    Product getProductById(Long id);
}
