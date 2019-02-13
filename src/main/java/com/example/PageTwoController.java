package com.example;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PageTwoController {

	@Resource(name="sessionAttr")
	UserInput sessionAttr;
	
    @GetMapping("/page2")
    public String pageTwo(Model model) {   	
        model.addAttribute("userInput", sessionAttr);
        return "page2";
    }

    @PostMapping(value="/page2", params="btn-submit=Submit")
    public String refresh(@ModelAttribute("userInput") UserInput userPref, Model model) {
    	sessionAttr.setUserId(userPref.getUserId());
    	sessionAttr.setPassword(userPref.getPassword());
    	System.out.println(sessionAttr.getSelection());
        model.addAttribute("userInput", sessionAttr);
        return "redirect:page2";
    }
    @PostMapping(value="/page2", params="btn-clear=Clear")
    public String clear(Model model) {
    	sessionAttr.setCategory("");
    	sessionAttr.setSubCategory("");
    	sessionAttr.setUserId("");
    	sessionAttr.setPassword("");
    	System.out.println(sessionAttr.getSelection());
        model.addAttribute("userInput", sessionAttr);
        return "redirect:page2";
    }
}