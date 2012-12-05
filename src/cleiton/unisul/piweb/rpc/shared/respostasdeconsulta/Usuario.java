package cleiton.unisul.piweb.rpc.shared.respostasdeconsulta;

import java.io.Serializable;

import cleiton.unisul.piweb.rpc.shared.objetoschaveados.Frota;

@SuppressWarnings("serial")
public class Usuario implements Serializable{
	public Usuario(){}
	
	public Usuario(String email, String idUsuario, String nickname,
			String getAuthDomain, boolean isUserAdmin) {
		super();
		this.email = email;
		this.idUsuario = idUsuario;
		this.nickname = nickname;
		this.getAuthDomain = getAuthDomain;
		this.isUserAdmin = isUserAdmin;
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
	public boolean isUserAdmin() {
		return isUserAdmin;
	}

	public void setUserAdmin(boolean isUserAdmin) {
		this.isUserAdmin = isUserAdmin;
	}
	
	private String email;
	private String idUsuario;
	private String nickname;
	private String getAuthDomain;
	private boolean isUserAdmin;

}