package cleiton.unisul.piweb.server;

//import cleiton.unisul.piweb.client.GreetingService;
import cleiton.unisul.piweb.client.GreetingService;
import cleiton.unisul.piweb.shared.FieldVerifier;
import cleiton.unisul.piweb.shared.Usuario;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server side implementation of the RPC service.
 */


@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements GreetingService{
	
	UserService userService = UserServiceFactory.getUserService();
	User user = userService.getCurrentUser();
	
	public String greetServer(String input) throws IllegalArgumentException {
	    

	    String authURL = (user != null) ? userService.createLogoutURL("/")
	    	      : userService.createLoginURL("/");
	 	if (user==null){
    		return "";
    	}else{
    		return user.getEmail();
    	}

	}

	/**
	 * Escape an html string. Escaping data received from the client helps to
	 * prevent cross-site script vulnerabilities.
	 * 
	 * @param html the html string to escape
	 * @return the escaped string
	 */
	private String escapeHtml(String html) {
		if (html == null) {
			return null;
		}
		return html.replaceAll("&", "&amp;").replaceAll("<", "&lt;")
				.replaceAll(">", "&gt;");
	}

	@Override
	public String urlLogout(String destino) {
		return userService.createLogoutURL(destino);
	}

	@Override
	public Usuario getUsuario(String qualquer) {
		// TODO Auto-generated method stub
		return new Usuario(user.getEmail(),user.getUserId(),user.getNickname(),user.getAuthDomain());
	}
}
