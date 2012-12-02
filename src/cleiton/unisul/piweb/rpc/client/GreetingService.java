package cleiton.unisul.piweb.rpc.client;

import cleiton.unisul.piweb.rpc.shared.Usuario;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.Frota;

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

	boolean definirFrota(Frota frota);
}