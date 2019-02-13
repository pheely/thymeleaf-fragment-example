package com.example;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice(basePackages= {"com.example"})
public class SharedModelAttributes {
	@ModelAttribute("pages")
	public List<String> getPages() {
    	List<String> pages = new ArrayList<>();
    	pages.add("page1");
    	pages.add("page2");
    	
    	return pages;
	}
	
	@ModelAttribute("categories")
	public List<String> getCategories() {
    	List<String> categories = new ArrayList<>();
    	categories.add("Cat1");
    	categories.add("Cat2");
    	categories.add("Cat3");
    	
    	return categories;
	}

	@ModelAttribute("subCategories")
	public List<String> getSubCategories() {
    	List<String> subcategories = new ArrayList<>();
    	subcategories.add("SubCat1");
    	subcategories.add("SubCat2");
    	subcategories.add("SubCat3");
    	subcategories.add("SubCat4");
    	subcategories.add("SubCat5");
    	
    	return subcategories;
	}
}
