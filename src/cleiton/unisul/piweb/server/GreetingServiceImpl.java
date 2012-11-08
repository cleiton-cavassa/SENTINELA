package cleiton.unisul.piweb.server;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import cleiton.unisul.piweb.client.GreetingService;
import cleiton.unisul.piweb.shared.*;

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

	public Boolean persistir(ClientePF obj){return persista(obj);}
	public Boolean persistir(ClientePJ obj){return persista(obj);}
	public Boolean persistir(Corrida obj){return persista(obj);}
	public Boolean persistir(CorridaAtendida obj){return persista(obj);}
	public Boolean persistir(CorridaCancelada obj){return persista(obj);}
	public Boolean persistir(CorridaMarcada obj){return persista(obj);}
	public Boolean persistir(Frota obj){return persista(obj);}
	public Boolean persistir(Motorista obj){return persista(obj);}
	
	private Boolean persista(Object objeto){
	    boolean resultado;    
		try {
			pm.makePersistent(objeto);
			resultado=true;	
		}catch(Throwable t){
			resultado=false;
		}finally {
			pm.close();
		}
		return resultado;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Serializable> recuperarDadosCategoria(boolean exemplo){
		Query q = pm.newQuery(ClientePJ.class);
		//q.setFilter("lastName == lastNameParam");
		//q.setOrdering("height desc");
		//q.declareParameters("String lastNameParam");
		List<Serializable>  r;
		ArrayList<Serializable>  results;
		
		try {
			r=((List<Serializable>) q.execute());

		}catch(Throwable t){
			throw new RuntimeException("Problema na consulta");
		} finally {
			q.closeAll();
		}
		results=(ArrayList<Serializable>)r;
		return results;
	}

}
