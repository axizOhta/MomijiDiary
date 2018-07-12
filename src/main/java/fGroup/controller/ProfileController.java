package fGroup.controller;

import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import fGroup.dao.UsersDao;
import fGroup.dto.Profile;
import fGroup.dto.Users;
import fGroup.form.ProfileForm;
import fGroup.service.DateModifiedService;
import fGroup.service.ProfileService;

@Controller
public class ProfileController {

	@Autowired
	HttpSession session;

	@Autowired
	ProfileService profileService;

	@Autowired
	DateModifiedService DMS;

	@Autowired
	UsersDao uDao;

	@RequestMapping(value="/45myPro")
	public String myPro(Model model) {
		Users user = (Users)session.getAttribute("user");
		Profile profile = new Profile();
		profile.setUser_id(user.getUser_id());
		model.addAttribute("form", profile);
		return "45myPro";
	}

	@RequestMapping(value="/22profile", method=RequestMethod.POST)
	public String profile(@ModelAttribute("form") ProfileForm form) {
		Integer user_id = form.getUser_id();
		Profile profile = profileService.FindById(user_id);

		session.setAttribute("Profile", profile);

		return "22profile";
	}

	@RequestMapping(value="/51profileUnlogin", method=RequestMethod.POST)
	public String profileU(@ModelAttribute("form") ProfileForm form) {
		Integer user_id = (Integer)session.getAttribute("tempId");
		Profile profile = profileService.FindById(user_id);

		session.setAttribute("Profile", profile);

		return "51profileUnlogin";
	}

	@RequestMapping(value="/23profileEdit", method=RequestMethod.GET)
	public String profileEdit(@ModelAttribute("form") ProfileForm form) {
		Users user = (Users)session.getAttribute("user");
		Integer user_id = user.getUser_id();
		Profile beforeProfile = profileService.FindById(user_id);

		session.setAttribute("beforeProfile", beforeProfile);

		return "23profileEdit";
	}

	@RequestMapping(value="/24profileEditResult", method=RequestMethod.POST)
	public String updateResult(@ModelAttribute("form") ProfileForm form, Model model) {

		Users user = (Users)session.getAttribute("user");
		Integer user_id = user.getUser_id();

		try {
			MultipartFile file = form.getProfile_image();

			String uploadedfile = file.getOriginalFilename();


			if(!(uploadedfile.equals(""))){
				Path path = Paths.get("C:\\pleiades\\pleiades\\workspace\\MapleDiary\\src\\main\\resources\\static\\profile\\images", uploadedfile);
				file.transferTo(path.toFile());
			}else {
			}

		}catch(Exception e) {
			return "upload";
		}

		String profile_image = form.getProfile_image().getOriginalFilename();
		String newName = form.getName();
		String newSex = form.getSex();
		Integer newBirthyear = form.getBirthyear();
		Integer newBirthmonth = form.getBirthmonth();
		Integer newBirthday = form.getBirthday();
		String newHobby = form.getHobby();
		String newSelfIntroduction = form.getSelf_introduction();

		Profile updateProfile = new Profile(user_id,profile_image,newName,newSex,newBirthyear,newBirthmonth,newBirthday,newHobby,newSelfIntroduction);

		Profile beforeProfile = (Profile)session.getAttribute("beforeProfile");

		profileService.update(updateProfile, beforeProfile);

		Profile newProfile = profileService.FindById(user_id);

		DMS.dateModified(user_id);

		Users newUser = uDao.findById(user_id);

		session.setAttribute("user", newUser);

		session.setAttribute("newProfile", newProfile);

		return "24profileEditResult";
	}
}
