package fGroup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import fGroup.form.ContactForm;

@Controller
public class ContactController {

	@RequestMapping("/30contact")
	public String contact(@ModelAttribute("contactForm") ContactForm form, Model model) {
		return "30 contact";
	}


	@RequestMapping("/42faq")
	public String faq(@ModelAttribute("contactForm") ContactForm form, Model model) {
		return "42 faq";
	}

}
