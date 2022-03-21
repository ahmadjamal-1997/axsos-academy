package com.axsos.ProductsCategories.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.axsos.ProductsCategories.Service.productCategoryService;
import com.axsos.ProductsCategories.models.Category;
import com.axsos.ProductsCategories.models.Product;

@Controller
public class productCategoryController {
	private final productCategoryService ProductCategoryService;

	public productCategoryController(productCategoryService productCategoryService) {
		ProductCategoryService = productCategoryService;
	}
	
	@RequestMapping("/products/new")
	public String newProduct(@ModelAttribute("product") Product product) {
		return "newProduct.jsp";
	}
	@PostMapping("/products/new")
	public String createProduct(@Valid@ModelAttribute("product") Product product,BindingResult result) {
		if (result.hasErrors()) {
			return "redirect:/products/new";
		}
		else {
		ProductCategoryService.createProduct(product);
		return "redirect:/products/new";
		}
	}
	@RequestMapping("/categories/new")
	public String newCategory(@ModelAttribute("category") Category category) {
		return "newCategory.jsp";
	}
	@PostMapping("/categories/new")
	public String createCategory(@Valid@ModelAttribute("category") Category category,BindingResult result) {
		if (result.hasErrors()) {
			return "redirect:/products/new";
		}
		else {
		ProductCategoryService.createCategory(category);
		return "redirect:/categories/new";
		}
	}
	@RequestMapping("/products/{id}")
	public String showProduct(@PathVariable("id") Long id,Model model) {
		Product product = ProductCategoryService.findProduct(id);
		List<Category> categories= ProductCategoryService.getCategoriesExcept(id);
		model.addAttribute("product", product);
		model.addAttribute("categories",categories );
		return "showProduct.jsp";
	}
	@RequestMapping(value="/addcategories/{id}",method= RequestMethod.POST)
	public String addCategory(@Valid@RequestParam("categoryid") Long id,@PathVariable("id") Long productId) {
		Category ThisCategory = ProductCategoryService.findCategory(id);
		Product ThisProduct = ProductCategoryService.findProduct(productId);
		ThisProduct.getCategories().add(ThisCategory);
		ProductCategoryService.createProduct(ThisProduct);
		return "redirect:/products/{id}";
			
	}
	@RequestMapping("/categories/{id}")
	public String showCategory(@PathVariable("id") Long id,Model model) {
		Category category = ProductCategoryService.findCategory(id);
		List<Product> products= ProductCategoryService.getProductsExcept(id);
		model.addAttribute("category", category);
		model.addAttribute("products",products );
		return "showCategory.jsp";
	}
	@RequestMapping(value="/addproducts/{id}",method= RequestMethod.POST)
	public String addProduct(@Valid@RequestParam("productid") Long id,@PathVariable("id") Long categoryId) {
		Category ThisCategory = ProductCategoryService.findCategory(categoryId);
		Product ThisProduct = ProductCategoryService.findProduct(id);
		ThisCategory.getProducts().add(ThisProduct);
		ProductCategoryService.createCategory(ThisCategory);
		return "redirect:/categories/{id}";
			
	}
}
