package cleiton.unisul.piweb.client;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import cleiton.unisul.piweb.shared.*;
import cleiton.unisul.piweb.shared.ObjetoChaveado.RespostaPersistencia;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("armazenamento")
public interface Armazenamento extends RemoteService {
	
	RespostaPersistencia persistir(ClientePF obj,Boolean novoRegistro, Boolean salvarMesmoSeNaoOcorrerOEsperado);
	RespostaPersistencia persistir(ClientePJ obj,Boolean novoRegistro, Boolean salvarMesmoSeNaoOcorrerOEsperado);
	RespostaPersistencia persistir(Corrida obj,Boolean novoRegistro, Boolean salvarMesmoSeNaoOcorrerOEsperado);
	RespostaPersistencia persistir(CorridaAtendida obj,Boolean novoRegistro, Boolean salvarMesmoSeNaoOcorrerOEsperado);
	RespostaPersistencia persistir(CorridaCancelada obj,Boolean novoRegistro, Boolean salvarMesmoSeNaoOcorrerOEsperado);
	RespostaPersistencia persistir(CorridaMarcada obj,Boolean novoRegistro, Boolean salvarMesmoSeNaoOcorrerOEsperado);
	RespostaPersistencia persistir(Frota cliente,Boolean novoRegistro, Boolean salvarMesmoSeNaoOcorrerOEsperado);
	RespostaPersistencia persistir(Motorista obj,Boolean novoRegistro, Boolean salvarMesmoSeNaoOcorrerOEsperado);

	List<ClientePF> recuperar(ClientePF exemplo) throws Exception;
	List<ClientePJ> recuperar(ClientePJ exemplo) throws Exception;
	List<Corrida> recuperar(Corrida exemplo) throws Exception;
	List<CorridaAtendida> recuperar(CorridaAtendida exemplo) throws Exception;
	List<CorridaCancelada> recuperar(CorridaCancelada exemplo) throws Exception;
	List<CorridaMarcada> recuperar(CorridaMarcada exemplo) throws Exception;
	List<Expediente> recuperar(Expediente exemplo) throws Exception;
	List<Frota> recuperar(Frota exemplo) throws Exception;
	List<Motorista> recuperar(Motorista exemplo) throws Exception;
	List<Usuario> recuperar(Usuario exemplo) throws Exception;
	
	List<ClientesPFePJ> recuperar(ClientesPFePJ exemplo) throws Exception;
}
