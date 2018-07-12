package fGroup.controller;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fGroup.dto.Users;
import fGroup.form.UserUpForm;
import fGroup.service.UserUpService;

@Controller
public class UserUpController {
	@Autowired
    MessageSource messageSource;

	@Autowired
	private UserUpService userUpService;

	@Autowired
	HttpSession session;


	@RequestMapping(value = "/19userinfoUpdate")
	public String update(@ModelAttribute("form") UserUpForm form, Model model) {
		Users user = (Users)session.getAttribute("user");
		form.setNewName(user.getName());
		form.setNewEmail(user.getEmail_address());
		model.addAttribute("form", form);
		return "19userinfoUpdate";
	}



	@RequestMapping(value = "/20userinfoUpdateConfirm" ,method = RequestMethod.POST)
	public String updateConfirm(@ModelAttribute("form") UserUpForm form,  Model model) {

		//Users beforeUser = (Users) session.getAttribute("user");

		if (form.hasRequiredError()) {//空チェック;
			String errorMsg = messageSource.getMessage("required.error", null, Locale.getDefault());
			model.addAttribute("msg", errorMsg);
			return "19userinfoUpdate";
		}

		Users users = new Users();
		String loginId = users.getLogin_id();

		if (form.getNewName().equals(loginId)) {//ログインIDと名前が同じ場合
			//String errorMsg = messageSource.getMessage("equalsId.error", null, Locale.getDefault());
			model.addAttribute("msg", "名前と同じログインIDは登録できません。別のログインIDを入力してください。");
			return "19userinfoUpdate";
		}

		if (form.getNewName().length() > 20) {//名前の文字数が20字より多いとき
			String errorMsg = messageSource.getMessage("namelong.error", null, Locale.getDefault());
			model.addAttribute("msg", errorMsg);
			return "19userinfoUpdate";
		}

//		if (form.getNewEmail().hasEmailError()) {//Eメール形式じゃないとき
//			String errorMsg = messageSource.getMessage("email.error", null, Locale.getDefault());
//			model.addAttribute("msg", errorMsg);
//			return "19userinfoUpdate";
//		}

		if ((4 > form.getNewPassword().length())||( form.getNewPassword().length() > 10)) {//パスワードの文字数制限
			String errorMsg = messageSource.getMessage("pass.error", null, Locale.getDefault());
			model.addAttribute("msg", errorMsg);
			return "19userinfoUpdate";
		}



//		Users afterUser = new Users();
//		afterUser.setName(form.getNewName());
//		afterUser.setEmail_address(form.getNewEmail());
//		afterUser.setPassword(form.getNewPassword());
//
//		if(afterUser.equals(beforeUser)) {//変更されていないとき
//			String errorMsg = messageSource.getMessage("required.change", null, Locale.getDefault());
//			model.addAttribute("msg", errorMsg);
//			return "19userinfoUpdate";
//		}
//
//
//		form.setPrevName(beforeUser.getName());
//		form.setPrevEmail(beforeUser.getEmail_address());
//		form.setPrevPassword(beforeUser.getPassword());
//
//		if(beforeUser.getPassword().equals(afterUser.getPassword())) {
//			form.setConfirmNewPassword(afterUser.getPassword());
//		}

		return "20userinfoUpdateConfirm";
	}


	@RequestMapping(value = "/updateInputBack")
	public String updateInputBack(@ModelAttribute("form") UserUpForm form, Model model) {

//		Users afterUser = sessionInfo.getAfterUser();
//
//		form.setNewName(afterUser.getName());
//		form.setNewEmail(afterUser.getEmail_address());
//		form.setNewPassword(afterUser.getPassword());

		return "19userinfoUpdate";
	}

	@RequestMapping(value = "/21userinfoUpdateResult" , method = RequestMethod.POST)
	public String list4(Model model, @ModelAttribute("form") UserUpForm form, BindingResult result) {
		Users afterUser = new Users();

		if(!form.getNewPassword().equals(form.getConfirmNewPassword())) {//パス再入力一致しないとき
			String errorMsg = messageSource.getMessage("password.not.match.error", null, Locale.getDefault());
			model.addAttribute("msg", errorMsg);

			form.setConfirmNewPassword("");
			Users beforeUser = new Users();
			form.setPrevName(beforeUser.getName());
			form.setPrevEmail(beforeUser.getEmail_address());
			form.setPrevPassword(beforeUser.getPassword());

			return "20userinfoUpdateConfirm";
		}

		//テスト用
		//Users test = new Users();
		//test.setUser_id(88);
		//session.setAttribute("user", test);
		//

		Users beforeUser = (Users) session.getAttribute("user");
		afterUser.setUser_id(beforeUser.getUser_id());

		afterUser.setName(form.getNewName());
		afterUser.setEmail_address(form.getNewEmail());
		afterUser.setPassword(form.getNewPassword());

		//System.out.println(afterUser.getName());
		userUpService.userUpdate(afterUser);
		userUpService.proUpdate(afterUser);

//		sessionInfo.setAfterUser(null);
//		sessionInfo.setPrevUser(null);

		model.addAttribute("user", session);

		return "21userinfoUpdateResult";
	}
}

