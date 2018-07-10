package fGroup.form;

public class SelectForm {

	public String keyword;

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public boolean isEmpty() {
		return keyword == null || keyword.isEmpty();
	}

}
