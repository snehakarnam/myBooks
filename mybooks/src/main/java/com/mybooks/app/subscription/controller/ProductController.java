package com.mybooks.app.subscription.controller;




import com.mybooks.app.subscription.dto.ProductDto;
import com.mybooks.app.subscription.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/products")
@Validated
public class ProductController {


    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @Operation(
            summary = "Create a new product",
            description = "Creates a new product under a specific vendor",
            tags = {"Product"}
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Product created successfully",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ProductDto.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid input data", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    @PostMapping
    public ResponseEntity<List<ProductDto>> createProduct(@Valid @RequestBody List<ProductDto> productDTO) {
        List<ProductDto> createdProduct = productService.createProduct(productDTO);
        return ResponseEntity.status(201).body(createdProduct);
    }

    @Operation(
            summary = "Get a product by ID",
            description = "Fetches a product using its unique identifier",
            tags = {"Product"}
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product found",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ProductDto.class))}),
            @ApiResponse(responseCode = "404", description = "Product not found", content = @Content)
    })
    @GetMapping("/{productId}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable String productId) {
        ProductDto product = productService.getProductById(productId);
        return ResponseEntity.ok(product);
    }

    @Operation(
            summary = "Get all products",
            description = "Retrieves a list of all products",
            tags = {"Product"}
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Products retrieved successfully",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ProductDto.class))}),
            @ApiResponse(responseCode = "204", description = "No products found", content = @Content)
    })
    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        List<ProductDto> products = productService.getAllProducts();
        if (products.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(products);
    }

    @Operation(
            summary = "Update a product",
            description = "Updates the details of an existing product",
            tags = {"Product"}
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product updated successfully",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ProductDto.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid input data", content = @Content),
            @ApiResponse(responseCode = "404", description = "Product not found", content = @Content)
    })
    @PutMapping("/{productId}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable String productId, @Valid @RequestBody ProductDto productDTO) {
        ProductDto updatedProduct = productService.updateProduct(productId, productDTO);
        return ResponseEntity.ok(updatedProduct);
    }

    @Operation(
            summary = "Delete a product",
            description = "Deletes a product by its unique identifier",
            tags = {"Product"}
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Product deleted successfully", content = @Content),
            @ApiResponse(responseCode = "404", description = "Product not found", content = @Content)
    })
    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable String productId) {
        productService.deleteProduct(productId);
        return ResponseEntity.noContent().build();
    }
}
