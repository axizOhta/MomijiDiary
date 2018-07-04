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

@Controller
public class LoginController {

	@Autowired
	UsersDao usersDao;

	@Autowired
	HttpSession session;

//ユーザーログイン
	@RequestMapping("/login")//GET
	public String index(@ModelAttribute("form") Users users, Model model){
		return "04login_user";
	}

	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String get(@ModelAttribute("form") Users users, Model model) {
	String id = users.getLogin_id();
	String pass = users.getPassword();

	if(id==null && pass ==null || id.equals("") && pass.equals("")) {
		model.addAttribute("errmsg", "ログインIDとパスワードを入力してください。");

		return "04login_user";
	} else if ( id == null || id.equals("")) {
		model.addAttribute("errmsg", "ログインIDを入力してください。");
		return "04login_user";
	} else if (pass == null || pass.equals("")) {
		model.addAttribute("errmsg", "パスワードを入力してください。");
		return "04login_user";
	}

	Users us = usersDao.findByIdAndPassword(id,pass);
		if (us != null) {
		session.setAttribute("user", us);
			return "05mypage";
		} else {//id、passの一致するアカウントが無い
			model.addAttribute("errmsg", "ログインIDまたはパスワードが違います。");
			return "04login_user";
		}

}


// 管理者ログイン	//----------------------------------------------------------------------------------
		@Autowired
		AdminDao adminDao;

		@RequestMapping("/Mlogin")//GET
		public String indexM(@ModelAttribute("form") Admin admin, Model model){
			return "35login_manager";
		}

		@RequestMapping(value="/Mlogin", method = RequestMethod.POST)
		public String getM(@ModelAttribute("form") Admin admin, Model model) {
		Integer id = admin.getAdmin_id();
		String pass = admin.getPassword();

		if(id==null && pass ==null) {
			model.addAttribute("errmsg", "ログインIDとパスワードを入力してください。");
			return "35login_manager";
		} else if ( id == null ) {
			model.addAttribute("errmsg", "ログインIDを入力してください。");
			return "35login_manager";
		} else if (pass == null || pass.equals("")) {
			model.addAttribute("errmsg", "パスワードを入力してください。");
			return "35login_manager";
		}

		Admin ad = adminDao.findByIdAndPassword(id,pass);
			if (ad != null) {//ログイン
				session.setAttribute("user", ad);
				return "43managerMenu";
			} else {//id、passの一致するアカウントが無い
				model.addAttribute("errmsg", "ログインIDまたはパスワードが違います。");
				return "35login_manager";
			}
		}

}

