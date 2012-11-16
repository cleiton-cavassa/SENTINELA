package cleiton.unisul.piweb.classesrpc.server;

import javax.jdo.PersistenceManager;

import cleiton.unisul.piweb.classesrpc.client.GreetingService;
import cleiton.unisul.piweb.classesrpc.shared.Usuario;
import cleiton.unisul.piweb.sistema.shared.*;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server side implementation of the RPC service.
 */


@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements GreetingService{

	PersistenceManager pm = PMF.get().getPersistenceManager();
	
	UserService userService = UserServiceFactory.getUserService();
	User user = userService.getCurrentUser();
	
	public String greetServer(String input) throws IllegalArgumentException {
	    
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
	@Override
	public String urlLogout(String destino) {
		return userService.createLogoutURL(destino);
	}

	@Override
	public Usuario getUsuario(String qualquer) {
		return new Usuario(user.getEmail(),user.getUserId(),user.getNickname(),user.getAuthDomain());
	}


}
