package cleiton.unisul.piweb.client;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import cleiton.unisul.piweb.shared.*;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("armazenamento")
public interface Armazenamento extends RemoteService {
	
	Boolean persistir(ClientePF obj);
	Boolean persistir(ClientePJ obj);
	Boolean persistir(Corrida obj);
	Boolean persistir(CorridaAtendida obj);
	Boolean persistir(CorridaCancelada obj);
	Boolean persistir(CorridaMarcada obj);
	Boolean persistir(Frota cliente);
	Boolean persistir(Motorista obj);

	List<ClientePF> recuperar(ClientePF exemplo);
	List<ClientePJ> recuperar(ClientePJ exemplo);
	List<Corrida> recuperar(Corrida exemplo);
	List<CorridaAtendida> recuperar(CorridaAtendida exemplo);
	List<CorridaCancelada> recuperar(CorridaCancelada exemplo);
	List<CorridaMarcada> recuperar(CorridaMarcada exemplo);
	List<Expediente> recuperar(Expediente exemplo);
	List<Frota> recuperar(Frota exemplo);
	List<Motorista> recuperar(Motorista exemplo);
	List<Usuario> recuperar(Usuario exemplo);
}
