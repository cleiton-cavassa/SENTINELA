package cleiton.unisul.piweb.rpc.client;

import cleiton.unisul.piweb.rpc.shared.Usuario;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.Frota;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface GreetingServiceAsync {
	void greetServer(String input, AsyncCallback<String> callback)
			throws IllegalArgumentException;
	void urlLogout(String qualquer, AsyncCallback<String> callback);
	void getUsuario(String qualquer, AsyncCallback<Usuario> callback);
	
	void definirFrota(Frota frota, AsyncCallback<Boolean> callback);
	
}
