package fGroup.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fGroup.dao.UsersDao;
import fGroup.dto.Users;
import fGroup.form.UnsubscribeForm;

@Controller
public class UnsubscribeController {

	@Autowired
	UsersDao usersDao;

	@Autowired
	HttpSession session;

//退会パスワード入力画面:48unsubscribepass
	@RequestMapping("/48unsubscribepass")//GET
	public String unsubpass(@ModelAttribute("form") UnsubscribeForm users, Model model) {
		return "48unsubscribepass";
	}

	@RequestMapping(value = "/unsub", method = RequestMethod.POST)
	public String unsubP(@ModelAttribute("form") UnsubscribeForm users, Model model) {
		String newpassword = users.getNewpassword();
		String repassword = users.getRepassword();

		if(newpassword == null && repassword ==null || newpassword.equals("") && repassword.equals("")) {
			model.addAttribute("errmsg", "パスワードを入力してください。<br><br>パスワードは４文字以上 １０文字以下 の 半角英数字 です。");
			return "48unsubscribepass";
		} else if (newpassword == null || newpassword.equals("")) {
			model.addAttribute("errmsg", "パスワードを２回入力してください。");
			return "48unsubscribepass";
		} else if (repassword == null || repassword.equals("")) {
			model.addAttribute("errmsg", "パスワードを２回入力してください。");
			return "48unsubscribepass";
		} else if ( ! (newpassword.equals(repassword)) ) {
			model.addAttribute("errmsg", "パスワードが間違っています。<br><br>同じパスワードを<br>２回入力してください。");
			return "48unsubscribepass";
		}

			Users pass = usersDao.findByPass(newpassword);
			if (pass != null) {//次ページへ
				session.setAttribute("user", pass);
				return "28unsubscribe";
			} else {//passの一致するアカウントが無い
				model.addAttribute("errmsg", "パスワードが間違っています。<br><br>パスワードは４文字以上１０文字以下の半角英数字です。");
				return "48unsubscribepass";
			}
		}

	@RequestMapping("/28unsubscribe")
	public String unsub1(Model model){
	return "28unsubscribe";
	}

//退会確認画面:46unsubscribeResult
	@RequestMapping("/unsubResult")//GET
	public String unsubResult(@ModelAttribute("form") UnsubscribeForm users, Model model) {
		Users user = (Users) session.getAttribute("user");
		Integer user_id = user.getUser_id();
		usersDao.Unsub(user_id);
		return "46unsubscribeResult";
	}
}