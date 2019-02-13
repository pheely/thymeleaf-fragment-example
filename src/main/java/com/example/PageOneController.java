package com.example;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PageOneController {

	@Resource(name="sessionAttr")
	UserInput sessionAttr;
	
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

    @GetMapping("/page1")
    public String pageOne(Model model) {   	
        model.addAttribute("userInput", sessionAttr);
        return "page1";
    }

    @PostMapping("/page1")
    public String refresh(@ModelAttribute("userInput") UserInput userPref, Model model) {
    	sessionAttr.setCategory(userPref.getCategory());
    	sessionAttr.setSubCategory(userPref.getSubCategory());
    	System.out.println(sessionAttr.getSelection());
        model.addAttribute("userInput", sessionAttr);
        return "redirect:page1";
    }
}