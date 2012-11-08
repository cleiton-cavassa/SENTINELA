package cleiton.unisul.piweb.client;

import java.io.Serializable;
import java.util.ArrayList;

import cleiton.unisul.piweb.shared.*;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface GreetingServiceAsync {
	void greetServer(String input, AsyncCallback<String> callback)
			throws IllegalArgumentException;
	void urlLogout(String qualquer, AsyncCallback<String> callback);
	void getUsuario(String qualquer, AsyncCallback<Usuario> callback);
	void persistir(ClientePF obj,AsyncCallback<Boolean> callback);
	void persistir(ClientePJ obj,AsyncCallback<Boolean> callback);
	void persistir(Corrida obj,AsyncCallback<Boolean> callback);
	void persistir(CorridaAtendida obj,AsyncCallback<Boolean> callback);
	void persistir(CorridaCancelada obj,AsyncCallback<Boolean> callback);
	void persistir(CorridaMarcada obj,AsyncCallback<Boolean> callback);
	void persistir(Frota obj,AsyncCallback<Boolean> callback);
	void persistir(Motorista obj,AsyncCallback<Boolean> callback);
	void recuperarDadosCategoria(boolean exemplo, AsyncCallback<ArrayList<Serializable>> resultado);
}
