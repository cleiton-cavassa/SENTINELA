package cleiton.unisul.piweb.classesrpc.shared;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Usuario implements Serializable{
	public Usuario(){}
	
	public Usuario(String email, String idUsuario, String nickname,
			String getAuthDomain) {
		super();
		this.email = email;
		this.idUsuario = idUsuario;
		this.nickname = nickname;
		this.getAuthDomain = getAuthDomain;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getGetAuthDomain() {
		return getAuthDomain;
	}
	public void setGetAuthDomain(String getAuthDomain) {
		this.getAuthDomain = getAuthDomain;
	}
	private String email;
	private String idUsuario;
	private String nickname;
	private String getAuthDomain;	
}
