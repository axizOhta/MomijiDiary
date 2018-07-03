package fGroup.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fGroup.dto.Article;
import fGroup.form.Post;
import fGroup.service.ArtService;


@Controller
public class ArtController {

	@Autowired
	HttpSession session;

	@Autowired
	ArtService artS;

	@RequestMapping(value="/15art")
	public String art (@ModelAttribute("form") Post post,
			 @RequestParam("art_id") Integer art_id, Model model) {

		//art_idを元に記事情報検索
		Article art = artS.selectArt(art_id);

		//記事ページに情報渡す
		model.addAttribute("art", art);

		return "15art";
	}

	@RequestMapping(value="/06post")
	public String postGET (@ModelAttribute("form") Post post, Model model) {

		return "06post";
	}

	@RequestMapping(value="/06post", method=RequestMethod.POST)
	public String post (@ModelAttribute("form") Post post, Model model) {

		return "06post";
	}

	@RequestMapping(value="/07postCon", method=RequestMethod.POST)
	public String postCon (@ModelAttribute("form") Post post, Model model) {

		return "07postCon";
	}

	@RequestMapping(value="/08postOK", method=RequestMethod.POST)
	public String postOK (@ModelAttribute("form") Post post, Model model) {

		return "08postOK";
	}


}
