package com.project.ecommerce;

import com.project.ecommerce.models.Category;
import com.project.ecommerce.models.Comments;
import com.project.ecommerce.models.Product;
import com.project.ecommerce.models.User;
import com.project.ecommerce.models.enums.Color;
import com.project.ecommerce.models.enums.StatusProduct;
import com.project.ecommerce.repositories.CategoryRepository;
import com.project.ecommerce.repositories.CommentsRepository;
import com.project.ecommerce.repositories.ProductRepository;
import com.project.ecommerce.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.LocalDateTime;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    public ProductRepository productRepository;

    @Autowired
    public UserRepository userRepository;

    @Autowired
    public CategoryRepository categoryRepository;

    @Autowired
    public CommentsRepository commentsRepositories;

    @Override
    public void run(String... args) throws Exception {

        Category c1 = new Category(null, "Eletronics");
        Category c2 = new Category(null, "FootWear");
        Category c3 = new Category(null, "Books");

        User u1 = new User(null, "Thales Garcia","thalesgsoares@example.com","1234");
        User u2 = new User(null, "Bruno Garcia","brunograna@example.com","5678");

        Product p1 = new Product(null, "Iphone 7 Plus", 2500.0, LocalDateTime.now(), 1, 2500d, 4.5, Color.WHITE, StatusProduct.AVAILABLE,c1,u1);
        Product p2 = new Product(null, "Adidas NMD", 650d, LocalDateTime.now(), 1, 650d, 4.2, Color.BLACK, StatusProduct.ON_ROUTE,c2,u2);
        Product p3 = new Product(null, "Harry Potter and the Sorcerer's Stone ", 30.0, LocalDateTime.now(), 3, 90d, 5d, Color.RED, StatusProduct.SALE_OFF,c3,u1);
        Product p4 = new Product(null, "Samsung Galaxy S10", 1500d, LocalDateTime.now(), 2, 3000d, 3.8d, Color.BLUE, StatusProduct.CANCELED,c1,u2);

        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4));
        userRepository.saveAll(Arrays.asList(u1,u2));
        categoryRepository.saveAll(Arrays.asList(c1,c2,c3));

        Comments com1 = new Comments(null, "Angry", "That's too expensive", 1.5,p1);
        Comments com2 = new Comments(null, "Happy", "That's great", 4.5,p2);
        Comments com3 = new Comments(null, "Confuse", "That's too confused", 3d,p3);
        Comments com4 = new Comments(null, "Boring", "This is very boring", 1d,p1);
        Comments com5 = new Comments(null, "Awesome", "That's unbelievable", 5d,p4);

        commentsRepositories.saveAll(Arrays.asList(com1, com2, com3, com4, com5));




    }
}
