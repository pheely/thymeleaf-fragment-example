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
public class ContainerController {

	@Resource(name="sample")
	Sample sessionAttr;
	
	@ModelAttribute("templateOptions")
	public List<String> getTemplates() {
    	List<String> templateOptions = new ArrayList<>();
    	templateOptions.add("template1");
    	templateOptions.add("template2");
    	templateOptions.add("template3");
    	
    	return templateOptions;
	}

    @GetMapping("/container")
    public String greeting(Model model) {
    	System.out.println("session: " + sessionAttr.getOption());
    	
    	if (sessionAttr.getOption()==null) {
    		sessionAttr.setOption("template1");
    	}
        model.addAttribute("sample", sessionAttr);
        return "container";
    }

    @PostMapping("/container")
    public String refresh(@ModelAttribute("sample") Sample sample, Model model) {
    	System.out.println("model: " + sample.getOption());
    	System.out.println("session: " + sessionAttr.getOption());
    	sessionAttr.setOption(sample.getOption());
        model.addAttribute("sample", sessionAttr);
        return "redirect:container";
    }
}