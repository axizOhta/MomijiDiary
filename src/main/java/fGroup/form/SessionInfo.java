package fGroup.form;


import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import fGroup.dto.Users;

@Component
@Scope(value= "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SessionInfo implements Serializable {
	private static final long serialVersionUID = 6334063099671792256L;

	private Users loginUser;

	public Users getLoginUser() {
		return loginUser;
	}

	public void setLoginUser(Users loginUser) {
		this.loginUser = loginUser;
	}
	private Users newUser;

	private Users prevUser;

	private Users afterUser;

	public Users getNewUser() {
		return newUser;
	}

	public void setNewUser(Users newUser) {
		this.newUser = newUser;
	}

	public Users getPrevUser() {
		return prevUser;
	}

	public void setPrevUser(Users prevUser) {
		this.prevUser = prevUser;
	}

	public Users getAfterUser() {
		return afterUser;
	}

	public void setAfterUser(Users afterUser) {
		this.afterUser = afterUser;
	}
	public void invalidate() {
		loginUser = null;
		newUser = null;
		prevUser = null;
		afterUser = null;
	}
}
