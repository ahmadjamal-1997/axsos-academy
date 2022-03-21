package com.axsos.ProductsCategories.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.axsos.ProductsCategories.Repositores.CategoryRepository;
import com.axsos.ProductsCategories.Repositores.ProductRepository;
import com.axsos.ProductsCategories.models.Category;
import com.axsos.ProductsCategories.models.Product;

@Service
public class productCategoryService {
	private final ProductRepository productRepository;
	private final CategoryRepository categoryRepository;
	public productCategoryService(ProductRepository productRepository, CategoryRepository categoryRepository) {
		this.productRepository = productRepository;
		this.categoryRepository = categoryRepository;
	}
	public Product createProduct(Product b) {
		return productRepository.save(b);
	}
	public Category createCategory(Category c) {
		return categoryRepository.save(c);
	}
	public Product findProduct(Long id) {
		return productRepository.findById(id).orElse(null);
	}
	public Category findCategory(Long id) {
		return categoryRepository.findById(id).orElse(null);
	}
	public List<Product> getAllProducts(){
		return productRepository.findAll();
	}
	public List<Category> getAllCategories(){
		return categoryRepository.findAll();
	}
	public List<Category> getCategoriesExcept(Long id){
		return categoryRepository.findCategoriesExceptThisProductCategories(id);
	}
	public List<Product> getProductsExcept(Long id){
		return productRepository.findProductsExceptThisCategoryProducts(id);
	}
}

