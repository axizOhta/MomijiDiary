package fGroup.form;

public class DELETE_ART_M {


	private Integer article_id;
	private String article_title;

	public DELETE_ART_M(Integer article_id, String title) {
		this.article_id = article_id;
		this.article_title = title;
	}

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

}
