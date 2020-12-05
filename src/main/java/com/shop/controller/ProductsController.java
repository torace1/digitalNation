package com.shop.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shop.model.database.Product;
import com.shop.model.repository.ProductRepository;

@Controller
@RequestMapping("/products/")
public class ProductsController {
	
	private final ProductRepository productRepository;

	@Autowired
	public ProductsController(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	  @GetMapping("signup")
	    public String showSignUpForm(Product product) {
	        return "add-product";
	    }
	
	 @GetMapping("list")
	    public String showUpdateForm(Model model, String keyword) {
	     
		 if(keyword != null) {
			 model.addAttribute("products",findByKeyword(keyword));
		 }
		 else {
		 model.addAttribute("products", productRepository.findAll());
		 }
	        return "index";
	    }
	 
	 @PostMapping("add")
	    public String addProduct( Product product, BindingResult result, Model model) {
	        if (result.hasErrors()) {
	            return "add-product";
	        }

	        productRepository.save(product);
	        return "redirect:list";
	    }

	    @GetMapping("edit/{id}")
	    public String showUpdateForm(@PathVariable("id") int id, Model model) {
	    	Product produs = new Product();
	    	try {
	    	Optional<Product> product = productRepository.findById(id);
	    	 produs = product.get();
	    	}
	    	catch (Exception e) {
				System.out.print(e.getMessage());
			}
	        model.addAttribute("product", produs);
	        return "update-product";
	    }
	    
	    @PostMapping("update/{id}")
	    public String updateProduct(@PathVariable("id") int id,  Product produs, BindingResult result,
	        Model model) {
	        if (result.hasErrors()) {
	        	produs.setId(id);
	            return "update-product";
	        }

	        productRepository.save(produs);
	        model.addAttribute("products", productRepository.findAll());
	        return "index";
	    }

	    @GetMapping("delete/{id}")
	    public String deleteProduct(@PathVariable("id") int id, Model model) {
	    	
	    	Product produs = new Product();
	    	try {
	    	Optional<Product> product = productRepository.findById(id);
	    	 produs = product.get();
	    	}
	    	catch (Exception e) {
				System.out.print(e.getMessage());
			}

	    	productRepository.delete(produs);
	        model.addAttribute("products", productRepository.findAll());
	        return "index";
	    }
	
	public List<Product> findByKeyword(String keyword){
		return productRepository.findByKeyword(keyword);
	}
}
