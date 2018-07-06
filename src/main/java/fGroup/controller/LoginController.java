package fGroup.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fGroup.dao.AdminDao;
import fGroup.dao.UsersDao;
import fGroup.dto.Admin;
import fGroup.dto.Users;
import fGroup.form.AdminForm;

@Controller
public class LoginController {

	@Autowired
	UsersDao usersDao;

	@Autowired
	HttpSession session;

//ユーザーログイン
	@RequestMapping("/04login_user")//GET
	public String index(@ModelAttribute("form") Users users, Model model){
		return "04login_user";
	}

	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String get(@ModelAttribute("form") Users users, Model model) {
	String id = users.getLogin_id();
	String pass = users.getPassword();

	if(id==null && pass ==null || id.equals("") && pass.equals("")) {
		model.addAttribute("errmsg", "ID と パスワード を<br>入力してください。");
		return "04login_user";
	} else if ( id == null || id.equals("")) {
		model.addAttribute("errmsg", "IDを入力してください。");
		return "04login_user";
	} else if (pass == null || pass.equals("")) {
		model.addAttribute("errmsg", "パスワードを入力してください。"
				+ "<br><br>パスワードは 4文字以上 10文字以下 の 半角英数字 です。");
		return "04login_user";
	}

	Users us = usersDao.findByIdAndPassword(id,pass);
		if (us != null) {
		session.setAttribute("user", us);
			return "05mypage";
		} else {//id、passの一致するアカウントが無い
			model.addAttribute("errmsg", "IDまたはパスワードが<br>間違っています。"
					+ "<br><br>パスワードは4文字以上10文字以下の半角英数字です。");
			return "04login_user";
		}

}

		@RequestMapping("/47Top")
		public String Top(Model model){
		return "47Top";
		}
		@RequestMapping("/05mypage")
		public String mypage(Model model){
		return "05mypage";
		}


// 管理者ログイン	//----------------------------------------------------------------------------------
		@Autowired
		AdminDao adminDao;

		@RequestMapping("/35login_manager")//GET
		public String topM(@ModelAttribute("form") Admin admin, Model model){
			return "35login_manager";
		}

		@RequestMapping(value="/Mlogin", method = RequestMethod.POST)
		public String getM(@ModelAttribute("form") AdminForm admin, Model model) {

		String id = admin.getAdmin_id();
		String pass = admin.getPassword();

		System.out.println(id);
		if(id==null && pass ==null || id.equals("") && pass.equals("")) {
			model.addAttribute("errmsg", "IDとパスワード を入力してください。");
			return "35login_manager";
		} else if ( id == null ||  id.equals("")) {
			model.addAttribute("errmsg", "IDを入力してください。");
			return "35login_manager";
		} else if (pass == null || pass.equals("")) {
			model.addAttribute("errmsg", "パスワードを入力してください。");
			return "35login_manager";
		}

		try {
			Integer.parseInt(admin.getAdmin_id());
		} catch (NumberFormatException nfex) {
			model.addAttribute("errmsg", "IDまたはパスワードが間違っています。");
			return "35login_manager";
		}
		Integer adminId=Integer.parseInt(id);

		Admin ad = adminDao.findByIdAndPassword(adminId,pass);
			if (ad != null) {//ログイン
				session.setAttribute("user", ad);
				return "43managerMenu";
			} else {//id、passの一致するアカウントが無い
				model.addAttribute("errmsg", "IDまたはパスワードが違います。");
				return "35login_manager";
			}
		}
		@RequestMapping("/43managerMenu")
		public String menu(Model model){
		return "43managerMenu";
		}
}

