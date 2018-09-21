package com.example.demo.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {
	@RequestMapping("/viral")
	public String index() {
		return "viral";
	}
	
//	@RequestMapping("/challenge")
//	public String challenge(@RequestParam(value="name", required=false, defaultValue="kiki")String name, Model model) {
//		model.addAttribute("name", name);
//		return "challenge";
//	}
	
	@RequestMapping(value= {"/challenge", "/challenge/{name}"})
	public String challengePath(@PathVariable Optional<String> name, Model model) {
		if(name.isPresent()) {
			model.addAttribute("name", name.get());
		}else {
			model.addAttribute("name", "KB");
		}
		return "challenge";
	}
	
	@RequestMapping("/generator")
	public String generator(@RequestParam(value="a", required=false) Optional<Integer> a, @RequestParam(value="b", required=false)Optional<Integer> b, Model model){
		String hm = "h";
		String totalhm = "";
		if (! (a.isPresent() & b.isPresent())) {
			model.addAttribute("a", 0);
			model.addAttribute("b", 0);
			model.addAttribute("hm", "hm");
		} else if ((a.get() == 0 | a.get()==1) & (b.get()==0 | b.get()==1)) {
			model.addAttribute("a", a.get());
			model.addAttribute("b", b.get());
			model.addAttribute("hm", "hm");
		} else {
			model.addAttribute("a", a.get());
			model.addAttribute("b", b.get());
			if (a.get() == 0) {
				hm = "hm";
			}
			for(int i = 0; i < a.get();i++) {
				hm += "m";
			}
			for(int j=0; j < b.get(); j++ ) {
				totalhm += hm + " ";
			}
			model.addAttribute("hm", totalhm);
		}
		
		return "generator";
	}
}
