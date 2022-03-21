package com.axsos.ProductsCategories.Repositores;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axsos.ProductsCategories.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product,Long> {
	List<Product> findAll();
	Optional<Product> findById(Long id);
	@Query(value="SELECT * FROM products WHERE id Not IN (SELECT product_id FROM categories_products WHERE category_id=?1)",nativeQuery=true)
	List<Product> findProductsExceptThisCategoryProducts(Long id);
}
