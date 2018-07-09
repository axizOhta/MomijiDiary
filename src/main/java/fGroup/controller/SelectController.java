package fGroup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import fGroup.dto.Article;
import fGroup.form.SelectForm;
import fGroup.service.impl.ArticleService;

@Controller
public class SelectController {

	@Autowired
    MessageSource messageSource;

	@Autowired
	private ArticleService articleService;
	//会員用
	@RequestMapping("/17select")
	public String select(@ModelAttribute("selectForm") SelectForm form, Model model) {
		return "17select";
	}

	@RequestMapping(value = "/18selectResult")
	public String article(@Validated @ModelAttribute("selectForm") SelectForm form, BindingResult bindingResult,
			Model model) {

		if (bindingResult.hasErrors()) {
//			String errorMsg = messageSource.getMessage("select.error", null, Locale.getDefault());
//			model.addAttribute("errmsg", errorMsg);
			model.addAttribute("errmsg", "キーワードを入力してください");

			return "17select";
		}

		String Keyword = form.keyword;
		model.addAttribute("keyword", Keyword);

		if(form.keyword == null || form.isEmpty()) {
//			String errorMsg = messageSource.getMessage("select.null.error", null, Locale.getDefault());
//			model.addAttribute("errmsg", errorMsg);
			model.addAttribute("errmsg", "キーワードを入力してください");

			return "17select";
		}

		Article condition = new Article();
		condition.setKeyword(form.getKeyword());

		List<Article> resultList = articleService.findByConditions(condition);

		if(resultList.isEmpty()) {
//			String errorMsg = messageSource.getMessage("select.error", null, Locale.getDefault());
//			model.addAttribute("errmsg", errorMsg);
			model.addAttribute("errmsg", "入力したキーワードを含む記事は見つかりませんでした");
			return "17select";
		}else {
			model.addAttribute("articlelist", resultList);
			return "18selectResult";
		}
	}

	//非会員用
	@RequestMapping("/53selectUnlogin")
	public String unselect(@ModelAttribute("selectForm") SelectForm form, Model model) {
		return "53selectUnlogin";
	}

	@RequestMapping(value = "/49selectResultUnlogin")
	public String unarticle(@Validated @ModelAttribute("selectForm") SelectForm form, BindingResult bindingResult,
			Model model) {

		if (bindingResult.hasErrors()) {
//			String errorMsg = messageSource.getMessage("select.error", null, Locale.getDefault());
//			model.addAttribute("errmsg", errorMsg);
			model.addAttribute("errmsg", "キーワードを入力してください");
			return "53selectUnlogin";
		}

		String Keyword = form.keyword;
		model.addAttribute("keyword", Keyword);

		if(form.keyword == null || form.isEmpty()) {
//			String errorMsg = messageSource.getMessage("select.null.error", null, Locale.getDefault());
//			model.addAttribute("errmsg", errorMsg);
			model.addAttribute("errmsg", "キーワードを入力してください");
			return "53selectUnlogin";
		}

		Article condition = new Article();
		condition.setKeyword(form.getKeyword());

		List<Article> resultList = articleService.findByConditions(condition);

		if(resultList.isEmpty()) {
//			String errorMsg = messageSource.getMessage("select.error", null, Locale.getDefault());
//			model.addAttribute("errmsg", errorMsg);
			model.addAttribute("errmsg", "入力したキーワードを含む記事は見つかりませんでした");
			return "53selectUnlogin";
		}else {
			model.addAttribute("articlelist", resultList);

			return "49selectResultUnlogin";
		}
	}




	}