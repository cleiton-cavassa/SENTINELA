package cleiton.unisul.piweb.rpc.server;

import javax.jdo.PersistenceManager;

import cleiton.unisul.piweb.rpc.client.GreetingService;
import cleiton.unisul.piweb.rpc.shared.Usuario;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.Frota;

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

	@Override
	public boolean definirFrota(Frota frota) {
		this.getThreadLocalRequest().setAttribute("frota", frota);
		return true;
	}
	
	@Override
	public String urlLogout(String destino) {
		return userService.createLogoutURL(destino);
	}

	@Override
	public Usuario getUsuario(String qualquer) {
		Frota result=null;
		try {
			result = (Frota)(getThreadLocalRequest().getAttribute("frota"));
		} catch (Throwable e) {
			e.printStackTrace();
		}

		return new Usuario(
				user.getEmail(),
				user.getUserId(),
				user.getNickname(),
				user.getAuthDomain()
				,userService.isUserAdmin()
				,result
				);
	}

}
