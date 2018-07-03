package fGroup.form;

import javax.validation.constraints.NotBlank;

public class ContactForm {

	@NotBlank
	private String mail;

	@NotBlank
	private String subject;

	@NotBlank
	private String content;

	public String getMail() {
		 return mail;
	}

	public void setMail(String _mail) {
		this.mail=_mail;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String _subject) {
		this.subject=_subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String _content) {
		this.content=_content;
	}

}
