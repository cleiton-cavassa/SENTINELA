package cleiton.unisul.piweb.classesrpc.client;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import cleiton.unisul.piweb.classesrpc.shared.Usuario;
import cleiton.unisul.piweb.sistema.shared.*;

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
