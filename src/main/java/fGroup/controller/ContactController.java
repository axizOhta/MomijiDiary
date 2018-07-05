package fGroup.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fGroup.dto.Contact;
import fGroup.form.ContactForm;
import fGroup.service.ContactService;

@Controller
public class ContactController {

	@Autowired
	private ContactService contactService;

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

	@RequestMapping(value = "/30contactBack")
	public String contactback(@Validated @ModelAttribute("form") ContactForm form, BindingResult bindingResult, Model model,HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		Contact contact = (Contact)session.getAttribute("contact");

		form.setEmail_address(contact.getEmail_address());
		form.setContact_title(contact.getContact_title());
		form.setContact_message(contact.getContact_message());

		return "30 contact";
	}

	@RequestMapping(value = "/54contactUnloginBack")
	public String contactunloginback(@Validated @ModelAttribute("form") ContactForm form, BindingResult bindingResult, Model model,HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		Contact contact = (Contact)session.getAttribute("contact");

		form.setEmail_address(contact.getEmail_address());
		form.setContact_title(contact.getContact_title());
		form.setContact_message(contact.getContact_message());

		return "54 contactUnlogin";
	}

	@RequestMapping(value = "/32contactResult")
	public String contactresult(@Validated @ModelAttribute("form") ContactForm form, BindingResult bindingResult,HttpServletRequest request, HttpServletResponse response,
			Model model) {

		HttpSession session = request.getSession();
		Contact contact = (Contact)session.getAttribute("contact");

		int id= contactService.coninsert(contact);

		form.setContact_id(id);

		session.removeAttribute("contact");
		model.addAttribute("contactId",id);

		return "32 contactResult";
	}

	@RequestMapping(value = "/56contactResultUnlogin")
	public String contactresultunlogin(@Validated @ModelAttribute("form") ContactForm form, BindingResult bindingResult,HttpServletRequest request, HttpServletResponse response,
			Model model) {

		HttpSession session = request.getSession();
		Contact contact = (Contact)session.getAttribute("contact");

		int id= contactService.coninsert(contact);

		form.setContact_id(id);

		session.removeAttribute("contact");
		model.addAttribute("contactId",id);

		return "56 contactResultUnlogin";
	}

	@RequestMapping("/34contactsuper")
	public String contactsuper(@ModelAttribute("form") ContactForm form, Model model,HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		Contact contact = new Contact();

		List<Contact> contactList = contactService.contactall(contact);

		model.addAttribute("contactlist",contactList);

		return "34 contactsuper";
	}

}
