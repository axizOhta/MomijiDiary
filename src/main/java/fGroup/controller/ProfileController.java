package fGroup.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fGroup.dto.Profile;
import fGroup.form.ProfileForm;
import fGroup.form.SelectForm;
import fGroup.service.impl.ProfileService;
import jp.co.axiz.web.entity.UserInfo;

@Controller
public class ProfileController {

//	@Autowired
//	private SessionInfo sessionInfo;

	@Autowired
    MessageSource messageSource;

	@Autowired
	private ProfileService profileService;

	@RequestMapping("/45myPro")
	public String myPro(@ModelAttribute("profileForm") ProfileForm form, Model model) {
		return "45myPro";
	}

	//自己紹介表示
	@RequestMapping(value = "/22profile")
	public String article(@Validated @ModelAttribute("selectForm") SelectForm form, BindingResult bindingResult,@RequestParam("userid") Integer userid,
			Model model) {

		if (bindingResult.hasErrors()) {
			String errorMsg = messageSource.getMessage("select.error", null, Locale.getDefault());
			model.addAttribute("errmsg", errorMsg);
			return "45myPro";
		}

//		Profile profile = profileService.findById(session.getAttribute(user));

//		Profile condition = new Profile();
//		condition.setAttribute(session.getUser());

		List<Profile> resultList = profileService.findByConditions(userid);

		if(resultList.isEmpty()) {
			String errorMsg = messageSource.getMessage("select.error", null, Locale.getDefault());
			model.addAttribute("errmsg", errorMsg);
			return "45myPro";
		}else {
			model.addAttribute("profilelist", resultList);
			return "22profile";
		}
	}

	//自己紹介編集
	@RequestMapping(value = "/23profileEdit", method = RequestMethod.POST)
	public String updateInput(@Validated @ModelAttribute("profileForm") ProfileForm form, BindingResult bindingResult,@RequestParam("userid") Integer userid,
			Model model) {

		if (bindingResult.hasFieldErrors("userId")) {
			String errorMsg = messageSource.getMessage("required.error", null, Locale.getDefault());
			model.addAttribute("errmsg", errorMsg);
			return "22profile";
		}

		//session.getAttribute(userid);
		Profile prof = profileService.findById(userid);

		if(prof == null) {
			String errorMsg = messageSource.getMessage("id.not.found.error", null, Locale.getDefault());
			model.addAttribute("errmsg", errorMsg);
			return "22prrfile";
		}

		//sessionInfo.setPrevUser(user);

		form.setName(prof.getName());
		form.setSex(prof.getSex());
		form.setBirthyear(prof.getBirthyear());
		form.setBirthmonth(prof.getBirthmonth());
		form.setBirthday(prof.getBirthday());
		form.setHobby(prof.getHobby());
		form.setSelf_introduction(prof.getSelf_introduction());


		return "23profileEdit";
	}

//	@RequestMapping(value = "/updateConfirm", method = RequestMethod.POST)
//	public String updateConfirm(@Validated @ModelAttribute("updateForm") UpdateForm form, BindingResult bindingResult,
//			Model model) {
//
//		if (form.hasRequiredError()) {
//			String errorMsg = messageSource.getMessage("required.error", null, Locale.getDefault());
//			model.addAttribute("errmsg", errorMsg);
//			return "updateInput";
//		}
//
//		UserInfo beforeUser = sessionInfo.getPrevUser();
//
//		UserInfo afterUser = new UserInfo();
//		afterUser.setUserId(beforeUser.getUserId());
//		afterUser.setUserName(form.getNewName());
//		afterUser.setTelephone(form.getNewTel());
//		afterUser.setPassword(form.getNewPassword());
//
//		if(afterUser.equals(beforeUser)) {
//			String errorMsg = messageSource.getMessage("required.change", null, Locale.getDefault());
//			model.addAttribute("errmsg", errorMsg);
//			return "updateInput";
//		}
//
//		sessionInfo.setAfterUser(afterUser);
//
//		form.setPrevName(beforeUser.getUserName());
//		form.setPrevTel(beforeUser.getTelephone());
//		form.setPrevPassword(beforeUser.getPassword());
//
//		if(beforeUser.getPassword().equals(afterUser.getPassword())) {
//			form.setConfirmNewPassword(afterUser.getPassword());
//		}
//
//		return "updateConfirm";
//	}

//	@RequestMapping(value = "/updateInputBack")
//	public String updateInputBack(@ModelAttribute("updateForm") UpdateForm form, Model model) {
//
//		UserInfo afterUser = sessionInfo.getAfterUser();
//
//		form.setUserId(afterUser.getUserId());
//		form.setNewName(afterUser.getUserName());
//		form.setNewTel(afterUser.getTelephone());
//		form.setNewPassword(afterUser.getPassword());
//
//		return "updateInput";
//	}
//
//
	//自己紹介編集完了
	@RequestMapping(value = "/24profileEditResult", method = RequestMethod.POST)
	public String updateExecute(@Validated @ModelAttribute("profileForm") Profile form, BindingResult bindingResult,@RequestParam("userid") Integer userid,
			Model model) {

		UserInfo afterUser = sessionInfo.getAfterUser();

//		if(!afterUser.getPassword().equals(form.getConfirmNewPassword())) {
//			String errorMsg = messageSource.getMessage("password.not.match.error", null, Locale.getDefault());
//			model.addAttribute("errmsg", errorMsg);
//
//			form.setConfirmNewPassword("");
//
//			UserInfo beforeUser = sessionInfo.getPrevUser();
//			form.setPrevName(beforeUser.getUserName());
//			form.setPrevTel(beforeUser.getTelephone());
//			form.setPrevPassword(beforeUser.getPassword());
//
//			return "updateConfirm";
//		}

		profileService.update(afterUser);
//
//		sessionInfo.setAfterUser(null);
//		sessionInfo.setPrevUser(null);

		model.addAttribute("user", sessionInfo.getLoginUser());

		return "24profileEditResult";
	}

}
