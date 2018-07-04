package fGroup.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LogOutController {

 	@Autowired
 	HttpSession session;

//ユーザーログアウト
		@RequestMapping(value="/logout",method=RequestMethod.POST)
		public String logout(Model model){
			session.invalidate();
			return "29logout";
		}

//管理者ログアウト
		@RequestMapping(value="/Mlogout",method=RequestMethod.POST)
		public String logoutM(Model model){
			session.invalidate();
			return "35login_manager";
		}
}
