package cleiton.unisul.piweb.classesrpc.client;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import cleiton.unisul.piweb.classesrpc.shared.Usuario;
import cleiton.unisul.piweb.sistema.shared.*;

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

}