package cleiton.unisul.piweb.client;

import java.io.Serializable;
import java.util.ArrayList;

import cleiton.unisul.piweb.shared.*;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("greet")
public interface GreetingService extends RemoteService {
	String greetServer(String name) throws IllegalArgumentException;
	String urlLogout(String qualquer);
	Usuario getUsuario(String qualquer);
	Boolean persistir(ClientePF obj);
	Boolean persistir(ClientePJ obj);
	Boolean persistir(Corrida obj);
	Boolean persistir(CorridaAtendida obj);
	Boolean persistir(CorridaCancelada obj);
	Boolean persistir(CorridaMarcada obj);
	Boolean persistir(Frota cliente);
	Boolean persistir(Motorista obj);
	ArrayList<Serializable> recuperarDadosCategoria(boolean exemplo);
}