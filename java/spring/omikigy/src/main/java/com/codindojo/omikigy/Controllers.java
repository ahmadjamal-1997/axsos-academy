package com.codindojo.omikigy;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Controllers {

	@RequestMapping(value="/",method=RequestMethod.POST)
	public String form(HttpSession session,@RequestParam(value="quantity") Integer quantity,
	@RequestParam(value="city") String city,@RequestParam(value="name") String name,
	@RequestParam(value="hope") String hope,@RequestParam(value="type") String type,@RequestParam(value="message") String message) {
		session.setAttribute("quantity", quantity);
		session.setAttribute("city", city);
		session.setAttribute("hope", hope);
		session.setAttribute("name", name);
		session.setAttribute("type", type);
		session.setAttribute("message", message);
		
	return "redirect:/show";
	}
	@RequestMapping("/show")
	public String show(Model model,HttpSession session) {
		model.addAttribute("quantity", session.getAttribute("quantity"));
		model.addAttribute("city", session.getAttribute("city"));
		model.addAttribute("hope", session.getAttribute("hope"));
		model.addAttribute("name", session.getAttribute("name"));
		model.addAttribute("type", session.getAttribute("type"));
		model.addAttribute("message", session.getAttribute("message"));
		return "show.jsp";
	}
	@RequestMapping("/index")
	public String index() {
		return "form.jsp";
	}
}
