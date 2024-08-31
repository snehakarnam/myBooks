package com.mybooks.app.subscription.config;


import com.mybooks.app.subscription.service.DBGateway.ProductDBGateway;
import com.mybooks.app.subscription.service.Impl.ProductServiceImpl;
import com.mybooks.app.subscription.service.ProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {


    @Bean
    public ProductService productService(final ProductDBGateway productDBGateway) {
        return new ProductServiceImpl(productDBGateway);
    }
}
