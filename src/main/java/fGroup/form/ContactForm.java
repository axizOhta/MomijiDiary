package fGroup.form;

import javax.validation.constraints.NotBlank;

public class ContactForm {

	@NotBlank
	private String email_address;

	@NotBlank
	private String contact_title;

	@NotBlank
	private String contact_message;

	public String getEmail_address() {
		 return email_address;
	}

	public void setEmail_address(String _email_address) {
		this.email_address=_email_address;
	}

	public String getContact_title() {
		return contact_title;
	}

	public void setContact_title(String _contact_title) {
		this.contact_title=_contact_title;
	}

	public String getContact_message() {
		return contact_message;
	}

	public void setContact_message(String _contact_message) {
		this.contact_message=_contact_message;
	}

}
