package fGroup.form;

import org.springframework.web.multipart.MultipartFile;

public class Post {

	private Integer article_id;
	private String article_title;
	private String contribute_date;
	private String article_main;

	//画像投稿用フォーム
	private MultipartFile[] file;

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
	public MultipartFile[] getFile() {
		return file;
	}
	public void setFile(MultipartFile[] file) {
		this.file = file;
	}

}
