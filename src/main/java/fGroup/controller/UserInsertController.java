package fGroup.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

import fGroup.dto.Users;
import fGroup.form.UserInsertForm;
import fGroup.service.UserInsertService;

@Controller
public class UserInsertController {

	@Autowired
	private UserInsertService userinsertservice;

	@RequestMapping("/25userinsert")
	public String userinsert(@ModelAttribute("form") UserInsertForm form, Model model) {
		return "25 userinsert";
	}

	@RequestMapping(value="/26userinsertConfirm", method = RequestMethod.POST)
	public String userinsertconfirm(@Validated@ModelAttribute("form") UserInsertForm form, Model model,HttpServletRequest request, HttpServletResponse response) {

		String logi = form.getLogin_id();
		String nam = form.getName();

		if(logi.equals(nam)) {
			model.addAttribute("sameerr","名前と同じログインIDは登録できません。別のログインIDを入力してください。");
			return "25 userinsert";
		}

		String pass =form.getPassword();

		Pattern p = Pattern.compile("\\w");

		Matcher m = p.matcher(pass);

		if(!(m.find())) {

			model.addAttribute("nhlferr","パスワードは4文字以上10文字以下の半角英数字で入力してください。");
		}


		Users u = userinsertservice.findLoginId(form.getLogin_id());

		Users users = new Users();
		users.setLogin_id(logi);
		users.setName(nam);
		users.setEmail_address(form.getEmail_address());
		users.setPassword(pass);

		if(users.equals(u)) {

			model.addAttribute("alrderr","そのログインIDは既に登録されています。別のログインIDを入力してください。");
			return "25 userinsert";

		}

		HttpSession session = request.getSession();
		session.setAttribute("userinsert", users);

		return "26 userinsertConfirm";
	}

	@RequestMapping("/27userinsertResult")
	public String userinsertresult(@ModelAttribute("form") UserInsertForm form, BindingResult bindingResult, Model model,HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();

		Users users = (Users) session.getAttribute("userinsert");

		if(users==null) {
			System.out.println("i");
		}

		if(!users.getPassword().equals(form.getRepassword())) {

			model.addAttribute("errmsg", "前画面で入力したパスワードと一致しません。");

			form.setRepassword("");

			return "26 userinsertConfirm";
		}



		int id = userinsertservice.insert(users);

		session.removeAttribute("userinsert");

		form.setUser_id(id);

		return "27 userinsertResult";


	}

}
