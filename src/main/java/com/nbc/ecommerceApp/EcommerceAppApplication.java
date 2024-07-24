package com.nbc.ecommerceApp;

import com.nbc.ecommerceApp.model.Authority;
import com.nbc.ecommerceApp.model.Product;
import com.nbc.ecommerceApp.model.User;
import com.nbc.ecommerceApp.repository.AuthorityRepo;
import com.nbc.ecommerceApp.repository.UserRepo;
import com.nbc.ecommerceApp.service.ProductService;
import lombok.With;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.math.BigDecimal;
import java.util.Arrays;

@SpringBootApplication
public class EcommerceAppApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(EcommerceAppApplication.class, args);

		ProductService productService = context.getBean(ProductService.class);

		productService.addProduct(Product.builder().name("Sony Xperia 1 II").price(BigDecimal.valueOf(29990.0)).build());
		productService.addProduct(Product.builder().name("Sony Bravia").price(BigDecimal.valueOf(28000.0)).build());
		productService.addProduct(Product.builder().name("Sony Alpha 800D").price(BigDecimal.valueOf(56900.0)).build());
		productService.addProduct(Product.builder().name("Sony Buds Pro 2").price(BigDecimal.valueOf(33499.0)).build());
		productService.addProduct(Product.builder().name("Sony Headset Z").price(BigDecimal.valueOf(3200.00)).build());

		AuthorityRepo authorityRepo = context.getBean(AuthorityRepo.class);
		PasswordEncoder encoder = context.getBean(PasswordEncoder.class);
		authorityRepo.save(Authority.builder().authority("USER").active(true)
				.user(User.builder().username("user").password(encoder.encode("userpass")).build()).build());

	}

}
