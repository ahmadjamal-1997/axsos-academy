package com.axsos.ProductsCategories.Repositores;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axsos.ProductsCategories.models.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category,Long>{
	List<Category> findAll();
	Optional<Category> findById(Long id);
	@Query(value="SELECT * FROM categories WHERE id Not IN (SELECT category_id FROM categories_products WHERE product_id=?1)",nativeQuery=true)
	List<Category> findCategoriesExceptThisProductCategories(Long id);
	
}

