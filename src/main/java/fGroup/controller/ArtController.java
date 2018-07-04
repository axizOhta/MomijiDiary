package fGroup.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;

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

	@RequestMapping(value="/15art")
	public String art (@ModelAttribute("form") Post post,
			 @RequestParam("art_id") Integer art_id, Model model) {

		//art_idを元に記事情報検索
		Article art = artS.selectArt(art_id);

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

	@RequestMapping(value="/06post")
	public String postGET (@ModelAttribute("form") Post post, Model model) {
		//テスト用　後で消す
		Users user = new Users();
		user.setUser_id(10001);
		user.setName("F野次郎");
		session.setAttribute("user", user);

		return "06post";
	}

	@RequestMapping(value="/06post", method=RequestMethod.POST)
	public String post (@ModelAttribute("form") Post post, Model model) {

		model.addAttribute("form", post);
		return "06post";
	}

	@RequestMapping(value="/08postOK", params="return", method = RequestMethod.POST)
	public String postArtReturn (@ModelAttribute("form") Post post, Model model) {

	return "06post";
	}

	@RequestMapping(value="/07postCon", method=RequestMethod.POST)
	public String postCon (@ModelAttribute("form") Post post, Model model) {

		if(post.getArticle_title() == null && post.getArticle_title() == null || post.getArticle_title().equals("") && post.getArticle_main().equals("")) {
			model.addAttribute("msg", "記事の題名と本文を入力してください");
			return "06post";
		} else if (post.getArticle_title() == null || post.getArticle_title().equals("")) {
			model.addAttribute("msg", "記事の題名を入力してください");
			return "06post";
		} else if (post.getArticle_main() == null || post.getArticle_main().equals("")) {
			model.addAttribute("msg", "本文を入力してください");
			return "06post";
		} else if (post.getArticle_title().length() > 50) {
			model.addAttribute("msg", "記事の題名の文字数が多すぎます。<br>50字以内で入力してください。");
			return "06post";
		} else if (post.getArticle_main().length() > 3000) {
			model.addAttribute("msg", "本文の文字数が多すぎます。<br>3000字以内で入力してください。");
			return "06post";
		}

		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd (E) HH時mm分");
		date = sdf.format(cal.getTime());
		post.setContribute_date(date);

		model.addAttribute("post", post);

		return "07postCon";
	}

	@RequestMapping(value="/08postOK", method=RequestMethod.POST)
	public String postOK (@ModelAttribute("form") Post post, Model model) {

		Users user = (Users) session.getAttribute("user");

		//記事投稿処理（DB）insert
		artS.insert(post.getArticle_title(), post.getContribute_date(), post.getArticle_main(), user.getUser_id(), user.getName());

		//投稿した記事のidセット
		model.addAttribute("art_id", artS.lastId());
		return "08postOK";
	}


	@RequestMapping(value="/10edit", method=RequestMethod.POST)
	public String edit (@ModelAttribute("form") Post post, Model model) {
		return "10edit";
	}

	@RequestMapping(value="/12editOK", params="return", method = RequestMethod.POST)
	public String editArtReturn (@ModelAttribute("form") Post post, Model model) {

	return "10edit";
	}

	@RequestMapping(value="/11editCon", method=RequestMethod.POST)
	public String editCon (@ModelAttribute("form") Post post, Model model) {

		if(post.getArticle_title() == null && post.getArticle_title() == null || post.getArticle_title().equals("") && post.getArticle_main().equals("")) {
			model.addAttribute("msg", "記事の題名と本文を入力してください");
			return "10edit";
		} else if (post.getArticle_title() == null || post.getArticle_title().equals("")) {
			model.addAttribute("msg", "記事の題名を入力してください");
			return "10edit";
		} else if (post.getArticle_main() == null || post.getArticle_main().equals("")) {
			model.addAttribute("msg", "本文を入力してください");
			return "10edit";
		} else if (post.getArticle_title().length() > 50) {
			model.addAttribute("msg", "記事の題名の文字数が多すぎます。<br>50字以内で入力してください。");
			return "10edit";
		} else if (post.getArticle_main().length() > 3000) {
			model.addAttribute("msg", "本文の文字数が多すぎます。<br>3000字以内で入力してください。");
			return "10edit";
		}

		model.addAttribute("edit", post);
		return "11editCon";
	}

	@RequestMapping(value="/12editOK", method=RequestMethod.POST)
	public String editOK (@ModelAttribute("form") Post post, Model model) {

		//記事更新処理
		artS.update(post.getArticle_id(), post.getArticle_title(), post.getArticle_main());

		//更新した記事のidセット
		model.addAttribute("art_id", post.getArticle_id());
		return "12editOK";
	}


}
