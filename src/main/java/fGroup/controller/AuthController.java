package fGroup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthController {



	@RequestMapping("/47Top")
	public String Top(Model model) {
		return "47Top";
	}

}
