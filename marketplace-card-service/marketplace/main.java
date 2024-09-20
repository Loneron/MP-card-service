package marketplace;

import marketplace.controller.ProductController;
import marketplace.model.Product;
import marketplace.repository.InMemoryProductRepository;
import marketplace.service.ProductService;

public class main {
    public static void main(String[] args)
    {
        InMemoryProductRepository repository = new InMemoryProductRepository();
        ProductService service = new ProductService(repository);
        ProductController controller = new ProductController(service);

        // Добавление продуктов
        controller.addProduct(new Product(
                1L,
                "Core i3-10105F",
                "The Intel Core i3-10105F processor can be used in a variety of builds thanks " +
                        "to the balanced performance provided by the 4-core configuration and 3.7-4.4 GHz operation.",
                5899.0)
        );
        controller.addProduct(new Product(
                2L,
                "Product B",
                "Product description B",
                200.0)
        );
        controller.addProduct(new Product(
                3L,
                "Product C",
                "Product description C",
                150.0)
        );

        // Получение всех продуктов
        System.out.println("All products:");
        controller.getAllProducts().forEach(product -> System.out.println((product.getName() + " " + "Price: " + product.getPrice())));
        controller.getAllProducts().forEach(product -> System.out.println(product.getDescription()));

        // Получение продукта по ID
        Product product = controller.getProductById(1L);
        System.out.println("Received product: " + product.getName());
        System.out.println("Price: " + product.getPrice());
        System.out.println("Product description : " + product.getDescription());
    }
}
