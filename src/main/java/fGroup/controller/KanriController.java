package fGroup.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fGroup.dto.Article;
import fGroup.dto.Users;
import fGroup.form.SELECT_ART_M_model;
import fGroup.form.UserUpForm;
import fGroup.service.ArtService;
import fGroup.service.UserUpService;



@Controller
public class KanriController {

	@Autowired
    MessageSource messageSource;

	@Autowired
	private UserUpService userUpService;

	@Autowired
	HttpSession session;

	@Autowired
	ArtService artS;


//	@RequestMapping(value = "/43managerMenu") //Getで直に管理メニューへ飛んだときに管理ログインへ遷移//あとでreturn先を35login_managerに変更すること
//	public String menu(@ModelAttribute("form") UserUpForm form,Model model) {
//		return "43managerMenu";
//	}

	@RequestMapping(value = "/36userinfo") //Getで直にユーザー一覧へ飛んだときに管理ログインへ遷移//あとでreturn先を35login_managerに変更すること
	public String useritiran(@ModelAttribute("form") UserUpForm form, Model model) {
		return "43managerMenu";
	}




	@RequestMapping(value = "/36userinfo" ,method = RequestMethod.POST)//Postでユーザー一覧へ遷移
	public String users(@ModelAttribute("form") Users form, Model model) {
		List<Users> resultList =userUpService.find(form);
		model.addAttribute("userlist", resultList);
		return "36userinfo";
	}


	@RequestMapping(value = "/39forced_deleteArt")//記事削除へ遷移（//Getで来たらログインへ遷移）//あとでreturn先を35login_managerに変更すること
	public String artget(@ModelAttribute("form") SELECT_ART_M_model form,
			@RequestParam("user_id") Integer user_id ,
			@RequestParam(value ="name" ,required = false) String user_name,Model model) {//ここまで強制退会と同じ

		List<Article> resultList =userUpService.findByName(user_id);
		model.addAttribute("name", user_name);
		model.addAttribute("user_id", user_id);
		model.addAttribute("userlist", resultList);


//		SELECT_ART_M_model selectArtM = new SELECT_ART_M_model();
//		selectArtM.setSelect_article_id(new String[] { "1111111111" });
//		model.addAttribute("form", selectArtM);
//
//		List<DELETE_ART_M> list = new ArrayList<>();
//
//		for (Article art : resultList) {
//			list.add(new DELETE_ART_M(art.getArticle_id(), art.getArticle_title()));
//		}
//		 model.addAttribute("art_id", list);

		return "39forced_deleteArt";
	}
	//未完成ここから
	@RequestMapping(value = "/40forced_deleteArtCon" ,method = RequestMethod.POST)//記事削除確認へ遷移
	public String artdel1(@ModelAttribute("form") SELECT_ART_M_model form,
			@RequestParam("user_id") Integer user_id ,
			@RequestParam(value ="name" ,required = false) String user_name,
			@RequestParam(value ="article_id",required = false) Integer article_id ,
			@RequestParam(value ="article_title",required = false) String article_title ,
			@RequestParam(value ="check" ,required = false) String check[], Model model) {

		model.addAttribute("user_id",user_id);
		model.addAttribute("name",user_name);

		List<Article> list = new ArrayList<Article>();

		if(check == null) {
			model.addAttribute("msg", "チェックされていません");
			return "39forced_deleteArt";
		}

		for(String art_id : check) {

			Article art = artS.selectArt(Integer.parseInt(art_id));
			list.add(art);
		}
		model.addAttribute("userlist", list);
		session.setAttribute("delList", list);

		return "40forced_deleteArtCon";
	}

	@RequestMapping(value = "/41forced_deleteArtOK")//記事削除完了へ遷移
	public String artdel2(@ModelAttribute("form") Article form,
			@RequestParam(value ="name" ,required = false) String user_name,
			Model model) {
		List<Article> list = (List<Article>) session.getAttribute("delList");
		for (Article art : list) {
			userUpService.artDelete(art.getArticle_id());
		}

		model.addAttribute("name",user_name);
		model.addAttribute("userlist", list);
		return "41forced_deleteArtOK";
	}

	//以下完成済み

	@RequestMapping(value = "/37userdelete" )//Getで強制退会へ遷移
	public String userget(@ModelAttribute("form") Users form,@RequestParam("user_id") Integer user_id ,
			@RequestParam(value ="name" ,required = false) String user_name, Model model) {
		model.addAttribute("user_id",user_id );
		model.addAttribute("user_name",user_name );
		return "37userdelete";
	}

	@RequestMapping(value = "/38userdeleteResult")//強制退会削除完了へ遷移
	public String userdel(@ModelAttribute("form") Users form, @RequestParam("user_id") Integer user_id ,
			@RequestParam(value ="name" ,required = false) String user_name,Model model) {
		userUpService.userDelete(user_id);
		model.addAttribute("user_id",user_id );
		model.addAttribute("user_name",user_name );
		return "38userdeleteResult";
	}


}
