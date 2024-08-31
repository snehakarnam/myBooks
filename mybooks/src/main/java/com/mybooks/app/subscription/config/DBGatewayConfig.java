package com.mybooks.app.subscription.config;


import com.mybooks.app.subscription.repository.DBGatewayImpl.ProductDBGatewayImpl;
import com.mybooks.app.subscription.repository.ProductRepository;
import com.mybooks.app.subscription.service.DBGateway.ProductDBGateway;
import com.mybooks.app.subscription.service.Impl.ProductServiceImpl;
import com.mybooks.app.subscription.service.ProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DBGatewayConfig {


    @Bean
    public ProductDBGateway productDBGateway(final ProductRepository productRepository) {
        return new ProductDBGatewayImpl(productRepository);
    }
}
