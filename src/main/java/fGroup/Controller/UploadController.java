package fGroup.Controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import fGroup.form.Image;

@Controller
public class UploadController {

	@Autowired
	ServletContext context;

	@Autowired
	HttpSession session;

	@ModelAttribute("form")
	@RequestMapping(value = "/uploadTest", method = RequestMethod.GET)
	public String uploadForm() {
		return "uploadTest";
	}

	@SuppressWarnings("null")
	@ModelAttribute("form")
	@RequestMapping(value = "/uploadResult", method = RequestMethod.POST)
	public String uploadRecv(@RequestParam String test,
			@RequestParam("file") MultipartFile[] file, Model model) throws IOException {
		try {
			model.addAttribute("test", test);
			for(int i = 0;i < file.length;i++) {
				Path path = Paths.get("C:\\pleiades\\pleiades\\workspace\\MapleDiary\\src\\main\\resources\\static\\images", file[i].getOriginalFilename());
				file[i].transferTo(path.toFile());
				//model.addAttribute("fileName", path);
			}

			model.addAttribute("uploadedImage", file);
			return "uploadResult";
		}catch(Exception e) {
			return "uploadTest";
		}
	}

	@RequestMapping(value = "/uploadtestpart2", method = RequestMethod.GET)
	public String uploadFormPart2() {
		return "uploadTestPart2";
	}

	@RequestMapping(value = "/uploadtestpart2", method = RequestMethod.POST)
	public @ResponseBody Image saveProduct(HttpServletRequest request,
			@RequestParam("file") MultipartFile file) throws IllegalStateException, IOException {


		Image image = new Image();


		if (file.getSize() > 0) {
			image.setName(file.getOriginalFilename());

			image.setSize(file.getSize());

			File imageFile = new File(context.getRealPath("/") + "/images",image.getName());
			if (!imageFile.exists()) {
				File imageDir = new File(context.getRealPath("/") + "/images");
				imageDir.mkdir();
			}
			file.transferTo(imageFile);
		}

		return image;
	}

}
