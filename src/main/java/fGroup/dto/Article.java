package fGroup.dto;

public class Article {

	private Integer article_id;
	private Integer user_id;
	private String name;
	private String article_title;
	private String article_main;
	private String image_1;
	private String image_2;
	private String image_3;
	private String image_4;
	private String contribute_date;

	private String keyword;

	public Article() {
	}

	public Article(Integer article_id, Integer user_id, String name, String article_title, String article_main,
					String image_1, String image_2, String image_3, String image_4, String contribute_date) {
		this.article_id = article_id;
		this.user_id = user_id;
		this.name = name;
		this.article_title = article_title;
		this.article_main = article_main;
		this.image_1 = image_1;
		this.image_2 = image_2;
		this.image_3 = image_3;
		this.image_4 = image_4;
		this.contribute_date = contribute_date;
	}

	public Integer getArticle_id() {
		return article_id;
	}

	public void setArticle_id(Integer article_id) {
		this.article_id = article_id;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getImage_1() {
		return image_1;
	}

	public void setImage_1(String image_1) {
		this.image_1 = image_1;
	}

	public String getImage_2() {
		return image_2;
	}

	public void setImage_2(String image_2) {
		this.image_2 = image_2;
	}

	public String getImage_3() {
		return image_3;
	}

	public void setImage_3(String image_3) {
		this.image_3 = image_3;
	}

	public String getImage_4() {
		return image_4;
	}

	public void setImage_4(String image_4) {
		this.image_4 = image_4;
	}

	public String getContribute_date() {
		return contribute_date;
	}

	public void setContribute_date(String contribute_date) {
		this.contribute_date = contribute_date;
	}

	public boolean isConditionsEmpty() {
		return article_id == null
				&& user_id == null
				&& (name == null || name.isEmpty())
				&& (article_title == null || article_title.isEmpty())
				&& (article_main == null || article_main.isEmpty())
				&& (image_1 == null || image_1.isEmpty())
				&& (image_2 == null || image_2.isEmpty())
				&& (image_3 == null || image_3.isEmpty())
				&& (image_4 == null || image_4.isEmpty())
				&& (contribute_date == null || contribute_date.isEmpty());
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public boolean isEmpty() {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}



}
