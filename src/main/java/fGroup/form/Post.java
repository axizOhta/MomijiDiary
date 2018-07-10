package fGroup.form;

import org.springframework.web.multipart.MultipartFile;

public class Post {

	private Integer article_id;
	private String article_title;
	private String contribute_date;
	private String article_main;
	private Integer user_id;

	private MultipartFile image1;
	private MultipartFile image2;
	private MultipartFile image3;
	private MultipartFile image4;

	public Integer getArticle_id() {
		return article_id;
	}
	public void setArticle_id(Integer article_id) {
		this.article_id = article_id;
	}
	public String getArticle_title() {
		return article_title;
	}
	public void setArticle_title(String article_title) {
		this.article_title = article_title;
	}
	public String getArticle_main() {
		return article_main;
	}
	public void setArticle_main(String article_main) {
		this.article_main = article_main;
	}
	public String getContribute_date() {
		return contribute_date;
	}
	public void setContribute_date(String contribute_date) {
		this.contribute_date = contribute_date;
	}

	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public MultipartFile getImage1() {
		return image1;
	}
	public void setImage1(MultipartFile image1) {
		this.image1 = image1;
	}
	public MultipartFile getImage2() {
		return image2;
	}
	public void setImage2(MultipartFile image2) {
		this.image2 = image2;
	}
	public MultipartFile getImage3() {
		return image3;
	}
	public void setImage3(MultipartFile image3) {
		this.image3 = image3;
	}
	public MultipartFile getImage4() {
		return image4;
	}
	public void setImage4(MultipartFile image4) {
		this.image4 = image4;
	}

}
