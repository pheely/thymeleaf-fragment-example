package com.example;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HeaderController {

	@Resource(name="sessionAttr")
	UserInput sessionAttr;
	
    @GetMapping("/page")
    public String greeting(@RequestParam(name="reset", required=false, defaultValue="false") boolean reset,  
    		Model model) {
    	
    	if (reset) {
    		sessionAttr.setPage("page1");
    		sessionAttr.setCategory(null);
    		sessionAttr.setSubCategory(null);
    		sessionAttr.setUserId(null);
    		sessionAttr.setPassword(null);
    	}
        model.addAttribute("userInput", sessionAttr);
        return sessionAttr.getPage();
    }

    @PostMapping("/page")
    public String refresh(@ModelAttribute("userInput") UserInput userPref, Model model) {
    	sessionAttr.setPage(userPref.getPage());
    	System.out.println("userPref: " + userPref.getPage());
        model.addAttribute("userInput", sessionAttr);
        return "redirect:page";
    }
}