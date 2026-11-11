package org.example.store.repository;

import org.example.store.model.entity.Product;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
    @EntityGraph(attributePaths = "category")
    List<Product> findAllByProductNameContainingIgnoreCase(String productName);

    @EntityGraph(attributePaths = "category")
    List<Product> findAll();

    @EntityGraph(attributePaths = "category")
    Optional<Product> findById(Long id);

    @EntityGraph(attributePaths = "category")
    @Query("SELECT p FROM Product p WHERE p.category.id = :categoryId")
    List<Product> findByCategoryId(Long categoryId);
}
