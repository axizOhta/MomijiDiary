package fGroup.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fGroup.dto.Contact;
import fGroup.form.ContactForm;

@Controller
public class ContactController {

	@RequestMapping("/30contact")
	public String contact(@ModelAttribute("form") ContactForm form, Model model) {
		return "30 contact";
	}


	@RequestMapping("/42faq")
	public String faq(@ModelAttribute("form") ContactForm form, Model model) {
		return "42 faq";
	}

	@RequestMapping("/57faqUnlogin")
	public String faqunlogin(@ModelAttribute("form") ContactForm form, Model model) {
		return "57 faqUnlogin";
	}

	@RequestMapping("/54contactUnlogin")
	public String contactunlogin(@ModelAttribute("form") ContactForm form, Model model) {
		return "54 contactUnlogin";
	}

	@RequestMapping(value = "/31contactConfirm", method = RequestMethod.POST)
	public String contactconfirm(@Validated @ModelAttribute("form") ContactForm form, BindingResult bindingResult, Model model,HttpServletRequest request, HttpServletResponse response) {

		if (bindingResult.hasErrors()) {
			model.addAttribute("errmsg","入力されていない項目があります。");
			return "30 contact";
		}
		Contact contact = new Contact();
		contact.setEmail_address(form.getEmail_address());
		contact.setContact_title(form.getContact_title());
		contact.setContact_message(form.getContact_message());

		HttpSession session = request.getSession();
		session.setAttribute("contact", contact);

		return "31 contactConfirm";
	}

	@RequestMapping(value = "/55contactConfirmUnlogin", method = RequestMethod.POST)
	public String contactconfirmUnlogin(@Validated @ModelAttribute("form") ContactForm form, BindingResult bindingResult, Model model,HttpServletRequest request, HttpServletResponse response) {

		if (bindingResult.hasErrors()) {
			model.addAttribute("errmsg","入力されていない項目があります。");
			return "54 contactUnlogin";
		}
		Contact contact = new Contact();
		contact.setEmail_address(form.getEmail_address());
		contact.setContact_title(form.getContact_title());
		contact.setContact_message(form.getContact_message());

		HttpSession session = request.getSession();
		session.setAttribute("contact", contact);

		return "55 contactConfirmUnlogin";
	}

}
