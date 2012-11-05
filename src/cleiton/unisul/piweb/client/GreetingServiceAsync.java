package cleiton.unisul.piweb.client;

import cleiton.unisul.piweb.shared.Usuario;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface GreetingServiceAsync {
	void greetServer(String input, AsyncCallback<String> callback)
			throws IllegalArgumentException;
	void urlLogout(String qualquer, AsyncCallback<String> callback);
	void getUsuario(String qualquer, AsyncCallback<Usuario> callback);
}
