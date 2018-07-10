package fGroup.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fGroup.dto.Article;
import fGroup.dto.Users;
import fGroup.form.Post;
import fGroup.service.ArtService;


@Controller
public class ArtController {

	@Autowired
	HttpSession session;

	@Autowired
	ArtService artS;

	String date;

	@RequestMapping(value="/44myArt")
	public String myArt (@ModelAttribute("form") Post post, Model model) {
		//テスト用　後で消す
		Users user = new Users();
		user.setUser_id(10001);
		user.setName("OK");
		session.setAttribute("user", user);

		return "44myArt";
	}

	@RequestMapping(value="/15art")
	public String art (@ModelAttribute("form") Post post,
			 @RequestParam("art_id") Integer art_id, Model model) {

		//art_idを元に記事情報検索
		Article art = artS.selectArt(art_id);

		//退会情報の確認
		if(art ==null || !artS.existUser(art.getUser_id())) {
			model.addAttribute("noArt", "指定された記事は存在しません");
			return "15art";
		}

		//記事ページに情報渡す
		model.addAttribute("art", art);
		model.addAttribute("form", art);

		return "15art";
	}

	@RequestMapping(value="/50artUnlogin")
	public String artUnlogin (@ModelAttribute("form") Post post,
			 @RequestParam("art_id") Integer art_id, Model model) {

		//art_idを元に記事情報検索
		Article art = artS.selectArt(art_id);

		//記事ページに情報渡す
		model.addAttribute("art", art);

		return "50artUnlogin";
	}

    @RequestMapping(value="/16all_postArt", method = RequestMethod.POST)
    public String postArtLogin(@ModelAttribute("form") Post post,
    		@RequestParam("user_id") Integer user_id,
    		@RequestParam("user_name") String user_name, Model model) {

    	List <Article> list = artS.getAllArt(user_id);
    	model.addAttribute("list", list);
    	model.addAttribute("name", user_name);

        return "16all_postArt";
    }

    @RequestMapping(value="/52all_postArtUnlogin", method = RequestMethod.POST)
    public String postArtUnlogin(@ModelAttribute("form") Post post,
    		@RequestParam("user_id") Integer user_id,
    		@RequestParam("user_name") String user_name, Model model) {

    	List <Article> list = artS.getAllArt(user_id);
    	model.addAttribute("list", list);
    	model.addAttribute("name", user_name);

        return "16all_postArt";
    }


}
